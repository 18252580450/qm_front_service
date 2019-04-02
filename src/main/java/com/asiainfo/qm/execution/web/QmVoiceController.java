package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.QmVoiceService;
import com.asiainfo.qm.execution.vo.QmVoiceResponse;
import com.asiainfo.qm.execution.vo.QmVoiceServiceResponse;
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
 * @ Date       ：Created in 2019-03-20 20:18
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/beyondPlanVoicePool")
public class QmVoiceController {

    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(QmVoiceController.class);

    @Autowired
    private QmVoiceService qmVoiceService;

    @ApiOperation(value = "前端调用接口查询语音", notes = "qm_configservice查询语音", response = QmVoiceServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryQmVoice", threadPoolKey = "queryQmVoiceThread", fallbackMethod = "fallbackQueryQmVoice", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryQmVoice", method = RequestMethod.GET)
    public QmVoiceServiceResponse queryQmVoice(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        QmVoiceResponse qmVoiceResponse = new QmVoiceResponse();
        QmVoiceServiceResponse qmVoiceServiceResponse = new QmVoiceServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            qmVoiceResponse = qmVoiceService.queryVoiceRecord(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("语音数据查询异常", e);
            qmVoiceResponse.setRspcode(WebUtil.EXCEPTION);
            qmVoiceResponse.setRspdesc("语音数据查询异常!");
        }
        qmVoiceServiceResponse.setResponse(qmVoiceResponse);
        return qmVoiceServiceResponse;
    }

    public QmVoiceServiceResponse fallbackQueryQmVoice(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("语音数据查询出错啦！");
        logger.error("");
        return new QmVoiceServiceResponse();
    }

    @ApiOperation(value = "前端调用接口进行语音分派", notes = "qm_configservice语音分派", response = QmVoiceServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice", commandKey = "voiceAllocate", threadPoolKey = "voiceAllocateThread", fallbackMethod = "fallbackVoiceAllocate", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public QmVoiceServiceResponse voiceAllocate(@RequestBody Map<String, Object> reqMap) throws Exception {
        QmVoiceResponse qmVoiceResponse = new QmVoiceResponse();
        QmVoiceServiceResponse qmVoiceServiceResponse = new QmVoiceServiceResponse();
        try {
            qmVoiceResponse = qmVoiceService.voiceAllocate(reqMap);
        } catch (Exception e) {
            logger.error("语音分派异常", e);
            qmVoiceResponse.setRspcode(WebUtil.EXCEPTION);
            qmVoiceResponse.setRspdesc("语音分派异常!");
        }
        qmVoiceServiceResponse.setResponse(qmVoiceResponse);
        return qmVoiceServiceResponse;
    }

    public QmVoiceServiceResponse fallbackVoiceAllocate(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("语音分派出错啦！");
        logger.error("");
        return new QmVoiceServiceResponse();
    }
}
