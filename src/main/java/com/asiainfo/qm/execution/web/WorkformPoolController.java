package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.WorkformPoolService;
import com.asiainfo.qm.execution.vo.WorkformPoolResponse;
import com.asiainfo.qm.execution.vo.WorkformPoolServiceResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.util.WebUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qm/configservice/pool/")
public class WorkformPoolController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(WorkformPoolController.class);

	@Autowired
	private WorkformPoolService workformPoolService;
	@Autowired
	private SequenceUtils sequenceUtils;


	// 查询考评模板详细信息
	@ApiOperation(value = "前端调用接口查询质检池详细信息", notes = "qm_configservice查询质检池详细信息", response = WorkformPoolServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public WorkformPoolServiceResponse selectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
		WorkformPoolServiceResponse workformPoolServiceResponse = new WorkformPoolServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			workformPoolResponse = workformPoolService.selectByParams(reqParams,start,limit);//查询方法
		}catch (Exception e){
			logger.error("数据查询异常");
			workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
			workformPoolResponse.setRspdesc("数据查询异常!");
		}
		workformPoolServiceResponse.setResponse(workformPoolResponse);
		return workformPoolServiceResponse;
	}

	public WorkformPoolServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("数据查询出错啦！");
		logger.error("");
		WorkformPoolServiceResponse workformPoolServiceResponse = new WorkformPoolServiceResponse();
		return workformPoolServiceResponse;
	}

	@ApiOperation(value = "前端调用接口删除质检池数据", notes = "qm_configservice删除质检池数据", response = WorkformPoolServiceResponse.class)
	@ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误")})
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteItems", threadPoolKey = "deleteItemsThread", fallbackMethod = "fallbackDeleteItems", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200")})
	@RequestMapping(value = "/{delArr}", method = RequestMethod.DELETE)
	public WorkformPoolServiceResponse deleteItems(@PathVariable("delArr") String delArr) throws Exception {
		WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
		WorkformPoolServiceResponse workformPoolServiceResponse = new WorkformPoolServiceResponse();
		List<String> idlList = Arrays.asList(delArr.split(","));
		try {
			workformPoolResponse = workformPoolService.deleteItems(idlList);
		} catch (Exception e) {
			logger.error("质检池数据删除异常", e);
			workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
			workformPoolResponse.setRspdesc("质检池数据删除异常!");
		}
		workformPoolServiceResponse.setResponse(workformPoolResponse);
		return workformPoolServiceResponse;
	}

	public WorkformPoolServiceResponse fallbackDeleteItems(@RequestParam(name = "delArr") String delArr) throws Exception {
		logger.info("质检池数据删除出错啦！");
		logger.error("");
		return new WorkformPoolServiceResponse();
	}

	@ApiOperation(value = "前端调用接口清空质检员", notes = "qm_configservice清空质检员", response = WorkformPoolServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "action", threadPoolKey = "actionThread", fallbackMethod = "fallbackAction",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public WorkformPoolServiceResponse action(@RequestBody String params) throws Exception {
		WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
		WorkformPoolServiceResponse voicePoolServiceResponse = new WorkformPoolServiceResponse();
		//String 转 ListMap
		JSONArray jsonArray = JSONArray.fromObject(params);
		List<String> list = (List<String>)jsonArray;
		try {
			workformPoolResponse = workformPoolService.update(list);
		}catch (Exception e){
			logger.error("数据修改异常");
			workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
			workformPoolResponse.setRspdesc("数据修改异常!");
		}
		voicePoolServiceResponse.setResponse(workformPoolResponse);
		return voicePoolServiceResponse;
	}

	public WorkformPoolServiceResponse fallbackAction(@PathVariable("ids") String ids) throws Exception {
		logger.info("数据更新出错啦！");
		logger.error("");
		return new WorkformPoolServiceResponse();
	}
}
