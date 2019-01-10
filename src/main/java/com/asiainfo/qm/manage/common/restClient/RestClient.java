package com.asiainfo.qm.manage.common.restClient;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//import com.unicom.kc.manage.demo.util.TokenUtils;
//import com.csc.permission.security.certificationclient.util.SpringSecurityUtil;
//import com.unicom.kc.manage.demo.exception.NoTokenException;

/**
 * 调用示例
 * 1.GET请求
 * 	DemoUserServiceResponse rsp = (DemoUserServiceResponse) RestClient.getInstance().getForObjectWithHeader(
			"http://localhost:8080/kc/configservice/users/1", DemoUserServiceResponse.class,null);
 * 2.POST请求
		DemoUserServiceResponse rsp = (DemoUserServiceResponse) RestClient.getInstance().callRemoteServicetWithHeader(
				"http://localhost:8080/kc/configservice/userinfo", HttpMethod.POST, demoUserRequestMsg,
				DemoUserServiceResponse.class, null);
 * @author Administrator
 *
 */
@Component
public class RestClient {
	
	@Autowired
	private RestTemplate restTemplate;
	@Bean
	@LoadBalanced
	private RestTemplate restTemplate() {
		return new RestTemplate();
	}

//	//不带参数的get请求
//	@SuppressWarnings("rawtypes")
//	public  Object getForObjectWithHeader(String serviceUrl, Class respcalzz, Map<String, String> headers) throws NoTokenException {
//		String token = SpringSecurityUtil.getToken();//获取token
//		if(token == null || token.equals("")) {
//			throw new NoTokenException("获取不到Token");
//		}else 		
//		
//		return getForObjectWithHeader(serviceUrl, respcalzz, null, headers,token);
//	}

	@SuppressWarnings("rawtypes")
	public  Object getForObjectWithHeaderJob(String serviceUrl, Class respcalzz, Map<String, String> headers) {
		//String token = TokenUtils.getInstance().getToken();//获取token
		String token = "";
		if(token == null || token.equals("")) {
			//throw new NoTokenException("获取不到Token");
		}
		return getForObjectWithHeader(serviceUrl, respcalzz, null, headers,token);
	}
	
	
	/**
	 * URL带参数的GET请求，使用这个方法
	 * @param serviceUrl
	 * @param respcalzz
	 * @param params
	 * @param
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Object getForObjectWithHeader(String serviceUrl, Class respcalzz, Map<String, Object> params,
			Map<String, String> headers,String token) {
		HttpHeaders requestHeaders = null;
		if ( headers!=null)
			requestHeaders = buildGrayHeaders(headers,token);
		else
			requestHeaders = buildSimpleHeaders(headers,token);
		org.springframework.http.HttpEntity<String> requestEntity = new org.springframework.http.HttpEntity(null,
				requestHeaders);
		ResponseEntity<String> response = null;
		if (params == null)
			response = restTemplate.exchange(serviceUrl, HttpMethod.GET, requestEntity, String.class);
		else
			response = restTemplate.exchange(serviceUrl, HttpMethod.GET, requestEntity, String.class, params);
		String sttr = response.getBody();
		// Object o = JSON.parseObject(sttr, new
		// TypeReference<DemoUserServiceResponse>(){});
		Object o = JSONObject.parseObject(sttr, respcalzz);
		return o;
	}
	
	//带参数get请求
//	@SuppressWarnings({ "rawtypes" })
//	public  Object getForObjectWithHeader(String serviceUrl, Class respcalzz, Map<String, Object> params,
//										  Map<String, String> headers) throws NoTokenException {
//		String token = SpringSecurityUtil.getToken();//获取token
//		if(token == null || token.equals("")) {
//			throw new NoTokenException("获取不到Token");
//		}else
//			return getForObjectWithHeader(serviceUrl, respcalzz, params, headers,token);
//	}

//	//带参数get请求
//	@SuppressWarnings({ "rawtypes" })
//	public  Object getForObjectWithHeader1(String serviceUrl, Class respcalzz, Map<String, Object> params,
//										  Map<String, String> headers) throws NoTokenException {
//		String token = "";//获取token
//		if(token == null || token.equals("")) {
//			throw new NoTokenException("获取不到Token");
//		}else
//			return getForObjectWithHeader(serviceUrl, respcalzz, params, headers,token);
//	}

//	//带参数的get请求
//	@SuppressWarnings({  "rawtypes" })
//	public  Object getForObjectWithHeaderJob(String serviceUrl, Class respcalzz, Map<String, Object> params,
//			Map<String, String> headers) throws NoTokenException {
//		String token = TokenUtils.getInstance().getToken();//获取token
//		if(token == null || token.equals("")) {
//			throw new NoTokenException("获取不到Token");
//		}else
//
//		return getForObjectWithHeader(serviceUrl, respcalzz, params, headers,token);
//	}

	/**
	 * 通用方法，所有请求内容在请求体中传递到服务端
	 * @param serviceUrl
	 * @param httpMethod
	 * @param reqobj
	 * @param respcalzz
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Object callRemoteServicetWithHeader(String serviceUrl, HttpMethod httpMethod, Object reqobj,
			Class respcalzz, Map<String, String> headers,String token) {
		HttpHeaders requestHeaders = null;
		if (headers!=null)
			requestHeaders = buildGrayHeaders(headers,token);
		else
			requestHeaders = buildSimpleHeaders(headers,token);
		org.springframework.http.HttpEntity<String> requestEntity = new org.springframework.http.HttpEntity(reqobj,
				requestHeaders);
		ResponseEntity<String> response = null;
		restTemplate = new RestTemplate();
		response = restTemplate.exchange(serviceUrl, httpMethod, requestEntity, String.class);
		String sttr = response.getBody();
//		System.out.println("返回结果："+sttr);
		Object o = JSONObject.parseObject(sttr, respcalzz);
		return o;
	}

//	//post请求
//	@SuppressWarnings({ "rawtypes" })
//	public  Object callRemoteServicetWithHeader(String serviceUrl, HttpMethod httpMethod, Object reqobj,
//			Class respcalzz, Map<String, String> headers) throws NoTokenException {
//		String token = SpringSecurityUtil.getToken();//获取token
//		if(token == null || token.equals("")) {
//			throw new NoTokenException("获取不到Token");
//		}else 		
//		
//		return callRemoteServicetWithHeader( serviceUrl,  httpMethod,  reqobj,
//				 respcalzz, headers, token);
//	}
	
//	//post请求
//	@SuppressWarnings({ "rawtypes" })
//	public  Object callRemoteServicetWithHeaderJob(String serviceUrl, HttpMethod httpMethod, Object reqobj,
//			Class respcalzz, Map<String, String> headers) throws NoTokenException {
//		String token = TokenUtils.getInstance().getToken();//获取token
//		if(token == null || token.equals("")) {
//			throw new NoTokenException("获取不到Token");
//		}else
//
//		return callRemoteServicetWithHeader( serviceUrl,  httpMethod,  reqobj,
//				 respcalzz, headers, token);
//	}
	
	
	
	public  HttpHeaders buildSimpleHeaders(Map<String, String> headers,String token) {
		return buildHeaders(null,token);
	}

	public  HttpHeaders buildGrayHeaders(Map<String, String> headers,String token) {
		Map<String, String> newheaders = new HashMap<String, String>();
		if (headers != null) {
			String ipAddress = "211.1.1.23";
			newheaders.put("ipAddress",ipAddress);
//			String staffid = headers.get("staffid");
//			staffid = staffid == null ? "" : staffid;
//			newheaders.put("staffid", staffid);
//
//			String departid = headers.get("departid");
//			departid = departid == null ? "" : departid;
//			newheaders.put("departid", departid);
//
//			String provincecode = headers.get("provincecode");
//			provincecode = provincecode == null ? "" : provincecode;
//			newheaders.put("provincecode", provincecode);
//
//			String eparchycode = headers.get("eparchycode");
//			eparchycode = eparchycode == null ? "" : eparchycode;
//			newheaders.put("eparchycode", eparchycode);
//
//			String citycode = headers.get("citycode");
//			citycode = citycode == null ? "" : citycode;
//			newheaders.put("citycode", citycode);
//
//			String serialnumber = headers.get("serialnumber");
//			serialnumber = serialnumber == null ? "" : serialnumber;
//			newheaders.put("serialnumber", serialnumber);
//
//			String userid = headers.get("userid");
//			userid = userid == null ? "" : userid;
//			newheaders.put("userid", userid);
//
//			String custid = headers.get("custid");
//			custid = custid == null ? "" : custid;
//			newheaders.put("custid", custid);
//
//			String acctid = headers.get("acctid");
//			acctid = acctid == null ? "" : acctid;
//			newheaders.put("acctid", acctid);
//
//			String psptid = headers.get("psptid");
//			psptid = psptid == null ? "" : psptid;
//			newheaders.put("psptid", psptid);
//
//			String ip = headers.get("ip");
//			ip = ip == null ? "" : ip;
//			newheaders.put("ip", ip);
//
//			String origdomain = headers.get("origdomain");
//			origdomain = origdomain == null ? "" : origdomain;
//			newheaders.put("origdomain", origdomain);
//
//			String osnduns = headers.get("osnduns");
//			osnduns = osnduns == null ? "" : osnduns;
//			newheaders.put("osnduns", osnduns);
//
//			String routetype = headers.get("routetype");
//			routetype = routetype == null ? "" : routetype;
//			newheaders.put("routetype", routetype);
//
//			String routevalue = headers.get("routevalue");
//			routevalue = routevalue == null ? "" : routevalue;
//			newheaders.put("routevalue", routevalue);
//
//			String transido = headers.get("transido");
//			transido = transido == null ? "" : transido;
//			newheaders.put("transido", transido);
//
//			String channelid = headers.get("channelid");
//			channelid = channelid == null ? "" : channelid;
//			newheaders.put("channelid", channelid);
//
//			String channeltype = headers.get("channeltype");
//			channeltype = channeltype == null ? "" : channeltype;
//			newheaders.put("channeltype", channeltype);
//
//			String accesstype = headers.get("accesstype");
//			accesstype = accesstype == null ? "" : accesstype;
//			newheaders.put("accesstype", accesstype);
//
//			String processtime = headers.get("processtime");
//			processtime = processtime == null ? "" : processtime;
//			newheaders.put("processtime", processtime);
		}
		return buildHeaders(newheaders,token);
	}

	public  HttpHeaders buildHeaders(Map<String, String> headers,String token) {

		HttpHeaders reqHeaders = new HttpHeaders();
		reqHeaders.add("Content-Type", "application/json; charset=UTF-8");
		reqHeaders.add("Accept", "application/json");
		//内部接口
//		reqHeaders.add("Accept-Encoding", "gzip");
		//外部接口
		reqHeaders.add("Accept-Encoding", "UTF-8");
		reqHeaders.add("Authorization", "Bearer "+token);
		if (headers != null) {
			StringBuffer sb = new StringBuffer();
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				sb.append(entry.getKey()).append("=").append(entry.getValue()).append("$");
			}
			String sbstr = sb.toString();
			int len = sbstr.length();
			String newsbstr = sbstr.substring(0, len - 1);
			reqHeaders.add("ACBSS-MS-GRAY", newsbstr);
		}
		String ipAddress = "211.1.1.23";
		reqHeaders.add("ipAddress", ipAddress);
		return reqHeaders;
	}

	public static void main(String[] args){
//		String url = "http://203.57.227.53:8082/tcwf/detail/getDetailMess?provCode=00030000&wrkfmId=1812041617580000045";
		String url = "http://183.78.183.156:9990/vmservice/selectPublicIpByIdOrIp";
		RestClient restClient = new RestClient();
		Map params = new HashMap<>();
		JSONObject  rsp =  (JSONObject)restClient.callRemoteServicetWithHeader(url,HttpMethod.GET,params,JSONObject.class,null,"1");
		System.out.println(rsp.toJSONString());

	}

}
