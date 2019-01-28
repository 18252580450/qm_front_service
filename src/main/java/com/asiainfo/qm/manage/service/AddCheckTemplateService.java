package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.CheckItem;
import com.asiainfo.qm.manage.domain.TemplateDetail;
import com.asiainfo.qm.manage.domain.TemplateDetailKey;
import com.asiainfo.qm.manage.vo.OrdinaryCommentResponse;
import com.asiainfo.qm.manage.vo.TemplateDetailResponse;

import java.util.List;
import java.util.Map;


public interface AddCheckTemplateService {

//    List<CheckItem> queryCheckItem(Map params)throws Exception;

    TemplateDetailResponse deleteByIds(List<String> ids)throws Exception;

    TemplateDetailResponse insertTempDetail(List<TemplateDetail> list)throws Exception;

    TemplateDetailResponse selectByParams(Map params, int start, int limit)throws Exception;

    TemplateDetailResponse update(List<Map> list)throws Exception;

    TemplateDetailResponse deleteByPrimaryKey(TemplateDetailKey templateDetailKey)throws Exception;

    TemplateDetailResponse selectByPrimaryKey(TemplateDetailKey templateDetailKey)throws Exception;

}
