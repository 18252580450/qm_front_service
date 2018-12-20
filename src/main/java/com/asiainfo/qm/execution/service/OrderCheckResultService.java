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
     * 工单质检暂存数据查询
     */
    OrderCheckResultResponse queryOrderSavedResult(Map params, int start, int limit) throws Exception;

    /**
     * 工单质检结果新增
     */
    OrderCheckResultResponse addOrderCheckResult(List<OrderCheckResult> orderCheckResultList) throws Exception;

    /**
     * 工单质检结果修改
     */
    OrderCheckResultResponse updateOrderCheckResult(List<OrderCheckResult> orderCheckResultList) throws Exception;

    /**
     * 工单质检结果删除
     */
    OrderCheckResultResponse deleteOrderCheckResult(List<String> idList) throws Exception;

}
