package com.asiainfo.qm.task.web;

import com.asiainfo.qm.task.service.IExtractService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qm/configservice/qmAutoExtract/")
public class QmAutoExtractController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(QmAutoExtractController.class);

	@Autowired
	private IExtractService extractService;

	@ApiOperation(value = "计划执行定时任务", notes = "qm_configservice计划执行定时任务", response = Boolean.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			                @ApiResponse(code = 403, message = "资源不存在"),
			                @ApiResponse(code = 404, message = "传入的参数无效"),
			                @ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "doPlanTask", threadPoolKey = "doPlanTaskThread", fallbackMethod = "fallbackDoPlanTask",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/doPlanTask/{planId}", method = RequestMethod.GET)
	public boolean doPlanTask(@PathVariable(name = "planId")String planId) throws Exception {
		boolean flag = false;
		try {
			flag = extractService.extract(planId);
		}catch (Exception e){
			logger.error("计划执行定时任务异常");
		}
        return flag;
	}

	public boolean fallbackDoPlanTask(@PathVariable(name = "planId")String planId) throws Exception {
		logger.info("计划执行定时任务出错啦！");
		logger.error("");
		return false;
	}


}
