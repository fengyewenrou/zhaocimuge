package com.zhaoci.share.utils;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

public class ApiV2Util {
	public static RestTemplate httpClientRestTemplate;
	public static HttpComponentsClientHttpRequestFactory httpClientRequestFactory;
	public static RestTemplate before(){
		// 设置使用HttpClient4.0
		httpClientRestTemplate = new RestTemplate(); 
		httpClientRequestFactory = new HttpComponentsClientHttpRequestFactory();
		// (optional)设置20秒超时
		httpClientRequestFactory.setConnectTimeout(20000);

		httpClientRestTemplate.setRequestFactory(httpClientRequestFactory);

		// 设置处理HttpBasic Header的Interceptor
		ClientHttpRequestInterceptor interceptor = new HttpBasicInterceptor("jadmin", "jadmin");
		httpClientRestTemplate.setInterceptors(Lists.newArrayList(interceptor));
		return httpClientRestTemplate;
	}
	
	public static class HttpBasicInterceptor implements ClientHttpRequestInterceptor {

		private final String user;
		private final String password;

		public HttpBasicInterceptor(String user, String password) {
			this.user = user;
			this.password = password;
		}
		public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
				throws IOException {
			request.getHeaders().set(com.google.common.net.HttpHeaders.AUTHORIZATION,
					encodeHttpBasic(user, password));
			return execution.execute(request, body);
		}
		
	}
	/**
	 * 客户端对Http Basic验证的 Header进行编码.
	 */
	public static String encodeHttpBasic(String userName, String password) {
		String encode = userName + ":" + password;
		return "Basic " + org.apache.commons.codec.binary.Base64.encodeBase64String(encode.getBytes());
	}
	
	public static void end(HttpComponentsClientHttpRequestFactory httpClientRequestFactory){
		try {
			httpClientRequestFactory.destroy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
/*		before();
		String message=null;
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		Map<String, String> map=new HashMap<String, String>();
		map.put("carNumber", "沪HTD998");
		map.put("chargeType", "A");
		HttpEntity<?> request = new HttpEntity(map, requestHeaders);
		String json=null;
		
		json = httpClientRestTemplate.postForObject("http://139.196.24.16/p_share_web/api/v2/getParklotFee", request, String.class);
		
		if(json!=null&&json.length()!=0){
			JSONObject js=JSONObject.fromObject(json);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 Calendar cal = Calendar.getInstance();
			if ("FAIL".equals(js.getString("messageCode"))) {
				//mess = ShangAnMessageType.operateToJson("1", "无数据");
			} else {
				JSONObject jss = js.getJSONObject("result");
				String carNumber = jss.getString("carNumber");//车牌号
				String parkingId = jss.getString("parkId");//取得停车场ID
				String parkingName=jss.getString("parkName");//取得停车场名字
				String amountPayable = jss.getString("amountPayable");
				String inTime = jss.getString("inTime");//取得订单开始时间
				String getTimes = jss.getString("getTimes");//取得订单结束时间
				try {
					Date begin = sdf.parse(inTime);
					Date end = sdf.parse(getTimes);
					int times = 0;
					int day = 0;
					int hour = 0;
					int minute = 0;
					int second = 0;
					times = (int) (end.getTime() - begin.getTime());
					day = times/(1000*60*60*24);
					hour = (times%(1000*60*60*24))/(1000*60*60);
					minute = (times%(1000*60*60))/(1000*60);
					second = (times%(1000*60))/1000;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		
		//end();
		}
		String a = "1";*/
	}
}
