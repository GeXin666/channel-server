package com.framework.core.mybatis;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

/**
 * MySql数据库分页插件
 */
@Intercepts(@Signature(type=StatementHandler.class, method="prepare", args={Connection.class})) 
public class MySqlPagingInterceptor extends AbstractPagingInterceptor {

	@Override
	public String getSelectTotalSql(String originalSql) {
		//原始Sql转换为小写,利用小写Sql计算关键字位置
		StringBuilder sqlBuilder = new StringBuilder(originalSql.toLowerCase());
		//原始Sql
		StringBuilder orgSqlBuilder = new StringBuilder(originalSql);
		
		int orderByPos = 0;
		if((orderByPos = sqlBuilder.lastIndexOf(ORDER_BY)) != -1) {
			sqlBuilder.delete(orderByPos, sqlBuilder.length());
			orgSqlBuilder.delete(orderByPos, orgSqlBuilder.length());
		}

		orgSqlBuilder.insert(0, "select count(1) as my_count from ( ").append(" ) as _alias");
		return orgSqlBuilder.toString();
	}

	@Override
	public String getSelectPagingSql(String originalSql, PageBounds bounds) {
		StringBuilder sqlBuilder = new StringBuilder(originalSql);
		sqlBuilder.append(" limit " + bounds.getmOffset() + "," + bounds.getPageSize());
		return sqlBuilder.toString();
	}

}
