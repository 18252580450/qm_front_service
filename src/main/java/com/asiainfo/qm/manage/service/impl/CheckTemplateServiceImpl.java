package com.asiainfo.qm.manage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.CheckTemplateMapper;
import com.asiainfo.qm.manage.dao.QmPlanMapper;
import com.asiainfo.qm.manage.dao.TplOpLogMapper;
import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.CheckTemplateExample;
import com.asiainfo.qm.manage.domain.TemplateDetail;
import com.asiainfo.qm.manage.domain.TplOpLog;
import com.asiainfo.qm.manage.service.AddCheckTemplateService;
import com.asiainfo.qm.manage.service.CheckTemplateService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckTemplateResponse;
import com.asiainfo.qm.manage.vo.TemplateDetailResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class CheckTemplateServiceImpl implements CheckTemplateService {

	private static Logger logger = LoggerFactory.getLogger(CheckTemplateServiceImpl.class);

	@Autowired
	private AddCheckTemplateService addCheckTemplateService;
	@Autowired
	private CheckTemplateMapper checkTemplateMapper;
	@Autowired
	private QmPlanMapper qmPlanMapper;
	@Autowired
	private TplOpLogMapper tplOpLogMapper;
	@Autowired
	private SequenceUtils sequenceUtils;

	@Override
	public CheckTemplateResponse selectByParams(Map params, int start, int limit) throws Exception  {
		CheckTemplateResponse checkTemplateResponse = null;
		CheckTemplateExample example = new CheckTemplateExample();
		try {
			CheckTemplateExample.Criteria criteria= example.createCriteria();//在运行时动态生成查询语句
			if(null != params.get("tenantId")&& !"".equals(params.get("tenantId"))){
				example.createCriteria().andTenantIdEqualTo((String) params.get("tenantId"));
			}
			if(null != params.get("templateId")&& !"".equals(params.get("templateId"))){
				criteria.andTemplateIdEqualTo((String) params.get("templateId"));
			}
			if(null != params.get("templateName") && !"".equals(params.get("templateName"))) {
				criteria.andTemplateNameEqualTo((String) params.get("templateName"));
			}
			if(null != params.get("templateStatus") && !"".equals(params.get("templateStatus"))) {
				criteria.andTemplateStatusEqualTo((String) params.get("templateStatus"));
			}

			if (0 != limit) {
				PageHelper.offsetPage(start, limit);
				List<CheckTemplate> list = checkTemplateMapper.selectByExample(example);
				Page<CheckTemplate> pagelist = (Page)list;
				checkTemplateResponse = new CheckTemplateResponse(pagelist);
			} else {
				checkTemplateResponse = new CheckTemplateResponse();
				List<CheckTemplate> list = checkTemplateMapper.selectByExample(example);
				checkTemplateResponse.setData(list);
			}

			if(null != checkTemplateResponse.getData() && checkTemplateResponse.getData().size() > 0){
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("查询成功");
			}else {
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("无数据");
			}
		}catch (Exception e){
			logger.error("查询异常",e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("查询异常");
		}
		return checkTemplateResponse;
	}

	@Override
	public CheckTemplateResponse deleteByIds(List<String> ids) throws Exception {
		String flag = "0";//操作结果标识（默认成功）
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			//如果该考评模版被考评计划绑定，则不可删除
            int size = qmPlanMapper.selectByTemplateId(ids);
			if(size > 0){
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("考评模版已经被绑定，无法删除");
			}else{
//				int result = checkTemplateMapper.deleteByExample(example);
				int result = checkTemplateMapper.deleteTemplate(ids);
				if(result > 0){
					checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
					checkTemplateResponse.setRspdesc("删除考评模板基本信息成功");
				}else {
					flag = "1";
					checkTemplateResponse.setRspcode(WebUtil.FAIL);
					checkTemplateResponse.setRspdesc("删除考评模板基本信息失败");
				}
			}
		}catch (Exception e){
			flag = "1";
			e.printStackTrace();
			logger.error("删除考评模板基本信息异常",e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("删除考评模板基本信息异常");
		}finally {//日志
			for(int i=0;i<ids.size();i++){
				Map map = new HashMap();
				map.put("operateStaffId", net.sf.json.JSONObject.fromObject(ids.get(0)).get("operateId"));
				map.put("templateId",net.sf.json.JSONObject.fromObject(ids.get(0)).get("templateId"));
				map.put("operateType","2");
				map.put("reserve1",flag);
				addTplOpLog(map);
			}
		}
		return checkTemplateResponse;
	}

	@Override
	public CheckTemplateResponse update(@Param("list")List<String> list) throws Exception{
		String flag = "0";//操作结果标识（默认成功）
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			int result = checkTemplateMapper.update(list);
			if (result > 0) {
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("操作成功");
			} else {
				flag = "1";
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("操作失败");
			}
		} catch (Exception e) {
			flag = "1";
			e.printStackTrace();
			logger.error("操作异常", e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("操作异常");
		}finally {//日志
			Map map = new HashMap();
			map.put("operateStaffId", net.sf.json.JSONObject.fromObject(list.get(0)).get("operateStaffId"));
			map.put("templateId", net.sf.json.JSONObject.fromObject(list.get(0)).get("templateId"));
			map.put("operateType","1");
			map.put("reserve1",flag);
			addTplOpLog(map);
		}
		return checkTemplateResponse;
	}

	@Override
	public CheckTemplateResponse updateTemplate(@Param("list")List<String> list) throws Exception{
		String flag = "0";//操作结果标识（默认成功）
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			int result = checkTemplateMapper.updateTemplate(list);
			if (result > 0) {
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("操作成功");
			} else {
				flag = "1";
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("操作失败");
			}
		} catch (Exception e) {
			flag = "1";
			e.printStackTrace();
			logger.error("操作异常", e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("操作异常");
		}finally {//日志
			Map map = new HashMap();
			map.put("operateStaffId", net.sf.json.JSONObject.fromObject(list.get(0)).get("operateStaffId"));
			map.put("templateId",net.sf.json.JSONObject.fromObject(list.get(0)).get("templateId"));
			map.put("operateType","1");
			map.put("reserve1",flag);
			addTplOpLog(map);
		}
		return checkTemplateResponse;
	}


//	@Override
//	public CheckTemplateResponse copyTemplate(CheckTemplate checkTemplate) throws Exception{
//		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
//		try {
//			checkTemplate.setCreateTime(DateUtil.getCurrontTime());
//			checkTemplate.setTemplateId(String.valueOf(sequenceUtils.getSequence("t_qm_checktemplate")));
//			int result = checkTemplateMapper.insertSelective(checkTemplate);
//			if(result > 0){
//				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
//				checkTemplateResponse.setRspdesc("复制成功");
//			}else {
//				checkTemplateResponse.setRspcode(WebUtil.FAIL);
//				checkTemplateResponse.setRspdesc("复制失败");
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//			logger.error("复制异常",e);
//			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
//			checkTemplateResponse.setRspdesc("复制异常");
//		}
//		return  checkTemplateResponse;
//	}

	@Override
	public CheckTemplateResponse copyTemplate(CheckTemplate checkTemplate) throws Exception{
		String flag = "0";//操作结果标识（默认成功）
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			//先根据templateId查询出要复制的模板的所有信息
			Map map =new HashMap();
			map.put("templateId",checkTemplate.getTemplateId());
			CheckTemplateResponse response = selectByParams(map,0,0);
			List<CheckTemplate> list = response.getData();//获取要复制的模板的一条信息

			//更改模板的创建时间、模板状态（默认刚生成的复制模板状态都为未发布）、模板名称并随机生成templateId，然后将其插入到数据库中
			list.get(0).setCreateTime(DateUtil.getCurrontTime());
			list.get(0).setTemplateStatus("0");//复制的默认都为未发布
			list.get(0).setTemplateName(checkTemplate.getTemplateName());
			String id= String.valueOf(sequenceUtils.getSequence("t_qm_checktemplate"));
			list.get(0).setTemplateId(id);
			list.get(0).setCreateStaffId(checkTemplate.getCreateStaffId());//创建工号
			list.get(0).setCopyedTimes(0);//复制出来的考评信息不能被复制,因此拷贝次数应该都为0
			list.get(0).setTemplateName(checkTemplate.getTemplateName()+"(复制"+String.valueOf(checkTemplate.getCopyedTimes()+1)+")");//模板名称后面加（复制+次数）
			//已复制次数加1,并更新到被复制模板信息中
			checkTemplate.setCopyedTimes(checkTemplate.getCopyedTimes()+1);
			int result = checkTemplateMapper.updateByPrimaryKey(checkTemplate);
			if(result > 0){
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("更新拷贝模版次数成功");
			}else {
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("更新拷贝模版次数出错");
			}
			int resultNew = checkTemplateMapper.insertSelective(list.get(0));
			if(resultNew > 0){
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("插入复制模版信息成功");
			}else {
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("插入复制模版信息出错");
			}

			Map mapNew =new HashMap();
			mapNew.put("templateId",checkTemplate.getTemplateId());
			mapNew.put("tenantId","10010000");
			TemplateDetailResponse templateDetailResponse = addCheckTemplateService.selectByParams(mapNew,0,0);
			List<TemplateDetail> listNew = templateDetailResponse.getData();
			for(TemplateDetail t : listNew) {//循环插入
				t.setCrtTime(DateUtil.getCurrontTime());
				t.setTemplateId(id);//templateId与考评模板对应
			}

			TemplateDetailResponse detailResponse = addCheckTemplateService.insertTempDetail(listNew);
			if(detailResponse.getRspdesc().equals("新增成功")){
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("复制成功");
			}else {
				flag = "1";
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("复制失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			flag = "1";
			logger.error("复制异常",e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("复制异常");
		}finally {//日志
			Map map = new HashMap();
			map.put("operateStaffId",checkTemplate.getCreateStaffId());
			map.put("templateId",checkTemplate.getTemplateId());
			map.put("operateType","0");
			map.put("reserve1",flag);
			addTplOpLog(map);
		}
		return  checkTemplateResponse;
	}

	@Override
	public CheckTemplateResponse insertCheckTemplate(CheckTemplate checkTemplate) throws Exception{
		String flag = "0";//操作结果标识（默认成功）
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			checkTemplate.setCreateTime(DateUtil.getCurrontTime());
//			checkTemplate.setTemplateId(String.valueOf(sequenceUtils.getSequence("t_qm_checktemplate")));
			int result = checkTemplateMapper.insertSelective(checkTemplate);
			if(result > 0){
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("新增成功");
			}else {
				flag = "1";
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("新增失败");
			}
		}catch (Exception e){
			flag = "1";
			e.printStackTrace();
			logger.error("新增异常",e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("新增异常");
		}finally {//日志
			Map map = new HashMap();
			map.put("operateStaffId",checkTemplate.getCreateStaffId());
			map.put("templateId",checkTemplate.getTemplateId());
			map.put("operateType","0");
			map.put("reserve1",flag);
			addTplOpLog(map);
		}
		return  checkTemplateResponse;
	}

	public void addTplOpLog(Map map)throws Exception{
		TplOpLog tplOpLog = new TplOpLog();
		tplOpLog.setOperateTime(DateUtil.getCurrontTime());//操作时间
		tplOpLog.setOperateStaffId((String) map.get("operateStaffId"));//操作工号
		tplOpLog.setTemplateId((String) map.get("templateId"));//考评模板编码
		tplOpLog.setOperateType((String) map.get("operateType"));//操作类型
		tplOpLog.setReserve1((String) map.get("reserve1"));//操作结果标识
		tplOpLog.setTenantId("10010000");//租户ID
		tplOpLog.setOperateId(String.valueOf(sequenceUtils.getSequence("t_qm_tpl_op_log")));
		tplOpLogMapper.insertSelective(tplOpLog);
	}
}
