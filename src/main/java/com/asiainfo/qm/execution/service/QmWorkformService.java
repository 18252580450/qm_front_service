package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.QmWorkformResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-20 19:47
 * @ Description：${description}
 */
public interface QmWorkformService {

    /**
     * 计划外工单查询
     */
    QmWorkformResponse queryWorkForm(Map params, int start, int limit)throws Exception;

    /**
     * 工单分配
     */
    QmWorkformResponse workFormAllocate(Map<String, Object> params) throws Exception;
}
