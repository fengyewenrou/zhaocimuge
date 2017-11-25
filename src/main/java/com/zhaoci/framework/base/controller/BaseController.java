package com.zhaoci.framework.base.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.util.WebUtils;

import com.zhaoci.framework.base.Constants;

public class BaseController {
	/**
	 * 获取页面参数Map
	 * @param 	request					HttpServletRequest对象
	 * @return	Map<String, Object>		页面参数Map
	 * 注：使用此方法需注意页面的HTML元素的name以p_开头，例如：<input name="g_username"/>。最后生成的Map中的key为页面
	 * HTML的元素的name去掉p_，即key为username。
	 */
	protected Map<String, Object> getParamMap(HttpServletRequest request) {
		return WebUtils.getParametersStartingWith((ServletRequest) request, "p_");
	}
	
	/**
	 * 获取登录用户信息
	 * @param request
	 * @return
	 */
	protected Object getLoginUser(HttpServletRequest request) {
		return request.getSession().getAttribute(Constants.LOGIN_USER);
	}
	
	protected List<FileItem> getFileItemList(HttpServletRequest request){
		List<FileItem> fileItemList = null;
		try	{
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			FileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
			fileItemList =  servletFileUpload.parseRequest(httpServletRequest);
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		
		return fileItemList;
	}

}
