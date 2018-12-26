package com.asiainfo.qm.task.service;

import com.asiainfo.qm.task.domain.QmVoice;

import java.util.List;
import java.util.Map;

/**
 * Created by shiying on 2018/12/24.
 */
public interface IAutoExtractCommonService {

    public List<QmVoice> autoExtractVoiceInfo(Map params) throws Exception;

//    public List<QmVoice> autoExtractVoiceInfo(Map params) throws Exception;
}
