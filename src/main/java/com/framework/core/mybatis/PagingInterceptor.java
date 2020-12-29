package com.framework.core.mybatis;

import org.apache.ibatis.plugin.Interceptor;

/**
 * Mybatis分页拦截器接口
 */
public interface PagingInterceptor extends Interceptor {
	
	/**
	 * 传入原始Sql返回查询总数的Sql
	 * @param originalSql 原始Sql
	 * @return 改造后查询总数的Sql
	 */
	String getSelectTotalSql(String originalSql);
	
	/**
	 * 传入原始Sql返回带分页语句的Sql
	 * @param originalSql 原始Sql
	 * @param pageBounds 封装了页码及行数信息
	 * @return 改造后带分页查询的Sql
	 */
	String getSelectPagingSql(String originalSql, PageBounds pageBounds);
}
