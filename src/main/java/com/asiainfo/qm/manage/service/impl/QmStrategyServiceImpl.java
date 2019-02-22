package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.QmStrategyElementRelMapper;
import com.asiainfo.qm.manage.dao.QmStrategyMapper;
import com.asiainfo.qm.manage.domain.*;
import com.asiainfo.qm.manage.service.QmStrategyService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.QmStrategyResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class QmStrategyServiceImpl implements QmStrategyService {

	private static Logger logger = LoggerFactory.getLogger(QmStrategyServiceImpl.class);

	@Autowired
	private QmStrategyMapper qmStrategyMapper;

	@Autowired
	private QmStrategyElementRelMapper qmStrategyElementRelMapper;

	@Autowired
	private SequenceUtils sequenceUtils;

	@Override
	public QmStrategyResponse selectByParams(Map params,int start,int limit) throws Exception  {
		QmStrategyResponse qmStrategyResponse = null;
		QmStrategyExample example = new QmStrategyExample();
		try {
			QmStrategyExample.Criteria criteria= example.createCriteria();
			criteria.andTenantIdEqualTo((String) params.get("tenantId"));
			if(null != params.get("pName")&& !"".equals(params.get("pName"))){
				criteria.andPNameLike("%"+ params.get("pName")+"%");
			}
			if(null != params.get("paramsTypeId")&& !"".equals(params.get("paramsTypeId"))){
				criteria.andParamsTypeIdEqualTo((String) params.get("paramsTypeId"));
			}
			if(null != params.get("isValidate")&& !"".equals(params.get("isValidate"))){
				criteria.andIsValidateEqualTo((String) params.get("isValidate"));
			}

			if(0 != limit) {
				PageHelper.offsetPage(start, limit);
				List<QmStrategy> list = qmStrategyMapper.selectByExample(example);
				Page<QmStrategy> pagelist = (Page) list;
				qmStrategyResponse = new QmStrategyResponse(pagelist);
			}else {
				qmStrategyResponse = new QmStrategyResponse();
				List<QmStrategy> list = qmStrategyMapper.selectByExample(example);
				qmStrategyResponse.setData(list);
			}

			if(null != qmStrategyResponse.getData() && qmStrategyResponse.getData().size() > 0){
				qmStrategyResponse.setRspcode(WebUtil.SUCCESS);
				qmStrategyResponse.setRspdesc("查询成功");
			}else {
				qmStrategyResponse.setRspcode(WebUtil.FAIL);
				qmStrategyResponse.setRspdesc("无数据");
			}
		}catch (Exception e){
			logger.error("查询异常",e);
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("查询异常");
		}
		return qmStrategyResponse;
	}

	@Override
	public QmStrategyResponse deleteByIds(List<String> ids) throws Exception {
		QmStrategyResponse qmStrategyResponse = new QmStrategyResponse();
		try {
			QmStrategyExample example = new QmStrategyExample();
			QmStrategyExample.Criteria criteria= example.createCriteria();
			criteria.andPIdIn(ids);
			int result = qmStrategyMapper.deleteByExample(example);
			if(result > 0){
				for(int i = 0;i<ids.size();i++){
					QmStrategyElementRelExample elementRelExample = new QmStrategyElementRelExample();
					QmStrategyElementRelExample.Criteria eleCriteria = elementRelExample.createCriteria();
					eleCriteria.andPIdEqualTo(ids.get(i));
					qmStrategyElementRelMapper.deleteByExample(elementRelExample);
				}
				qmStrategyResponse.setRspcode(WebUtil.SUCCESS);
				qmStrategyResponse.setRspdesc("删除成功");
			}else {
				qmStrategyResponse.setRspcode(WebUtil.FAIL);
				qmStrategyResponse.setRspdesc("删除失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("删除异常",e);
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("删除异常");
		}
		return qmStrategyResponse;
	}

	@Override
	public QmStrategyResponse addQmStrategy(QmStrategy qmStrategy) throws Exception {
		QmStrategyResponse qmStrategyResponse = new QmStrategyResponse();
		try {
			qmStrategy.setCreateDate(DateUtil.getCurrontTime());
			qmStrategy.setpId(String.valueOf(sequenceUtils.getSequence("t_qm_strategy")));
			int result = qmStrategyMapper.insertSelective(qmStrategy);
			if(result > 0){
				List<QmStrategyElementRel> elementRels = qmStrategy.getElements();
				int eleRet = elementRels.size();
				for(int i = 0;i<elementRels.size();i++){
					QmStrategyElementRel elementRel = elementRels.get(i);
					elementRel.setpId(qmStrategy.getpId());
					int ret = qmStrategyElementRelMapper.insertSelective(elementRel);
					if(ret <= 0){
						eleRet--;
					}
				}
				if(eleRet == elementRels.size()){
					qmStrategyResponse.setRspcode(WebUtil.SUCCESS);
					qmStrategyResponse.setRspdesc("新增成功");
				}else {
					qmStrategyResponse.setRspcode(WebUtil.FAIL);
					qmStrategyResponse.setRspdesc("新增元素失败");
				}
			}else {
				qmStrategyResponse.setRspcode(WebUtil.FAIL);
				qmStrategyResponse.setRspdesc("新增失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增异常",e);
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("新增异常");
		}
		return  qmStrategyResponse;
	}

	@Override
	public QmStrategyResponse updateQmStrategy(QmStrategy qmStrategy) throws Exception {
		QmStrategyResponse qmStrategyResponse = new QmStrategyResponse();
		try {
			qmStrategy.setUpdateDate(DateUtil.getCurrontTime());
			int result = qmStrategyMapper.updateByPrimaryKeySelective(qmStrategy);
			if(result > 0){
				QmStrategyElementRelExample elementRelExample = new QmStrategyElementRelExample();
				QmStrategyElementRelExample.Criteria eleCriteria = elementRelExample.createCriteria();
				eleCriteria.andPIdEqualTo(qmStrategy.getpId());
				qmStrategyElementRelMapper.deleteByExample(elementRelExample);
				List<QmStrategyElementRel> elementRels = qmStrategy.getElements();
				int eleRet = elementRels.size();
				for(int i = 0;i<elementRels.size();i++){
					QmStrategyElementRel elementRel = elementRels.get(i);
					elementRel.setpId(qmStrategy.getpId());
					int ret = qmStrategyElementRelMapper.insertSelective(elementRel);
					if(ret <= 0){
						eleRet--;
					}
				}
				if(eleRet == elementRels.size()){
					qmStrategyResponse.setRspcode(WebUtil.SUCCESS);
					qmStrategyResponse.setRspdesc("更新成功");
				}else{
					qmStrategyResponse.setRspcode(WebUtil.FAIL);
					qmStrategyResponse.setRspdesc("更新元素失败");
				}
			}else {
				qmStrategyResponse.setRspcode(WebUtil.FAIL);
				qmStrategyResponse.setRspdesc("更新失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("更新异常",e);
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("更新异常");
		}
		return  qmStrategyResponse;
	}

	@Override
	public QmStrategyResponse getStrategyById(String id) throws Exception {
		QmStrategyResponse qmStrategyResponse = new QmStrategyResponse();

		try {
			QmStrategy qmStrategy = qmStrategyMapper.selectByPrimaryKey(id);
			if(null != qmStrategy){
				List<QmStrategy> list = new ArrayList<>();
				QmStrategyElementRelExample qmStrategyElementRelExample = new QmStrategyElementRelExample();
				QmStrategyElementRelExample.Criteria criteria = qmStrategyElementRelExample.createCriteria();
				criteria.andPIdEqualTo(qmStrategy.getpId());
				List<QmStrategyElementRel> qmStrategyElementRels = qmStrategyElementRelMapper.selectByExample(qmStrategyElementRelExample);
				qmStrategy.setElements(qmStrategyElementRels);
				list.add(qmStrategy);
				qmStrategyResponse.setData(list);
				qmStrategyResponse.setRspcode(WebUtil.SUCCESS);
				qmStrategyResponse.setRspdesc("查询成功");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("查询异常",e);
			qmStrategyResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyResponse.setRspdesc("查询异常");
		}
		return  qmStrategyResponse;
	}

}
