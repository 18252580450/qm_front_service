package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.OrderCheckResponse;
import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-01-05 10:55
 * @ Description：${description}
 */
public interface OrderCheckService {

    /**
     * 工单质检
     */
    OrderCheckResponse orderCheck(Map<String, Object> params) throws Exception;

}
