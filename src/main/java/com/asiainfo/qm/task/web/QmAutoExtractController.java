package com.asiainfo.qm.task.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qm/configservice/qmAutoExtract/")
public class QmAutoExtractController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(QmAutoExtractController.class);

//	@Autowired
//	private QmPlanService qmPlanService;
//
//	@ApiOperation(value = "查询考评计划", notes = "qm_configservice查询考评计划", response = QmPlanServiceResponse.class)
//	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
//			                @ApiResponse(code = 403, message = "资源不存在"),
//			                @ApiResponse(code = 404, message = "传入的参数无效"),
//			                @ApiResponse(code = 500, message = "服务器出现异常错误") })
//	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
//			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
//					@HystrixProperty(name = "coreSize", value = "200") })
//	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
//	public QmPlanServiceResponse selectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
//		QmPlanResponse qmPlanResponse = new QmPlanResponse();
//		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
//		Map reqParams = JSONObject.parseObject(params);
//		try {
//			qmPlanResponse = qmPlanService.selectByParams(reqParams,start,limit);
//		}catch (Exception e){
//			logger.error("考评计划查询异常");
//			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
//			qmPlanResponse.setRspdesc("考评计划查询异常!");
//		}
//		qmPlanServiceResponse.setResponse(qmPlanResponse);
//        return qmPlanServiceResponse;
//	}
//
//	public QmPlanServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params,@RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
//		logger.info("考评计划查询出错啦！");
//		logger.error("");
//		QmPlanServiceResponse qmPlanServiceResponse = new QmPlanServiceResponse();
//		return qmPlanServiceResponse;
//	}


}
