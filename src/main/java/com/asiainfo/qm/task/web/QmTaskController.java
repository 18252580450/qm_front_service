package com.asiainfo.qm.task.web;

import com.asiainfo.qm.task.service.IExtractService;
import com.asiainfo.qm.task.service.IQmTaskService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qm/configservice/doQmTask/")
public class QmTaskController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(QmTaskController.class);

	@Autowired
	private IExtractService extractService;

	@Autowired
	private IQmTaskService taskService;

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
			e.printStackTrace();
		}
        return flag;
	}

	public boolean fallbackDoPlanTask(@PathVariable(name = "planId")String planId) throws Exception {
		logger.info("计划执行定时任务出错啦！");
		logger.error("");
		return false;
	}

	@ApiOperation(value = "语音数据同步定时任务", notes = "qm_configservice语音数据同步定时任务", response = Boolean.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "doSynchroVoicesTask", threadPoolKey = "doSynchroVoicesTaskThread", fallbackMethod = "fallbackDoSynchroVoicesTask",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/doSynchroVoicesTask", method = RequestMethod.GET)
	public boolean doSynchroVoicesTask() throws Exception {
		boolean flag = false;
		try {
			//语音数据同步
			flag = taskService.doSynchroVoices(1);
			if(flag){
				//更新满意度
				taskService.queryScore();
				//下载录音文件
				taskService.downloadRecordFiles();
			}
		}catch (Exception e){
			logger.error("语音数据同步定时任务异常");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean fallbackDoSynchroVoicesTask() throws Exception {
		logger.info("语音数据同步定时任务出错啦！");
		logger.error("");
		return false;
	}

}
