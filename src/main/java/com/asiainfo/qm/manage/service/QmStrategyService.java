package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.QmStrategy;
import com.asiainfo.qm.manage.vo.QmStrategyResponse;

import java.util.List;
import java.util.Map;

public interface QmStrategyService {

	QmStrategyResponse selectByParams(Map params, int start, int limit)throws Exception;

	QmStrategyResponse deleteByIds(List<String> ids)throws Exception;

	QmStrategyResponse addQmStrategy(QmStrategy qmStrategy)throws Exception;

	QmStrategyResponse updateQmStrategy(QmStrategy qmStrategy)throws Exception;

//	QmStrategyResponse batchUpdate(List<String> ids, String halfFlag)throws Exception;

//	QmStrategyResponse getPlanById(String id)throws Exception;
}
	