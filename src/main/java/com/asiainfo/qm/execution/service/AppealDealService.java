package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.AppealDealResponse;
import com.asiainfo.qm.execution.domain.AppealDeal;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-21 14:22
 * @ Description：${description}
 */
public interface AppealDealService {
    /**
     * 质检申诉查询
     */
    AppealDealResponse queryAppeal(Map params, int start, int limit) throws Exception;

    /**
     * 质检申诉新增（提交）
     */
    AppealDealResponse createAppeal(AppealDeal appealDeal) throws Exception;

    /**
     * 质检申诉状态更新
     */
    AppealDealResponse updateAppeal(AppealDeal appealDeal) throws Exception;

    /**
     * 质检申诉结果删除
     */
    AppealDealResponse deleteAppeal(List<String> idList) throws Exception;
}
