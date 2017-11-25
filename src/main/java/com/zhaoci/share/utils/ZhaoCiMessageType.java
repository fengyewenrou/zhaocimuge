package com.zhaoci.share.utils;

import com.zhaoci.share.utils.json.JacksonUtil;

public class ZhaoCiMessageType {
	
	/**
	 * 返回指定消息格式：
	 * @param errorNum 0--无错误; 1--无数据; 2--查询失败
	 * @param mess 返回信息
	 * */
	public static String toZhaociJson(String errorNum,String errorInfo,String name,Object obj)
	{
		String mess = JacksonUtil.toJson(obj);
		String str="";
		str = "{\"errorNum\":\""+errorNum+"\",\"errorInfo\":\""+errorInfo+"\",\""+name+"\":"+mess+"}";
	    return str;
	}
	
	/**
	 * 返回指定消息格式：
	 * @param errorNum 0--无错误; 1--无数据; 2--查询失败
	 * @param mess 返回信息
	 * */
	public static String operateToJson(String errorNum,String errorInfo)
	{
		String str = "{\"errorNum\":\""+errorNum+"\",\"errorInfo\":\""+errorInfo+"\"}";
	    return str;
	}

	
}
