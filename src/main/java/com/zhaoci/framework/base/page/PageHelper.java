package com.zhaoci.framework.base.page;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.WebUtils;

import com.zhaoci.framework.base.Constants;

/**
 * @author fanfuchen
 * @date 2016-1-2
 */
public class PageHelper {
	
	public static <T> void initPage(HttpServletRequest request,Page<T> page){
		/**
		 * 设置当前页码，如果不存在则默认为第一页
		 */
		String currentPage = request.getParameter("currentPage");
		String pageQuery = request.getParameter("pageQuery");
		if(Constants.TRUE.equals(pageQuery) && !StringUtils.isEmpty(currentPage)){
			long cp = Long.parseLong(currentPage);
			cp = cp<0?1L:cp;
			page.setCurrentPage(cp);
		}
		
		/**
		 * 设置页行数大小，如果不存在默认为一页10行
		 */
		String pageSize = request.getParameter("pageSize");
		if(!StringUtils.isEmpty(pageSize)){
			page.setPageSize(Integer.parseInt(pageSize));
		}
		
		/**
		 * 设置查询排序，如果不存在则不排序
		 */
		String orderBy = request.getParameter("orderBy");
		if(!StringUtils.isEmpty(orderBy)){
			page.setOrderBy(orderBy);
		}
		page.setParams(WebUtils.getParametersStartingWith(request, "p_"));
	}
	
	public static <T> void setPageModel(HttpServletRequest request,Page<T> page){
		//设置分页对象
		request.setAttribute("page", page);
		
	}
	
	/**
	 * 计算总页数
	 * @param 	totalCount		总记录数
	 * @param 	pageSize		每页显示记录数
	 * @return	int				总页数
	 */
	public static long computeTotalPage(final long totalCount, final int pageSize) {
		return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
	}
}
