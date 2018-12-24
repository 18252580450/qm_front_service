package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.service.VoicePoolService;
import com.asiainfo.qm.execution.vo.VoicePoolResponse;
import com.asiainfo.qm.execution.vo.VoicePoolServiceResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.util.ExcelUtil;
import com.asiainfo.qm.manage.util.JDBCUtils;
import com.asiainfo.qm.manage.util.WebUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.json.JSONArray;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.net.URLDecoder;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
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

	@ResponseBody
	@RequestMapping(value="/export", method=RequestMethod.GET)
	public void export(HttpServletResponse response, String params) throws Exception {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatTime = sdf.format(d);

		String str= URLDecoder.decode(params, "UTF-8");
		Map paramsMap = net.sf.json.JSONObject.fromObject(str);//转成Map
		int start = (int) paramsMap.get("start");
		int limit = (int) paramsMap.get("pageNum");
		String param = (String) paramsMap.get("params");
		Map reqParams = net.sf.json.JSONObject.fromObject(param);//转成Map
		String fields = (String) paramsMap.get("fields");
		JSONArray fieldsList = JSONArray.fromObject(fields);//转list
		String titles = (String) paramsMap.get("titles");
		JSONArray titlesList = JSONArray.fromObject(titles);//转list

		VoicePoolResponse voicePoolResponse = voicePoolService.selectByParams(reqParams,start,limit);//查询方法
		List<VoicePool> list = voicePoolResponse.getData();
		List<Map<String,Object>> listMap = new ArrayList<>();
		Map<String, Object> m= new HashMap<String, Object>();
		m.put("sheetName", "sheet1");
		listMap.add(m);
		if (list != null && list.size() > 0) {
			Map<String, Object> map = null;
			VoicePool voicePool = null;
			for (int i = 0,size = list.size(); i < size; i++) {
				voicePool = list.get(i);
				map = net.sf.json.JSONObject.fromObject(voicePool);//实体类转换成Map类型
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				map.put("checkedTime",sdf2.format(voicePool.getCheckedTime()));//转换时间格式
				map.put("operateTime",sdf2.format(voicePool.getOperateTime()));//转换时间格式
				listMap.add(map);
			}
		}
		String fileName="语音质检池详情表-"+formatTime;//文件名称
		//List转String数组
		String[] columnNames= (String[]) titlesList.toArray(new String[titlesList.size()]);//中文列名
		String[] keys= (String[]) fieldsList.toArray(new String[fieldsList.size()]);//英文列名
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(listMap,keys,columnNames).write(os);//创建excel文档
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	@RequestMapping(value = "/insertComment", method = RequestMethod.POST)
	public void fun1() throws Exception {
		/*
		 * 1. 得到Connection
		 * 2. 给出sql模板，创建pstmt
		 * 3. 设置sql模板中的参数
		 * 4. 调用pstmt的executeUpdate()执行
		 */
		Connection con = JDBCUtils.getConnection();
		String sql = "insert into t_qm_voice_pool(RESERVE_2,RESERVE_3) values(?,?) where TOUCH_ID='1'";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, "流光飞舞.mp3");
		/**
		 * 需要得到Blob
		 * 1. 我们有的是文件，目标是Blob
		 * 2. 先把文件变成byte[]
		 * 3. 再使用byte[]创建Blob
		 */
		// 把文件转换成byte[]
		byte[] bytes = IOUtils.toByteArray(new FileInputStream("F:/流光飞舞.mp3"));
		// 使用byte[]创建Blob
		Blob blob = new SerialBlob(bytes);
		// 设置参数
		pstmt.setBlob(2, blob);

		pstmt.executeUpdate();
	}

}
