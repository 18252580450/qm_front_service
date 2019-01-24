package com.asiainfo.qm.task.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckTemplateServiceResponse;
import com.asiainfo.qm.task.domain.QmBindRlnKey;
import com.asiainfo.qm.task.service.QmBindRlnService;
import com.asiainfo.qm.task.vo.QmBindRlnResponse;
import com.asiainfo.qm.task.vo.QmBindRlnServiceResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qm/configservice/qmBindRln/")
public class QmBindRlnController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(QmBindRlnController.class);

	@Autowired
	private QmBindRlnService qmBindRlnService;
	@Autowired
	private SequenceUtils sequenceUtils;

	@ApiOperation(value = "前端调用接口删除考评计划人员绑定信息", notes = "qm_configservice删除考评计划人员绑定信息", response = CheckTemplateServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteByIds", threadPoolKey = "deleteByIdsThread", fallbackMethod = "fallbackDeleteByIds",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public QmBindRlnServiceResponse deleteByIds(@RequestBody String params) throws Exception {
		QmBindRlnResponse qmBindRlnResponse = new QmBindRlnResponse();
		QmBindRlnServiceResponse qmBindRlnServiceResponse = new QmBindRlnServiceResponse();
		Map map = (Map) JSON.parse(params);//转换成Map
		List<Map<String,Object>> list = (List<Map<String,Object>>) map.get("params");
		try {
			qmBindRlnResponse = qmBindRlnService.deleteByIds(list);
		}catch (Exception e){
			logger.error("考评计划人员绑定信息删除异常");
			qmBindRlnResponse.setRspcode(WebUtil.EXCEPTION);
			qmBindRlnResponse.setRspdesc("考评计划人员绑定信息删除异常!");
		}
		qmBindRlnServiceResponse.setResponse(qmBindRlnResponse);
		return qmBindRlnServiceResponse;
	}

	public QmBindRlnServiceResponse fallbackDeleteByIds(@RequestBody String params) throws Exception {
		logger.info("考评模板基本信息删除出错啦！");
		logger.error("");
		QmBindRlnServiceResponse qmBindRlnServiceResponse = new QmBindRlnServiceResponse();
		return qmBindRlnServiceResponse;
	}

	@ApiOperation(value = "前端调用接口查询", notes = "qm_configservice查询", response = CheckTemplateServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByPrimaryKey",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public QmBindRlnServiceResponse selectByPrimaryKey(@RequestParam(name = "params")String params) throws Exception {
		QmBindRlnResponse qmBindRlnResponse = new QmBindRlnResponse();
		QmBindRlnServiceResponse qmBindRlnServiceResponse = new QmBindRlnServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		QmBindRlnKey qmBindRlnKey = new QmBindRlnKey();
		qmBindRlnKey.setCheckedObjectId((String) reqParams.get("checkedObjectId"));
		qmBindRlnKey.setCheckStaffId((String) reqParams.get("checkStaffId"));
		qmBindRlnKey.setPlanId((String) reqParams.get("planId"));
		try {
			qmBindRlnResponse = qmBindRlnService.selectByPrimaryKey(qmBindRlnKey);//查询方法
		}catch (Exception e){
			logger.error("数据查询异常");
			qmBindRlnResponse.setRspcode(WebUtil.EXCEPTION);
			qmBindRlnResponse.setRspdesc("数据查询异常!");
		}
		qmBindRlnServiceResponse.setResponse(qmBindRlnResponse);
		return qmBindRlnServiceResponse;
	}

	public QmBindRlnServiceResponse fallbackSelectByPrimaryKey(@RequestParam(name = "params")String params) throws Exception {
		logger.info("数据查询出错啦！");
		logger.error("");
		QmBindRlnServiceResponse qmBindRlnServiceResponse = new QmBindRlnServiceResponse();
		return qmBindRlnServiceResponse;
	}
}
