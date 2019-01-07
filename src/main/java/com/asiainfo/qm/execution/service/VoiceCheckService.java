package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.VoiceCheckResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-01-07 09:21
 * @ Description：${description}
 */
public interface VoiceCheckService {
    /**
     * 语音质检
     */
    VoiceCheckResponse voiceCheck(Map<String, Object> params) throws Exception;
}
