package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.domain.QmStrategy;
import com.asiainfo.qm.manage.service.QmStrategyService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.QmStrategyResponse;
import com.asiainfo.qm.manage.vo.QmStrategyServiceResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/qm/configservice/qmStrategy/")
public class QmStrategyController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(QmStrategyController.class);

	@Autowired
	private QmStrategyService qmStrategyService;

	@ApiOperation(value = "查询考评策略", notes = "qm_configservice查询考评策略", response = QmStrategyServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			                @ApiResponse(code = 403, message = "资源不存在"),
			                @ApiResponse(code = 404, message = "传入的参数无效"),
			                @ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public QmStrategyServiceResponse selectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		QmStrategyResponse qmStrategyResponse = new QmStrategyResponse();
		QmStrategyServiceResponse qmStrategyServiceResponse = new QmStrategyServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			qmStrategyResponse = qmStrategyService.selectByParams(reqParams,start,limit);
		}catch (Exception e){
			logger.error("考评策略查询异常");
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("考评策略查询异常!");
		}
		qmStrategyServiceResponse.setResponse(qmStrategyResponse);
        return qmStrategyServiceResponse;
	}

	public QmStrategyServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("考评策略查询出错啦！");
		logger.error("");
		QmStrategyServiceResponse qmStrategyServiceResponse = new QmStrategyServiceResponse();
		return qmStrategyServiceResponse;
	}

	@ApiOperation(value = "删除考评策略", notes = "qm_configservice删除考评策略", response = QmStrategyServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "deleteByIds", threadPoolKey = "deleteByIdsThread",fallbackMethod = "fallbackDeleteByIds", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	public QmStrategyServiceResponse deleteByIds(@PathVariable("ids")String ids) throws Exception {
		QmStrategyResponse qmStrategyResponse = new QmStrategyResponse();
		QmStrategyServiceResponse qmStrategyServiceResponse = new QmStrategyServiceResponse();
		List<String> idList = Arrays.asList(ids.split(","));
		try {
			qmStrategyResponse = qmStrategyService.deleteByIds(idList);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("考评策略删除异常");
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("考评策略删除异常!");
		}
		qmStrategyServiceResponse.setResponse(qmStrategyResponse);
		return qmStrategyServiceResponse;
	}

	public QmStrategyServiceResponse fallbackDeleteByIds(@PathVariable("ids")String ids) throws Exception {
		logger.info("考评策略删除出错啦！");
		logger.error("");
		QmStrategyServiceResponse qmStrategyServiceResponse = new QmStrategyServiceResponse();
		return qmStrategyServiceResponse;
	}

	@ApiOperation(value = "新增考评策略", notes = "qm_configservice新增考评策略", response = QmStrategyServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "addQmStrategy", threadPoolKey = "addQmStrategyThread",fallbackMethod = "fallbackAddQmStrategy", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public QmStrategyServiceResponse addQmStrategy(@RequestBody String qmStrategy) throws Exception {
		QmStrategyResponse qmStrategyResponse = new QmStrategyResponse();
		QmStrategyServiceResponse qmStrategyServiceResponse = new QmStrategyServiceResponse();
		try {
			QmStrategy qmStrategyBean = JSONObject.parseObject(qmStrategy,QmStrategy.class);
			qmStrategyResponse = qmStrategyService.addQmStrategy(qmStrategyBean);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增考评策略异常");
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("新增考评策略异常!");
		}
		qmStrategyServiceResponse.setResponse(qmStrategyResponse);
		return qmStrategyServiceResponse;
	}

	public QmStrategyServiceResponse fallbackAddQmStrategy(@RequestBody String  qmStrategy) throws Exception {
		logger.info("新增考评策略出错啦！");
		logger.error("");
		QmStrategyServiceResponse qmStrategyServiceResponse = new QmStrategyServiceResponse();
		return qmStrategyServiceResponse;
	}

	@ApiOperation(value = "更新考评策略", notes = "qm_configservice更新考评策略", response = QmStrategyServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "updateQmStrategy", threadPoolKey = "updateQmStrategyThread",fallbackMethod = "fallbackUpdateQmStrategy", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
	public QmStrategyServiceResponse updateQmStrategy(@RequestBody String qmStrategy) throws Exception {
		QmStrategyResponse qmStrategyResponse = new QmStrategyResponse();
		QmStrategyServiceResponse qmStrategyServiceResponse = new QmStrategyServiceResponse();
		try {
			QmStrategy qmStrategyBean = JSONObject.parseObject(qmStrategy,QmStrategy.class);
			qmStrategyResponse = qmStrategyService.updateQmStrategy(qmStrategyBean);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("更新考评策略异常");
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("更新考评策略异常!");
		}
		qmStrategyServiceResponse.setResponse(qmStrategyResponse);
		return qmStrategyServiceResponse;
	}

	public QmStrategyServiceResponse fallbackUpdateQmStrategy(@RequestBody String qmStrategy) throws Exception {
		logger.info("更新考评策略出错啦！");
		logger.error("");
		QmStrategyServiceResponse qmStrategyServiceResponse = new QmStrategyServiceResponse();
		return qmStrategyServiceResponse;
	}

	@ApiOperation(value = "根据ID查询考评策略", notes = "qm_configservice根据ID查询考评策略", response = QmStrategyServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "getStrategyById", threadPoolKey = "getStrategyByIdThread",fallbackMethod = "fallbackGetStrategyById", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public QmStrategyServiceResponse getStrategyById(@ApiParam(value = "策略ID", required = true) @PathVariable("id") String id) throws Exception {
		QmStrategyServiceResponse qmStrategyServiceResponse = new QmStrategyServiceResponse();
		QmStrategyResponse qmStrategyResponse = new QmStrategyResponse();
		try {
			qmStrategyResponse = qmStrategyService.getStrategyById(id);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("根据ID查询考评策略异常");
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("批根据ID查询考评策略异常!");
		}
		qmStrategyServiceResponse.setResponse(qmStrategyResponse);
		return qmStrategyServiceResponse;
	}

	// 降级处理的函数
	public QmStrategyServiceResponse fallbackGetStrategyById(String id) {
		QmStrategyServiceResponse serviceResponse = new QmStrategyServiceResponse();
		return serviceResponse;
	}
}
