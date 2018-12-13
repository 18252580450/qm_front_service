package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.vo.TemplateDetailResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-12 16:13
 * @ Description：${description}
 */
public interface CheckTemplateDetailService {

    /**
     * 考评模版详细信息查询
     */
    TemplateDetailResponse queryTemplateDetail(Map params, int start, int limit) throws Exception;
}
