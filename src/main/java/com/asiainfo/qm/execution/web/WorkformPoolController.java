package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.domain.WorkformPool;
import com.asiainfo.qm.execution.service.WorkformPoolService;
import com.asiainfo.qm.execution.vo.WorkformPoolResponse;
import com.asiainfo.qm.execution.vo.WorkformPoolServiceResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.util.ExcelUtil;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/qm/configservice/orderPool/")
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

	@ApiOperation(value = "前端调用接口配置质检员", notes = "qm_configservice配置质检员", response = WorkformPoolServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "updateCheck", threadPoolKey = "updateCheckThread", fallbackMethod = "fallbackUpdateCheck",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/updateCheck", method = RequestMethod.PUT)
	public WorkformPoolServiceResponse updateCheck(@RequestBody String params) throws Exception {
		WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
		WorkformPoolServiceResponse workformPoolServiceResponse = new WorkformPoolServiceResponse();
		//String 转 ListMap
		JSONArray jsonArray = JSONArray.fromObject(params);
		List<Map> list = (List<Map>)jsonArray;
		try {
			workformPoolResponse = workformPoolService.updateCheck(list);
		}catch (Exception e){
			logger.error("配置质检员异常");
			workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
			workformPoolResponse.setRspdesc("配置质检员异常!");
		}
		workformPoolServiceResponse.setResponse(workformPoolResponse);
		return workformPoolServiceResponse;
	}

	public WorkformPoolServiceResponse fallbackUpdateCheck(@RequestBody String params)  throws Exception {
		logger.info("配置质检员出错啦！");
		logger.error("");
		return new WorkformPoolServiceResponse();
	}

//	@ResponseBody
//	@RequestMapping(value="/exportSysUsers.do", method=RequestMethod.GET)
//	public void exportSysUsers(HttpServletRequest req, HttpServletResponse res,
//							   String name, String phone, String email, Integer roleId, String createTimeStart, String createTimeEnd,
//							   Integer status, Integer departmentId) throws IOException {
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("name", "".equals(name) || null == name ? null : name);
//		params.put("phone", "".equals(phone) || null == phone ? null : phone);
//		params.put("email", "".equals(email) || null == email ? null : email);
//		params.put("roleId", "".equals(roleId) || null == roleId ? null : roleId);
//		params.put("createTimeStart", "".equals(createTimeStart) || null == createTimeStart ? null : createTimeStart+" 00:00:00");
//		params.put("createTimeEnd", "".equals(createTimeEnd) || null == createTimeEnd ? null : createTimeEnd+" 23:59:59");
//		params.put("status", "".equals(status) || null == status ? null : status);
//		params.put("departmentId", "".equals(departmentId) || null == departmentId ? null : departmentId);
//
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		String formatTime = sdf.format(d);
//		String fileName="系统用户表-"+formatTime;
//		//填充projects数据
//		List<WorkformPool> userList = sysUserService.getUserList(params);
//		List<Map<String,Object>> list=createExcelRecord(userList);
//		String columnNames[]={"姓名", "性别", "邮箱", "电话", "部门", "角色", "状态", "创建时间"};//列名
//		String keys[] = {"name", "gender", "email", "phone", "department", "role", "status", "createTime"};//map中的key
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
//		try {
//			ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		byte[] content = os.toByteArray();
//		InputStream is = new ByteArrayInputStream(content);
//		// 设置response参数，可以打开下载页面
//		res.reset();
//		res.setContentType("application/vnd.ms-excel;charset=utf-8");
//		res.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
//		ServletOutputStream out = res.getOutputStream();
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
//		try {
//			bis = new BufferedInputStream(is);
//			bos = new BufferedOutputStream(out);
//			byte[] buff = new byte[2048];
//			int bytesRead;
//			// Simple read/write loop.
//			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//				bos.write(buff, 0, bytesRead);
//			}
//		} catch (final IOException e) {
//			throw e;
//		} finally {
//			if (bis != null)
//				bis.close();
//			if (bos != null)
//				bos.close();
//		}
//	}
//
//	/**
//	 * 生成Excel数据
//	 * @param userList
//	 * @return
//	 */
//	private List<Map<String, Object>> createExcelRecord(List<SysUser> userList) {
//		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("sheetName", "sheet1");
//		listmap.add(map);
//		SysUser user = null;
//		for (int j = 0; j < userList.size(); j++) {
//			user = userList.get(j);
//			Map<String, Object> mapValue = new HashMap<String, Object>();
//			mapValue.put("name", user.getName());
//			mapValue.put("gender", (user.getGender()==1) ? "男":((user.getGender()==0) ? "女" : "保密"));
//			mapValue.put("email", user.getEmail());
//			mapValue.put("phone", user.getPhone());
//			mapValue.put("department", user.getDepartment().getName());
//			mapValue.put("role", user.getRole().getName());
//			mapValue.put("status", user.getStatus()==1 ? "启用" : "禁用");
//			mapValue.put("createTime", user.getCreateTime().substring(0, 19));
//			listmap.add(mapValue);
//		}
//		return listmap;
//	}
}
