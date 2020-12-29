package com.framework.core.mybatis;

import java.util.List;

/**
 * MyBatis分页模型
 */
public class PageModel<T> {
	
	/**
	 * 数据库总数
	 */
	private long total;

	/**
	 * 当前页码
	 */
	private int pageNo;

	/**
	 * 每页显示行数
	 */
	private int limit;
	
	/**
	 * 结果集
	 */
	private List<T> list;
	
	public PageModel(List<T> list, PageBounds bounds) {
		this.list = list;
		this.total = bounds.getTotal();
		this.limit = bounds.getPageSize();
		this.pageNo = bounds.getPage();
	}
	
	/**
	 * 取得结果集
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置结果集
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * 获取数据库总数
	 */
	public long getTotal() {
		return total;
	}  
	
	/**
	 * 设置数据库总数
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * 取得总页数
	 */
	public long getTotalPages() {
		return (total + limit - 1) / limit;
	}

	/**
	 * 获取每页显示多少行
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * 取得当前页
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 取得第一页
	 */
	public int getTopPageNo() {
		return 1;
	}

	/**
	 * 取得上一页
	 */
	public int getPreviousPageNo() {
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo - 1;
	}

	/**
	 * 取得下一页
	 */
	public long getNextPageNo() {
		if (pageNo >= getTotalPages()) {
			return getTotalPages() == 0 ? 1 : getTotalPages();
		}
		return pageNo + 1;
	}

	/**
	 * 取得最后一页
	 */
	public long getBottomPageNo() {
		return getTotalPages() == 0 ? 1 : getTotalPages();
	}
	
	/**
	 * 判断还有更多数据
	 */
	public boolean hashMore() {
		return getNextPageNo() > pageNo;
	}
}
