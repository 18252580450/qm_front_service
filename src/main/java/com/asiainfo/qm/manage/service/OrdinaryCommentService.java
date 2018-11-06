package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.OrdinaryComment;
import com.asiainfo.qm.manage.vo.OrdinaryCommentResponse;
import java.util.List;
import java.util.Map;

public interface OrdinaryCommentService {

	OrdinaryCommentResponse selectByParams(Map params, int start, int limit)throws Exception;

	OrdinaryCommentResponse deleteByIds(List<String> ids)throws Exception;

	OrdinaryCommentResponse updateComment(OrdinaryComment ordinaryComment) throws Exception;

	OrdinaryCommentResponse insertComment(OrdinaryComment ordinaryComment)throws Exception;
}
	