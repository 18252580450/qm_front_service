package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.CheckItem;
import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.OrdinaryComment;
import com.asiainfo.qm.manage.domain.TemplateDetail;
import com.asiainfo.qm.manage.service.AddCheckTemplateService;
import com.asiainfo.qm.manage.service.CheckItemService;
import com.asiainfo.qm.manage.service.CheckTemplateService;
import com.asiainfo.qm.manage.util.DateUtil;
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

import java.util.*;

@RestController
@RequestMapping("/qm/configservice/addCheckTemplate/")
public class AddCheckTemplateController {

	// 创建Logger实例
	private static Logger logger = LoggerFactory.getLogger(AddCheckTemplateController.class);

	@Autowired
	private AddCheckTemplateService addCheckTemplateService;
	@Autowired
	private SequenceUtils sequenceUtils;

	//下拉框数据查询
	@RequestMapping(value = "/queryCheckItem", method = RequestMethod.GET)
	public List<CheckItem>  queryCheckItem(@RequestParam(name = "params")String params) throws Exception {
		Map reqParams = JSONObject.parseObject(params);
		List<CheckItem> list = addCheckTemplateService.queryCheckItem(reqParams);
		return list;
	}

	//新增考评模板详细信息
	@ApiOperation(value = "新增考评模板详细信息", notes = "qm_configservice新增考评模板详细信息", response = TemplateDetailServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice", commandKey = "insertTempDetail", threadPoolKey = "insertTempDetailThread",fallbackMethod = "fallbackinsertTempDetail", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/insertTempDetail", method = RequestMethod.POST)
	public TemplateDetailServiceResponse insertTempDetail(@RequestBody String params) throws Exception {
		TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
		TemplateDetailServiceResponse templateDetailServiceResponse = new TemplateDetailServiceResponse();
		Map map = (Map) JSON.parse(params);//转换成Map
		List<Map<String,Object>> list = (List<Map<String,Object>>) map.get("params");
		TemplateDetail templateDetail;
		List<TemplateDetail> listNew = new ArrayList<TemplateDetail>();
		for(int i=0;i<list.size();i++){
			templateDetail = new TemplateDetail();
			Map<String,Object> mapNew = list.get(i);
			templateDetail.setCrtTime(DateUtil.getCurrontTime());
			templateDetail.setTenantId((String) mapNew.get("tenantId"));
			templateDetail.setTemplateId((String) mapNew.get("templateId"));
			templateDetail.setNodeId((String) mapNew.get("nodeId"));
			templateDetail.setNodeName((String) mapNew.get("nodeName"));
			templateDetail.setMaxScore((Integer) mapNew.get("maxScore"));
			templateDetail.setNodeScore((Integer) mapNew.get("nodeScore"));
			templateDetail.setErrorType((String) mapNew.get("errorType"));
			templateDetail.setNodeType((String) mapNew.get("nodeType"));
			templateDetail.setpNodeId((String) mapNew.get("pNodeId "));//父节点
			listNew.add(templateDetail);
		}
		try {
			templateDetailResponse = addCheckTemplateService.insertTempDetail(listNew);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增考评模板详细信息异常");
			templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
			templateDetailResponse.setRspdesc("新增考评模板详细信息异常!");
		}
		templateDetailServiceResponse.setResponse(templateDetailResponse);
		return templateDetailServiceResponse;
	}

	public TemplateDetailServiceResponse fallbackinsertTempDetail(@RequestBody String params) throws Exception {
		logger.info("新增考评模板详细信息出错啦！");
		logger.error("");
		TemplateDetailServiceResponse templateDetailServiceResponse = new TemplateDetailServiceResponse();
		return templateDetailServiceResponse;
	}

	// 查询考评模板详细信息
	@ApiOperation(value = "前端调用接口查询考评模板详细信息", notes = "qm_configservice查询考评模板详细信息", response = TemplateDetailServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "selectByParams", threadPoolKey = "selectByParamsThread", fallbackMethod = "fallbackSelectByParams",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/selectByParams", method = RequestMethod.GET)
	public TemplateDetailServiceResponse selectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
		TemplateDetailServiceResponse templateDetailServiceResponse = new TemplateDetailServiceResponse();
		Map reqParams = JSONObject.parseObject(params);
		try {
			templateDetailResponse = addCheckTemplateService.selectByParams(reqParams,start,limit);//查询方法
		}catch (Exception e){
			logger.error("数据查询异常");
			templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
			templateDetailResponse.setRspdesc("数据查询异常!");
		}
		templateDetailServiceResponse.setResponse(templateDetailResponse);
		return templateDetailServiceResponse;
	}

	public TemplateDetailServiceResponse fallbackSelectByParams(@RequestParam(name = "params")String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
		logger.info("数据查询出错啦！");
		logger.error("");
		TemplateDetailServiceResponse templateDetailServiceResponse = new TemplateDetailServiceResponse();
		return templateDetailServiceResponse;
	}

	@ApiOperation(value = "前端调用接口删除考评模板详细信息", notes = "qm_configservice删除考评模板详细信息", response = TemplateDetailServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
			@ApiResponse(code = 403, message = "资源不存在"),
			@ApiResponse(code = 404, message = "传入的参数无效"),
			@ApiResponse(code = 500, message = "服务器出现异常错误") })
	@HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteByIds", threadPoolKey = "deleteByIdsThread", fallbackMethod = "fallbackDeleteByIds",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "200") })
	@RequestMapping(value = "/deleteByIds/{ids}", method = RequestMethod.PUT)
	public TemplateDetailServiceResponse deleteByIds(@PathVariable(name = "ids")String ids) throws Exception {
		TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
		TemplateDetailServiceResponse templateDetailServiceResponse = new TemplateDetailServiceResponse();
		List<String> idList = Arrays.asList(ids.split(","));
		try {
			templateDetailResponse = addCheckTemplateService.deleteByIds(idList);
		}catch (Exception e){
			logger.error("数据删除异常");
			templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
			templateDetailResponse.setRspdesc("数据删除异常!");
		}
		templateDetailServiceResponse.setResponse(templateDetailResponse);
		return templateDetailServiceResponse;
	}

	public TemplateDetailServiceResponse fallbackDeleteByIds(@RequestParam(name = "ids")String ids) throws Exception {
		logger.info("数据删除出错啦！");
		logger.error("");
		TemplateDetailServiceResponse templateDetailServiceResponse = new TemplateDetailServiceResponse();
		return templateDetailServiceResponse;
	}

	//数据更新
    @ApiOperation(value = "前端调用接口修改考评模板状态", notes = "qm_configservice修改考评模板状态", response = TemplateDetailServiceResponse.class)
    @ApiResponses(value = { @ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误") })
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "action", threadPoolKey = "actionThread", fallbackMethod = "fallbackUpdate",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000") }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200") })
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public TemplateDetailServiceResponse action(@RequestBody String params) throws Exception {
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        TemplateDetailServiceResponse templateDetailServiceResponse = new TemplateDetailServiceResponse();
        //String 转 ListMap
        JSONArray jsonArray = JSONArray.fromObject(params);
        List<Map> list = (List<Map>)jsonArray;
        try {
            templateDetailResponse = addCheckTemplateService.update(list);
        }catch (Exception e){
            logger.error("数据修改异常");
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("数据修改异常!");
        }
        templateDetailServiceResponse.setResponse(templateDetailResponse);
        return templateDetailServiceResponse;
    }

    public TemplateDetailServiceResponse fallbackUpdate(@RequestBody String params) throws Exception {
        logger.info("修改模板状态出错啦！");
        logger.error("");
        TemplateDetailServiceResponse templateDetailServiceResponse = new TemplateDetailServiceResponse();
        return templateDetailServiceResponse;
    }
}
