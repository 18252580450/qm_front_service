package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.CheckTemplateMapper;
import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.CheckTemplateExample;
import com.asiainfo.qm.manage.domain.TemplateDetail;
import com.asiainfo.qm.manage.service.AddCheckTemplateService;
import com.asiainfo.qm.manage.service.CheckTemplateService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckTemplateResponse;
import com.asiainfo.qm.manage.vo.TemplateDetailResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			CheckTemplateExample example = new CheckTemplateExample();
			CheckTemplateExample.Criteria criteria= example.createCriteria();
			criteria.andTemplateIdIn(ids);
			int result = checkTemplateMapper.deleteByExample(example);
			if(result > 0){
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("删除考评模板基本信息成功");
			}else {
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("删除考评模板基本信息失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("删除考评模板基本信息异常",e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("删除考评模板基本信息异常");
		}
		return checkTemplateResponse;
	}

	@Override
	public CheckTemplateResponse action(CheckTemplate checkTemplate) throws Exception {
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			int result = checkTemplateMapper.updateByPrimaryKey(checkTemplate);
			if(result > 0){
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("修改模板成功");
			}else {
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("修改模板失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("修改模板异常",e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("修改模板异常");
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
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			//先根据templateId查询出要复制的模板的所有信息
			Map map =new HashMap();
			map.put("templateId",checkTemplate.getTemplateId());
			CheckTemplateResponse response = selectByParams(map,0,0);
			List<CheckTemplate> list = response.getData();//获取要复制的模板的一条信息

			//更改模板的创建时间、模板状态（默认刚生成的复制模板状态都为未发布）、模板名称并随机生成templateId，然后将其插入到数据库中
			list.get(0).setCreateTime(DateUtil.getCurrontTime());
			list.get(0).setTemplateStatus(checkTemplate.getTemplateStatus());
			list.get(0).setTemplateName(checkTemplate.getTemplateName());
			String id= String.valueOf(sequenceUtils.getSequence("t_qm_checktemplate"));
			list.get(0).setTemplateId(id);
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
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("复制失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("复制异常",e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("复制异常");
		}
		return  checkTemplateResponse;
	}

	@Override
	public CheckTemplateResponse insertCheckTemplate(CheckTemplate checkTemplate) throws Exception{
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			checkTemplate.setCreateTime(DateUtil.getCurrontTime());
//			checkTemplate.setTemplateId(String.valueOf(sequenceUtils.getSequence("t_qm_checktemplate")));
			int result = checkTemplateMapper.insertSelective(checkTemplate);
			if(result > 0){
				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
				checkTemplateResponse.setRspdesc("新增成功");
			}else {
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("新增失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增异常",e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("新增异常");
		}
		return  checkTemplateResponse;
	}
}
