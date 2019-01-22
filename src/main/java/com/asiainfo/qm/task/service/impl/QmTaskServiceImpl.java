package com.asiainfo.qm.task.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.restClient.RestClient;
import com.asiainfo.qm.task.service.IQmTaskService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiying on 2018/12/21.
 */
@Service
public class QmTaskServiceImpl implements IQmTaskService{

    @Override
    public boolean doSynchroVoices() {
        String url = "http://202.102.40.101:48989/vmservice/selectPublicIpByIdOrIp";
        RestClient restClient = new RestClient();
        Map params = new HashMap<>();
        JSONObject  rsp =  (JSONObject)restClient.callRemoteServicetWithHeader(url, HttpMethod.GET,params,JSONObject.class,null,"1");
        System.out.println(rsp.toJSONString());
        return true;
    }


}
