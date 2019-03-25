package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.QmVoiceResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-20 19:48
 * @ Description：${description}
 */
public interface QmVoiceService {

    QmVoiceResponse queryVoice(Map params, int start, int limit)throws Exception;
}
