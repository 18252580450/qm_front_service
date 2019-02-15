package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.OrderCheckResultDetailResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-19 15:59
 * @ Description：${description}
 */
public interface OrderCheckResultDetailService {

    /**
     * 工单质检结果暂存信息查询
     */
    OrderCheckResultDetailResponse querySavedResult(Map params, int start, int limit) throws Exception;

    /**
     * 工单质检结果详细信息查询
     */
    OrderCheckResultDetailResponse queryOrderCheckResultDetail(Map params, int start, int limit) throws Exception;

}
