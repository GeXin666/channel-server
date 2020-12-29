package com.framework.core.mybatis;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mybatis分页拦截器抽象类
 */
public class AbstractPagingInterceptor implements PagingInterceptor {

	private static final Logger log = LoggerFactory.getLogger(AbstractPagingInterceptor.class);
	
	private static final Pattern PATTERN_SQL_BLANK = Pattern.compile("\\s+");

	private static final String FIELD_DELEGATE = "delegate";
	
	private static final String FIELD_ROWBOUNDS = "rowBounds";
	
	private static final String FIELD_MAPPEDSTATEMENT = "mappedStatement";
	
	private static final String FIELD_SQL = "sql";
	
	private static final String BLANK = " ";

	public static final String ORDER_BY = "order by";

	/**
	 * 拦截器入口方法
	 */
	@Override
	public final Object intercept(Invocation invocation) throws Throwable {
		Connection connection = (Connection) invocation.getArgs()[0];
		RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();

		//通过反射获取相关对象
		StatementHandler handler = (StatementHandler) ReflectUtils.readField(statementHandler, FIELD_DELEGATE);
		MappedStatement mappedStatement = (MappedStatement) ReflectUtils.readField(handler, FIELD_MAPPEDSTATEMENT);
		PageBounds pagingBounds = (PageBounds) ReflectUtils.readField(handler, FIELD_ROWBOUNDS);
		BoundSql boundSql = handler.getBoundSql();
		
		//格式化Sql
		String originalSqlFormated = formatSql(boundSql.getSql());
		if(log.isDebugEnabled()) {
			log.debug("格式化后的原始Sql : " + originalSqlFormated);
		}
		
		//返回改造后查询总数的Sql
		String totalSql = this.getSelectTotalSql(originalSqlFormated);
		if(log.isDebugEnabled()) {
			log.debug("查询总数的totalSql : " + totalSql);
		}

		//查询总数
		this.queryTotalCount(totalSql, boundSql, pagingBounds, mappedStatement, connection);
		
		//返回带分页语句的Sql
		String pagingSql = this.getSelectPagingSql(originalSqlFormated, pagingBounds);
		if(log.isDebugEnabled()) {
			log.debug("带分页语句的pagingSql : " + pagingSql);
		}
		
		//通过反射替换掉Mybatis内部的Sql
		ReflectUtils.writeField(boundSql, FIELD_SQL, pagingSql);
		
		//交给Mybatis处理
		return invocation.proceed();
	}

	/**
	 * 格式化原始Sql<br> 将xml中的Sql去掉多余的空格与回车换行变为一行<br>
	 * 
	 * @param originalSql 原始Sql
	 * @return 处理后的Sql
	 */
	protected String formatSql(String originalSql) {
		Matcher matcher = PATTERN_SQL_BLANK.matcher(originalSql);
		//String formatedSql = matcher.replaceAll(BLANK).toLowerCase();
		return matcher.replaceAll(BLANK);
	}
	
	/**
	 * 查询总记录数并设置到PageBounds中
	 * @param totalSql 查询总数的Sql
	 * @param boundSql Myabtis内部对象
	 * @param bounds 封装了页码及行数信息
	 * @param mappedStatement Myabtis内部对象
	 * @param connection 数据库连接
	 * @throws SQLException
	 */
	protected void queryTotalCount(String totalSql, BoundSql boundSql, PageBounds bounds, 
						MappedStatement mappedStatement, Connection connection) throws SQLException {
		
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		Object parameterObject = boundSql.getParameterObject();
		BoundSql totalBoundSql = new BoundSql(mappedStatement.getConfiguration(), totalSql, parameterMappings, parameterObject);
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, totalBoundSql);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(totalSql);
			parameterHandler.setParameters(pstmt);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				long totalRecord = rs.getLong(1);
				bounds.setTotal(totalRecord);
			}
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	@Override
	public Object plugin(Object target) {
		if (target instanceof RoutingStatementHandler) {
			try {
				Field delegate = ReflectUtils.getField(RoutingStatementHandler.class, FIELD_DELEGATE);
				StatementHandler handler = (StatementHandler) delegate.get(target);
				RowBounds rowBounds = (RowBounds) ReflectUtils.readField(handler, FIELD_ROWBOUNDS);
				if (rowBounds instanceof PageBounds && ((PageBounds) rowBounds).getmOffset() != RowBounds.NO_ROW_LIMIT) {
					return Plugin.wrap(target, this);
				}
			} catch (IllegalAccessException e) {
				if(log.isErrorEnabled()) {
					log.error("can not plugin " + target.getClass(), e);
				}
				throw new PagingException("can not plugin " + target.getClass(), e);
			}
		}
		return target;
	}

	@Override
	public void setProperties(Properties properties) {

	}

	@Override
	public String getSelectTotalSql(String originalSql) {
		throw new PagingException("method [getSelectTotalSql] subclass must override!");
	}

	@Override
	public String getSelectPagingSql(String originalSql, PageBounds pageBounds) {
		throw new PagingException("method [getSelectPagingSql] subclass must override!");
	}

}
