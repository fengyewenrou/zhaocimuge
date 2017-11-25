package com.zhaoci.framework.base.controller;


import com.zhaoci.framework.base.Constants;
import com.zhaoci.share.utils.MD5Util;
import com.zhaoci.share.utils.json.JacksonUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

public class AppGatewayInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(AppGatewayInterceptor.class);

	/**
	 * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		logger.debug("preHandle::"+request.getRequestURL()+"=============="+request.getMethod());
		StringBuffer sbValues = new StringBuffer("");
		String summary = null;
		if(Constants.REQUEST_METHOD_GET.equalsIgnoreCase(request.getMethod())){
			@SuppressWarnings("unchecked")
			Map<String,String> pathVariables = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
			Iterator<String> values = pathVariables.keySet().iterator();
			while(values.hasNext()){
				String name = values.next();
				logger.info(name +"========="+ pathVariables.get(name));
				if("summary".equalsIgnoreCase(name)){
					summary = pathVariables.get(name);
				}else {
					sbValues.append(pathVariables.get(name));
				}
			}			
		}else {
			Map<String,String[]> pramMap = request.getParameterMap();
			List<String> keyList = new ArrayList<String>(pramMap.keySet());
			Collections.sort(keyList);
			for(String name:keyList){
				logger.info(name +"========="+ pramMap.get(name)[0]);
				if("summary".equalsIgnoreCase(name)){
					summary = pramMap.get(name)[0];
				}else {
					sbValues.append(pramMap.get(name)[0]);
				}
			}		
		}
		//logger.debug("========="+ sbValues.toString());
		if(!MD5Util.verify(sbValues.toString(), summary, null, Constants.CHARACTER_ENCODING_UTF8)){
			try {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=UTF-8");
				Map<String, String> map = new HashMap<String, String>();
				map.put("errorNum", "2");
				map.put("errorInfo", "验证不通过");
				out.print(JacksonUtil.toJson(map));
			} catch (Exception e) {
				logger.error("",e);
			}
			return false;
		}
		return true;
	}

	/**
	 * 该方法将在Controller执行之后，返回视图之前执行，ModelMap表示请求Controller处理之后返回的Model对象，所以可以在
	 * 这个方法中修改ModelMap的属性，从而达到改变返回的模型的效果。 
	 */
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		//logger.debug("::==============postHandle");
	}

	/**
	 * 该方法将在整个请求完成之后，也就是说在视图渲染之后进行调用，主要用于进行一些资源的释放 
	 */
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//logger.debug("::==============afterCompletion");
	}

}
