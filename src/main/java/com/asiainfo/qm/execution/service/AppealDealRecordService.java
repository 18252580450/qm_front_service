package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.AppealDealRecordResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-21 14:23
 * @ Description：${description}
 */
public interface AppealDealRecordService {
    /**
     * 申诉审批记录查询
     */
    AppealDealRecordResponse queryAppealRecord(Map params, int start, int limit) throws Exception;

}
