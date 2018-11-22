package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.OrdinaryComment;
import com.asiainfo.qm.manage.vo.CheckTemplateResponse;
import com.asiainfo.qm.manage.vo.OrdinaryCommentResponse;

import java.util.List;
import java.util.Map;

public interface CheckTemplateService {

	CheckTemplateResponse selectByParams(Map params, int start, int limit)throws Exception;

	CheckTemplateResponse deleteByIds(List<String> ids)throws Exception;

	CheckTemplateResponse action(CheckTemplate checkTemplate) throws Exception;

	CheckTemplateResponse copyTemplate(CheckTemplate checkTemplate)throws Exception;

	CheckTemplateResponse insertCheckTemplate(CheckTemplate checkTemplate)throws Exception;
}
	