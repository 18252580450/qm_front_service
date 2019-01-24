package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.StaticParamsMapper;
import com.asiainfo.qm.manage.domain.StaticParams;
import com.asiainfo.qm.manage.domain.StaticParamsExample;
import com.asiainfo.qm.manage.service.StaticParamsService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.StaticParamsResponse;
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
public class StaticParamsServiceImpl implements StaticParamsService {

	private static Logger logger = LoggerFactory.getLogger(StaticParamsServiceImpl.class);

	@Autowired
	private StaticParamsMapper staticParamsMapper;

	@Autowired
	private SequenceUtils sequenceUtils;

	@Override
	public StaticParamsResponse selectByParams(Map params,int start,int limit) throws Exception  {
		StaticParamsResponse staticParamsResponse = null;
		StaticParamsExample example = new StaticParamsExample();
		try {
			StaticParamsExample.Criteria criteria= example.createCriteria();
			criteria.andTenantIdEqualTo((String) params.get("tenantId"));
			if(null != params.get("paramsPurposeId")&& !"".equals(params.get("paramsPurposeId"))){
				example.createCriteria().andParamsPurposeIdEqualTo((String) params.get("paramsPurposeId"));
			}
			if(null != params.get("paramsTypeId") && !"".equals(params.get("paramsTypeId"))) {
				criteria.andParamsTypeIdEqualTo((String) params.get("paramsTypeId"));
			}
			if(null != params.get("paramsTypeName") && !"".equals(params.get("paramsTypeName"))) {
				criteria.andParamsTypeNameLike("%" + params.get("paramsTypeName") + "%");
			}
			if(0 != limit) {
				PageHelper.offsetPage(start, limit);
				List<StaticParams> list = staticParamsMapper.selectByExample(example);
				Page<StaticParams> pagelist = (Page) list;
				staticParamsResponse = new StaticParamsResponse(pagelist);
			}else {
				staticParamsResponse = new StaticParamsResponse();
				List<StaticParams> list = staticParamsMapper.selectByExample(example);
				staticParamsResponse.setData(list);
			}

			if(null != staticParamsResponse.getData() && staticParamsResponse.getData().size() > 0){
				staticParamsResponse.setRspcode(WebUtil.SUCCESS);
				staticParamsResponse.setRspdesc("查询成功");
			}else {
				staticParamsResponse.setRspcode(WebUtil.FAIL);
				staticParamsResponse.setRspdesc("无数据");
			}
		}catch (Exception e){
			logger.error("查询异常",e);
			staticParamsResponse.setRspcode(WebUtil.EXCEPTION);
			staticParamsResponse.setRspdesc("查询异常");
		}
		return staticParamsResponse;
	}

	@Override
	public StaticParamsResponse selectAllTypes(Map params) throws Exception {
		StaticParamsResponse staticParamsResponse = null;
		StaticParamsExample example = new StaticParamsExample();
		try {
			StaticParamsExample.Criteria criteria= example.createCriteria();
			criteria.andTenantIdEqualTo((String) params.get("tenantId"));
			staticParamsResponse = new StaticParamsResponse();
			List<StaticParams> list = staticParamsMapper.selectAllTypes(example);
			staticParamsResponse.setData(list);

			if(null != staticParamsResponse.getData() && staticParamsResponse.getData().size() > 0){
				staticParamsResponse.setRspcode(WebUtil.SUCCESS);
				staticParamsResponse.setRspdesc("查询类型成功");
			}else {
				staticParamsResponse.setRspcode(WebUtil.FAIL);
				staticParamsResponse.setRspdesc("无数据");
			}
		}catch (Exception e){
			logger.error("查询类型异常",e);
			staticParamsResponse.setRspcode(WebUtil.EXCEPTION);
			staticParamsResponse.setRspdesc("查询类型异常");
		}
		return staticParamsResponse;
	}

	@Override
	public StaticParamsResponse deleteByIds(List<String> ids) throws Exception {
		StaticParamsResponse staticParamsResponse = new StaticParamsResponse();
		try {
			StaticParamsExample example = new StaticParamsExample();
			StaticParamsExample.Criteria criteria= example.createCriteria();
			criteria.andParamsPurposeIdIn(ids);
			int result = staticParamsMapper.deleteByExample(example);
			if(result > 0){
				staticParamsResponse.setRspcode(WebUtil.SUCCESS);
				staticParamsResponse.setRspdesc("删除成功");
			}else {
				staticParamsResponse.setRspcode(WebUtil.FAIL);
				staticParamsResponse.setRspdesc("删除失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("删除异常",e);
			staticParamsResponse.setRspcode(WebUtil.EXCEPTION);
			staticParamsResponse.setRspdesc("删除异常");
		}
		return staticParamsResponse;
	}

	@Override
	public StaticParamsResponse addStaticParams(StaticParams staticParams) throws Exception {
		StaticParamsResponse staticParamsResponse = new StaticParamsResponse();
		try {
			StaticParamsExample example = new StaticParamsExample();
			StaticParamsExample.Criteria criteria= example.createCriteria();
			criteria.andParamsCodeEqualTo(staticParams.getParamsCode());
			criteria.andParamsTypeIdEqualTo(staticParams.getParamsTypeId());
			List<StaticParams> params = staticParamsMapper.selectByExample(example);
			if(params.size() > 0){
				staticParamsResponse.setRspcode(WebUtil.FAIL);
				staticParamsResponse.setRspdesc("该类型下参数编码已存在！");
			}else {
				staticParams.setCrtTime(DateUtil.getCurrontTime());
				staticParams.setParamsPurposeId(String.valueOf(sequenceUtils.getSequence("t_qm_static_params")));
				int result = staticParamsMapper.insertSelective(staticParams);
				if (result > 0) {
					staticParamsResponse.setRspcode(WebUtil.SUCCESS);
					staticParamsResponse.setRspdesc("新增成功");
				} else {
					staticParamsResponse.setRspcode(WebUtil.FAIL);
					staticParamsResponse.setRspdesc("新增失败");
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增异常",e);
			staticParamsResponse.setRspcode(WebUtil.EXCEPTION);
			staticParamsResponse.setRspdesc("新增异常");
		}
		return  staticParamsResponse;
	}

	@Override
	public StaticParamsResponse updateStaticParams(StaticParams staticParams) throws Exception {
		StaticParamsResponse staticParamsResponse = new StaticParamsResponse();
		try {
			StaticParamsExample example = new StaticParamsExample();
			StaticParamsExample.Criteria criteria= example.createCriteria();
			criteria.andParamsCodeEqualTo(staticParams.getParamsCode());
			criteria.andParamsTypeIdEqualTo(staticParams.getParamsTypeId());
			List<StaticParams> params = staticParamsMapper.selectByExample(example);
			boolean flag = false;
			if(params.size() > 0){
				for(int i = 0;i<params.size();i++){
					if(params.get(i).getParamsPurposeId().equals(staticParams.getParamsPurposeId())){
						continue;
					}else {
						flag = true;
						staticParamsResponse.setRspcode(WebUtil.FAIL);
						staticParamsResponse.setRspdesc("该类型下参数编码已存在！");
						break;
					}
				}

			}
			if(!flag) {
				staticParams.setModfTime(DateUtil.getCurrontTime());
				int result = staticParamsMapper.updateByPrimaryKeySelective(staticParams);
				if (result > 0) {
					staticParamsResponse.setRspcode(WebUtil.SUCCESS);
					staticParamsResponse.setRspdesc("更新成功");
				} else {
					staticParamsResponse.setRspcode(WebUtil.FAIL);
					staticParamsResponse.setRspdesc("更新失败");
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("更新异常",e);
			staticParamsResponse.setRspcode(WebUtil.EXCEPTION);
			staticParamsResponse.setRspdesc("更新异常");
		}
		return  staticParamsResponse;
	}


}
