package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.VoicePoolMapper;
import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.service.VoiceCheckResultService;
import com.asiainfo.qm.execution.service.VoiceCheckService;
import com.asiainfo.qm.execution.vo.*;
import com.asiainfo.qm.execution.web.VoiceCheckController;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.VoiceCheckResultDetailMapper;
import com.asiainfo.qm.manage.dao.VoiceCheckResultMapper;
import com.asiainfo.qm.manage.domain.VoiceCheckResult;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetail;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-01-07 09:21
 * @ Description：${description}
 */

@Service
public class VoiceCheckServiceImpl implements VoiceCheckService {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(VoiceCheckController.class);

    @Autowired
    private VoiceCheckResultMapper voiceCheckResultMapper;
    @Autowired
    private VoiceCheckResultDetailMapper voiceCheckResultDetailMapper;
    @Autowired
    private VoicePoolMapper voicePoolMapper;
    @Autowired
    private VoiceCheckResultService voiceCheckResultService;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public VoiceCheckResponse voiceCheck(Map<String, Object> reqMap) throws Exception {
        VoiceCheckResponse voiceCheckResponse = new VoiceCheckResponse();
        VoiceCheckResultResponse voiceCheckResultResponse = new VoiceCheckResultResponse();
        VoiceCheckResultDetailResponse voiceCheckResultDetailResponse = new VoiceCheckResultDetailResponse();
        VoiceCheckResultServiceResponse voiceCheckResultServiceResponse = new VoiceCheckResultServiceResponse();
        @SuppressWarnings("unchecked")
        Map<String, Object> checkResult = (Map<String, Object>) reqMap.get("voiceCheckResult");
        @SuppressWarnings("unchecked")
        List<Map> checkItemList = (ArrayList<Map>) reqMap.get("checkItemList");
        //质检流水
        String inspectionId = String.valueOf(sequenceUtils.getSequence("t_qm_voice_check_result"));
        //质检结果状态（新增、暂存、复检）
        String checkStatus = checkResult.get("resultStatus").toString();
        //质检开始时间
        Date currentTime = DateUtil.getCurrontTime();
        String tmpStr = checkResult.get("checkStartTime").toString();
        String checkStartTime = tmpStr.substring(0, 10) + " " + tmpStr.substring(11);
        boolean updateFlag = false; //更新标志
        try {
//            String rspCode = WebUtil.SUCCESS;
            //查询语音质检结果信息表，存在暂存数据则更新质检结果，反之插入
            Map<String, Object> params = new HashMap<>();
            params.put("tenantId", checkResult.get("tenantId"));
            params.put("touchId", checkResult.get("touchId"));
            params.put("resultStatus", Constants.QM_CHECK_RESULT.TEMP_SAVE);
            voiceCheckResultResponse = voiceCheckResultService.queryVoiceCheckResult(params, 0, 0);
            if (voiceCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                voiceCheckResponse.setRspcode(voiceCheckResultResponse.getRspcode());
                voiceCheckResponse.setRspdesc(voiceCheckResultResponse.getRspdesc());
                return voiceCheckResponse;
            }
            if (null != voiceCheckResultResponse.getData() && voiceCheckResultResponse.getData().size() > 0) {
                inspectionId = voiceCheckResultResponse.getData().get(0).getInspectionId();
                updateFlag = true;
            }

            //原质检流水
            String originInspectionId = inspectionId;
            //复检
            if (checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                //查询原质检流水号
                voiceCheckResultResponse = voiceCheckResultService.queryOriginInspectionId(checkResult);
                if (voiceCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                    voiceCheckResponse.setRspcode(voiceCheckResultResponse.getRspcode());
                    voiceCheckResponse.setRspdesc(voiceCheckResultResponse.getRspdesc());
                    return voiceCheckResponse;
                }
                if (null != voiceCheckResultResponse.getData() && voiceCheckResultResponse.getData().size() > 0) {
                    originInspectionId = voiceCheckResultResponse.getData().get(0).getInspectionId();
                }
            }

            //语音质检结果
            VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
            voiceCheckResult.setTenantId(checkResult.get("tenantId").toString());
            voiceCheckResult.setCallingNumber(checkResult.get("callingNumber").toString());
            voiceCheckResult.setAcceptNumber(checkResult.get("acceptNumber").toString());
            voiceCheckResult.setInspectionId(inspectionId);
            voiceCheckResult.setOriginInspectionId(originInspectionId);
            voiceCheckResult.setTouchId(checkResult.get("touchId").toString());
            voiceCheckResult.setPlanId(checkResult.get("planId").toString());
            voiceCheckResult.setTemplateId(checkResult.get("templateId").toString());
            voiceCheckResult.setCheckModel(checkResult.get("checkModel").toString());        //默认计划内质检
            voiceCheckResult.setCheckedStaffId(checkResult.get("checkedStaffId").toString());
            voiceCheckResult.setCheckedStaffName(checkResult.get("checkedStaffName").toString());
            voiceCheckResult.setCheckedDepartId(checkResult.get("checkedDepartId").toString());
            voiceCheckResult.setCheckedDepartName(checkResult.get("checkedDepartName").toString());
            voiceCheckResult.setCheckStaffId(checkResult.get("checkStaffId").toString());
            voiceCheckResult.setCheckStaffName(checkResult.get("checkStaffName").toString());
            voiceCheckResult.setCheckDepartId(checkResult.get("checkDepartId").toString());
            voiceCheckResult.setCheckDepartName(checkResult.get("checkDepartName").toString());
            voiceCheckResult.setCheckStartTime(DateUtil.string2Date(checkStartTime));
            voiceCheckResult.setCheckEndTime(currentTime);
            voiceCheckResult.setCheckTime(Integer.parseInt(checkResult.get("checkTime").toString()));
//            voiceCheckResult.setPlayVoiceTime(0);       //放音时长，暂时不处理
//            voiceCheckResult.setPlayVoiceNum(0);        //放音次数，暂时不处理
            voiceCheckResult.setScoreType(checkResult.get("scoreType").toString());
            voiceCheckResult.setResultStatus(checkStatus);
            voiceCheckResult.setLastResultFlag("1");      //最新质检结果
            voiceCheckResult.setFinalScore(BigDecimal.valueOf(Double.parseDouble(checkResult.get("finalScore").toString())));
            voiceCheckResult.setCheckComment(checkResult.get("checkComment").toString());

            //重置之前质检的最新质检结果标志
            VoiceCheckResult result = new VoiceCheckResult();
            result.setTouchId(checkResult.get("touchId").toString());
            result.setLastResultFlag("0");
            voiceCheckResultResponse = resetLastResultFlag(result);
            if (voiceCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                voiceCheckResponse.setRspcode(voiceCheckResultResponse.getRspcode());
                voiceCheckResponse.setRspdesc(voiceCheckResultResponse.getRspdesc());
                return voiceCheckResponse;
            }

            //更新语音质检结果
            if (updateFlag) {
                voiceCheckResultResponse = updateVoiceCheckResult(voiceCheckResult);
                if (!voiceCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    voiceCheckResponse.setRspcode(voiceCheckResultResponse.getRspcode());
                    voiceCheckResponse.setRspdesc(voiceCheckResultResponse.getRspdesc());
                    return voiceCheckResponse;
                }
            } else {
                voiceCheckResultResponse = addVoiceCheckResult(voiceCheckResult);
                if (!voiceCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    voiceCheckResponse.setRspcode(voiceCheckResultResponse.getRspcode());
                    voiceCheckResponse.setRspdesc(voiceCheckResultResponse.getRspdesc());
                    return voiceCheckResponse;
                }
            }

            //更新语音质检结果详细信息
            List<VoiceCheckResultDetail> voiceCheckResultDetailList = new ArrayList<>();
            for (Map checkItem : checkItemList
            ) {
                VoiceCheckResultDetail voiceCheckResultDetail = new VoiceCheckResultDetail();
                voiceCheckResultDetail.setNodeType(checkItem.get("nodeType").toString());
                voiceCheckResultDetail.setNodeId(checkItem.get("nodeId").toString());
                voiceCheckResultDetail.setNodeName(checkItem.get("nodeName").toString());
                voiceCheckResultDetail.setTenantId(checkResult.get("tenantId").toString());
                voiceCheckResultDetail.setInspectionId(inspectionId);
                voiceCheckResultDetail.setCheckStaffId(checkResult.get("checkStaffId").toString());
                voiceCheckResultDetail.setCheckStaffName(checkResult.get("checkStaffName").toString());
                voiceCheckResultDetail.setCheckDepartId(checkResult.get("checkDepartId").toString());
                voiceCheckResultDetail.setCheckDepartName(checkResult.get("checkDepartName").toString());
                voiceCheckResultDetail.setCheckStartTime(DateUtil.string2Date(checkStartTime));
                voiceCheckResultDetail.setCheckEndTime(currentTime);
                voiceCheckResultDetail.setScoreType(checkResult.get("scoreType").toString());
                voiceCheckResultDetail.setScoreScope(Integer.parseInt(checkItem.get("scoreScope").toString()));
                voiceCheckResultDetail.setMinScore(Integer.parseInt(checkItem.get("minScore").toString()));
                voiceCheckResultDetail.setMaxScore(Integer.parseInt(checkItem.get("maxScore").toString()));
                voiceCheckResultDetail.setRealScore(BigDecimal.valueOf(Double.parseDouble(checkItem.get("realScore").toString())));

                voiceCheckResultDetailList.add(voiceCheckResultDetail);
            }
            if (updateFlag) {
                voiceCheckResultDetailResponse = updateVoiceCheckResultDetail(voiceCheckResultDetailList);
                if (!voiceCheckResultDetailResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    voiceCheckResponse.setRspcode(voiceCheckResultDetailResponse.getRspcode());
                    voiceCheckResponse.setRspdesc(voiceCheckResultDetailResponse.getRspdesc());
                    return voiceCheckResponse;
                }
            } else {
                voiceCheckResultDetailResponse = addVoiceCheckResultDetail(voiceCheckResultDetailList);
                if (!voiceCheckResultDetailResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    voiceCheckResponse.setRspcode(voiceCheckResultDetailResponse.getRspcode());
                    voiceCheckResponse.setRspdesc(voiceCheckResultDetailResponse.getRspdesc());
                    return voiceCheckResponse;
                }
            }

            //更新语音质检池（质检暂存不更新质检池）
            if (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                VoicePool voicePool = new VoicePool();
                voicePool.setTouchId(checkResult.get("touchId").toString());
                voicePool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.CHECKED));

                VoicePoolResponse voicePoolResponse = updateVoicePool(voicePool);
                if (!voicePoolResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    voiceCheckResponse.setRspcode(voicePoolResponse.getRspcode());
                    voiceCheckResponse.setRspdesc(voicePoolResponse.getRspdesc());
                    return voiceCheckResponse;
                }
            }

            voiceCheckResponse.setRspcode(WebUtil.SUCCESS);
            if (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                voiceCheckResponse.setRspdesc("提交成功");
            }
            if (checkStatus.equals(Constants.QM_CHECK_RESULT.TEMP_SAVE)) {
                voiceCheckResponse.setRspdesc("保存成功");
            }
        } catch (Exception e) {
            logger.error("语音质检异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("语音质检异常!");
        }
        voiceCheckResultServiceResponse.setResponse(voiceCheckResultResponse);
        return voiceCheckResponse;
    }

    private VoiceCheckResultResponse resetLastResultFlag(VoiceCheckResult voiceCheckResult) throws Exception {
        VoiceCheckResultResponse voiceCheckResultResponse = new VoiceCheckResultResponse();
        try {
            voiceCheckResultMapper.resetLastResultFlag(voiceCheckResult);
            voiceCheckResultResponse.setRspcode(WebUtil.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("最新质检结果标识重置异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("最新质检结果标识重置异常");
        }
        return voiceCheckResultResponse;
    }

    private VoiceCheckResultResponse updateVoiceCheckResult(VoiceCheckResult voiceCheckResult) throws Exception {
        VoiceCheckResultResponse voiceCheckResultResponse = new VoiceCheckResultResponse();
        try {
            int result = voiceCheckResultMapper.updateByPrimaryKeySelective(voiceCheckResult);
            if (result > 0) {
                voiceCheckResultResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                voiceCheckResultResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultResponse.setRspdesc("语音质检结果更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音质检结果更新异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("语音质检结果更新异常");
        }
        return voiceCheckResultResponse;
    }

    private VoiceCheckResultResponse addVoiceCheckResult(VoiceCheckResult voiceCheckResult) throws Exception {
        VoiceCheckResultResponse voiceCheckResultResponse = new VoiceCheckResultResponse();
        String resultStatus = voiceCheckResult.getResultStatus();
        try {
            int result = voiceCheckResultMapper.insertSelective(voiceCheckResult);
            if (result > 0) {
                voiceCheckResultResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                voiceCheckResultResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultResponse.setRspdesc("语音质检结果新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音质检结果新增异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("语音质检结果新增异常");
        }
        return voiceCheckResultResponse;
    }

    private VoiceCheckResultDetailResponse updateVoiceCheckResultDetail(List<VoiceCheckResultDetail> voiceCheckResultDetailList) throws Exception {
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

    private VoiceCheckResultDetailResponse addVoiceCheckResultDetail(List<VoiceCheckResultDetail> voiceCheckResultDetailList) throws Exception {
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

    private VoicePoolResponse updateVoicePool(VoicePool voicePool) throws Exception {
        VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
        try {
            int result = voicePoolMapper.updateByTouchId(voicePool);
            if (result > 0) {
                voicePoolResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                voicePoolResponse.setRspcode(WebUtil.FAIL);
                voicePoolResponse.setRspdesc("语音质检池更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音质检池更新异常", e);
            voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
            voicePoolResponse.setRspdesc("语音质检池更新异常");
        }
        return voicePoolResponse;
    }
}
