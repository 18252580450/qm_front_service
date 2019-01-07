package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.domain.AppealProcess;
import com.asiainfo.qm.manage.service.AppealProcessService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 15:13 2018/11/8
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/appealProcess/")
public class AppealProcessController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(AppealProcessController.class);

    @Autowired
    private AppealProcessService appealProcessService;

    @ApiOperation(value = "前端调用接口查询申诉流程", notes = "qm_configservice查询申诉流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryAppealProcess", threadPoolKey = "queryAppealProcessThread", fallbackMethod = "fallbackQueryAppealProcess", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryAppealProcess", method = RequestMethod.GET)
    public AppealProcessServiceResponse queryAppealProcess(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            appealProcessResponse = appealProcessService.queryAppealProcess(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("申诉流程数据查询异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程数据查询异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackQueryAppealProcess(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("申诉流程数据查询出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }

    @ApiOperation(value = "前端调用接口新增申诉流程", notes = "qm_configservice新增申诉流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "createAppealProcess", threadPoolKey = "createAppealProcessThread", fallbackMethod = "fallbackCreateAppealProcess", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public AppealProcessServiceResponse createAppealProcess(@RequestBody Map<String, Object> reqMap) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        try {
            appealProcessResponse = appealProcessService.createAppealProcess(reqMap);
        } catch (Exception e) {
            logger.error("申诉流程新增异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程新增异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackCreateAppealProcess(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("申诉流程新增出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }

    @ApiOperation(value = "前端调用接口修改申诉流程", notes = "qm_configservice修改申诉流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "updateAppealProcess", threadPoolKey = "updateAppealProcessThread", fallbackMethod = "fallbackUpdateAppealProcess", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public AppealProcessServiceResponse updateAppealProcess(@RequestBody Map<String, Object> reqMap) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        try {
            appealProcessResponse = appealProcessService.editAppealProcess(reqMap);
        } catch (Exception e) {
            logger.error("申诉流程更新异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程更新异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackUpdateAppealProcess(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("申诉流程更新出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }

    @ApiOperation(value = "前端调用接口删除主流程", notes = "qm_configservice删除主流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteAppealProcess", threadPoolKey = "deleteAppealProcessThread", fallbackMethod = "fallbackDeleteAppealProcess", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/{delArr}", method = RequestMethod.DELETE)
    public AppealProcessServiceResponse deleteAppealProcess(@PathVariable("delArr") String delArr) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        List<String> idlList = Arrays.asList(delArr.split(","));
        try {
            appealProcessResponse = appealProcessService.deleteMainProcess(idlList);
        } catch (Exception e) {
            logger.error("主流程数据删除异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("主流程数据删除异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackDeleteAppealProcess(@RequestParam(name = "delArr") String delArr) throws Exception {
        logger.info("主流程数据删除出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }

    @ApiOperation(value = "前端调用接口修改流程状态", notes = "qm_configservice修改流程状态", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "changeProcessStatus", threadPoolKey = "changeProcessStatusThread", fallbackMethod = "fallbackChangeProcessStatus", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/changeProcessStatus", method = RequestMethod.PUT)
    public AppealProcessServiceResponse changeProcessStatus(@RequestBody List<AppealProcess> processList) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        String processStatus = processList.get(0).getProcessStatus();
        try {
            appealProcessResponse = appealProcessService.changeProcessStatus(processList, processStatus);
        } catch (Exception e) {
            logger.error("流程状态更新异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("流程状态更新异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackChangeProcessStatus(@RequestBody List<AppealProcess> processList) throws Exception {
        logger.info("流程状态更新出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }
}
