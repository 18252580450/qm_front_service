package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.WrkfmDetailService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.execution.vo.WrkfmDetailResponse;
import com.asiainfo.qm.execution.vo.WrkfmDetailServiceResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-30 17:22
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/wrkfmDetail/")
public class WrkfmDetailController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(WrkfmDetailController.class);

    @Autowired
    private WrkfmDetailService wrkfmDetailService;

    @ApiOperation(value = "调用外部接口查询工单详情", notes = "qm_configservice查询工单详情", response = WrkfmDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryWrkfmDetail", threadPoolKey = "queryWrkfmDetailThread", fallbackMethod = "fallbackQueryWrkfmDetail", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryWrkfmDetail", method = RequestMethod.GET)
    public WrkfmDetailServiceResponse queryWrkfmDetail(@RequestParam(name = "params") String params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        WrkfmDetailServiceResponse wrkfmDetailServiceResponse = new WrkfmDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            wrkfmDetailResponse = wrkfmDetailService.queryWrkfmDetail(reqParams);
        } catch (Exception e) {
            logger.error("工单详情数据查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("工单详情数据查询异常!");
        }
        wrkfmDetailServiceResponse.setResponse(wrkfmDetailResponse);
        return wrkfmDetailServiceResponse;
    }

    public WrkfmDetailServiceResponse fallbackQueryWrkfmDetail(@RequestParam(name = "params") String params) throws Exception {
        logger.info("工单详情数据查询出错啦！");
        logger.error("");
        return new WrkfmDetailServiceResponse();
    }

    @ApiOperation(value = "调用外部接口查询工单轨迹", notes = "qm_configservice查询工单轨迹", response = WrkfmDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "getProcProceLocus", threadPoolKey = "getProcProceLocusThread", fallbackMethod = "fallbackGetProcProceLocus", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/getProcProceLocus", method = RequestMethod.GET)
    public WrkfmDetailServiceResponse getProcProceLocus(@RequestParam(name = "params") String params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        WrkfmDetailServiceResponse wrkfmDetailServiceResponse = new WrkfmDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            wrkfmDetailResponse = wrkfmDetailService.getProcProceLocus(reqParams);
        } catch (Exception e) {
            logger.error("工单轨迹数据查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("工单轨迹数据查询异常!");
        }
        wrkfmDetailServiceResponse.setResponse(wrkfmDetailResponse);
        return wrkfmDetailServiceResponse;
    }

    public WrkfmDetailServiceResponse fallbackGetProcProceLocus(@RequestParam(name = "params") String params) throws Exception {
        logger.info("工单轨迹数据查询出错啦！");
        logger.error("");
        return new WrkfmDetailServiceResponse();
    }

    @ApiOperation(value = "调用外部接口查询内外部回复", notes = "qm_configservice查询内外部回复", response = WrkfmDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "getHandingLog", threadPoolKey = "getHandingLogThread", fallbackMethod = "fallbackGetHandingLog", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/getHandingLog", method = RequestMethod.GET)
    public WrkfmDetailServiceResponse getHandingLog(@RequestParam(name = "params") String params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        WrkfmDetailServiceResponse wrkfmDetailServiceResponse = new WrkfmDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            wrkfmDetailResponse = wrkfmDetailService.getHandingLog(reqParams);
        } catch (Exception e) {
            logger.error("内外部回复数据查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("内外部回复数据查询异常!");
        }
        wrkfmDetailServiceResponse.setResponse(wrkfmDetailResponse);
        return wrkfmDetailServiceResponse;
    }

    public WrkfmDetailServiceResponse fallbackGetHandingLog(@RequestParam(name = "params") String params) throws Exception {
        logger.info("内外部回复数据查询出错啦！");
        logger.error("");
        return new WrkfmDetailServiceResponse();
    }

    @ApiOperation(value = "调用外部接口查询接触记录", notes = "qm_configservice查询接触记录", response = WrkfmDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "getRecordList", threadPoolKey = "getRecordListThread", fallbackMethod = "fallbackGetRecordList", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/getRecordList", method = RequestMethod.GET)
    public WrkfmDetailServiceResponse getRecordList(@RequestParam(name = "params") String params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        WrkfmDetailServiceResponse wrkfmDetailServiceResponse = new WrkfmDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            wrkfmDetailResponse = wrkfmDetailService.getRecordList(reqParams);
        } catch (Exception e) {
            logger.error("接触记录数据查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("接触记录数据查询异常!");
        }
        wrkfmDetailServiceResponse.setResponse(wrkfmDetailResponse);
        return wrkfmDetailServiceResponse;
    }

    public WrkfmDetailServiceResponse fallbackGetRecordList(@RequestParam(name = "params") String params) throws Exception {
        logger.info("接触记录数据查询出错啦！");
        logger.error("");
        return new WrkfmDetailServiceResponse();
    }

    @ApiOperation(value = "调用外部接口查询工单历史", notes = "qm_configservice查询工单历史", response = WrkfmDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "getHistoryProProce", threadPoolKey = "getHistoryProProceThread", fallbackMethod = "fallbackGetHistoryProProce", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/getHistoryProProce", method = RequestMethod.GET)
    public WrkfmDetailServiceResponse getHistoryProProce(@RequestParam(name = "params") String params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        WrkfmDetailServiceResponse wrkfmDetailServiceResponse = new WrkfmDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            wrkfmDetailResponse = wrkfmDetailService.getHistoryProProce(reqParams);
        } catch (Exception e) {
            logger.error("工单历史数据查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("工单历史数据查询异常!");
        }
        wrkfmDetailServiceResponse.setResponse(wrkfmDetailResponse);
        return wrkfmDetailServiceResponse;
    }

    public WrkfmDetailServiceResponse fallbackGetHistoryProProce(@RequestParam(name = "params") String params) throws Exception {
        logger.info("工单历史数据查询出错啦！");
        logger.error("");
        return new WrkfmDetailServiceResponse();
    }

    @ApiOperation(value = "调用外部接口下载录音文件", notes = "qm_configservice下载录音文件", response = WrkfmDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "recordDownload", threadPoolKey = "recordDownloadThread", fallbackMethod = "fallbackRecordDownload", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/recordDownload", method = RequestMethod.GET)
    public void recordDownload(@RequestParam(name = "ftpPath") String ftpPath, HttpServletResponse response) throws Exception {
        try {
            wrkfmDetailService.downloadRecord(ftpPath, response);
        } catch (Exception e) {
            logger.error("录音文件下载异常", e);
        }
    }

    public void fallbackRecordDownload(@RequestParam(name = "ftpPath") String ftpPath, HttpServletResponse response) throws Exception {
        logger.info("录音文件下载出错啦！");
        logger.error("");
    }
}