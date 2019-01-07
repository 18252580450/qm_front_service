package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.*;
import com.asiainfo.qm.execution.vo.*;
import com.asiainfo.qm.manage.util.WebUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-21 15:08
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/appealDeal/")
public class AppealDealController {

    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(AppealDealController.class);

    @Autowired
    private AppealDealService appealDealService;
    @Autowired
    private AppealDealRecordService appealDealRecordService;

    @ApiOperation(value = "前端调用接口提交申诉", notes = "qm_configservice提交申诉", response = AppealDealServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "createAppealDeal", threadPoolKey = "createAppealDealThread", fallbackMethod = "fallbackCreateAppealDeal", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public AppealDealServiceResponse createAppealDeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        AppealDealServiceResponse appealDealServiceResponse = new AppealDealServiceResponse();
        try {
            appealDealResponse = appealDealService.submitAppeal(reqMap);
        } catch (Exception e) {
            logger.error("申诉提交异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉提交异常!");
        }
        appealDealServiceResponse.setResponse(appealDealResponse);
        return appealDealServiceResponse;
    }

    public AppealDealServiceResponse fallbackCreateAppealDeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("申诉提交出错啦！");
        logger.error("");
        return new AppealDealServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询申诉待办", notes = "qm_configservice查询申诉待办", response = AppealDealServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryAppealDeal", threadPoolKey = "queryAppealDealThread", fallbackMethod = "fallbackQueryAppealDeal", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryAppealDeal", method = RequestMethod.GET)
    public AppealDealServiceResponse queryAppealDeal(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        AppealDealServiceResponse appealDealServiceResponse = new AppealDealServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            appealDealResponse = appealDealService.queryAppeal(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("申诉待办数据查询异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉待办数据查询异常!");
        }
        appealDealServiceResponse.setResponse(appealDealResponse);
        return appealDealServiceResponse;
    }

    public AppealDealServiceResponse fallbackQueryAppealDeal(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("申诉待办数据查询出错啦！");
        logger.error("");
        return new AppealDealServiceResponse();
    }

    @ApiOperation(value = "前端调用接口处理申诉", notes = "qm_configservice处理申诉", response = AppealDealServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "dealAppeal", threadPoolKey = "dealAppealThread", fallbackMethod = "fallbackCreateAppealDeal", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public AppealDealServiceResponse dealAppeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        AppealDealServiceResponse appealDealServiceResponse = new AppealDealServiceResponse();
        try {
            appealDealResponse = appealDealService.dealAppeal(reqMap);
        } catch (Exception e) {
            logger.error("审批异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("审批异常!");
        }
        appealDealServiceResponse.setResponse(appealDealResponse);
        return appealDealServiceResponse;
    }

    public AppealDealServiceResponse fallbackDealAppeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("审批出错啦！");
        logger.error("");
        return new AppealDealServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询审批记录", notes = "qm_configservice查询审批记录", response = AppealDealRecordServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryAppealDealRecord", threadPoolKey = "queryAppealDealRecordThread", fallbackMethod = "fallbackQueryAppealDealRecord", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryDealRecord", method = RequestMethod.GET)
    public AppealDealRecordServiceResponse queryDealRecord(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        AppealDealRecordResponse appealDealRecordResponse = new AppealDealRecordResponse();
        AppealDealRecordServiceResponse appealDealRecordServiceResponse = new AppealDealRecordServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            appealDealRecordResponse = appealDealRecordService.queryAppealRecord(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("审批记录数据查询异常", e);
            appealDealRecordResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealRecordResponse.setRspdesc("审批记录数据查询异常!");
        }
        appealDealRecordServiceResponse.setResponse(appealDealRecordResponse);
        return appealDealRecordServiceResponse;
    }

    public AppealDealRecordServiceResponse fallbackQueryAppealDealRecord(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("审批记录数据查询出错啦！");
        logger.error("");
        return new AppealDealRecordServiceResponse();
    }
}
