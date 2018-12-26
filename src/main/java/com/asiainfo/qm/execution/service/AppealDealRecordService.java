package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.domain.AppealDealRecord;
import com.asiainfo.qm.execution.vo.AppealDealRecordResponse;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-21 14:23
 * @ Description：${description}
 */
public interface AppealDealRecordService {
    /**
     * 质检申诉查询
     */
    AppealDealRecordResponse queryAppealRecord(Map params, int start, int limit) throws Exception;

    /**
     * 质检申诉新增（提交）
     */
    AppealDealRecordResponse createAppealRecord(AppealDealRecord appealDeal) throws Exception;

    /**
     * 质检申诉状态更新
     */
    AppealDealRecordResponse updateAppealRecord(AppealDealRecord appealDeal) throws Exception;

    /**
     * 质检申诉结果删除
     */
    AppealDealRecordResponse deleteAppealRecord(List<String> idList) throws Exception;
}
