package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.service.AppealNodeService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.AppealNodeResponse;
import com.asiainfo.qm.manage.vo.AppealNodeServiceResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 18:00 2018/11/8
 * @ Description：${description}
 */

@RestController
@RequestMapping("/qm/configservice/appealNode/")
public class AppealNodeController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(AppealNodeController.class);

    @Autowired
    private AppealNodeService appealNodeService;

    @ApiOperation(value = "前端调用接口查询申诉节点", notes = "qm_configservice查询申诉节点", response = AppealNodeServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryAppealNode", threadPoolKey = "queryAppealNodeThread", fallbackMethod = "fallbackQueryAppealNode", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryAppealNode", method = RequestMethod.GET)
    public AppealNodeServiceResponse queryAppealNode(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        AppealNodeServiceResponse appealNodeServiceResponse = new AppealNodeServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            appealNodeResponse = appealNodeService.queryAppealNode(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("申诉节点数据查询异常", e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("申诉节点数据查询异常!");
        }
        appealNodeServiceResponse.setResponse(appealNodeResponse);
        return appealNodeServiceResponse;
    }

    public AppealNodeServiceResponse fallbackQueryAppealNode(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("申诉节点数据查询出错啦！");
        logger.error("");
        return new AppealNodeServiceResponse();
    }
}
