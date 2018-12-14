package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.domain.VoiceCheckResult;
import com.asiainfo.qm.execution.service.VoiceCheckResultService;
import com.asiainfo.qm.execution.vo.VoiceCheckResultResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 16:30
 * @ Description：${description}
 */

@Service
public class VoiceCheckResultServiceImpl implements VoiceCheckResultService {

    @Override
    public VoiceCheckResultResponse queryVoiceCheckResult(Map params, int start, int limit) throws Exception {
        return null;
    }

    @Override
    public VoiceCheckResultResponse addVoiceCheckResult(VoiceCheckResult voiceCheckResult) throws Exception {
        return null;
    }

    @Override
    public VoiceCheckResultResponse updateVoiceCheckResult(VoiceCheckResult voiceCheckResult) throws Exception {
        return null;
    }

    @Override
    public VoiceCheckResultResponse deleteCheckItem(List<String> idList) throws Exception {
        return null;
    }
}
