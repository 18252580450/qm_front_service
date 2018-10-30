package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.restClient.RestClient;
import com.asiainfo.qm.manage.dao.DemoUserMapper;
import com.asiainfo.qm.manage.domain.DemoUser;
import com.asiainfo.qm.manage.redis.RedisCommand;
import com.asiainfo.qm.manage.service.DemoUserService;
import com.asiainfo.qm.manage.util.BeanDictUtils;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.DemoUserResponse;
import com.asiainfo.qm.manage.vo.DemoUserServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import com.unicom.kc.manage.demo.vo.req.DemoUserRequestMsg;


/**
 *
 */
@Service
public class DemoUserServiceImpl implements DemoUserService {

	private static Logger logger = LoggerFactory.getLogger(DemoUserServiceImpl.class);

	@Autowired
	private DemoUserMapper userMapper;

	@Autowired
	private RedisCommand redisCommand;
	
	@Autowired
	private RestClient restClient;

	@Override
	public DemoUserResponse getUserById(Integer id) throws Exception  {
		logger.info("---------------------------------->id=" + id);// 具体日志格式参照文档
		DemoUserResponse demoUserResponse = new DemoUserResponse();
		demoUserResponse.setRspcode(WebUtil.SUCCESS);
		demoUserResponse.setRspdesc("查询目录树成功！");
		List<DemoUser> list = new ArrayList<DemoUser>();
		DemoUser demoUser = userMapper.selectByPrimaryKey(id);
		/******************************************/
		//动态增加属性
		Map<String, Object> newProperties = new HashMap<String,Object>();
		newProperties.put("displayLabel", "知识分享");
		newProperties.put("innerLabel", "KNOW");
		Object o = BeanDictUtils.convert(demoUser, newProperties);
		list.add((DemoUser) o);
		demoUserResponse.setData(list);
		/******************************************/
		logger.info("---------------从数据库取出来的信息是------------------->" + demoUser.getName());// 具体日志格式参照文档

		redisCommand.set("testkey", "testvalue");
		String testkey = redisCommand.get("testkey");
		logger.info("---------------从缓存取出来的信息是------------------->" + testkey);// 具体日志格式参照文档

		// 参见：2.7.3业务日志内容格式规范说明
		logger.info("");
		logger.error("");

		return demoUserResponse;
	}

//		调用远程微服务
//		@Override
		public DemoUserServiceResponse getUserInfo() {
//			DemoUserRequestMsg demoUserRequestMsg = new DemoUserRequestMsg();
//			DemoUserRequestMsg.DemoUserServiceBody body = demoUserRequestMsg.new DemoUserServiceBody();
//			body.setUserId(1l);
//			demoUserRequestMsg.setServiceBody(body);
//			DemoUserServiceResponse rsp = (DemoUserServiceResponse) RestClient.getInstance().getForObjectWithHeader(
//					"http://localhost:8080/kc/configservice/users/1", DemoUserServiceResponse.class,null);
			DemoUserServiceResponse rsp = (DemoUserServiceResponse) restClient.getForObjectWithHeader(
					"http://localhost:8080/qm/configservice/users/1", DemoUserServiceResponse.class, null, null,"");
//			DemoUserServiceResponse rsp = (DemoUserServiceResponse) restClient.callRemoteServicetWithHeader(
//					"http://localhost:8080/kc/configservice/userinfo", HttpMethod.POST, demoUserRequestMsg,
//					DemoUserServiceResponse.class, null);
			return rsp;
		}

}
