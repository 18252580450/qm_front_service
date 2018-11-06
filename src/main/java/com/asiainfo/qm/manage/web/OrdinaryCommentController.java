package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.OrdinaryComment;
import com.asiainfo.qm.manage.service.OrdinaryCommentService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.DemoUserServiceResponse;
import com.asiainfo.qm.manage.vo.OrdinaryCommentResponse;
import com.asiainfo.qm.manage.vo.OrdinaryCommentServiceResponse;
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
@RequestMapping("/qm/configservice/ordinaryComment/")
public class OrdinaryCommentController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(OrdinaryCommentController.class);

	@Autowired
	private OrdinaryCommentService ordinaryCommentService;
	@Autowired
	private SequenceUtils sequenceUtils;

	// 以这个为准
	@ApiOperation(value = "前端调用接口查询考评评语数据", notes = "qm_configservice查询考评评语数据", response = OrdinaryCommentServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			                @ApiResponse(code = 403, message = "资源不存在"),
			                @ApiResponse(code = 404, message = "传入的参数无效"),
			                @ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public OrdinaryCommentServiceResponse selectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		OrdinaryCommentResponse ordinaryCommentResponse = new OrdinaryCommentResponse();
		OrdinaryCommentServiceResponse ordinaryCommentServiceResponse = new OrdinaryCommentServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			ordinaryCommentResponse = ordinaryCommentService.selectByParams(reqParams,start,limit);//查询方法
		}catch (Exception e){
			logger.error("数据查询异常");
			ordinaryCommentResponse.setRspcode(WebUtil.EXCEPTION);
			ordinaryCommentResponse.setRspdesc("数据查询异常!");
		}
		ordinaryCommentServiceResponse.setResponse(ordinaryCommentResponse);
        return ordinaryCommentServiceResponse;
	}

	public OrdinaryCommentServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("数据查询出错啦！");
		logger.error("");
		OrdinaryCommentServiceResponse ordinaryCommentServiceResponse = new OrdinaryCommentServiceResponse();
		return ordinaryCommentServiceResponse;
	}

	@ApiOperation(value = "前端调用接口删除考评评语数据", notes = "qm_configservice删除考评评语数据", response = OrdinaryCommentResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteByIds", threadPoolKey = "deleteByIdsThread", fallbackMethod = "fallbackDeleteByIds",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/deleteByIds/{ids}", method = RequestMethod.DELETE)
	public OrdinaryCommentServiceResponse deleteByIds(@PathVariable(name = "ids")String ids) throws Exception {
		OrdinaryCommentResponse ordinaryCommentResponse = new OrdinaryCommentResponse();
		OrdinaryCommentServiceResponse ordinaryCommentServiceResponse = new OrdinaryCommentServiceResponse();
		List<String> idList = Arrays.asList(ids.split(","));
		try {
			ordinaryCommentResponse = ordinaryCommentService.deleteByIds(idList);
		}catch (Exception e){
			logger.error("数据删除异常");
			ordinaryCommentResponse.setRspcode(WebUtil.EXCEPTION);
			ordinaryCommentResponse.setRspdesc("数据删除异常!");
		}
		ordinaryCommentServiceResponse.setResponse(ordinaryCommentResponse);
		return ordinaryCommentServiceResponse;
	}

	@ApiOperation(value = "前端调用接口修改考评评语数据", notes = "qm_configservice修改考评评语数据", response = OrdinaryCommentResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "updateById", threadPoolKey = "updateByIdThread", fallbackMethod = "fallbackUpdateById",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/updateComment", method = RequestMethod.PUT)
	public OrdinaryCommentServiceResponse updateComment(@RequestBody OrdinaryComment ordinaryComment) throws Exception {
		OrdinaryCommentResponse ordinaryCommentResponse = new OrdinaryCommentResponse();
		OrdinaryCommentServiceResponse ordinaryCommentServiceResponse = new OrdinaryCommentServiceResponse();
//		Map reqParams = JSONObject.parseObject(params);
//		List<String> idList = Arrays.asList(id.split(","));
		try {
			ordinaryCommentResponse = ordinaryCommentService.updateComment(ordinaryComment);
		}catch (Exception e){
			logger.error("数据修改异常");
			ordinaryCommentResponse.setRspcode(WebUtil.EXCEPTION);
			ordinaryCommentResponse.setRspdesc("数据修改异常!");
		}
		ordinaryCommentServiceResponse.setResponse(ordinaryCommentResponse);
		return ordinaryCommentServiceResponse;
	}

	@ApiOperation(value = "新增评语", notes = "qm_configservice新增评语", response = OrdinaryCommentServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "insertComment", threadPoolKey = "insertCommentThread",fallbackMethod = "fallbackInsertComment", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/insertComment", method = RequestMethod.POST)
	public OrdinaryCommentServiceResponse insertComment(@RequestBody OrdinaryComment ordinaryComment) throws Exception {
		OrdinaryCommentResponse ordinaryCommentResponse = new OrdinaryCommentResponse();
		OrdinaryCommentServiceResponse ordinaryCommentServiceResponse = new OrdinaryCommentServiceResponse();
		try {
			ordinaryCommentResponse = ordinaryCommentService.insertComment(ordinaryComment);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增评语异常");
			ordinaryCommentResponse.setRspcode(WebUtil.EXCEPTION);
			ordinaryCommentResponse.setRspdesc("新增评语异常!");
		}
		ordinaryCommentServiceResponse.setResponse(ordinaryCommentResponse);
		return ordinaryCommentServiceResponse;
	}

	public OrdinaryCommentServiceResponse fallbackInsertComment(@RequestBody OrdinaryComment ordinaryComment) throws Exception {
		logger.info("新增评语出错啦！");
		logger.error("");
		OrdinaryCommentServiceResponse ordinaryCommentServiceResponse = new OrdinaryCommentServiceResponse();
		return ordinaryCommentServiceResponse;
	}

	public OrdinaryCommentServiceResponse fallbackDeleteByIds(@RequestParam(name = "ids")String ids) throws Exception {
		logger.info("数据删除出错啦！");
		logger.error("");
		OrdinaryCommentServiceResponse ordinaryCommentServiceResponse = new OrdinaryCommentServiceResponse();
		return ordinaryCommentServiceResponse;
	}

	public OrdinaryCommentServiceResponse fallbackUpdateById(@RequestBody OrdinaryComment ordinaryComment) throws Exception {
		logger.info("数据更新出错啦！");
		logger.error("");
		OrdinaryCommentServiceResponse ordinaryCommentServiceResponse = new OrdinaryCommentServiceResponse();
		return ordinaryCommentServiceResponse;
	}
}
