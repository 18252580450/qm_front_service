package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.QmPlan;
import com.asiainfo.qm.manage.vo.QmPlanResponse;

import java.util.List;
import java.util.Map;

public interface QmPlanService {

	QmPlanResponse selectByParams(Map params, int start, int limit)throws Exception;

	QmPlanResponse deleteByIds(List<String> ids)throws Exception;

	QmPlanResponse addQmPlan(QmPlan qmPlan)throws Exception;

	QmPlanResponse updateQmPlan(QmPlan qmPlan)throws Exception;

	QmPlanResponse batchUpdate(List<String> ids, String halfFlag)throws Exception;
}
	