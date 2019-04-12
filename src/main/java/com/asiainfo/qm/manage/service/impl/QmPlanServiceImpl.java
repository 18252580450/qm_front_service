package com.asiainfo.qm.manage.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.restClient.RestClient;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.QmPlanMapper;
import com.asiainfo.qm.manage.domain.QmPlan;
import com.asiainfo.qm.manage.domain.QmPlanExample;
import com.asiainfo.qm.manage.service.QmPlanService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.DateUtils;
import com.asiainfo.qm.manage.util.HttpConstants;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.QmPlanResponse;
import com.asiainfo.qm.task.dao.QmBindRlnMapper;
import com.asiainfo.qm.task.domain.QmBindRln;
import com.asiainfo.qm.task.domain.QmBindRlnExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.corba.se.pept.encoding.InputObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
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
	private QmBindRlnMapper qmBindRlnMapper;

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
				for(int i = 0;i<ids.size();i++){
					QmBindRlnExample qmBindRlnExample = new QmBindRlnExample();
					QmBindRlnExample.Criteria qmBindRlnExampleCriteria = qmBindRlnExample.createCriteria();
					qmBindRlnExampleCriteria.andPlanIdEqualTo(ids.get(i));
					qmBindRlnMapper.deleteByExample(qmBindRlnExample);
				}
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
				List<QmBindRln> qmBindRlns = qmPlan.getQmBindRlnList();
				if(qmBindRlns.size() > 0){
					for(int i = 0;i<qmBindRlns.size();i++){
						QmBindRln bindRln = qmBindRlns.get(i);
						bindRln.setPlanId(qmPlan.getPlanId());
						qmBindRlnMapper.insertSelective(bindRln);
					}
				}
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
			int result = qmPlanMapper.updateByPrimaryKeySelective(qmPlan);
			if(result > 0){
				//删除原有的
				QmBindRlnExample example = new QmBindRlnExample();
				QmBindRlnExample.Criteria criteria = example.createCriteria();
				criteria.andPlanIdEqualTo(qmPlan.getPlanId());
				qmBindRlnMapper.deleteByExample(example);
				//新增最新的
				List<QmBindRln> qmBindRlns = qmPlan.getQmBindRlnList();
				if(qmBindRlns.size() > 0){
					for(int i = 0;i<qmBindRlns.size();i++){
						QmBindRln bindRln = qmBindRlns.get(i);
						qmBindRlnMapper.insertSelective(bindRln);
					}
				}
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

	@Override
	public QmPlanResponse getPlanById(String id) throws Exception {
		QmPlanResponse qmPlanResponse = new QmPlanResponse();

		try {
			QmPlan qmPlan = qmPlanMapper.selectByPrimaryKey(id);
			if(null != qmPlan){
				QmBindRlnExample example = new QmBindRlnExample();
				QmBindRlnExample.Criteria criteria = example.createCriteria();
				criteria.andPlanIdEqualTo(id);
				List<QmBindRln> qmBindRlns = qmBindRlnMapper.selectByExample(example);
				if(qmBindRlns.size() > 0){
					//调查询虚拟组接口
					for(int i = 0;i<qmBindRlns.size();i++){
						if(null != qmBindRlns.get(i).getCheckStaffId()&&!(qmBindRlns.get(i).getCheckStaffId().isEmpty())){
//							qmBindRlns.get(i).setCheckStaffName("质检人"+i);
							Map map = new HashMap();
							map.put("staffId",qmBindRlns.get(i).getCheckStaffId());
							map.put("groupId","");
							map.put("staffName","");
							map.put("start","");
							map.put("limit","");
							map.put("provCode","");
							map.put("roleCode","");
							QmPlanResponse planResponse = getQmPeople(map);
							if(planResponse.getListData().size()>0&&planResponse.getListData()!=null){
								HashMap hashMap = (HashMap) planResponse.getListData().get(0);
								qmBindRlns.get(i).setCheckStaffName(((JSONObject)(((JSONArray)hashMap.get("jsonArray")).get(0))).getString("STAFF_NAME"));
							}
						}
						if(null != qmBindRlns.get(i).getCheckedObjectId()&&!(qmBindRlns.get(i).getCheckedObjectId().isEmpty())){
//							qmBindRlns.get(i).setCheckedObjectName("被质检人"+i);
//							qmBindRlns.get(i).setCheckedDepartName("话务组"+i);
							Map map = new HashMap();
							map.put("staffId",qmBindRlns.get(i).getCheckedObjectId());
							map.put("groupId","");
							map.put("staffName","");
							map.put("start","");
							map.put("limit","");
							map.put("provCode","");
							map.put("roleCode","");
							QmPlanResponse planResponse = getQmPeople(map);
							if(planResponse.getListData().size()>0&&planResponse.getListData()!=null){
								HashMap hashMap = (HashMap) planResponse.getListData().get(0);
								qmBindRlns.get(i).setCheckedObjectName(((JSONObject)(((JSONArray)hashMap.get("jsonArray")).get(0))).getString("STAFF_NAME"));
								qmBindRlns.get(i).setCheckedDepartName(((JSONObject)(((JSONArray)hashMap.get("jsonArray")).get(0))).getString("GROUP_NAME"));
							}
						}
					}
				}
				qmPlan.setQmBindRlnList(qmBindRlns);
				List<QmPlan> list = new ArrayList<>();
				list.add(qmPlan);
				qmPlanResponse.setData(list);
				qmPlanResponse.setRspcode(WebUtil.SUCCESS);
				qmPlanResponse.setRspdesc("查询成功");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("查询异常",e);
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("查询异常");
		}
		return  qmPlanResponse;
	}

	@Override
	public QmPlanResponse getWorkList(Map params) throws Exception{
		QmPlanResponse qmPlanResponse = new QmPlanResponse();

		try {
			String url = HttpConstants.HttpParams.VIRTUAL_GROUP_SERVLET+"?parentId="+params.get("parentId")+"&groupId="+params.get("groupId")+"&groupName="+params.get("groupName")+"&provCode="+params.get("provCode");
			RestClient restClient = new RestClient();
			Map map = new HashMap();
			List list = (List) restClient.callRemoteServicetWithHeaderForList(url, HttpMethod.POST,map,JSONObject.class,null,"1");
			if(list.size() >0){
				qmPlanResponse.setRspcode(WebUtil.SUCCESS);
				qmPlanResponse.setListData(list);
				qmPlanResponse.setRspdesc("查询成功");
			}else {
				qmPlanResponse.setRspcode(WebUtil.FAIL);
				qmPlanResponse.setRspdesc("查询失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("查询异常",e);
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("查询异常");
		}
		return  qmPlanResponse;
	}

	@Override
	public QmPlanResponse getQmPeople(Map params) throws Exception{
		QmPlanResponse qmPlanResponse = new QmPlanResponse();

		try {
			String url = HttpConstants.HttpParams.VIRTUAL_GROUP_PERSONAL_SERVLET+"?groupId="
					+params.get("groupId")+"&staffName="+params.get("staffName")+
					"&staffId="+params.get("staffId")+"&start="+params.get("start")+
					"&limit="+params.get("limit")+"&provCode="+params.get("provCode")+
					"&roleCode="+params.get("roleCode");
			String urlAll = HttpConstants.HttpParams.VIRTUAL_GROUP_PERSONAL_SERVLET+"?groupId=&staffName=&staffId=&start=&limit=&=provCode=&roleCode="+params.get("roleCode");
			RestClient restClient = new RestClient();
			Map map = new HashMap();
			JSONArray jsonArray = (JSONArray) restClient.callRemoteServicetWithHeaderForList(url, HttpMethod.POST,map,JSONObject.class,null,"1");
			JSONArray jsonArrayAll = (JSONArray) restClient.callRemoteServicetWithHeaderForList(urlAll, HttpMethod.POST,map,JSONObject.class,null,"1");
			if(jsonArray.size() >0){
				qmPlanResponse.setRspcode(WebUtil.SUCCESS);
				List list = new ArrayList();
				Map hashMap = new HashMap();
				hashMap.put("totalAll",((JSONObject) jsonArrayAll.get(0)).get("TOTAL"));
				hashMap.put("jsonArray",jsonArray);
				hashMap.put("jsonArrayAll",jsonArrayAll);
				list.add(hashMap);
				qmPlanResponse.setListData(list);
				qmPlanResponse.setRspdesc("查询成功");
			}else {
				qmPlanResponse.setRspcode(WebUtil.FAIL);
				qmPlanResponse.setRspdesc("查询失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("查询异常",e);
			qmPlanResponse.setRspcode(WebUtil.EXCEPTION);
			qmPlanResponse.setRspdesc("查询异常");
		}
		return  qmPlanResponse;
	}
}
