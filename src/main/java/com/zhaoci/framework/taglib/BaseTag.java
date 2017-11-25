package com.zhaoci.framework.taglib;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 基本标签库类(子类必须覆盖setTagPagePath()方法设置标签对应的响应页面路径)
 */
public abstract class BaseTag extends TagSupport {
	private static final long serialVersionUID = -6019499196930226950L;

	/**
	 * 设置标签对应的响应页面路径
	 * 
	 * @return String 标签对应的响应页面路径
	 */
	public abstract String setTagPagePath();

	/**
	 * 开始标签业务处理
	 */
	public abstract void handlerStartTag();

	/**
	 * 调用开始标签
	 * 
	 * @return int
	 * @throws JspException
	 */
	@Override
	public int doStartTag() throws JspException {
		this.handlerStartTag();
		return SKIP_BODY;
	}

	/**
	 * 调用结束标签
	 * 
	 * @return int
	 * @throws JspException
	 */
	@Override
	public int doEndTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext
				.getResponse();
		try {
			response.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			ServletContext servletContext = pageContext.getServletContext();
			RequestDispatcher dispatcher = servletContext
					.getRequestDispatcher(this.setTagPagePath());
			TagPageResponseWrapper wrapper = new TagPageResponseWrapper(
					response);
			dispatcher.include(request, wrapper);
			JspWriter jspWriter = pageContext.getOut();
			jspWriter.write(wrapper.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
