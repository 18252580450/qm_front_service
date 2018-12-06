package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.QmStrategyElement;
import com.asiainfo.qm.manage.vo.QmStrategyElesResponse;

import java.util.List;
import java.util.Map;

public interface QmStrategyElesService {

	QmStrategyElesResponse selectByParams(Map params, int start, int limit)throws Exception;

	QmStrategyElesResponse deleteByIds(List<String> ids)throws Exception;

	QmStrategyElesResponse addQmStrategyEles(QmStrategyElement qmStrategyEles)throws Exception;

	QmStrategyElesResponse updateQmStrategyEles(QmStrategyElement qmStrategyEles)throws Exception;

//	QmStrategyResponse batchUpdate(List<String> ids, String halfFlag)throws Exception;

	QmStrategyElesResponse getStrategyElesById(String id)throws Exception;
}
	