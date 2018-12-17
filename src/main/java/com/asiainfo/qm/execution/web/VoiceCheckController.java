package com.asiainfo.qm.execution.web;

import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.service.VoiceCheckResultDetailService;
import com.asiainfo.qm.execution.service.VoicePoolService;
import com.asiainfo.qm.execution.vo.VoiceCheckResultDetailResponse;
import com.asiainfo.qm.execution.vo.VoicePoolResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.execution.service.VoiceCheckResultService;
import com.asiainfo.qm.manage.domain.VoiceCheckResult;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetail;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.execution.vo.VoiceCheckResultResponse;
import com.asiainfo.qm.execution.vo.VoiceCheckResultServiceResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 17:12
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/voiceCheck/")
public class VoiceCheckController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(VoiceCheckController.class);

    @Autowired
    private VoiceCheckResultService voiceCheckResultService;
    @Autowired
    private VoiceCheckResultDetailService voiceCheckResultDetailService;
    @Autowired
    private VoicePoolService voicePoolService;

    @Autowired
    private SequenceUtils sequenceUtils;

    @ApiOperation(value = "前端调用接口进行语音质检", notes = "qm_configservice语音质检", response = VoiceCheckResultServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice", commandKey = "voiceCheck", threadPoolKey = "voiceCheckThread", fallbackMethod = "fallbackVoiceCheck", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public VoiceCheckResultServiceResponse voiceCheck(@RequestBody Map<String, Object> reqMap) throws Exception {
        VoiceCheckResultResponse voiceCheckResultResponse = new VoiceCheckResultResponse();
        VoiceCheckResultDetailResponse voiceCheckResultDetailResponse = new VoiceCheckResultDetailResponse();
        VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
        VoiceCheckResultServiceResponse voiceCheckResultServiceResponse = new VoiceCheckResultServiceResponse();
        @SuppressWarnings("unchecked")
        Map<String, Object> checkResult = (Map<String, Object>) reqMap.get("voiceCheckResult");
        @SuppressWarnings("unchecked")
        List<Map> checkItemList = (ArrayList<Map>) reqMap.get("checkItemList");
        Date currentTime = DateUtil.getCurrontTime();
        try {
            //更新语音质检结果信息表
            VoiceCheckResult voiceCheckResult = new VoiceCheckResult();

            voiceCheckResult.setTenantId(checkResult.get("tenantId").toString());
            voiceCheckResult.setCallingNumber(checkResult.get("callingNumber").toString());
            voiceCheckResult.setAcceptNumber(checkResult.get("acceptNumber").toString());
            voiceCheckResult.setInspectionId(checkResult.get("inspectionId").toString());
            voiceCheckResult.setOriginInspectionId(checkResult.get("originInspectionId").toString());
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
            voiceCheckResult.setCheckStartTime(DateUtil.string2Date(checkResult.get("checkStartTime").toString()));
            voiceCheckResult.setCheckEndTime(currentTime);
            voiceCheckResult.setCheckTime(Integer.parseInt(checkResult.get("checkTime").toString()));
//            voiceCheckResult.setPlayVoiceTime(0);       //放音时长，暂时不处理
//            voiceCheckResult.setPlayVoiceNum(0);        //放音次数，暂时不处理
            voiceCheckResult.setScoreType(checkResult.get("scoreType").toString());
            voiceCheckResult.setResultStatus(checkResult.get("resultStatus").toString());
            voiceCheckResult.setLastResultFlag("1");      //最新质检结果
            voiceCheckResult.setFinalScore(BigDecimal.valueOf(Double.parseDouble(checkResult.get("finalScore").toString())));
            voiceCheckResult.setCheckComment(checkResult.get("checkComment").toString());

            voiceCheckResultResponse = voiceCheckResultService.addVoiceCheckResult(voiceCheckResult);

            //更新语音质检结果详细信息表
            if (voiceCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                List<VoiceCheckResultDetail> voiceCheckResultDetailList = new ArrayList<>();
                for (Map checkItem : checkItemList
                ) {
                    VoiceCheckResultDetail voiceCheckResultDetail = new VoiceCheckResultDetail();

                    voiceCheckResultDetail.setNodeType(checkItem.get("nodeType").toString());
                    voiceCheckResultDetail.setNodeId(checkItem.get("nodeId").toString());
                    voiceCheckResultDetail.setNodeName(checkItem.get("nodeName").toString());
                    voiceCheckResultDetail.setTenantId(checkResult.get("tenantId").toString());
                    voiceCheckResultDetail.setInspectionId(checkResult.get("inspectionId").toString());
                    voiceCheckResultDetail.setCheckStaffId(checkResult.get("checkStaffId").toString());
                    voiceCheckResultDetail.setCheckStaffName(checkResult.get("checkStaffName").toString());
                    voiceCheckResultDetail.setCheckDepartId(checkResult.get("checkDepartId").toString());
                    voiceCheckResultDetail.setCheckDepartName(checkResult.get("checkDepartName").toString());
                    voiceCheckResultDetail.setCheckStartTime(DateUtil.string2Date(checkResult.get("checkStartTime").toString()));
                    voiceCheckResultDetail.setCheckEndTime(currentTime);
                    voiceCheckResultDetail.setScoreType(checkResult.get("scoreType").toString());
                    voiceCheckResultDetail.setScoreScope(Integer.parseInt(checkItem.get("scoreScope").toString()));
                    voiceCheckResultDetail.setMinScore(Integer.parseInt(checkItem.get("minScore").toString()));
                    voiceCheckResultDetail.setMaxScore(Integer.parseInt(checkItem.get("maxScore").toString()));
                    voiceCheckResultDetail.setRealScore(BigDecimal.valueOf(Double.parseDouble(checkItem.get("realScore").toString())));
//                    voiceCheckResultDetail.setCheckComment(checkResult.get("checkComment").toString());  //具体考评项暂不作评语

                    voiceCheckResultDetailList.add(voiceCheckResultDetail);
                }
                voiceCheckResultDetailResponse = voiceCheckResultDetailService.addVoiceCheckResultDetail(voiceCheckResultDetailList);
                if (voiceCheckResultDetailResponse.getRspcode().equals(WebUtil.FAIL)) {
                    voiceCheckResultResponse.setRspcode(WebUtil.FAIL);
                    voiceCheckResultResponse.setRspdesc("质检详细信息更新失败");
                }

                //更新语音质检池
                if (voiceCheckResultDetailResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    VoicePool voicePool = new VoicePool();
                    voicePool.setInspectionId(checkResult.get("inspectionId").toString());
                    voicePool.setReserve1(Constants.QM_CHECK_RESULT.CHECKED);

                    voicePoolResponse = voicePoolService.updateVoicePool(voicePool);
                    if (voicePoolResponse.getRspcode().equals(WebUtil.FAIL)) {
                        voiceCheckResultResponse.setRspcode(WebUtil.FAIL);
                        voiceCheckResultResponse.setRspdesc("质检池更新失败");
                    }
                }
            }
        } catch (
                Exception e) {
            logger.error("语音质检异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("语音质检异常!");
        }
        voiceCheckResultServiceResponse.setResponse(voiceCheckResultResponse);
        return voiceCheckResultServiceResponse;
    }

    public VoiceCheckResultServiceResponse fallbackVoiceCheck(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("语音质检出错啦！");
        logger.error("");
        return new VoiceCheckResultServiceResponse();
    }
}
