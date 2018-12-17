package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.VoiceCheckResultDetailService;
import com.asiainfo.qm.execution.vo.VoiceCheckResultDetailResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.VoiceCheckResultDetailMapper;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetail;
import com.asiainfo.qm.manage.service.impl.CheckItemServiceImpl;
import com.asiainfo.qm.manage.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-17 09:56
 * @ Description：${description}
 */

@Service
public class VoiceCheckResultDetailServiceImpl implements VoiceCheckResultDetailService {

    private static Logger logger = LoggerFactory.getLogger(CheckItemServiceImpl.class);
    @Autowired
    private VoiceCheckResultDetailMapper voiceCheckResultDetailMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public VoiceCheckResultDetailResponse queryVoiceCheckResultDetail(Map params, int start, int limit) throws Exception {
        return null;
    }

    @Override
    public VoiceCheckResultDetailResponse addVoiceCheckResultDetail(List<VoiceCheckResultDetail> voiceCheckResultDetailList) throws Exception {
        VoiceCheckResultDetailResponse voiceCheckResultDetailResponse = new VoiceCheckResultDetailResponse();
        try {
            int result = 0;
            for (VoiceCheckResultDetail voiceCheckResultDetail : voiceCheckResultDetailList
            ) {
                result = voiceCheckResultDetailMapper.insertSelective(voiceCheckResultDetail);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                voiceCheckResultDetailResponse.setRspcode(WebUtil.SUCCESS);
                voiceCheckResultDetailResponse.setRspdesc("质检完成");
            } else {
                voiceCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultDetailResponse.setRspdesc("质检失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音考评结果新增异常", e);
            voiceCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultDetailResponse.setRspdesc("语音考评结果新增异常");
        }
        return voiceCheckResultDetailResponse;
    }
}
