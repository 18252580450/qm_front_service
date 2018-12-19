package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.execution.vo.VoiceCheckResultResponse;
import java.util.Map;


public interface VoiceCheckResultService {

    VoiceCheckResultResponse selectByParams(Map params, int start, int limit)throws Exception;

}
