package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.WrkfmDetailResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-30 17:29
 * @ Description：${description}
 */
public interface WrkfmDetailService {

    /**
     * 查询工单详情
     */
    WrkfmDetailResponse queryWrkfmDetail(Map params, int start, int limit) throws Exception;
}
