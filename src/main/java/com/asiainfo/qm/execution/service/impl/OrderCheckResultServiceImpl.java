package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.OrderCheckResultService;
import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;
import com.asiainfo.qm.manage.domain.OrderCheckResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 16:24
 * @ Description：${description}
 */

@Service
public class OrderCheckResultServiceImpl implements OrderCheckResultService {

    @Override
    public OrderCheckResultResponse queryOrderCheckResult(Map params, int start, int limit) throws Exception {
        return null;
    }

    @Override
    public OrderCheckResultResponse addOrderCheckResult(OrderCheckResult orderCheckResult) throws Exception {
        return null;
    }

    @Override
    public OrderCheckResultResponse updateOrderCheckResult(OrderCheckResult orderCheckResult) throws Exception {
        return null;
    }

    @Override
    public OrderCheckResultResponse deleteCheckItem(List<String> idList) throws Exception {
        return null;
    }
}
