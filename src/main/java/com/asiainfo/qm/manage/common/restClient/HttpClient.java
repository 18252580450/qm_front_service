package com.asiainfo.qm.manage.common.restClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.HttpConstants;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by shiying on 2019/1/16.
 */
@Component
public class HttpClient {

    // 默认字符集
    private static final String ENCODING = "UTF-8";

    private static final int CONNECT_TIMEOUT = 6000;

    private static final int SOCKET_TIMEOUT = 6000;

    public  static String sendPost(String serviceUrl, Map<String, String> headers,JSONObject params,String encoding) {
        String resultJson = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost();
        try {
            httpPost.setURI(new URI(serviceUrl));
            if(headers != null){
                Header[] allHeader = new BasicHeader[headers.size()];
                int i = 0;
                for (Map.Entry<String, String> entry: headers.entrySet()){
                    allHeader[i] = new BasicHeader(entry.getKey(), entry.getValue());
                    i++;
                }
                httpPost.setHeaders(allHeader);
            }
            httpPost.setEntity(new StringEntity(JSON.toJSONString(params)));
            CloseableHttpResponse response = client.execute(httpPost);
            int status = response.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                resultJson = EntityUtils.toString(response.getEntity(),encoding);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            httpPost.releaseConnection();
        }
        return resultJson;
    }

    public  static String sendGet(String serviceUrl, Map<String, String> headers,Map<String, String> params,String encoding){
        String resultJson = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(serviceUrl);
            if (params != null) {
                Set<Map.Entry<String, String>> entrySet = params.entrySet();
                for (Map.Entry<String, String> entry : entrySet) {
                    uriBuilder.setParameter(entry.getKey(), entry.getValue());
                }
            }
            httpGet = new HttpGet(uriBuilder.build());
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
            httpGet.setConfig(requestConfig);
            if (headers != null) {
                Set<Map.Entry<String, String>> entrySet = headers.entrySet();
                for (Map.Entry<String, String> entry : entrySet) {
                    // 设置到请求头到HttpRequestBase对象中
                    httpGet.setHeader(entry.getKey(), entry.getValue());
                }
            }
            CloseableHttpResponse httpResponse = null;
            httpResponse = client.execute(httpGet);
            if (httpResponse != null && httpResponse.getStatusLine() != null) {
                if (httpResponse.getEntity() != null) {
                    resultJson = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            httpGet.releaseConnection();
        }
        return resultJson;
    }

    public static String sendPost(String url, JSONObject data) {
        // 设置默认请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("Accept", "application/json");
        headers.put("Accept-Encoding", "UTF-8");
        return sendPost(url, headers, data, ENCODING);

    }

    public static String sendGet(String url, Map<String, String> params) {
        // 设置默认请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("Accept", "application/json");
        headers.put("Accept-Encoding", "UTF-8");
        return sendGet(url, headers, params, ENCODING);

    }

    public static void main(String[] args)throws Exception{
        //录音查询
//        String url = HttpConstants.HttpParams.URI + HttpConstants.HttpParams.SESSION_DETAIL_QUERY;
//        Map<String,String> params = new HashMap();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(DateUtil.string2Date("2019-01-27 00:00:00"));
//        Long startTime = calendar.getTimeInMillis();
//        calendar.setTime(DateUtil.string2Date("2019-01-27 23:59:59"));
//        Long endTime = calendar.getTimeInMillis();
//        params.put("startTime",startTime + "");
//        params.put("endTime",endTime + "");
//        params.put("entId","0251210001");
//        params.put("pageNum","1");
//        String ret = sendGet(url, params);
//        System.out.println(ret);
        //录音地址查询
        String url = HttpConstants.HttpParams.URI + HttpConstants.HttpParams.RECORD_DETAIL_QUERY;
        Map<String,String> params = new HashMap();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.string2Date("2019-01-27 00:00:00"));
        Long startTime = calendar.getTimeInMillis();
        calendar.setTime(DateUtil.string2Date("2019-01-27 23:59:59"));
        Long endTime = calendar.getTimeInMillis();
        params.put("startTime",startTime + "");
        params.put("endTime",endTime + "");
        params.put("agentIds", "");
        params.put("entId","0251210001");
        params.put("remoteUrl", "15855290633");
        params.put("sessionIds", "2331822886785909023");
        params.put("pageNum","1");
        String ret = sendGet(url, params);
        System.out.println(ret);
    }

}
