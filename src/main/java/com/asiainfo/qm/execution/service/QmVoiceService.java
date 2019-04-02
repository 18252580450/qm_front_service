package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.QmVoiceResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-20 19:48
 * @ Description：${description}
 */
public interface QmVoiceService {

    /**
     * 计划外语音查询
     */
    QmVoiceResponse queryVoiceRecord(Map params, int start, int limit)throws Exception;

    /**
     * 工单分配
     */
    QmVoiceResponse voiceAllocate(Map<String, Object> params) throws Exception;
}
