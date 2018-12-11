package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.PoolService;
import com.asiainfo.qm.execution.vo.PoolResponse;
import com.asiainfo.qm.execution.vo.PoolServiceResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.CheckItem;
import com.asiainfo.qm.manage.domain.TemplateDetail;
import com.asiainfo.qm.manage.service.AddCheckTemplateService;
import com.asiainfo.qm.manage.util.DateUtil;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qm/configservice/pool/")
public class PoolController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(PoolController.class);

	@Autowired
	private PoolService poolService;
	@Autowired
	private SequenceUtils sequenceUtils;


	// 查询考评模板详细信息
	@ApiOperation(value = "前端调用接口查询质检池详细信息", notes = "qm_configservice查询质检池详细信息", response = PoolServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public PoolServiceResponse selectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		PoolResponse poolResponse = new PoolResponse();
		PoolServiceResponse poolServiceResponse = new PoolServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			poolResponse = poolService.selectByParams(reqParams,start,limit);//查询方法
		}catch (Exception e){
			logger.error("数据查询异常");
			poolResponse.setRspcode(WebUtil.EXCEPTION);
			poolResponse.setRspdesc("数据查询异常!");
		}
		poolServiceResponse.setResponse(poolResponse);
		return poolServiceResponse;
	}

	public PoolServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("数据查询出错啦！");
		logger.error("");
		PoolServiceResponse poolServiceResponse = new PoolServiceResponse();
		return poolServiceResponse;
	}

	@ApiOperation(value = "前端调用接口删除质检池数据", notes = "qm_configservice删除质检池数据", response = PoolServiceResponse.class)
	@ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误")})
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteItems", threadPoolKey = "deleteItemsThread", fallbackMethod = "fallbackDeleteItems", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200")})
	@RequestMapping(value = "/{delArr}", method = RequestMethod.DELETE)
	public PoolServiceResponse deleteItems(@PathVariable("delArr") String delArr) throws Exception {
		PoolResponse poolResponse = new PoolResponse();
		PoolServiceResponse poolServiceResponse = new PoolServiceResponse();
		List<String> idlList = Arrays.asList(delArr.split(","));
		try {
			poolResponse = poolService.deleteItems(idlList);
		} catch (Exception e) {
			logger.error("质检池数据删除异常", e);
			poolResponse.setRspcode(WebUtil.EXCEPTION);
			poolResponse.setRspdesc("质检池数据删除异常!");
		}
		poolServiceResponse.setResponse(poolResponse);
		return poolServiceResponse;
	}

	public PoolServiceResponse fallbackDeleteItems(@RequestParam(name = "delArr") String delArr) throws Exception {
		logger.info("质检池数据删除出错啦！");
		logger.error("");
		return new PoolServiceResponse();
	}
}
