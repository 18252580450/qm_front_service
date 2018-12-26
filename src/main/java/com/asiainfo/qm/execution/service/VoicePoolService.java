package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.vo.VoicePoolResponse;
import java.util.List;
import java.util.Map;


public interface VoicePoolService {

    VoicePoolResponse selectByParams(Map params, int start, int limit)throws Exception;

    VoicePoolResponse update(List<String> idList) throws Exception;

    VoicePoolResponse updateCheck(List<Map> list) throws Exception;

    VoicePoolResponse deleteItems(List<String> idList) throws Exception;

    /**
     * 语音质检池更新（质检之后）
     */
    VoicePoolResponse updateVoicePool(VoicePool voicePool) throws Exception;

    /**
     * 申诉通过重新质检
     */
    VoicePoolResponse recheckUpdate(VoicePool voicePool) throws Exception;
}
