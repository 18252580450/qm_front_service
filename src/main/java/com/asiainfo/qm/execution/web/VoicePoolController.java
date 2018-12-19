package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.VoicePoolService;
import com.asiainfo.qm.execution.vo.VoicePoolResponse;
import com.asiainfo.qm.execution.vo.VoicePoolServiceResponse;
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

import java.util.*;

@RestController
@RequestMapping("/qm/configservice/voicePool/")
public class VoicePoolController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(VoicePoolController.class);

	@Autowired
	private VoicePoolService voicePoolService;
	@Autowired
	private SequenceUtils sequenceUtils;


	// 查询考评模板详细信息
	@ApiOperation(value = "前端调用接口查询语音质检池详细信息", notes = "qm_configservice查询语音质检池详细信息", response = VoicePoolServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public VoicePoolServiceResponse selectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
		VoicePoolServiceResponse voicePoolServiceResponse = new VoicePoolServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			voicePoolResponse = voicePoolService.selectByParams(reqParams,start,limit);//查询方法
		}catch (Exception e){
			logger.error("数据查询异常");
			voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
			voicePoolResponse.setRspdesc("数据查询异常!");
		}
		voicePoolServiceResponse.setResponse(voicePoolResponse);
		return voicePoolServiceResponse;
	}

	public VoicePoolServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("数据查询出错啦！");
		logger.error("");
		VoicePoolServiceResponse voicePoolServiceResponse = new VoicePoolServiceResponse();
		return voicePoolServiceResponse;
	}

	@ApiOperation(value = "前端调用接口清空质检员", notes = "qm_configservice清空质检员", response = VoicePoolServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "action", threadPoolKey = "actionThread", fallbackMethod = "fallbackAction",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/{ids}", method = RequestMethod.PUT)
	public VoicePoolServiceResponse action(@PathVariable("ids") String ids) throws Exception {
		VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
		VoicePoolServiceResponse voicePoolServiceResponse = new VoicePoolServiceResponse();
		List<String> idlList = Arrays.asList(ids.split(","));
		try {
			voicePoolResponse = voicePoolService.update(idlList);
		}catch (Exception e){
			logger.error("数据修改异常");
			voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
			voicePoolResponse.setRspdesc("数据修改异常!");
		}
		voicePoolServiceResponse.setResponse(voicePoolResponse);
		return voicePoolServiceResponse;
	}

	public VoicePoolServiceResponse fallbackAction(@PathVariable("ids") String ids) throws Exception {
		logger.info("数据更新出错啦！");
		logger.error("");
		return new VoicePoolServiceResponse();
	}

	@ApiOperation(value = "前端调用接口配置质检员", notes = "qm_configservice配置质检员", response = VoicePoolServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "updateCheck", threadPoolKey = "updateCheckThread", fallbackMethod = "fallbackUpdateCheck",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/updateCheck", method = RequestMethod.PUT)
	public VoicePoolServiceResponse updateCheck(@RequestBody String params) throws Exception {
		VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
		VoicePoolServiceResponse voicePoolServiceResponse = new VoicePoolServiceResponse();
		//String 转 ListMap
		JSONArray jsonArray = JSONArray.fromObject(params);
		List<Map> list = (List<Map>)jsonArray;
		try {
			voicePoolResponse = voicePoolService.updateCheck(list);
		}catch (Exception e){
			logger.error("配置质检员异常");
			voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
			voicePoolResponse.setRspdesc("配置质检员异常!");
		}
		voicePoolServiceResponse.setResponse(voicePoolResponse);
		return voicePoolServiceResponse;
	}

	public VoicePoolServiceResponse fallbackUpdateCheck(@RequestBody String params)  throws Exception {
		logger.info("配置质检员出错啦！");
		logger.error("");
		return new VoicePoolServiceResponse();
	}

	@ApiOperation(value = "前端调用接口删除质检池数据", notes = "qm_configservice删除质检池数据", response = VoicePoolServiceResponse.class)
	@ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误")})
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteItems", threadPoolKey = "deleteItemsThread", fallbackMethod = "fallbackDeleteItems", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200")})
	@RequestMapping(value = "/{delArr}", method = RequestMethod.DELETE)
	public VoicePoolServiceResponse deleteItems(@PathVariable("delArr") String delArr) throws Exception {
		VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
		VoicePoolServiceResponse voicePoolServiceResponse = new VoicePoolServiceResponse();
		List<String> idlList = Arrays.asList(delArr.split(","));
		try {
			voicePoolResponse = voicePoolService.deleteItems(idlList);
		} catch (Exception e) {
			logger.error("质检池数据删除异常", e);
			voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
			voicePoolResponse.setRspdesc("质检池数据删除异常!");
		}
		voicePoolServiceResponse.setResponse(voicePoolResponse);
		return voicePoolServiceResponse;
	}

	public VoicePoolServiceResponse fallbackDeleteItems(@RequestParam(name = "delArr") String delArr) throws Exception {
		logger.info("质检池数据删除出错啦！");
		logger.error("");
		return new VoicePoolServiceResponse();
	}
}
