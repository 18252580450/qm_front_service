package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.VoiceCheckResultResponse;
import com.asiainfo.qm.manage.domain.VoiceCheckResult;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 16:30
 * @ Description：${description}
 */
public interface VoiceCheckResultService {

    /**
     * 语音质检暂存数据查询
     */
    VoiceCheckResultResponse queryVoiceSavedResult(Map params, int start, int limit) throws Exception;

    /**
     * 查询原质检（首次质检）流水号
     */
    VoiceCheckResultResponse queryOriginInspectionId(Map params) throws Exception;

    /**
     * 语音质检结果新增
     */
    VoiceCheckResultResponse addVoiceCheckResult(VoiceCheckResult voiceCheckResult) throws Exception;

    /**
     * 语音质检结果修改
     */
    VoiceCheckResultResponse updateVoiceCheckResult(VoiceCheckResult voiceCheckResult) throws Exception;

    /**
     * 重置之前质检的最新质检结果标志
     */
    VoiceCheckResultResponse resetLastResultFlag(VoiceCheckResult voiceCheckResult) throws Exception;

    /**
     * 语音质检结果申诉信息更新
     */
    VoiceCheckResultResponse updateAppealInfo(VoiceCheckResult voiceCheckResult) throws Exception;

    /**
     * 语音质检结果删除
     */
    VoiceCheckResultResponse deleteVoiceCheckResult(List<String> idList) throws Exception;

}
