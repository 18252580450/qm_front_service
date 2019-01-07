package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;
import com.asiainfo.qm.manage.domain.OrderCheckResult;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 16:23
 * @ Description：${description}
 */
public interface OrderCheckResultService {

    /**
     * 工单质检结果查询
     */
    OrderCheckResultResponse queryOrderCheckResult(Map params, int start, int limit) throws Exception;

    /**
     * 查询原质检（首次质检）流水号
     */
    OrderCheckResultResponse queryOriginInspectionId(Map params) throws Exception;

}
