package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.domain.QmPlan;
import com.asiainfo.qm.manage.service.QmPlanService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.QmPlanResponse;
import com.asiainfo.qm.manage.vo.QmPlanServiceResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qm/configservice/qmPlan/")
public class QmPlanController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(QmPlanController.class);

	@Autowired
	private QmPlanService qmPlanService;

	@ApiOperation(value = "查询考评计划", notes = "qm_configservice查询考评计划", response = QmPlanServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			                @ApiResponse(code = 403, message = "资源不存在"),
			                @ApiResponse(code = 404, message = "传入的参数无效"),
			                @ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public QmPlanServiceResponse selectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			qmPlanResponse = qmPlanService.selectByParams(reqParams,start,limit);
		}catch (Exception e){
			logger.error("考评计划查询异常");
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("考评计划查询异常!");
		}
		qmPlanServiceResponse.setResponse(qmPlanResponse);
        return qmPlanServiceResponse;
	}

	public QmPlanServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("考评计划查询出错啦！");
		logger.error("");
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		return qmPlanServiceResponse;
	}

	@ApiOperation(value = "删除考评计划", notes = "qm_configservice删除考评计划", response = QmPlanServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "deleteByIds", threadPoolKey = "deleteByIdsThread",fallbackMethod = "fallbackDeleteByIds", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	public QmPlanServiceResponse deleteByIds(@PathVariable("ids")String ids) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		List<String> idList = Arrays.asList(ids.split(","));
		try {
			qmPlanResponse = qmPlanService.deleteByIds(idList);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("考评计划删除异常");
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("考评计划删除异常!");
		}
		qmPlanServiceResponse.setResponse(qmPlanResponse);
		return qmPlanServiceResponse;
	}

	public QmPlanServiceResponse fallbackDeleteByIds(@PathVariable("ids")String ids) throws Exception {
		logger.info("考评计划删除出错啦！");
		logger.error("");
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		return qmPlanServiceResponse;
	}

	@ApiOperation(value = "新增考评计划", notes = "qm_configservice新增考评计划", response = QmPlanServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "addQmPlan", threadPoolKey = "addQmPlanThread",fallbackMethod = "fallbackAddQmPlan", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public QmPlanServiceResponse addQmPlan(@RequestBody QmPlan qmPlan) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		try {
			qmPlanResponse = qmPlanService.addQmPlan(qmPlan);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增考评计划异常");
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("新增考评计划异常!");
		}
		qmPlanServiceResponse.setResponse(qmPlanResponse);
		return qmPlanServiceResponse;
	}

	public QmPlanServiceResponse fallbackAddQmPlan(@RequestBody QmPlan qmPlan) throws Exception {
		logger.info("新增考评计划出错啦！");
		logger.error("");
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		return qmPlanServiceResponse;
	}

	@ApiOperation(value = "更新考评计划", notes = "qm_configservice更新考评计划", response = QmPlanServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "updateQmPlan", threadPoolKey = "updateQmPlanThread",fallbackMethod = "fallbackUpdateQmPlan", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
	public QmPlanServiceResponse updateQmPlan(@RequestBody QmPlan qmPlan) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		try {
			qmPlanResponse = qmPlanService.updateQmPlan(qmPlan);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("更新考评计划异常");
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("更新考评计划异常!");
		}
		qmPlanServiceResponse.setResponse(qmPlanResponse);
		return qmPlanServiceResponse;
	}

	public QmPlanServiceResponse fallbackUpdateQmPlan(@RequestBody QmPlan qmPlan) throws Exception {
		logger.info("更新考评计划出错啦！");
		logger.error("");
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		return qmPlanServiceResponse;
	}

	@ApiOperation(value = "批量更新考评计划", notes = "qm_configservice批量更新考评计划", response = QmPlanServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "updateQmPlan", threadPoolKey = "batchUpdateThread",fallbackMethod = "fallbackBatchUpdate", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "batchUpdate", method = RequestMethod.PUT)
	public QmPlanServiceResponse batchUpdate(@RequestParam(name = "ids")String ids,@RequestParam(name = "halfFlag") String halfFlag) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		List<String> idList = Arrays.asList(ids.split(","));
		try {
			qmPlanResponse = qmPlanService.batchUpdate(idList,halfFlag);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("批量更新考评计划异常");
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("批量更新考评计划异常!");
		}
		qmPlanServiceResponse.setResponse(qmPlanResponse);
		return qmPlanServiceResponse;
	}

	public QmPlanServiceResponse fallbackBatchUpdate(@RequestParam(name = "ids")String ids,@RequestParam(name = "halfFlag") int halfFlag) throws Exception {
		logger.info("批量更新考评计划出错啦！");
		logger.error("");
		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
		return qmPlanServiceResponse;
	}
}
