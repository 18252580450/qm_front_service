package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.domain.TypicalCase;
import com.asiainfo.qm.manage.service.TypicalCaseService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.TypicalCaseResponse;
import com.asiainfo.qm.manage.vo.TypicalCaseServiceResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-04-09 11:16
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/typicalCase/")
public class TypicalCaseController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(TypicalCaseController.class);

    @Autowired
    private TypicalCaseService typicalCaseService;

    @ApiOperation(value = "前端调用接口查询典型案例", notes = "qm_configservice查询典型案例", response = TypicalCaseServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryTypicalCase", threadPoolKey = "queryTypicalCaseThread", fallbackMethod = "fallbackQueryTypicalCase", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryTypicalCase", method = RequestMethod.GET)
    public TypicalCaseServiceResponse queryTypicalCase(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        TypicalCaseResponse typicalCaseResponse = new TypicalCaseResponse();
        TypicalCaseServiceResponse typicalCaseServiceResponse = new TypicalCaseServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            typicalCaseResponse = typicalCaseService.queryTypicalCase(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("典型案例数据查询异常", e);
            typicalCaseResponse.setRspcode(WebUtil.EXCEPTION);
            typicalCaseResponse.setRspdesc("典型案例数据查询异常!");
        }
        typicalCaseServiceResponse.setResponse(typicalCaseResponse);
        return typicalCaseServiceResponse;
    }

    public TypicalCaseServiceResponse fallbackQueryTypicalCase(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("典型案例数据查询出错啦！");
        logger.error("");
        return new TypicalCaseServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询典型案例详情", notes = "qm_configservice查询典型案例", response = TypicalCaseServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryTypicalCase", threadPoolKey = "queryTypicalCaseThread", fallbackMethod = "fallbackQueryTypicalCaseDetail", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryTypicalCaseDetail", method = RequestMethod.GET)
    public TypicalCaseServiceResponse queryTypicalCaseDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        TypicalCaseResponse typicalCaseResponse = new TypicalCaseResponse();
        TypicalCaseServiceResponse typicalCaseServiceResponse = new TypicalCaseServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            typicalCaseResponse = typicalCaseService.queryTypicalCaseDetail(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("典型案例数据查询异常", e);
            typicalCaseResponse.setRspcode(WebUtil.EXCEPTION);
            typicalCaseResponse.setRspdesc("典型案例数据查询异常!");
        }
        typicalCaseServiceResponse.setResponse(typicalCaseResponse);
        return typicalCaseServiceResponse;
    }

    public TypicalCaseServiceResponse fallbackQueryTypicalCaseDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("典型案例数据查询出错啦！");
        logger.error("");
        return new TypicalCaseServiceResponse();
    }

    @ApiOperation(value = "前端调用接口新增典型案例", notes = "qm_configservice新增典型案例", response = TypicalCaseServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "createTypicalCase", threadPoolKey = "createTypicalCaseThread", fallbackMethod = "fallbackCreateTypicalCase", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TypicalCaseServiceResponse createTypicalCase(@RequestBody TypicalCase typicalCase) throws Exception {
        TypicalCaseResponse typicalCaseResponse = new TypicalCaseResponse();
        TypicalCaseServiceResponse typicalCaseServiceResponse = new TypicalCaseServiceResponse();
        try {
            typicalCaseResponse = typicalCaseService.addTypicalCase(typicalCase);
        } catch (Exception e) {
            logger.error("典型案例数据新增异常", e);
            typicalCaseResponse.setRspcode(WebUtil.EXCEPTION);
            typicalCaseResponse.setRspdesc("典型案例数据新增异常!");
        }
        typicalCaseServiceResponse.setResponse(typicalCaseResponse);
        return typicalCaseServiceResponse;
    }

    public TypicalCaseServiceResponse fallbackCreateTypicalCase(@RequestBody TypicalCase typicalCase) throws Exception {
        logger.info("典型案例数据新增出错啦！");
        logger.error("");
        return new TypicalCaseServiceResponse();
    }

    @ApiOperation(value = "前端调用接口删除典型案例", notes = "qm_configservice删除典型案例", response = TypicalCaseServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteTypicalCase", threadPoolKey = "deleteTypicalCaseThread", fallbackMethod = "fallbackDeleteTypicalCase", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public TypicalCaseServiceResponse deleteTypicalCase(@RequestBody Map<String, Object> reqMap) throws Exception {
        TypicalCaseResponse typicalCaseResponse = new TypicalCaseResponse();
        TypicalCaseServiceResponse typicalCaseServiceResponse = new TypicalCaseServiceResponse();
        String delType = reqMap.get("delType").toString();
        @SuppressWarnings("unchecked")
        List<String> delArr = (List<String>)reqMap.get("delArr");
        try {
            typicalCaseResponse = typicalCaseService.deleteTypicalCase(delType, delArr);
        } catch (Exception e) {
            logger.error("典型案例数据删除异常", e);
            typicalCaseResponse.setRspcode(WebUtil.EXCEPTION);
            typicalCaseResponse.setRspdesc("典型案例数据删除异常!");
        }
        typicalCaseServiceResponse.setResponse(typicalCaseResponse);
        return typicalCaseServiceResponse;
    }

    public TypicalCaseServiceResponse fallbackDeleteTypicalCase(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("典型案例数据删除出错啦！");
        logger.error("");
        return new TypicalCaseServiceResponse();
    }
}
