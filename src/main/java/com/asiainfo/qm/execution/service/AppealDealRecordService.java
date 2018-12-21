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
    AppealDealRecordResponse queryAppeal(Map params, int start, int limit) throws Exception;

    /**
     * 质检申诉新增（提交）
     */
    AppealDealRecordResponse createAppeal(AppealDealRecord appealDeal) throws Exception;

    /**
     * 质检申诉状态更新
     */
    AppealDealRecordResponse updateAppeal(AppealDealRecord appealDeal) throws Exception;

    /**
     * 质检申诉结果删除
     */
    AppealDealRecordResponse deleteAppeal(List<String> idList) throws Exception;
}
