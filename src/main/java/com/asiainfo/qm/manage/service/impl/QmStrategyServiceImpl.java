package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.QmStrategyMapper;
import com.asiainfo.qm.manage.domain.QmStrategy;
import com.asiainfo.qm.manage.domain.QmStrategyExample;
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
	private SequenceUtils sequenceUtils;

	@Override
	public QmStrategyResponse selectByParams(Map params,int start,int limit) throws Exception  {
		QmStrategyResponse qmStrategyResponse = null;
		QmStrategyExample example = new QmStrategyExample();
		try {
			QmStrategyExample.Criteria criteria= example.createCriteria();
			criteria.andTenantIdEqualTo((String) params.get("tenantId"));
//			if(null != params.get("planId")&& !"".equals(params.get("planId"))){
//				criteria.andPlanIdEqualTo((String) params.get("planId"));
//			}
//			if(null != params.get("planName")&& !"".equals(params.get("planName"))){
//				criteria.andPlanNameLike("%" + params.get("planName") + "%");
//			}
//			if(null != params.get("haltFlag")&& !"".equals(params.get("haltFlag"))){
//				criteria.andHaltFlagEqualTo((String) params.get("haltFlag"));
//			}
//			if(null != params.get("planType")&& !"".equals(params.get("planType"))){
//				criteria.andPlanTypeEqualTo((String) params.get("planType"));
//			}
//			if(null != params.get("createTimeStart")&& !"".equals(params.get("createTimeStart")) &&
//					null != params.get("createTimeEnd")&& !"".equals(params.get("createTimeEnd"))){
//				Timestamp createTimeStart = DateUtils.paraseSqlTimestamp((String) params.get("createTimeStart"), DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
//				Timestamp createTimeEnd = DateUtils.paraseSqlTimestamp((String)params.get("createTimeEnd"),DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
//				criteria.andCreateTimeBetween(createTimeStart, createTimeEnd);
//			}else{
//				if(null != params.get("createTimeStart")&& !"".equals(params.get("createTimeStart"))){
//					Timestamp createTimeStart = DateUtils.paraseSqlTimestamp((String) params.get("createTimeStart"), DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
//					criteria.andCreateTimeGreaterThanOrEqualTo(createTimeStart);
//				}
//				if(null != params.get("createTimeEnd")&& !"".equals(params.get("createTimeEnd"))){
//					Timestamp createTimeEnd = DateUtils.paraseSqlTimestamp((String) params.get("createTimeEnd"), DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
//					criteria.andCreateTimeGreaterThanOrEqualTo(createTimeEnd);
//				}
//			}

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
//			criteria.andPlanIdIn(ids);
			int result = qmStrategyMapper.deleteByExample(example);
			if(result > 0){
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
				qmStrategyResponse.setRspcode(WebUtil.SUCCESS);
				qmStrategyResponse.setRspdesc("新增成功");
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
			int result = qmStrategyMapper.updateByPrimaryKey(qmStrategy);
			if(result > 0){
				qmStrategyResponse.setRspcode(WebUtil.SUCCESS);
				qmStrategyResponse.setRspdesc("更新成功");
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

//	@Override
//	public QmPlanResponse getPlanById(String id) throws Exception {
//		QmPlanResponse qmPlanResponse = new QmPlanResponse();
//
//		try {
//			QmPlan qmPlan = qmPlanMapper.selectByPrimaryKey(id);
//			if(null != qmPlan){
//				List<QmPlan> list = new ArrayList<QmPlan>();
//				list.add(qmPlan);
//				qmPlanResponse.setData(list);
//				qmPlanResponse.setRspcode(WebUtil.SUCCESS);
//				qmPlanResponse.setRspdesc("查询成功");
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//			logger.error("查询异常",e);
//			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
//			qmPlanResponse.setRspdesc("查询异常");
//		}
//		return  qmPlanResponse;
//	}

}
