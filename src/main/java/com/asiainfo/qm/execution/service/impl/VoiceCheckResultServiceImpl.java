package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.VoiceCheckResultService;
import com.asiainfo.qm.execution.vo.VoiceCheckResultResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.VoiceCheckResultMapper;
import com.asiainfo.qm.manage.domain.VoiceCheckResult;
import com.asiainfo.qm.manage.domain.VoiceCheckResultExample;
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
 * @ Date       ：Created in 2018-12-11 16:30
 * @ Description：${description}
 */

@Service
public class VoiceCheckResultServiceImpl implements VoiceCheckResultService {

    private static Logger logger = LoggerFactory.getLogger(VoiceCheckResultServiceImpl.class);
    @Autowired
    private VoiceCheckResultMapper voiceCheckResultMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public VoiceCheckResultResponse queryVoiceCheckResult(Map params, int start, int limit) throws Exception {
        VoiceCheckResultResponse voiceCheckResultResponse = null;
        VoiceCheckResultExample example = new VoiceCheckResultExample();
        try {
            VoiceCheckResultExample.Criteria criteria = example.createCriteria();
            if (null != params.get("tenantId") && !"".equals(params.get("tenantId"))) {
                criteria.andTenantIdEqualTo((String) params.get("tenantId"));
            }
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                criteria.andTouchIdEqualTo((String) params.get("touchId"));
            }
            if (null != params.get("inspectionId") && !"".equals(params.get("inspectionId"))) {
                criteria.andInspectionIdEqualTo((String) params.get("inspectionId"));
            }
            if (null != params.get("resultStatus") && !"".equals(params.get("resultStatus"))) {
                criteria.andResultStatusEqualTo((String) params.get("resultStatus"));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<VoiceCheckResult> list = voiceCheckResultMapper.selectByExample(example);
                Page<VoiceCheckResult> pagelist = (Page) list;
                voiceCheckResultResponse = new VoiceCheckResultResponse(pagelist);
            } else {
                voiceCheckResultResponse = new VoiceCheckResultResponse();
                List<VoiceCheckResult> list = voiceCheckResultMapper.selectByExample(example);
                voiceCheckResultResponse.setData(list);
            }

            if (null != voiceCheckResultResponse.getData() && voiceCheckResultResponse.getData().size() > 0) {
                voiceCheckResultResponse.setRspcode(WebUtil.SUCCESS);
                voiceCheckResultResponse.setRspdesc("查询成功");
            } else {
                voiceCheckResultResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("质检结果查询异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("质检结果查询异常");
        }
        return voiceCheckResultResponse;
    }

    @Override
    public VoiceCheckResultResponse queryOriginInspectionId(Map params) throws Exception {
        VoiceCheckResultResponse voiceCheckResultResponse = null;
        VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
        try {
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                voiceCheckResult.setTouchId(params.get("touchId").toString());
            }
            voiceCheckResultResponse = new VoiceCheckResultResponse();

            List<VoiceCheckResult> list = voiceCheckResultMapper.queryFirstInspectionId(voiceCheckResult);
            voiceCheckResultResponse.setData(list);

            if (null != voiceCheckResultResponse.getData() && voiceCheckResultResponse.getData().size() > 0) {
                voiceCheckResultResponse.setRspcode(WebUtil.SUCCESS);
                voiceCheckResultResponse.setRspdesc("查询成功");
            } else {
                voiceCheckResultResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("原质检流水查询异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("原质检流水查询异常");
        }
        return voiceCheckResultResponse;
    }
}
