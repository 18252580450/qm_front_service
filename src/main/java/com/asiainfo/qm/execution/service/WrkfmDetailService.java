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
    WrkfmDetailResponse queryWrkfmDetail(Map params) throws Exception;

    /**
     * 查询工单轨迹
     */
    WrkfmDetailResponse getProcProceLocus(Map params) throws Exception;

    /**
     * 查询内外部回复
     */
    WrkfmDetailResponse getHandingLog(Map params) throws Exception;

    /**
     * 查询工单接触记录
     */
    WrkfmDetailResponse getRecordList(Map params) throws Exception;

    /**
     * 查询工单历史
     */
    WrkfmDetailResponse getHistoryProProce(Map params) throws Exception;

}
