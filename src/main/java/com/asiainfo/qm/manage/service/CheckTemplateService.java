package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.vo.CheckTemplateResponse;

import java.util.List;
import java.util.Map;

public interface CheckTemplateService {

	CheckTemplateResponse selectByParams(Map params, int start, int limit)throws Exception;

	CheckTemplateResponse deleteByIds(List<String> ids)throws Exception;

	CheckTemplateResponse copyTemplate(CheckTemplate checkTemplate)throws Exception;

	CheckTemplateResponse insertCheckTemplate(CheckTemplate checkTemplate)throws Exception;

	CheckTemplateResponse update(List<String> idList) throws Exception;
	CheckTemplateResponse updateTemplate(List<String> idList) throws Exception;
}
	