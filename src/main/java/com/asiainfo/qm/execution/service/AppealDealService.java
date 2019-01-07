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
     * 申诉提交
     */
    AppealDealResponse submitAppeal(Map<String, Object> reqMap) throws Exception;

    /**
     * 申诉查询
     */
    AppealDealResponse queryAppeal(Map params, int start, int limit) throws Exception;

    /**
     * 申诉处理
     */
    AppealDealResponse dealAppeal(Map<String, Object> reqMap) throws Exception;

}
