package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.OrderCheckResultDetailService;
import com.asiainfo.qm.execution.service.OrderCheckResultService;
import com.asiainfo.qm.execution.service.OrderCheckService;
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
 * @ Date       ：Created in 2018-12-11 17:11
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/orderCheck/")
public class OrderCheckController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(OrderCheckController.class);

    @Autowired
    private OrderCheckService orderCheckService;
    @Autowired
    private OrderCheckResultService orderCheckResultService;
    @Autowired
    private OrderCheckResultDetailService orderCheckResultDetailService;

    @ApiOperation(value = "前端调用接口进行工单质检", notes = "qm_configservice工单质检", response = OrderCheckServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice", commandKey = "orderCheck", threadPoolKey = "orderCheckThread", fallbackMethod = "fallbackOrderCheck", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public OrderCheckServiceResponse orderCheck(@RequestBody Map<String, Object> reqMap) throws Exception {
        OrderCheckResponse orderCheckResponse = new OrderCheckResponse();
        OrderCheckServiceResponse orderCheckServiceResponse = new OrderCheckServiceResponse();
        try {
            orderCheckResponse = orderCheckService.orderCheck(reqMap);
        } catch (Exception e) {
            logger.error("工单质检异常", e);
            orderCheckResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResponse.setRspdesc("工单质检异常!");
        }
        orderCheckServiceResponse.setResponse(orderCheckResponse);
        return orderCheckServiceResponse;
    }

    public OrderCheckServiceResponse fallbackOrderCheck(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("工单质检出错啦！");
        logger.error("");
        return new OrderCheckServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询工单质检结果", notes = "qm_configservice查询工单质检结果", response = OrderCheckResultServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryOrderCheckResult", threadPoolKey = "queryOrderCheckResultThread", fallbackMethod = "fallbackQueryOrderCheckResult", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryOrderCheckResult", method = RequestMethod.GET)
    public OrderCheckResultServiceResponse queryOrderCheckResult(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        OrderCheckResultServiceResponse orderCheckResultServiceResponse = new OrderCheckResultServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            orderCheckResultResponse = orderCheckResultService.queryOrderCheckResult(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("工单质检结果数据查询异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("工单质检结果数据查询异常!");
        }
        orderCheckResultServiceResponse.setResponse(orderCheckResultResponse);
        return orderCheckResultServiceResponse;
    }

    public OrderCheckResultServiceResponse fallbackQueryOrderCheckResult(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("工单质检结果数据查询出错啦！");
        logger.error("");
        return new OrderCheckResultServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询工单质检结果详情", notes = "qm_configservice查询工单质检结果详情", response = OrderCheckResultDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryOrderCheckResultDetail", threadPoolKey = "queryOrderCheckResultDetailThread", fallbackMethod = "fallbackQueryOrderCheckResultDetail", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryOrderCheckResultDetail", method = RequestMethod.GET)
    public OrderCheckResultDetailServiceResponse queryOrderCheckResultDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        OrderCheckResultDetailResponse orderCheckResultDetailResponse = new OrderCheckResultDetailResponse();
        OrderCheckResultDetailServiceResponse orderCheckResultDetailServiceResponse = new OrderCheckResultDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            orderCheckResultDetailResponse = orderCheckResultDetailService.queryOrderCheckResultDetail(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("工单质检结果详情数据查询异常", e);
            orderCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultDetailResponse.setRspdesc("工单质检结果详情数据查询异常!");
        }
        orderCheckResultDetailServiceResponse.setResponse(orderCheckResultDetailResponse);
        return orderCheckResultDetailServiceResponse;
    }

    public OrderCheckResultDetailServiceResponse fallbackQueryOrderCheckResultDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("工单质检结果详情数据查询出错啦！");
        logger.error("");
        return new OrderCheckResultDetailServiceResponse();
    }

}
