package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.VoiceCheckResultDetailService;
import com.asiainfo.qm.execution.service.VoiceCheckResultService;
import com.asiainfo.qm.execution.vo.VoiceCheckResultDetailResponse;
import com.asiainfo.qm.execution.vo.VoiceCheckResultResponse;
import com.asiainfo.qm.manage.dao.VoiceCheckResultDetailMapper;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetail;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetailExample;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    private VoiceCheckResultService voiceCheckResultService;

    @Override
    public VoiceCheckResultDetailResponse querySavedResult(Map params, int start, int limit) throws Exception {
        VoiceCheckResultDetailResponse voiceCheckResultDetailResponse = null;
        VoiceCheckResultDetailExample example = new VoiceCheckResultDetailExample();
        try {
            String inspectionId = ""; //暂存结果的质检流水号
            //通过质检结果表查询质检流水号
            Map<String, Object> param = new HashMap<>();
            param.put("tenantId", params.get("tenantId"));
            param.put("touchId", params.get("touchId"));
            param.put("resultStatus", Constants.QM_CHECK_RESULT.TEMP_SAVE);
            VoiceCheckResultResponse voiceCheckResultResponse = voiceCheckResultService.queryVoiceCheckResult(param, 0, 0);
            if (voiceCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                voiceCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultDetailResponse.setRspdesc("获取暂存质检结果异常");
                return voiceCheckResultDetailResponse;
            }
            if (null != voiceCheckResultResponse.getData() && voiceCheckResultResponse.getData().size() > 0) {
                inspectionId = voiceCheckResultResponse.getData().get(0).getInspectionId();
                VoiceCheckResultDetailExample.Criteria criteria = example.createCriteria();
                criteria.andInspectionIdEqualTo(inspectionId);

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
                } else {
                    voiceCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                    voiceCheckResultDetailResponse.setRspdesc("无数据");
                }
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
}
