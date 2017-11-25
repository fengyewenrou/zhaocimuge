package com.zhaoci.framework.base.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanfuchen
 * @date 2016-1-2
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = -3323321457300243220L;
	
	public static final int PAGE_SIZE_5 = 5;

	public static final int PAGE_SIZE_10 = 10;

	public static final int PAGE_SIZE_50 = 50;

	public static final int PAGE_SIZE_100 = 100;

	public static final int PAGE_SIZE_200 = 200;
	
	/**
	 * 默认每页显示记录数--10
	 */
	private static final int DEFAULT_PAGE_SIZE = PAGE_SIZE_10;

	/** 每页显示记录数(默认为20) */
	private int pageSize;
	
	/** 当前页数(默认为1) */
	private long currentPage;
	
	/** 总页数 */
	private long totalPage;
	
	/** 总记录数 */
	private long totalCount;
	
	/** 当前页对应的记录列表 */
	private List<T> resultList;
	
	/**
	 * 其他的参数我们把它分装成一个Map对象
	 */
	private Map<String, Object> params = new HashMap<String, Object>();
	
	/** 排序字符串 */
	private String orderBy;
	
	/** 每页显示记录数(默认为20) */
	public int getPageSize() {
		return pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
	}

	/** 每页显示记录数(默认为20) */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/** 当前页数(默认为1) */
	public long getCurrentPage() {
		return currentPage <= 0 ? 1 : currentPage;
	}

	/** 当前页数(默认为1) */
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	/** 总页数 */
	public long getTotalPage() {
		totalPage = totalCount % getPageSize() == 0 ? totalCount / getPageSize() : totalCount / getPageSize() + 1;
		return totalPage;
	}

	/** 总页数 */
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	/** 总记录数 */
	public long getTotalCount() {
		return totalCount;
	}

	/** 总记录数 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/** 当前页对应的记录列表 */
	public List<T> getResultList() {
		return resultList;
	}

	/** 当前页对应的记录列表 */
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	/** 分页查询条件对应的参数Map */
	public Map<String, Object> getParams() {
		return params;
	}

	/** 分页查询条件对应的参数Map */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	/** 排序字符串 */
	public String getOrderBy() {
		return orderBy;
	}

	/** 排序字符串 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
}
