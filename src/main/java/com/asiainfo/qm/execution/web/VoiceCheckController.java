package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.service.VoiceCheckResultDetailService;
import com.asiainfo.qm.execution.service.VoiceCheckService;
import com.asiainfo.qm.execution.service.VoicePoolService;
import com.asiainfo.qm.execution.vo.*;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.execution.service.VoiceCheckResultService;
import com.asiainfo.qm.manage.domain.VoiceCheckResult;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetail;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.DateUtil;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 17:12
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/voiceCheck/")
public class VoiceCheckController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(VoiceCheckController.class);

    @Autowired
    private VoiceCheckService voiceCheckService;
    @Autowired
    private VoiceCheckResultService voiceCheckResultService;
    @Autowired
    private VoiceCheckResultDetailService voiceCheckResultDetailService;
    @Autowired
    private VoicePoolService voicePoolService;

    @Autowired
    private SequenceUtils sequenceUtils;

    @ApiOperation(value = "前端调用接口进行语音质检", notes = "qm_configservice语音质检", response = VoiceCheckServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice", commandKey = "voiceCheck", threadPoolKey = "voiceCheckThread", fallbackMethod = "fallbackVoiceCheck", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public VoiceCheckServiceResponse voiceCheck(@RequestBody Map<String, Object> reqMap) throws Exception {
        VoiceCheckResponse voiceCheckResponse = new VoiceCheckResponse();
        VoiceCheckServiceResponse voiceCheckServiceResponse = new VoiceCheckServiceResponse();
        try {
            voiceCheckResponse = voiceCheckService.voiceCheck(reqMap);
        } catch (Exception e) {
            logger.error("语音质检异常", e);
            voiceCheckResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResponse.setRspdesc("语音质检异常!");
        }
        voiceCheckServiceResponse.setResponse(voiceCheckResponse);
        return voiceCheckServiceResponse;
    }

    public VoiceCheckServiceResponse fallbackVoiceCheck(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("语音质检出错啦！");
        logger.error("");
        return new VoiceCheckServiceResponse();
    }


    @ApiOperation(value = "前端调用接口查询语音质检结果", notes = "qm_configservice查询语音质检结果", response = VoiceCheckResultServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryVoiceCheckResult", threadPoolKey = "queryVoiceCheckResultThread", fallbackMethod = "fallbackQueryVoiceCheckResult", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryVoiceCheckResult", method = RequestMethod.GET)
    public VoiceCheckResultServiceResponse queryVoiceCheckResult(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        VoiceCheckResultResponse voiceCheckResultResponse = new VoiceCheckResultResponse();
        VoiceCheckResultServiceResponse voiceCheckResultServiceResponse = new VoiceCheckResultServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            voiceCheckResultResponse = voiceCheckResultService.queryVoiceCheckResult(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("语音质检结果数据查询异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("语音质检结果数据查询异常!");
        }
        voiceCheckResultServiceResponse.setResponse(voiceCheckResultResponse);
        return voiceCheckResultServiceResponse;
    }

    public VoiceCheckResultServiceResponse fallbackQueryVoiceCheckResult(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("语音质检结果数据查询出错啦！");
        logger.error("");
        return new VoiceCheckResultServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询语音质检结果详情", notes = "qm_configservice查询语音质检结果详情", response = VoiceCheckResultDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryVoiceCheckResultDetail", threadPoolKey = "queryVoiceCheckResultDetailThread", fallbackMethod = "fallbackQueryVoiceCheckResultDetail", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryVoiceCheckResultDetail", method = RequestMethod.GET)
    public VoiceCheckResultDetailServiceResponse queryVoiceCheckResultDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        VoiceCheckResultDetailResponse voiceCheckResultDetailResponse = new VoiceCheckResultDetailResponse();
        VoiceCheckResultDetailServiceResponse voiceCheckResultDetailServiceResponse = new VoiceCheckResultDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            voiceCheckResultDetailResponse = voiceCheckResultDetailService.queryVoiceCheckResultDetail(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("语音质检结果详情数据查询异常", e);
            voiceCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultDetailResponse.setRspdesc("语音质检结果详情数据查询异常!");
        }
        voiceCheckResultDetailServiceResponse.setResponse(voiceCheckResultDetailResponse);
        return voiceCheckResultDetailServiceResponse;
    }

    public VoiceCheckResultDetailServiceResponse fallbackQueryVoiceCheckResultDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("语音质检结果详情数据查询出错啦！");
        logger.error("");
        return new VoiceCheckResultDetailServiceResponse();
    }
}
