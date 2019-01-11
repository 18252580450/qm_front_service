package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.service.CheckTemplateService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.*;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qm/configservice/checkTemplate/")
public class CheckTemplateController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(CheckTemplateController.class);

	@Autowired
	private CheckTemplateService checkTemplateService;
	@Autowired
	private SequenceUtils sequenceUtils;

	// 以这个为准
	@ApiOperation(value = "前端调用接口查询考评模板数据", notes = "qm_configservice查询考评模板数据", response = CheckTemplateServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			                @ApiResponse(code = 403, message = "资源不存在"),
			                @ApiResponse(code = 404, message = "传入的参数无效"),
			                @ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public CheckTemplateServiceResponse selectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			checkTemplateResponse = checkTemplateService.selectByParams(reqParams,start,limit);//查询方法
		}catch (Exception e){
			logger.error("数据查询异常");
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("数据查询异常!");
		}
		checkTemplateServiceResponse.setResponse(checkTemplateResponse);
        return checkTemplateServiceResponse;
	}

	public CheckTemplateServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("数据查询出错啦！");
		logger.error("");
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		return checkTemplateServiceResponse;
	}

	@ApiOperation(value = "前端调用接口删除考评模板基本信息", notes = "qm_configservice删除考评模板基本信息", response = CheckTemplateServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteByIds", threadPoolKey = "deleteByIdsThread", fallbackMethod = "fallbackDeleteByIds",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/deleteByIds/{ids}", method = RequestMethod.DELETE)
	public CheckTemplateServiceResponse deleteByIds(@PathVariable(name = "ids")String ids) throws Exception {
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		List<String> idList = Arrays.asList(ids.split(","));
		try {
			checkTemplateResponse = checkTemplateService.deleteByIds(idList);
		}catch (Exception e){
			logger.error("考评模板基本信息删除异常");
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("考评模板基本信息删除异常!");
		}
		checkTemplateServiceResponse.setResponse(checkTemplateResponse);
		return checkTemplateServiceResponse;
	}

	@ApiOperation(value = "前端调用接口修改考评模板状态", notes = "qm_configservice修改考评模板状态", response = CheckTemplateResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "action", threadPoolKey = "actionThread", fallbackMethod = "fallbackAction",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/action", method = RequestMethod.PUT)
	public CheckTemplateServiceResponse action(@RequestBody String params) throws Exception {
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		//String 转 List
		JSONArray jsonArray = JSONArray.fromObject(params);
		List<String> list = (List<String>)jsonArray;
		try {
			checkTemplateResponse = checkTemplateService.update(list);
		}catch (Exception e){
			logger.error("数据修改异常");
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("数据修改异常!");
		}
		checkTemplateServiceResponse.setResponse(checkTemplateResponse);
		return checkTemplateServiceResponse;
	}

	@ApiOperation(value = "前端调用接口修改考评模板", notes = "qm_configservice修改考评模板", response = CheckTemplateResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "updateTemplate", threadPoolKey = "updateTemplateThread", fallbackMethod = "fallbackUpdateTemplate",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/updateTemplate", method = RequestMethod.PUT)
	public CheckTemplateServiceResponse updateTemplate(@RequestBody String params) throws Exception {
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		//String 转 List
		JSONArray jsonArray = JSONArray.fromObject(params);
		List<String> list = (List<String>)jsonArray;
		try {
			checkTemplateResponse = checkTemplateService.updateTemplate(list);
		}catch (Exception e){
			logger.error("数据修改异常");
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("数据修改异常!");
		}
		checkTemplateServiceResponse.setResponse(checkTemplateResponse);
		return checkTemplateServiceResponse;
	}

	@ApiOperation(value = "复制考评模板", notes = "qm_configservice复制考评模板", response = CheckTemplateServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "copyTemplate", threadPoolKey = "copyTemplateThread",fallbackMethod = "fallbackCopyTemplate", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/copyTemplate", method = RequestMethod.POST)
	public CheckTemplateServiceResponse copyTemplate(@RequestBody CheckTemplate checkTemplate) throws Exception {

		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		try {
			checkTemplateResponse = checkTemplateService.copyTemplate(checkTemplate);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("复制考评模板异常!");
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("复制考评模板异常!");
		}
		checkTemplateServiceResponse.setResponse(checkTemplateResponse);
		return checkTemplateServiceResponse;
	}

	@ApiOperation(value = "新增基本信息", notes = "qm_configservice新增基本信息", response = CheckTemplateServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "insertCheckTemplate", threadPoolKey = "insertCheckTemplateThread",fallbackMethod = "fallbackInsertCheckTemplate", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/insertCheckTemplate", method = RequestMethod.POST)
	public CheckTemplateServiceResponse insertCheckTemplate(@RequestBody CheckTemplate checkTemplate) throws Exception {
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		try {
			checkTemplateResponse = checkTemplateService.insertCheckTemplate(checkTemplate);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增基本信息异常");
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("新增基本信息异常!");
		}
		checkTemplateServiceResponse.setResponse(checkTemplateResponse);
		return checkTemplateServiceResponse;
	}

	public CheckTemplateServiceResponse fallbackInsertCheckTemplate(@RequestBody CheckTemplate checkTemplate) throws Exception {
		logger.info("新增基本信息出错啦！");
		logger.error("");
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		return checkTemplateServiceResponse;
	}
//
	public CheckTemplateServiceResponse fallbackAction(@RequestBody String params) throws Exception {
		logger.info("修改模板状态出错啦！");
		logger.error("");
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		return checkTemplateServiceResponse;
	}

	public CheckTemplateServiceResponse fallbackUpdateTemplate(@RequestBody String params) throws Exception {
		logger.info("修改模板出错啦！");
		logger.error("");
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		return checkTemplateServiceResponse;
	}

	public CheckTemplateServiceResponse fallbackCopyTemplate(@RequestBody CheckTemplate checkTemplate) throws Exception {
		logger.info("复制考评模板出错啦！");
		logger.error("");
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		return checkTemplateServiceResponse;
	}

	public CheckTemplateServiceResponse fallbackDeleteByIds(@RequestParam(name = "ids")String ids) throws Exception {
		logger.info("考评模板基本信息删除出错啦！");
		logger.error("");
		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
		return checkTemplateServiceResponse;
	}
}
