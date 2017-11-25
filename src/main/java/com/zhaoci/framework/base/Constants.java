package com.zhaoci.framework.base;

/**
 * @author fanfuchen
 * @date 2016-1-2
 */
public class Constants {
    // Suppress default constructor for noninstantiability
    private Constants() {
        throw new AssertionError();
    }
	/** yyyy-MM-dd */  
	public static final String DATE = "yyyy-MM-dd";

	/** yyyy-MM-dd HH:mm:ss */  
	public static final String TIME = "yyyy-MM-dd HH:mm:ss";

	/** TRUE - 1 */  
	public static final String TRUE = "1";

	/** FALSE - 0 */  
	public static final String FALSE = "0";
	
	/** 编码UTF-8 */
	public static final String CHARACTER_ENCODING_UTF8 = "UTF-8";
	
	/** 编码GBK  */
	public static final String CHARACTER_ENCODING_GBK = "GBK";
	
	public static final String LOGIN_USER = "user";
	/** HTTP请求方法  */
	public static final String REQUEST_METHOD_GET = "GET";

	public static final String SMS_URI = "http://sdk999ws.eucp.b2m.cn:8080/sdk/SDKService?wsdl";
	public static final String SMS_SERIAL_NO = "9SDK-EMY-0999-JFSTT";
}
