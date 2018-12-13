package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.service.CheckTemplateDetailService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.TemplateDetailResponse;
import com.asiainfo.qm.manage.vo.TemplateDetailServiceResponse;
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
 * @ Date       ：Created in 2018-12-12 16:24
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/checkTemplateDetail/")
public class CheckTemplateDetailController {

    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(CheckTemplateDetailController.class);

    @Autowired
    private CheckTemplateDetailService checkTemplateDetailService;
    @Autowired
    private SequenceUtils sequenceUtils;

    @ApiOperation(value = "前端调用接口查询考评模版详情", notes = "qm_configservice查询考评模版详情", response = TemplateDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryCheckTemplateDetail", threadPoolKey = "queryCheckTemplateDetailThread", fallbackMethod = "fallbackQueryCheckTemplateDetail", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryCheckTemplateDetail", method = RequestMethod.GET)
    public TemplateDetailServiceResponse queryCheckTemplateDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        TemplateDetailServiceResponse templateDetailServiceResponse = new TemplateDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            templateDetailResponse = checkTemplateDetailService.queryTemplateDetail(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("考评模版详情数据查询异常", e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("考评模版详情数据查询异常!");
        }
        templateDetailServiceResponse.setResponse(templateDetailResponse);
        return templateDetailServiceResponse;
    }

    public TemplateDetailServiceResponse fallbackQueryCheckTemplateDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("考评模版详情数据查询出错啦！");
        logger.error("");
        return new TemplateDetailServiceResponse();
    }
}
