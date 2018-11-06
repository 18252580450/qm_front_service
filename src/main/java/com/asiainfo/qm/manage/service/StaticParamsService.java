package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.StaticParams;
import com.asiainfo.qm.manage.vo.StaticParamsResponse;

import java.util.List;
import java.util.Map;

public interface StaticParamsService {

	StaticParamsResponse selectByParams(Map params,int start,int limit)throws Exception;

	StaticParamsResponse selectAllTypes(Map params)throws Exception;

	StaticParamsResponse deleteByIds(List<String> ids)throws Exception;

	StaticParamsResponse addStaticParams(StaticParams staticParams)throws Exception;

	StaticParamsResponse updateStaticParams(StaticParams staticParams)throws Exception;
}
	