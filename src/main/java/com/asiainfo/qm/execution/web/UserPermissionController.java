package com.asiainfo.qm.execution.web;

import com.asiainfo.qm.execution.vo.UserPermissionResponse;
import com.asiainfo.qm.execution.vo.WorkformPoolServiceResponse;
import com.asiainfo.qm.manage.dao.UserPermissionMapper;
import com.asiainfo.qm.manage.domain.UserPermission;
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
@RequestMapping("/qm/configservice/userPermission/")
public class UserPermissionController {

	@Autowired
	private UserPermissionMapper userPermissionMapper;
	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(UserPermissionController.class);

	// 查询考评模板详细信息
	@ApiOperation(value = "前端调用接口查询质检池详细信息", notes = "qm_configservice查询质检池详细信息", response = WorkformPoolServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "qryUserPermission", threadPoolKey = "qryUserPermissionThread", fallbackMethod = "fallbackQryUserPermission",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/qryUserPermission", method = RequestMethod.GET)
	public UserPermissionResponse qryUserPermission(@RequestParam(name = "params")String params) throws Exception {
		UserPermissionResponse userPermissionResponse = new UserPermissionResponse();
		JSONArray arry = JSONArray.fromObject(params);
		//把json数据放入到list中
		List paramList = new ArrayList<String>();
		for(Object obj:arry){
			paramList.add(obj);
		}
		try {
			List<UserPermission> list = userPermissionMapper.qryUserPermission(paramList);
			if(list.size() > 0){
				userPermissionResponse.setRspcode(WebUtil.SUCCESS);
				userPermissionResponse.setRspdesc("查询用户权限成功");
				userPermissionResponse.setData(list);
			}else {
				userPermissionResponse.setRspcode(WebUtil.FAIL);
				userPermissionResponse.setRspdesc("无数据");
			}
		}catch (Exception e){
			logger.error("用户权限查询异常");
			userPermissionResponse.setRspcode(WebUtil.EXCEPTION);
			userPermissionResponse.setRspdesc("用户权限查询异常!");
		}
		return userPermissionResponse;
	}

	public UserPermissionResponse fallbackQryUserPermission(@RequestParam(name = "params")String params) throws Exception {
		logger.info("用户权限查询出错啦！");
		logger.error("");
		UserPermissionResponse userPermissionResponse = new UserPermissionResponse();
		return userPermissionResponse;
	}
}
