package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.CheckTemplateMapper;
import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.CheckTemplateExample;
import com.asiainfo.qm.manage.service.CheckTemplateService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckTemplateResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class CheckTemplateServiceImpl implements CheckTemplateService {

	private static Logger logger = LoggerFactory.getLogger(CheckTemplateServiceImpl.class);

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
				checkTemplateResponse.setRspdesc("修改模板状态成功");
			}else {
				checkTemplateResponse.setRspcode(WebUtil.FAIL);
				checkTemplateResponse.setRspdesc("修改模板状态失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("修改模板状态异常",e);
			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
			checkTemplateResponse.setRspdesc("修改模板状态异常");
		}
		return checkTemplateResponse;
	}

	@Override
	public CheckTemplateResponse copyTemplate(CheckTemplate checkTemplate) throws Exception{
		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
		try {
			checkTemplate.setCreateTime(DateUtil.getCurrontTime());
			checkTemplate.setTemplateId(String.valueOf(sequenceUtils.getSequence("t_qm_checktemplate")));
			int result = checkTemplateMapper.insertSelective(checkTemplate);
			if(result > 0){
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
//
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
