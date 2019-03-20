package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.VoicePoolResponse;
import java.util.List;
import java.util.Map;


public interface VoicePoolService {

    VoicePoolResponse selectByParams(Map params, int start, int limit)throws Exception;

    VoicePoolResponse update(List<String> idList) throws Exception;

    VoicePoolResponse updateCheck(List<Map> list) throws Exception;
}
