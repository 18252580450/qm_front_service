package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.service.VoiceCheckResultDetailService;
import com.asiainfo.qm.execution.service.VoicePoolService;
import com.asiainfo.qm.execution.vo.*;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.execution.service.VoiceCheckResultService;
import com.asiainfo.qm.manage.domain.VoiceCheckResult;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetail;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
            String rspCode = WebUtil.SUCCESS;
            //查询语音质检结果信息表，存在暂存数据则更新质检结果，反之插入
            voiceCheckResultResponse = voiceCheckResultService.queryVoiceCheckResult(checkResult, 0, 0);
            if (voiceCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                rspCode = WebUtil.FAIL;
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
                    rspCode = WebUtil.FAIL;
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
            if (rspCode.equals(WebUtil.SUCCESS)) {
                VoiceCheckResult result = new VoiceCheckResult();
                result.setTouchId(checkResult.get("touchId").toString());
                result.setLastResultFlag("0");
                voiceCheckResultResponse = voiceCheckResultService.resetLastResultFlag(result);
                rspCode = voiceCheckResultResponse.getRspcode();
            }

            //更新语音质检结果
            if (rspCode.equals(WebUtil.SUCCESS)) {
                if (updateFlag) {
                    voiceCheckResultResponse = voiceCheckResultService.updateVoiceCheckResult(voiceCheckResult);
                    rspCode = voiceCheckResultResponse.getRspcode();
                } else {
                    voiceCheckResultResponse = voiceCheckResultService.addVoiceCheckResult(voiceCheckResult);
                    rspCode = voiceCheckResultResponse.getRspcode();
                }
            }

            //更新语音质检结果详细信息
            if (rspCode.equals(WebUtil.SUCCESS)) {
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
                    voiceCheckResultDetailResponse = voiceCheckResultDetailService.updateVoiceCheckResultDetail(voiceCheckResultDetailList);
                    rspCode = voiceCheckResultDetailResponse.getRspcode();
                } else {
                    voiceCheckResultDetailResponse = voiceCheckResultDetailService.addVoiceCheckResultDetail(voiceCheckResultDetailList);
                    rspCode = voiceCheckResultDetailResponse.getRspcode();
                }
            }

            //更新语音质检池（质检暂存不更新质检池）
            if (rspCode.equals(WebUtil.SUCCESS) && (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK))) {
                VoicePool voicePool = new VoicePool();
                voicePool.setTouchId(checkResult.get("touchId").toString());
                voicePool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.CHECKED));

                VoicePoolResponse voicePoolResponse = voicePoolService.updateVoicePool(voicePool);
                rspCode = voicePoolResponse.getRspcode();
            }

            //质检失败
            if (!rspCode.equals(WebUtil.SUCCESS)) {
                voiceCheckResultResponse.setRspcode(WebUtil.FAIL);
                if (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                    voiceCheckResultResponse.setRspdesc("提交失败");
                }
                if (checkStatus.equals(Constants.QM_CHECK_RESULT.TEMP_SAVE)) {
                    voiceCheckResultResponse.setRspdesc("保存失败");
                }
            }
        } catch (Exception e) {
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


    @ApiOperation(value = "前端调用接口查询语音质检结果", notes = "qm_configservice查询语音质检结果", response = VoiceCheckResultServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryVoiceCheckResult", threadPoolKey = "queryVoiceCheckResultThread", fallbackMethod = "fallbackQueryVoiceCheckResult", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryVoiceCheckResult", method = RequestMethod.GET)
    public VoiceCheckResultServiceResponse queryVoiceCheckResult(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        VoiceCheckResultResponse voiceCheckResultResponse = new VoiceCheckResultResponse();
        VoiceCheckResultServiceResponse voiceCheckResultServiceResponse = new VoiceCheckResultServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            voiceCheckResultResponse = voiceCheckResultService.queryVoiceCheckResult(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("语音质检结果数据查询异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("语音质检结果数据查询异常!");
        }
        voiceCheckResultServiceResponse.setResponse(voiceCheckResultResponse);
        return voiceCheckResultServiceResponse;
    }

    public VoiceCheckResultServiceResponse fallbackQueryVoiceCheckResult(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("语音质检结果数据查询出错啦！");
        logger.error("");
        return new VoiceCheckResultServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询语音质检结果详情", notes = "qm_configservice查询语音质检结果详情", response = VoiceCheckResultDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryVoiceCheckResultDetail", threadPoolKey = "queryVoiceCheckResultDetailThread", fallbackMethod = "fallbackQueryVoiceCheckResultDetail", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryVoiceCheckResultDetail", method = RequestMethod.GET)
    public VoiceCheckResultDetailServiceResponse queryVoiceCheckResultDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        VoiceCheckResultDetailResponse voiceCheckResultDetailResponse = new VoiceCheckResultDetailResponse();
        VoiceCheckResultDetailServiceResponse voiceCheckResultDetailServiceResponse = new VoiceCheckResultDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            voiceCheckResultDetailResponse = voiceCheckResultDetailService.queryVoiceCheckResultDetail(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("语音质检结果详情数据查询异常", e);
            voiceCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultDetailResponse.setRspdesc("语音质检结果详情数据查询异常!");
        }
        voiceCheckResultDetailServiceResponse.setResponse(voiceCheckResultDetailResponse);
        return voiceCheckResultDetailServiceResponse;
    }

    public VoiceCheckResultDetailServiceResponse fallbackQueryVoiceCheckResultDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("语音质检结果详情数据查询出错啦！");
        logger.error("");
        return new VoiceCheckResultDetailServiceResponse();
    }
}
