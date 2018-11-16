package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.QmPlanMapper;
import com.asiainfo.qm.manage.domain.QmPlan;
import com.asiainfo.qm.manage.domain.QmPlanExample;
import com.asiainfo.qm.manage.service.QmPlanService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.DateUtils;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.QmPlanResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class QmPlanServiceImpl implements QmPlanService {

	private static Logger logger = LoggerFactory.getLogger(QmPlanServiceImpl.class);

	@Autowired
	private QmPlanMapper qmPlanMapper;

	@Autowired
	private SequenceUtils sequenceUtils;

	@Override
	public QmPlanResponse selectByParams(Map params,int start,int limit) throws Exception  {
		QmPlanResponse qmPlanResponse = null;
		QmPlanExample example = new QmPlanExample();
		try {
			QmPlanExample.Criteria criteria= example.createCriteria();
			criteria.andTenantIdEqualTo((String) params.get("tenantId"));
			if(null != params.get("planId")&& !"".equals(params.get("planId"))){
				criteria.andPlanIdEqualTo((String) params.get("planId"));
			}
			if(null != params.get("planName")&& !"".equals(params.get("planName"))){
				criteria.andPlanNameLike("%" + params.get("planName") + "%");
			}
			if(null != params.get("haltFlag")&& !"".equals(params.get("haltFlag"))){
				criteria.andHaltFlagEqualTo((String) params.get("haltFlag"));
			}
			if(null != params.get("planType")&& !"".equals(params.get("planType"))){
				criteria.andPlanTypeEqualTo((String) params.get("planType"));
			}
			if(null != params.get("createTimeStart")&& !"".equals(params.get("createTimeStart")) &&
					null != params.get("createTimeEnd")&& !"".equals(params.get("createTimeEnd"))){
				Timestamp createTimeStart = DateUtils.paraseSqlTimestamp((String) params.get("createTimeStart"), DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
				Timestamp createTimeEnd = DateUtils.paraseSqlTimestamp((String)params.get("createTimeEnd"),DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
				criteria.andCreateTimeBetween(createTimeStart, createTimeEnd);
			}else{
				if(null != params.get("createTimeStart")&& !"".equals(params.get("createTimeStart"))){
					Timestamp createTimeStart = DateUtils.paraseSqlTimestamp((String) params.get("createTimeStart"), DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
					criteria.andCreateTimeGreaterThanOrEqualTo(createTimeStart);
				}
				if(null != params.get("createTimeEnd")&& !"".equals(params.get("createTimeEnd"))){
					Timestamp createTimeEnd = DateUtils.paraseSqlTimestamp((String) params.get("createTimeEnd"), DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
					criteria.andCreateTimeGreaterThanOrEqualTo(createTimeEnd);
				}
			}

			if(0 != limit) {
				PageHelper.offsetPage(start, limit);
				List<QmPlan> list = qmPlanMapper.selectByExample(example);
				Page<QmPlan> pagelist = (Page) list;
				qmPlanResponse = new QmPlanResponse(pagelist);
			}else {
				qmPlanResponse = new QmPlanResponse();
				List<QmPlan> list = qmPlanMapper.selectByExample(example);
				qmPlanResponse.setData(list);
			}

			if(null != qmPlanResponse.getData() && qmPlanResponse.getData().size() > 0){
				qmPlanResponse.setRspcode(WebUtil.SUCCESS);
				qmPlanResponse.setRspdesc("查询成功");
			}else {
				qmPlanResponse.setRspcode(WebUtil.FAIL);
				qmPlanResponse.setRspdesc("无数据");
			}
		}catch (Exception e){
			logger.error("查询异常",e);
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("查询异常");
		}
		return qmPlanResponse;
	}

	@Override
	public QmPlanResponse deleteByIds(List<String> ids) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();
		try {
			QmPlanExample example = new QmPlanExample();
			QmPlanExample.Criteria criteria= example.createCriteria();
			criteria.andPlanIdIn(ids);
			int result = qmPlanMapper.deleteByExample(example);
			if(result > 0){
				qmPlanResponse.setRspcode(WebUtil.SUCCESS);
				qmPlanResponse.setRspdesc("删除成功");
			}else {
				qmPlanResponse.setRspcode(WebUtil.FAIL);
				qmPlanResponse.setRspdesc("删除失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("删除异常",e);
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("删除异常");
		}
		return qmPlanResponse;
	}

	@Override
	public QmPlanResponse addQmPlan(QmPlan qmPlan) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();
		try {
			qmPlan.setCreateTime(DateUtil.getCurrontTime());
			qmPlan.setPlanId(String.valueOf(sequenceUtils.getSequence("t_qm_plan")));
			int result = qmPlanMapper.insertSelective(qmPlan);
			if(result > 0){
				qmPlanResponse.setRspcode(WebUtil.SUCCESS);
				qmPlanResponse.setRspdesc("新增成功");
			}else {
				qmPlanResponse.setRspcode(WebUtil.FAIL);
				qmPlanResponse.setRspdesc("新增失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增异常",e);
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("新增异常");
		}
		return  qmPlanResponse;
	}

	@Override
	public QmPlanResponse updateQmPlan(QmPlan qmPlan) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();
		try {
			qmPlan.setModifiedTime(DateUtil.getCurrontTime());
			int result = qmPlanMapper.updateByPrimaryKey(qmPlan);
			if(result > 0){
				qmPlanResponse.setRspcode(WebUtil.SUCCESS);
				qmPlanResponse.setRspdesc("更新成功");
			}else {
				qmPlanResponse.setRspcode(WebUtil.FAIL);
				qmPlanResponse.setRspdesc("更新失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("更新异常",e);
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("更新异常");
		}
		return  qmPlanResponse;
	}

	@Override
	public QmPlanResponse batchUpdate(List<String> ids, String halfFlag) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();

		try {
			QmPlan qmPlan = new QmPlan();
			qmPlan.setModifiedTime(DateUtil.getCurrontTime());
			qmPlan.setHaltFlag(halfFlag);
			QmPlanExample example = new QmPlanExample();
			example.createCriteria().andPlanIdIn(ids);
			int result = qmPlanMapper.updateByExampleSelective(qmPlan, example);
			if(result > 0){
				qmPlanResponse.setRspcode(WebUtil.SUCCESS);
				qmPlanResponse.setRspdesc("更新成功");
			}else {
				qmPlanResponse.setRspcode(WebUtil.FAIL);
				qmPlanResponse.setRspdesc("更新失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("更新异常",e);
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("更新异常");
		}
		return  qmPlanResponse;
	}


}
