package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.domain.QmStrategyElement;
import com.asiainfo.qm.manage.service.QmStrategyElesService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.QmStrategyElesResponse;
import com.asiainfo.qm.manage.vo.QmStrategyElesServiceResponse;
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
@RequestMapping("/qm/configservice/qmStrategyEles/")
public class QmStrategyElesController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(QmStrategyElesController.class);

	@Autowired
	private QmStrategyElesService qmStrategyElesService;

	@ApiOperation(value = "查询策略元素", notes = "qm_configservice查询策略元素", response = QmStrategyElesServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			                @ApiResponse(code = 403, message = "资源不存在"),
			                @ApiResponse(code = 404, message = "传入的参数无效"),
			                @ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public QmStrategyElesServiceResponse selectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		QmStrategyElesResponse qmStrategyElesResponse = new QmStrategyElesResponse();
		QmStrategyElesServiceResponse qmStrategyElesServiceResponse = new QmStrategyElesServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			qmStrategyElesResponse = qmStrategyElesService.selectByParams(reqParams,start,limit);
		}catch (Exception e){
			logger.error("策略元素查询异常");
			qmStrategyElesResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyElesResponse.setRspdesc("策略元素查询异常!");
		}
		qmStrategyElesServiceResponse.setResponse(qmStrategyElesResponse);
        return qmStrategyElesServiceResponse;
	}

	public QmStrategyElesServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("策略元素查询出错啦！");
		logger.error("");
		QmStrategyElesServiceResponse qmStrategyElesServiceResponse = new QmStrategyElesServiceResponse();
		return qmStrategyElesServiceResponse;
	}

	@ApiOperation(value = "删除策略元素", notes = "qm_configservice删除策略元素", response = QmStrategyElesServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "deleteByIds", threadPoolKey = "deleteByIdsThread",fallbackMethod = "fallbackDeleteByIds", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	public QmStrategyElesServiceResponse deleteByIds(@PathVariable("ids")String ids) throws Exception {
		QmStrategyElesResponse qmStrategyElesResponse = new QmStrategyElesResponse();
		QmStrategyElesServiceResponse qmStrategyElesServiceResponse = new QmStrategyElesServiceResponse();
		List<String> idList = Arrays.asList(ids.split(","));
		try {
			qmStrategyElesResponse = qmStrategyElesService.deleteByIds(idList);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("策略元素删除异常");
			qmStrategyElesResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyElesResponse.setRspdesc("策略元素删除异常!");
		}
		qmStrategyElesServiceResponse.setResponse(qmStrategyElesResponse);
		return qmStrategyElesServiceResponse;
	}

	public QmStrategyElesServiceResponse fallbackDeleteByIds(@PathVariable("ids")String ids) throws Exception {
		logger.info("策略元素删除出错啦！");
		logger.error("");
		QmStrategyElesServiceResponse qmStrategyElesServiceResponse = new QmStrategyElesServiceResponse();
		return qmStrategyElesServiceResponse;
	}

	@ApiOperation(value = "新增策略元素", notes = "qm_configservice新增策略元素", response = QmStrategyElesServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "addQmStrategyEles", threadPoolKey = "addQmStrategyElesThread",fallbackMethod = "fallbackAddQmStrategyEles", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public QmStrategyElesServiceResponse addQmStrategyEles(@RequestBody String qmStrategyEles) throws Exception {
		QmStrategyElesResponse qmStrategyElesResponse = new QmStrategyElesResponse();
		QmStrategyElesServiceResponse qmStrategyElesServiceResponse = new QmStrategyElesServiceResponse();
		try {
			QmStrategyElement qmStrategyElesBean = JSONObject.parseObject(qmStrategyEles,QmStrategyElement.class);
			qmStrategyElesResponse = qmStrategyElesService.addQmStrategyEles(qmStrategyElesBean);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增策略元素异常");
			qmStrategyElesResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyElesResponse.setRspdesc("新增策略元素异常!");
		}
		qmStrategyElesServiceResponse.setResponse(qmStrategyElesResponse);
		return qmStrategyElesServiceResponse;
	}

	public QmStrategyElesServiceResponse fallbackAddQmStrategyElesResponse(@RequestBody String  qmStrategyEles) throws Exception {
		logger.info("新增策略元素出错啦！");
		logger.error("");
		QmStrategyElesServiceResponse qmStrategyElesServiceResponse = new QmStrategyElesServiceResponse();
		return qmStrategyElesServiceResponse;
	}

	@ApiOperation(value = "更新策略元素", notes = "qm_configservice更新策略元素", response = QmStrategyElesServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "updateQmStrategyEles", threadPoolKey = "updateQmStrategyElesThread",fallbackMethod = "fallbackUpdateQmStrategyEles", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
	public QmStrategyElesServiceResponse updateQmStrategyEles(@RequestBody String qmStrategyEles) throws Exception {
		QmStrategyElesResponse qmStrategyElesResponse = new QmStrategyElesResponse();
		QmStrategyElesServiceResponse qmStrategyElesServiceResponse = new QmStrategyElesServiceResponse();
		try {
			QmStrategyElement qmStrategyElesBean = JSONObject.parseObject(qmStrategyEles,QmStrategyElement.class);
			qmStrategyElesResponse = qmStrategyElesService.updateQmStrategyEles(qmStrategyElesBean);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("更新策略元素异常");
			qmStrategyElesResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyElesResponse.setRspdesc("更新策略元素异常!");
		}
		qmStrategyElesServiceResponse.setResponse(qmStrategyElesResponse);
		return qmStrategyElesServiceResponse;
	}

	public QmStrategyElesServiceResponse fallbackUpdateQmStrategyEles(@RequestBody String qmStrategyEles) throws Exception {
		logger.info("更新策略元素出错啦！");
		logger.error("");
		QmStrategyElesServiceResponse qmStrategyElesServiceResponse = new QmStrategyElesServiceResponse();
		return qmStrategyElesServiceResponse;
	}

}
