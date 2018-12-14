package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.domain.OrderCheckResult;
import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;

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
     * 工单质检结果新增
     */
    OrderCheckResultResponse addOrderCheckResult(OrderCheckResult orderCheckResult) throws Exception;

    /**
     * 工单质检结果修改
     */
    OrderCheckResultResponse updateOrderCheckResult(OrderCheckResult orderCheckResult) throws Exception;

    /**
     * 工单质检结果删除
     */
    OrderCheckResultResponse deleteCheckItem(List<String> idList) throws Exception;

}
