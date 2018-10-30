package com.asiainfo.qm.manage.web;

import com.asiainfo.qm.manage.service.DemoUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.qm.manage.vo.DemoUserResponse;
import com.asiainfo.qm.manage.vo.DemoUserServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "configservice_user") // API的名称
@RestController
@RequestMapping("/kc/configservice/")
public class DemoUserController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(DemoUserController.class);

	@Autowired
	private DemoUserService userService;
	@Autowired
	private SequenceUtils sequenceUtils;

	// 以这个为准
	@ApiOperation(value = "前端调用接口查询用户信息", notes = "knowledgeservice查询用户", response = DemoUserServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			                @ApiResponse(code = 403, message = "资源不存在"),
			                @ApiResponse(code = 404, message = "传入的参数无效"),
			                @ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "kc_configservice ", commandKey = "getUserById", threadPoolKey = "getUserByIdThread", fallbackMethod = "fallbackGetResult", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public DemoUserServiceResponse getUserById(@ApiParam(value = "用户ID", required = true) @PathVariable("id") Integer id) throws Exception {

		DemoUserResponse demoUserResponse = null;

		demoUserResponse=userService.getUserById(1);

        DemoUserServiceResponse demoUserServiceResponse = new DemoUserServiceResponse();
        demoUserServiceResponse.setResponse(demoUserResponse);

        //参见：2.7.3业务日志内容格式规范说明
        logger.info("");
        logger.error("");

        //自动生成主键（下面只在插入方法时使用以下代码）
        Long SS = sequenceUtils.getSequence("demo");

        return demoUserServiceResponse;

	}

	// 降级处理的函数
	public DemoUserServiceResponse fallbackGetResult(Integer id) {
		 //参见：2.7.3业务日志内容格式规范说明
        logger.info("");
        logger.error("");
        
		DemoUserServiceResponse serviceResponse = new DemoUserServiceResponse();
		
		return serviceResponse;
	}

}
