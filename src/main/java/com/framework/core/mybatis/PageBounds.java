package com.framework.core.mybatis;

import org.apache.ibatis.session.RowBounds;

/**
 * 封装MyBatis分页信息
 */
public class PageBounds extends RowBounds {
	
	/**
	 * 总数
	 */
	private long total;
	
	/**
	 * 页码
	 */
	private int page;
	
	/**
	 * 行数
	 */
	private int pageSize;
	
	/**
	 * 查询起始数(从第几行开始)
	 * (page-1) * pageSize;
	 */
	private int mOffset = NO_ROW_LIMIT;

	/**
	 * 创业分页信息,无参数表示查询全部
	 */
	public PageBounds() {
		super();
	}

	/**
	 * 创建分页信息
	 * @param page 页码(当前第几页)
	 * @param pageSize 行数(每页显示行数)
	 */
	public PageBounds(int page, int pageSize) {
		super();
		this.mOffset = (page-1) * pageSize;
		this.page = page;
		this.pageSize = pageSize;
	}

	/**
	 * 页码
	 * @return 页码
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 行数
	 * @return 行数
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * 总数
	 * @return 总数
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * 设置总数
	 * @param total 总数
	 */
	void setTotal(long total) {
		this.total = total;
	}

	/**
	 * 查询起始数(从第几行开始)
	 * @return (page-1) * pageSize
	 */
	public int getmOffset() {
		return mOffset;
	}
}
