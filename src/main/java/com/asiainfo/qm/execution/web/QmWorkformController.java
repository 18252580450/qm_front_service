package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.QmWorkformService;
import com.asiainfo.qm.execution.vo.QmWorkformResponse;
import com.asiainfo.qm.execution.vo.QmWorkformServiceResponse;
import com.asiainfo.qm.manage.util.WebUtil;
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
 * @ Date       ：Created in 2019-03-20 20:18
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/beyondPlanOrderPool")
public class QmWorkformController {

    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(QmWorkformController.class);

    @Autowired
    private QmWorkformService qmWorkformService;

    @ApiOperation(value = "前端调用接口查询工单", notes = "qm_configservice查询工单", response = QmWorkformServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryQmWorkform", threadPoolKey = "queryQmWorkformThread", fallbackMethod = "fallbackQueryQmWorkform", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryQmWorkform", method = RequestMethod.GET)
    public QmWorkformServiceResponse queryQmWorkform(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        QmWorkformResponse qmWorkformResponse = new QmWorkformResponse();
        QmWorkformServiceResponse qmWorkformServiceResponse = new QmWorkformServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            qmWorkformResponse = qmWorkformService.queryWorkForm(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("工单数据查询异常", e);
            qmWorkformResponse.setRspcode(WebUtil.EXCEPTION);
            qmWorkformResponse.setRspdesc("工单数据查询异常!");
        }
        qmWorkformServiceResponse.setResponse(qmWorkformResponse);
        return qmWorkformServiceResponse;
    }

    public QmWorkformServiceResponse fallbackQueryQmWorkform(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("工单数据查询出错啦！");
        logger.error("");
        return new QmWorkformServiceResponse();
    }
}
