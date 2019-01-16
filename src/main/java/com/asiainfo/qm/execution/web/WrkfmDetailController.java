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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public WrkfmDetailServiceResponse queryWrkfmDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        WrkfmDetailServiceResponse wrkfmDetailServiceResponse = new WrkfmDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            wrkfmDetailResponse = wrkfmDetailService.queryWrkfmDetail(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("工单详情数据查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("工单详情数据查询异常!");
        }
        wrkfmDetailServiceResponse.setResponse(wrkfmDetailResponse);
        return wrkfmDetailServiceResponse;
    }

    public WrkfmDetailServiceResponse fallbackQueryWrkfmDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("工单详情数据查询出错啦！");
        logger.error("");
        return new WrkfmDetailServiceResponse();
    }
}