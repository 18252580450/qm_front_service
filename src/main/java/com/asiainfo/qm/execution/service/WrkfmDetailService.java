package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.domain.WrkfmDetail;
import com.asiainfo.qm.execution.vo.WrkfmDetailResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-30 17:29
 * @ Description：${description}
 */
public interface WrkfmDetailService {

    /**
     * 质检申诉查询
     */
    WrkfmDetailResponse queryWrkfmDetail(Map params, int start, int limit) throws Exception;
}
