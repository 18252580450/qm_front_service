package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.AppealProcess;
import com.asiainfo.qm.manage.service.AppealProcessService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.AppealProcessServiceResponse;
import com.asiainfo.qm.manage.vo.AppealProcessResponse;
import com.asiainfo.qm.manage.vo.AppealProcessResponse;
import com.asiainfo.qm.manage.vo.AppealProcessServiceResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private SequenceUtils sequenceUtils;

    @ApiOperation(value = "前端调用接口查询申诉流程", notes = "qm_configservice查询申诉流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误") })
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryAppealProcess", threadPoolKey = "queryAppealProcessThread", fallbackMethod = "fallbackQueryAppealProcess",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200") })
    @RequestMapping(value = "/queryAppealProcess", method = RequestMethod.GET)
    public AppealProcessServiceResponse queryAppealProcess(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            appealProcessResponse = appealProcessService.queryAppealProcess(reqParams,start,limit);
        }catch (Exception e){
            logger.error("申诉流程数据查询异常");
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程数据查询异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackQueryAppealProcess(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("申诉流程数据查询出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }

    @ApiOperation(value = "前端调用接口新增申诉流程", notes = "qm_configservice新增申诉流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误") })
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "createAppealProcess", threadPoolKey = "createAppealProcessThread", fallbackMethod = "fallbackCreateAppealProcess",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200") })
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public AppealProcessServiceResponse createAppealProcess(@RequestBody Map<String,Object> reqMap) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        @SuppressWarnings("unchecked")
        ArrayList<AppealProcess> appealProcessesList = (ArrayList<AppealProcess>)reqMap.get("appealProcess");
        try {
//            appealProcessResponse = appealProcessService.createAppealProcess(appealProcess);
        }catch (Exception e){
            logger.error("申诉流程新增异常");
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程新增异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackCreateAppealProcess(@RequestBody Map<String,Object> reqMap) throws Exception {
        logger.info("申诉流程新增出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }
}
