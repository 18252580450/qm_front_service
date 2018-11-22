package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.TplOpLog;
import com.asiainfo.qm.manage.service.CheckTemplateService;
import com.asiainfo.qm.manage.service.TplOpLogService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckTemplateResponse;
import com.asiainfo.qm.manage.vo.CheckTemplateServiceResponse;
import com.asiainfo.qm.manage.vo.TplOpLogResponse;
import com.asiainfo.qm.manage.vo.TplOpLogServiceResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/qm/configservice/tplOpLog/")
public class TplOpLogController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(TplOpLogController.class);

	@Autowired
	private TplOpLogService tplOpLogService;
	@Autowired
	private SequenceUtils sequenceUtils;

//	@ApiOperation(value = "前端调用接口修改考评模板状态", notes = "qm_configservice修改考评模板状态", response = CheckTemplateResponse.class)
//	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
//			@ApiResponse(code = 403, message = "资源不存在"),
//			@ApiResponse(code = 404, message = "传入的参数无效"),
//			@ApiResponse(code = 500, message = "服务器出现异常错误") })
//	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "action", threadPoolKey = "actionThread", fallbackMethod = "fallbackAction",commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
//			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
//			@HystrixProperty(name = "coreSize", value = "200") })
//	@RequestMapping(value = "/action", method = RequestMethod.PUT)
//	public CheckTemplateServiceResponse action(@RequestBody CheckTemplate checkTemplate) throws Exception {
//		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
//		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
//		try {
//			checkTemplateResponse = checkTemplateService.action(checkTemplate);
//		}catch (Exception e){
//			logger.error("数据修改异常");
//			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
//			checkTemplateResponse.setRspdesc("数据修改异常!");
//		}
//		checkTemplateServiceResponse.setResponse(checkTemplateResponse);
//		return checkTemplateServiceResponse;
//	}



	@ApiOperation(value = "新增操作日志", notes = "qm_configservice新增操作日志", response = TplOpLogServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "insertTplOpLog", threadPoolKey = "insertTplOpLogThread",fallbackMethod = "fallbackInsertTplOpLog", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/insertTplOpLog", method = RequestMethod.POST)
	public TplOpLogServiceResponse insertTplOpLog(@RequestBody TplOpLog tplOpLog) throws Exception {
		TplOpLogResponse tplOpLogResponse = new TplOpLogResponse();
		TplOpLogServiceResponse tplOpLogServiceResponse = new TplOpLogServiceResponse();
		try {
			tplOpLogResponse = tplOpLogService.insertTplOpLog(tplOpLog);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增操作日志异常");
			tplOpLogResponse.setRspcode(WebUtil.EXCEPTION);
			tplOpLogResponse.setRspdesc("新增操作日志异常!");
		}
		tplOpLogServiceResponse.setResponse(tplOpLogResponse);
		return tplOpLogServiceResponse;
	}

	public TplOpLogServiceResponse fallbackInsertTplOpLog(@RequestBody TplOpLog tplOpLog) throws Exception {
		logger.info("新增操作日志出错啦！");
		logger.error("");
		TplOpLogServiceResponse tplOpLogServiceResponse = new TplOpLogServiceResponse();
		return tplOpLogServiceResponse;
	}
//
//	public CheckTemplateServiceResponse fallbackAction(@RequestBody CheckTemplate checkTemplate) throws Exception {
//		logger.info("修改模板状态出错啦！");
//		logger.error("");
//		CheckTemplateServiceResponse checkTemplateServiceResponse = new CheckTemplateServiceResponse();
//		return checkTemplateServiceResponse;
//	}

}
