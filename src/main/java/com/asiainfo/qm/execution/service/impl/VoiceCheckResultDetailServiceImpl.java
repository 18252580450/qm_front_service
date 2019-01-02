package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.VoiceCheckResultDetailService;
import com.asiainfo.qm.execution.vo.VoiceCheckResultDetailResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.VoiceCheckResultDetailMapper;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetail;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetailExample;
import com.asiainfo.qm.manage.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    private static Logger logger = LoggerFactory.getLogger(VoiceCheckResultDetailServiceImpl.class);
    @Autowired
    private VoiceCheckResultDetailMapper voiceCheckResultDetailMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public VoiceCheckResultDetailResponse queryVoiceCheckResultDetail(Map params, int start, int limit) throws Exception {
        VoiceCheckResultDetailResponse voiceCheckResultDetailResponse = null;
        VoiceCheckResultDetailExample example = new VoiceCheckResultDetailExample();
        try {
            VoiceCheckResultDetailExample.Criteria criteria = example.createCriteria();
            if (null != params.get("inspectionId") && !"".equals(params.get("inspectionId"))) {
                criteria.andInspectionIdEqualTo((String) params.get("inspectionId"));
            }
            if (null != params.get("nodeId") && !"".equals(params.get("nodeId"))) {
                criteria.andNodeIdEqualTo((String) params.get("nodeId"));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<VoiceCheckResultDetail> list = voiceCheckResultDetailMapper.selectByExample(example);
                Page<VoiceCheckResultDetail> pagelist = (Page) list;
                voiceCheckResultDetailResponse = new VoiceCheckResultDetailResponse(pagelist);
            } else {
                voiceCheckResultDetailResponse = new VoiceCheckResultDetailResponse();
                List<VoiceCheckResultDetail> list = voiceCheckResultDetailMapper.selectByExample(example);
                voiceCheckResultDetailResponse.setData(list);
            }

            if (null != voiceCheckResultDetailResponse.getData() && voiceCheckResultDetailResponse.getData().size() > 0) {
                voiceCheckResultDetailResponse.setRspcode(WebUtil.SUCCESS);
                voiceCheckResultDetailResponse.setRspdesc("查询成功");
            } else {
                voiceCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultDetailResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("质检结果详情查询异常", e);
            voiceCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultDetailResponse.setRspdesc("质检结果详情查询异常");
        }
        return voiceCheckResultDetailResponse;
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
                voiceCheckResultDetailResponse.setRspdesc("语音质检结果详细信息新增成功");
            } else {
                voiceCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultDetailResponse.setRspdesc("语音质检结果详细信息新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音质检结果详细信息新增异常", e);
            voiceCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultDetailResponse.setRspdesc("语音质检结果详细信息新增异常");
        }
        return voiceCheckResultDetailResponse;
    }

    @Override
    public VoiceCheckResultDetailResponse updateVoiceCheckResultDetail(List<VoiceCheckResultDetail> voiceCheckResultDetailList) throws Exception {
        VoiceCheckResultDetailResponse voiceCheckResultDetailResponse = new VoiceCheckResultDetailResponse();
        try {
            int result = 0;
            for (VoiceCheckResultDetail voiceCheckResultDetail : voiceCheckResultDetailList
            ) {
                result = voiceCheckResultDetailMapper.updateByPrimaryKeySelective(voiceCheckResultDetail);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                voiceCheckResultDetailResponse.setRspcode(WebUtil.SUCCESS);
                voiceCheckResultDetailResponse.setRspdesc("语音质检结果详细信息更新成功");
            } else {
                voiceCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultDetailResponse.setRspdesc("语音质检结果详细信息更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音质检结果详细信息更新异常", e);
            voiceCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultDetailResponse.setRspdesc("语音质检结果详细信息更新异常");
        }
        return voiceCheckResultDetailResponse;
    }
}
