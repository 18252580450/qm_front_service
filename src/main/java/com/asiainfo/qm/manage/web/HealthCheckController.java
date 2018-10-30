package com.asiainfo.qm.manage.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

//注意:根据需要添加，不添加到项目中默认访问项目根路径
//@Api(value = "configservice_user")
@RestController
//@RequestMapping("/kc/configservice/")
public class HealthCheckController {

	
	@RequestMapping(value = "healthcheck", method = RequestMethod.GET)
	public String healthCheck() {
        return "200OK";
	}


}
