package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.service.StaticParamsService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.StaticParamsResponse;
import com.asiainfo.qm.manage.vo.StaticParamsServiceResponse;
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
@RequestMapping("/qm/configservice/staticParams/")
public class StaticParamsController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(StaticParamsController.class);

	@Autowired
	private StaticParamsService staticParamsService;
	@Autowired
	private SequenceUtils sequenceUtils;

	// 以这个为准
	@ApiOperation(value = "前端调用接口查询静态配置参数", notes = "qm_configservice查询静态配置参数", response = StaticParamsServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			                @ApiResponse(code = 403, message = "资源不存在"),
			                @ApiResponse(code = 404, message = "传入的参数无效"),
			                @ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public StaticParamsServiceResponse selectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		StaticParamsResponse staticParamsResponse = new StaticParamsResponse();
		StaticParamsServiceResponse staticParamsServiceResponse = new StaticParamsServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			staticParamsResponse = staticParamsService.selectByParams(reqParams,start,limit);
		}catch (Exception e){
			logger.error("数据查询异常");
			staticParamsResponse.setRspcode(WebUtil.EXCEPTION);
			staticParamsResponse.setRspdesc("数据查询异常!");
		}
		staticParamsServiceResponse.setResponse(staticParamsResponse);
        return staticParamsServiceResponse;
	}

	public StaticParamsServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("数据查询出错啦！");
		logger.error("");
		StaticParamsServiceResponse staticParamsServiceResponse = new StaticParamsServiceResponse();
		return staticParamsServiceResponse;
	}

	@ApiOperation(value = "前端调用接口查询静态配置参数", notes = "qm_configservice删除静态配置参数", response = StaticParamsServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "deleteByIds", threadPoolKey = "deleteByIdsThread", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/deleteByIds/{ids}", method = RequestMethod.DELETE)
	public StaticParamsServiceResponse deleteByIds(@PathVariable("ids")String ids) throws Exception {
		StaticParamsResponse staticParamsResponse = new StaticParamsResponse();
		StaticParamsServiceResponse staticParamsServiceResponse = new StaticParamsServiceResponse();
		List<String> idList = Arrays.asList(ids.split(","));
		try {
			staticParamsResponse = staticParamsService.deleteByIds(idList);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("数据删除异常");
			staticParamsResponse.setRspcode(WebUtil.EXCEPTION);
			staticParamsResponse.setRspdesc("数据删除异常!");
		}
		staticParamsServiceResponse.setResponse(staticParamsResponse);
		return staticParamsServiceResponse;
	}

	public StaticParamsServiceResponse fallbackDeleteByIds(@RequestParam(name = "ids")String ids) throws Exception {
		logger.info("数据删除出错啦！");
		logger.error("");
		StaticParamsServiceResponse staticParamsServiceResponse = new StaticParamsServiceResponse();
		return staticParamsServiceResponse;
	}
}
