package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.VoiceCheckResultDetailResponse;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetail;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-17 09:54
 * @ Description：${description}
 */
public interface VoiceCheckResultDetailService {

    /**
     * 语音质检结果详细信息查询
     */
    VoiceCheckResultDetailResponse querySavedResult(Map params, int start, int limit) throws Exception;

    /**
     * 语音质检结果详细信息查询
     */
    VoiceCheckResultDetailResponse queryVoiceCheckResultDetail(Map params, int start, int limit) throws Exception;

}
