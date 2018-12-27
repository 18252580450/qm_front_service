package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.dao.AppealDealMapper;
import com.asiainfo.qm.execution.domain.*;
import com.asiainfo.qm.execution.service.*;
import com.asiainfo.qm.execution.vo.*;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.AppealNode;
import com.asiainfo.qm.manage.domain.AppealProcess;
import com.asiainfo.qm.manage.domain.OrderCheckResult;
import com.asiainfo.qm.manage.domain.VoiceCheckResult;
import com.asiainfo.qm.manage.service.AppealNodeService;
import com.asiainfo.qm.manage.service.AppealProcessService;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.AppealNodeResponse;
import com.asiainfo.qm.manage.vo.AppealProcessResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-21 15:08
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/appealDeal/")
public class AppealDealController {

    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(AppealDealController.class);

    @Autowired
    private AppealProcessService appealProcessService;
    @Autowired
    private AppealNodeService appealNodeService;
    @Autowired
    private AppealDealService appealDealService;
    @Autowired
    private AppealDealRecordService appealDealRecordService;
    @Autowired
    private VoiceCheckResultService voiceCheckResultService;
    @Autowired
    private OrderCheckResultService orderCheckResultService;
    @Autowired
    private VoicePoolService voicePoolService;
    @Autowired
    private WorkformPoolService workformPoolService;
    @Autowired
    private AppealDealMapper appealDealMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @ApiOperation(value = "前端调用接口提交申诉", notes = "qm_configservice提交申诉", response = AppealDealServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "createAppealDeal", threadPoolKey = "createAppealDealThread", fallbackMethod = "fallbackCreateAppealDeal", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public AppealDealServiceResponse createAppealDeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        AppealDealServiceResponse appealDealServiceResponse = new AppealDealServiceResponse();
        //申诉流水号
        String appealId = String.valueOf(sequenceUtils.getSequence("t_qm_appeal_process"));
        String departmentId = reqMap.get("departmentId").toString();
        String mainProcessId = "";      //主流程编码
        String currentProcessId = "";   //当前子流程编码
        int currentNodeId = 0;          //当前子节点编码
        String currentNodeName = "";    //当前子节点名称
        String nextProcessId = "";      //下一子流程编码
        int nextNodeId = 0;             //下一子节点编码
        Date currentTime = DateUtil.getCurrontTime();
        try {
            String rspCode = WebUtil.SUCCESS;
            //根据申诉人部门id绑定申诉流程
            Map<String, String> mainProcessParams = new HashMap<String, String>();
            mainProcessParams.put("departmentId", departmentId);
            mainProcessParams.put("mainProcessFlag", "0");
            mainProcessParams.put("processStatus", Constants.QM_APPEAL_PROCESS_STATUS.ENABLE);
            //查询主流程
            AppealProcessResponse appealProcessResponse = appealProcessService.queryAppealProcess(mainProcessParams, 0, 0);
            if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                rspCode = WebUtil.FAIL;
            }
            if (null != appealProcessResponse.getData() && appealProcessResponse.getData().size() > 0) {
                int processNum = 1;  //主流程的子流程数
                //主流程ID
                mainProcessId = appealProcessResponse.getData().get(0).getProcessId();
                processNum = appealProcessResponse.getData().get(0).getSubProcessNum();
                //查询最大申诉次数
                int maxAppealNum = appealProcessResponse.getData().get(0).getMaxAppealNum();
                int appealNum = 0;  //已申诉次数
                //根据接触流水查询已申诉次数（非质检流水，每次申诉之后重新质检时质检流水号会变化）
                AppealDealExample example = new AppealDealExample();
                AppealDealExample.Criteria criteria = example.createCriteria();
                criteria.andTouchIdEqualTo((String) reqMap.get("touchId"));
                appealNum = appealDealMapper.countByExample(example);
                if (appealNum >= maxAppealNum) {
                    rspCode = WebUtil.FAIL;
                    appealDealResponse.setRspcode(rspCode);
                    appealDealResponse.setRspdesc("超过最大申诉次数！");
                } else {
                    //查询子流程
                    Map<String, String> subProcessParams = new HashMap<String, String>();
                    subProcessParams.put("parentProcessId", mainProcessId);
                    appealProcessResponse = appealProcessService.queryAppealProcess(subProcessParams, 0, 0);
                    if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        rspCode = WebUtil.FAIL;
                    }
                    if (null != appealProcessResponse.getData() && appealProcessResponse.getData().size() > 0) {
                        int nodeNum = 1;   //第一子流程的节点数
                        for (AppealProcess appealProcess : appealProcessResponse.getData()
                        ) {
                            if (appealProcess.getOrderNo() == 1) {
                                //当前子流程ID
                                currentProcessId = appealProcess.getProcessId();
                                nodeNum = appealProcess.getSubNodeNum();
                                break;
                            }
                        }

                        if (nodeNum > 1) {   //第一流程有多个子节点时，下一子流程编码为当前子流程编码
                            nextProcessId = currentProcessId;
                        } else {
                            if (processNum > 1) {  //主流程有多个子流程，且第一子流程只有一个节点
                                for (AppealProcess appealProcess : appealProcessResponse.getData()
                                ) {
                                    if (appealProcess.getOrderNo() == 2) {
                                        //下一子流程ID
                                        nextProcessId = appealProcess.getProcessId();
                                        break;
                                    }
                                }
                            } else {  //主流程只有一个子流程，且只有一个节点的情况
                                nextProcessId = currentProcessId;
                            }
                        }

                        //查询子节点
                        Map<String, String> nodeParams = new HashMap<String, String>();
                        nodeParams.put("processId", currentProcessId);
                        AppealNodeResponse appealNodeResponse = appealNodeService.queryAppealNode(nodeParams, 0, 0);
                        if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                            rspCode = WebUtil.FAIL;
                        }
                        if (null != appealNodeResponse.getData() && appealNodeResponse.getData().size() > 0) {
                            for (AppealNode appealNode : appealNodeResponse.getData()
                            ) {
                                if (appealNode.getOrderNo() == 1) {
                                    //当前子节点ID
                                    currentNodeId = appealNode.getNodeId();
                                    currentNodeName = appealNode.getNodeName();
                                    break;
                                }
                            }
                            if (nodeNum > 1) {   //第一流程有多个子节点当情况
                                for (AppealNode appealNode : appealNodeResponse.getData()
                                ) {
                                    if (appealNode.getOrderNo() == 2) {
                                        //下一子节点ID
                                        nextNodeId = appealNode.getNodeId();
                                        break;
                                    }
                                }
                            } else {
                                if (processNum > 1) {    //主流程有多个子流程，且第一子流程只有一个节点
                                    nodeParams.put("processId", nextProcessId);
                                    appealNodeResponse = appealNodeService.queryAppealNode(nodeParams, 0, 0);
                                    if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                                        rspCode = WebUtil.FAIL;
                                    }
                                    if (null != appealNodeResponse.getData() && appealNodeResponse.getData().size() > 0) {
                                        for (AppealNode appealNode : appealNodeResponse.getData()
                                        ) {
                                            if (appealNode.getOrderNo() == 1) {
                                                //下一子节点ID
                                                nextNodeId = appealNode.getNodeId();
                                                break;
                                            }
                                        }
                                    }
                                } else {  //主流程只有一个子流程，且只有一个节点的情况
                                    nextNodeId = currentNodeId;
                                }
                            }
                        }
                    }
                }
            }

            //新增申诉数据
            if (rspCode.equals(WebUtil.SUCCESS)) {
                AppealDeal appealDeal = new AppealDeal();
                appealDeal.setCheckType(reqMap.get("checkType").toString());
                appealDeal.setTouchId(reqMap.get("touchId").toString());
                appealDeal.setInspectionId(reqMap.get("inspectionId").toString());
                appealDeal.setAppealId(appealId);
                appealDeal.setAppealStaffId(reqMap.get("appealStaffId").toString());
                appealDeal.setAppealStaffName(reqMap.get("appealStaffName").toString());
                appealDeal.setAppealReason(reqMap.get("appealReason").toString());
                appealDeal.setAppealTime(currentTime);
                appealDeal.setAppealStatus(Constants.QM_APPEAL_STATUS.APPEALING);
                appealDeal.setMainProcessId(mainProcessId);
                appealDeal.setCurrentProcessId(currentProcessId);
                appealDeal.setCurrentNodeId(currentNodeId);
                appealDeal.setCurrentNodeName(currentNodeName);
                appealDeal.setNextProcessId(nextProcessId);
                appealDeal.setNextNodeId(nextNodeId);

                appealDealResponse = appealDealService.createAppeal(appealDeal);
                rspCode = appealDealResponse.getRspcode();
            }

            //更新质检结果（申诉信息、质检状态）
            if (rspCode.equals(WebUtil.SUCCESS)) {
                if (Constants.QM_CHECK_TYPE.VOICE.equals(reqMap.get("checkType").toString())) {
                    VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
                    voiceCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                    voiceCheckResult.setAppealId(appealId);
                    voiceCheckResult.setAppealNum(1);
                    voiceCheckResult.setAppealTime(currentTime);
                    voiceCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEALING);

                    VoiceCheckResultResponse voiceCheckResultResponse = voiceCheckResultService.updateAppealInfo(voiceCheckResult);
                    rspCode = voiceCheckResultResponse.getRspcode();
                }
                if (Constants.QM_CHECK_TYPE.ORDER.equals(reqMap.get("checkType").toString())) {
                    OrderCheckResult orderCheckResult = new OrderCheckResult();
                    orderCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                    orderCheckResult.setAppealId(appealId);
                    orderCheckResult.setAppealNum(1);
                    orderCheckResult.setAppealTime(currentTime);
                    orderCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEALING);

                    OrderCheckResultResponse orderCheckResultResponse = orderCheckResultService.updateAppealInfo(orderCheckResult);
                    rspCode = orderCheckResultResponse.getRspcode();
                }
                if (!rspCode.equals(WebUtil.SUCCESS)) {
                    appealDealResponse.setRspcode(WebUtil.FAIL);
                    appealDealResponse.setRspdesc("质检结果申诉信息更新异常");
                }
            }
        } catch (Exception e) {
            logger.error("申诉提交异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉提交异常!");
        }
        appealDealServiceResponse.setResponse(appealDealResponse);
        return appealDealServiceResponse;
    }

    public AppealDealServiceResponse fallbackCreateAppealDeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("申诉提交出错啦！");
        logger.error("");
        return new AppealDealServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询申诉待办", notes = "qm_configservice查询申诉待办", response = AppealDealServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryAppealDeal", threadPoolKey = "queryAppealDealThread", fallbackMethod = "fallbackQueryAppealDeal", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryAppealDeal", method = RequestMethod.GET)
    public AppealDealServiceResponse queryAppealDeal(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        AppealDealServiceResponse appealDealServiceResponse = new AppealDealServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            appealDealResponse = appealDealService.queryAppeal(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("申诉待办数据查询异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉待办数据查询异常!");
        }
        appealDealServiceResponse.setResponse(appealDealResponse);
        return appealDealServiceResponse;
    }

    public AppealDealServiceResponse fallbackQueryAppealDeal(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("申诉待办数据查询出错啦！");
        logger.error("");
        return new AppealDealServiceResponse();
    }

    @ApiOperation(value = "前端调用接口处理申诉", notes = "qm_configservice处理申诉", response = AppealDealServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "dealAppeal", threadPoolKey = "dealAppealThread", fallbackMethod = "fallbackCreateAppealDeal", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public AppealDealServiceResponse dealAppeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        AppealDealServiceResponse appealDealServiceResponse = new AppealDealServiceResponse();
        String approveStatus = reqMap.get("approveStatus").toString();                  //审批状态（0通过1驳回）
        String appealId = reqMap.get("appealId").toString();                            //申诉流水号
        String preProcessId = reqMap.get("currentProcessId").toString();                //上一子流程编码
        String preProcessName = "";                                                     //上一子流程名称
        int preNodeId = Integer.parseInt(reqMap.get("currentNodeId").toString());       //上一子节点编码
        String preNodeName = reqMap.get("currentNodeName").toString();                  //上一子节点名称
        String currentProcessId = reqMap.get("nextProcessId").toString();               //当前子流程编码
        int currentNodeId = Integer.parseInt(reqMap.get("nextNodeId").toString());      //当前子节点编码
        String currentNodeName = "";                                                    //当前子节点名称
        String nextProcessId = "";                                                      //下一子流程编码
        int nextNodeId = 0;                                                             //下一子节点编码
        Date currentTime = DateUtil.getCurrontTime();
        try {
            String rspCode = WebUtil.SUCCESS;
            if (preProcessId.equals(currentProcessId) && preNodeId == currentNodeId) {  //申诉末节点
                //更新申诉流程状态
                AppealDeal appealDeal = new AppealDeal();
                appealDeal.setAppealId(appealId);
                if (approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                    appealDeal.setAppealStatus(Constants.QM_APPEAL_STATUS.PASS);
                } else {
                    appealDeal.setAppealStatus(Constants.QM_APPEAL_STATUS.REJECT);
                }
                appealDealResponse = appealDealService.updateAppeal(appealDeal);
                rspCode = appealDealResponse.getRspcode();

                //新增审批记录
                if (rspCode.equals(WebUtil.SUCCESS)) {
                    //查询当前子流程名称
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("processId", preProcessId);
                    AppealProcessResponse appealProcessResponse = appealProcessService.queryAppealProcess(params, 0, 0);
                    if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        rspCode = WebUtil.FAIL;
                    }
                    if (null != appealProcessResponse.getData() && appealProcessResponse.getData().size() > 0) {
                        String currentProcessName = appealProcessResponse.getData().get(0).getProcessName();
                        AppealDealRecord appealDealRecord = new AppealDealRecord();
                        appealDealRecord.setCheckType(reqMap.get("checkType").toString());
                        appealDealRecord.setTouchId(reqMap.get("touchId").toString());
                        appealDealRecord.setInspectionId(reqMap.get("inspectionId").toString());
                        appealDealRecord.setAppealId(appealId);
                        appealDealRecord.setProcessId(preProcessId);
                        appealDealRecord.setProcessName(currentProcessName);
                        appealDealRecord.setNodeId(preNodeId);
                        appealDealRecord.setNodeName(preNodeName);
                        appealDealRecord.setApproveStaffId(reqMap.get("staffId").toString());
                        appealDealRecord.setApproveStaffName(reqMap.get("staffName").toString());
                        appealDealRecord.setApproveTime(currentTime);
                        appealDealRecord.setApproveStatus(approveStatus);
                        appealDealRecord.setApproveSuggestion(reqMap.get("approveSuggestion").toString());

                        AppealDealRecordResponse appealDealRecordResponse = appealDealRecordService.createAppealRecord(appealDealRecord);
                        rspCode = appealDealRecordResponse.getRspcode();
                    }
                }

                //更新质检结果（质检状态）
                if (rspCode.equals(WebUtil.SUCCESS)) {
                    if (Constants.QM_CHECK_TYPE.VOICE.equals(reqMap.get("checkType").toString())) {
                        VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
                        voiceCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                        if (approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                            voiceCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_PASS);
                        } else {
                            voiceCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_DENY);
                        }

                        VoiceCheckResultResponse voiceCheckResultResponse = voiceCheckResultService.updateAppealInfo(voiceCheckResult);
                        rspCode = voiceCheckResultResponse.getRspcode();
                    }
                    if (Constants.QM_CHECK_TYPE.ORDER.equals(reqMap.get("checkType").toString())) {
                        OrderCheckResult orderCheckResult = new OrderCheckResult();
                        orderCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                        if (approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                            orderCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_PASS);
                        } else {
                            orderCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_DENY);
                        }

                        OrderCheckResultResponse orderCheckResultResponse = orderCheckResultService.updateAppealInfo(orderCheckResult);
                        rspCode = orderCheckResultResponse.getRspcode();
                    }
                    if (!rspCode.equals(WebUtil.SUCCESS)) {
                        appealDealResponse.setRspcode(WebUtil.FAIL);
                        appealDealResponse.setRspdesc("质检结果申诉信息更新异常");
                    }
                }
                //更新质检池状态（申诉通过重新质检）
                if (rspCode.equals(WebUtil.SUCCESS) && approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                    //更新语音质检池
                    if (Constants.QM_CHECK_TYPE.VOICE.equals(reqMap.get("checkType").toString())) {
                        VoicePool voicePool = new VoicePool();
                        voicePool.setTouchId(reqMap.get("touchId").toString());
                        voicePool.setCheckStaffId(null);
                        voicePool.setCheckStaffName(null);
                        voicePool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.RECHECKING));  //待复检
                        voicePool.setIsOperate(Constants.QM_DISTRIBUTE_STATUS.NO);   //待分配
                        voicePool.setOperateTime(null);

                        VoicePoolResponse voicePoolResponse = voicePoolService.recheckUpdate(voicePool);
                        rspCode = voicePoolResponse.getRspcode();
                    }
                    //更新工单质检池
                    if (Constants.QM_CHECK_TYPE.ORDER.equals(reqMap.get("checkType").toString())) {
                        WorkformPool workformPool = new WorkformPool();
                        workformPool.setWrkfmId(Long.parseLong(reqMap.get("touchId").toString()));
                        workformPool.setCheckStaffId(null);
                        workformPool.setCheckStaffName(null);
                        workformPool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.RECHECKING));   //待复检
                        workformPool.setIsOperate(Constants.QM_DISTRIBUTE_STATUS.NO);  //待分配
                        workformPool.setOperateTime(null);

                        WorkformPoolResponse workformPoolResponse = workformPoolService.recheckUpdate(workformPool);
                        rspCode = workformPoolResponse.getRspcode();
                    }
                }
            } else {  //非末子节点
                int processNum = 1;             //子流程数
                int currentProcessOrderNo = 1;  //当前流程序号
                int currentProcessNodeNum = 1;  //当前流程子节点数
                int currentNodeOrderNo = 1;     //当前节点序号
                //查询所有子流程
                Map<String, String> mainProcessParams = new HashMap<String, String>();
                mainProcessParams.put("parentProcessId", reqMap.get("mainProcessId").toString());
                mainProcessParams.put("mainProcessFlag", Constants.QM_APPEAL_PROCESS_TYPE.SUB);
                AppealProcessResponse appealProcessResponse = appealProcessService.queryAppealProcess(mainProcessParams, 0, 0);
                if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    rspCode = WebUtil.FAIL;
                }
                if (null != appealProcessResponse.getData() && appealProcessResponse.getData().size() > 0) {
                    List<AppealProcess> appealProcesses = appealProcessResponse.getData();
                    processNum = appealProcessResponse.getData().size();  //子流程数

                    for (AppealProcess appealProcess : appealProcesses
                    ) {
                        if (appealProcess.getProcessId().equals(currentProcessId)) {
                            currentProcessOrderNo = appealProcess.getOrderNo();   //当前流程序号
                        }
                        if (appealProcess.getProcessId().equals(preProcessId)) {
                            preProcessName = appealProcess.getProcessName();      //上一流程名称
                        }
                    }
                    //查询当前流程的子节点
                    Map<String, String> nodeParams = new HashMap<String, String>();
                    nodeParams.put("processId", currentProcessId);
                    AppealNodeResponse appealNodeResponse = appealNodeService.queryAppealNode(nodeParams, 0, 0);
                    if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        rspCode = WebUtil.FAIL;
                    }
                    if (null != appealNodeResponse.getData() && appealNodeResponse.getData().size() > 0) {
                        List<AppealNode> appealNodes = appealNodeResponse.getData();
                        currentProcessNodeNum = appealNodeResponse.getData().size();  //当前流程子节点数

                        for (AppealNode appealNode : appealNodes
                        ) {
                            if (appealNode.getNodeId() == currentNodeId) {
                                currentNodeOrderNo = appealNode.getOrderNo();  //当前节点序号
                                currentNodeName = appealNode.getNodeName();    //当前节点名称
                                break;
                            }
                        }
                        //当前流程为最后一个流程
                        if (currentProcessOrderNo == processNum) {
                            nextProcessId = currentProcessId;
                            if (currentNodeOrderNo == currentProcessNodeNum) {  //当前节点为最后一个节点
                                nextNodeId = currentNodeId;
                            } else {   //当前节点为中间节点
                                nextNodeId = currentNodeId + 1;
                            }
                        } else {  //当前流程为中间流程
                            if (currentNodeOrderNo == currentProcessNodeNum) {  //当前节点为最后一个节点
                                nextNodeId = 1;
                                for (AppealProcess appealProcess : appealProcesses
                                ) {
                                    if (appealProcess.getOrderNo() == currentProcessOrderNo + 1) {
                                        nextProcessId = appealProcess.getProcessId();
                                    }
                                }
                            } else {  //当前节点为中间节点
                                nextProcessId = currentProcessId;
                                nextNodeId = currentNodeId + 1;
                            }
                        }
                    }
                }

                //更新申诉流程状态
                if (rspCode.equals(WebUtil.SUCCESS)) {
                    AppealDeal appealDeal = new AppealDeal();
                    appealDeal.setAppealId(appealId);
                    appealDeal.setAppealStatus(approveStatus);
                    appealDeal.setPreNodeDealStaffId(reqMap.get("staffId").toString());
                    appealDeal.setPreProcessId(preProcessId);
                    appealDeal.setPreNodeId(preNodeId);
                    appealDeal.setCurrentProcessId(currentProcessId);
                    appealDeal.setCurrentNodeId(currentNodeId);
                    appealDeal.setCurrentNodeName(currentNodeName);
                    appealDeal.setNextProcessId(nextProcessId);
                    appealDeal.setNextNodeId(nextNodeId);

                    appealDealResponse = appealDealService.updateAppeal(appealDeal);
                    rspCode = appealDealResponse.getRspcode();
                }

                //驳回则更新质检结果（申诉状态）
                if (rspCode.equals(WebUtil.SUCCESS)) {
                    if (Constants.QM_CHECK_TYPE.VOICE.equals(reqMap.get("checkType").toString())) {
                        VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
                        voiceCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                        if (approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                            voiceCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_PASS);
                        } else {
                            voiceCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_DENY);
                        }

                        VoiceCheckResultResponse voiceCheckResultResponse = voiceCheckResultService.updateAppealInfo(voiceCheckResult);
                        rspCode = voiceCheckResultResponse.getRspcode();
                    }
                    if (Constants.QM_CHECK_TYPE.ORDER.equals(reqMap.get("checkType").toString())) {
                        OrderCheckResult orderCheckResult = new OrderCheckResult();
                        orderCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                        if (approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                            orderCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_PASS);
                        } else {
                            orderCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_DENY);
                        }

                        OrderCheckResultResponse orderCheckResultResponse = orderCheckResultService.updateAppealInfo(orderCheckResult);
                        rspCode = orderCheckResultResponse.getRspcode();
                    }
                    if (!rspCode.equals(WebUtil.SUCCESS)) {
                        appealDealResponse.setRspcode(WebUtil.FAIL);
                        appealDealResponse.setRspdesc("质检结果申诉信息更新异常");
                    }
                }

                //新增审批记录
                if (rspCode.equals(WebUtil.SUCCESS)) {
                    AppealDealRecord appealDealRecord = new AppealDealRecord();
                    appealDealRecord.setCheckType(reqMap.get("checkType").toString());
                    appealDealRecord.setTouchId(reqMap.get("touchId").toString());
                    appealDealRecord.setInspectionId(reqMap.get("inspectionId").toString());
                    appealDealRecord.setAppealId(appealId);
                    appealDealRecord.setProcessId(preProcessId);
                    appealDealRecord.setProcessName(preProcessName);
                    appealDealRecord.setNodeId(preNodeId);
                    appealDealRecord.setNodeName(preNodeName);
                    appealDealRecord.setApproveStaffId(reqMap.get("staffId").toString());
                    appealDealRecord.setApproveStaffName(reqMap.get("staffName").toString());
                    appealDealRecord.setApproveTime(currentTime);
                    appealDealRecord.setApproveStatus(approveStatus);
                    appealDealRecord.setApproveSuggestion(reqMap.get("approveSuggestion").toString());

                    AppealDealRecordResponse appealDealRecordResponse = appealDealRecordService.createAppealRecord(appealDealRecord);
                    rspCode = appealDealRecordResponse.getRspcode();
                }
            }
            if (!rspCode.equals(WebUtil.SUCCESS)) {
                appealDealResponse.setRspcode(WebUtil.FAIL);
                appealDealResponse.setRspdesc("审批异常!");
            }
        } catch (Exception e) {
            logger.error("审批异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("审批异常!");
        }
        appealDealServiceResponse.setResponse(appealDealResponse);
        return appealDealServiceResponse;
    }

    public AppealDealServiceResponse fallbackDealAppeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("审批出错啦！");
        logger.error("");
        return new AppealDealServiceResponse();
    }
}
