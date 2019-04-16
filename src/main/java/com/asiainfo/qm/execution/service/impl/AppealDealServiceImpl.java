package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.AppealDealMapper;
import com.asiainfo.qm.execution.dao.AppealDealRecordMapper;
import com.asiainfo.qm.execution.dao.VoicePoolMapper;
import com.asiainfo.qm.execution.dao.WorkformPoolMapper;
import com.asiainfo.qm.execution.domain.*;
import com.asiainfo.qm.execution.service.AppealDealService;
import com.asiainfo.qm.execution.vo.*;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.OrderCheckResultMapper;
import com.asiainfo.qm.manage.dao.VoiceCheckResultMapper;
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
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-21 14:23
 * @ Description：${description}
 */
@Service
public class AppealDealServiceImpl implements AppealDealService {

    private static Logger logger = LoggerFactory.getLogger(AppealDealServiceImpl.class);

    @Autowired
    private AppealDealMapper appealDealMapper;
    @Autowired
    private AppealDealRecordMapper appealDealRecordMapper;
    @Autowired
    private VoiceCheckResultMapper voiceCheckResultMapper;
    @Autowired
    private OrderCheckResultMapper orderCheckResultMapper;
    @Autowired
    private WorkformPoolMapper workformPoolMapper;
    @Autowired
    private VoicePoolMapper voicePoolMapper;
    @Autowired
    private AppealProcessService appealProcessService;
    @Autowired
    private AppealNodeService appealNodeService;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public AppealDealResponse submitAppeal(Map<String, Object> reqMap) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        appealDealResponse.setRspcode(WebUtil.FAIL);
        //申诉流水号
        String departmentId = "";
        String appealId = String.valueOf(sequenceUtils.getSequence("t_qm_appeal_process"));
        if (null != reqMap.get("departmentId") && !"".equals(reqMap.get("departmentId"))) {
            departmentId = reqMap.get("departmentId").toString();
        } else {
            appealDealResponse.setRspdesc("无法获取申诉人部门信息！");
            return appealDealResponse;
        }
        String mainProcessId = "";      //主流程编码
        String currentProcessId = "";   //当前子流程编码
        int currentNodeId = 0;          //当前子节点编码
        String currentNodeName = "";    //当前子节点名称
        String nextProcessId = "";      //下一子流程编码
        int nextNodeId = 0;             //下一子节点编码
        Date currentTime = DateUtil.getCurrontTime();
        try {
            //根据申诉人部门id绑定申诉流程
            Map<String, String> mainProcessParams = new HashMap<String, String>();
            mainProcessParams.put("departmentId", departmentId);
            mainProcessParams.put("mainProcessFlag", "0");
            mainProcessParams.put("checkType", reqMap.get("checkType").toString());
            mainProcessParams.put("processStatus", Constants.QM_APPEAL_PROCESS_STATUS.ENABLE);
            //查询主流程
            AppealProcessResponse appealProcessResponse = appealProcessService.queryAppealProcess(mainProcessParams, 0, 0);
            if (appealProcessResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                appealDealResponse.setRspdesc("申诉流程查询异常！");
                return appealDealResponse;
            }
            if (appealProcessResponse.getRspcode().equals(WebUtil.FAIL)) {
                appealDealResponse.setRspdesc("请联系管理员添加申诉流程！");
                return appealDealResponse;
            }
            if (null != appealProcessResponse.getData() && appealProcessResponse.getData().size() > 0) {
                int processNum = 1;  //主流程的子流程数
                //主流程ID
                mainProcessId = appealProcessResponse.getData().get(0).getProcessId();
                processNum = appealProcessResponse.getData().get(0).getSubProcessNum();
                //查询最大申诉次数
                int maxAppealNum = appealProcessResponse.getData().get(0).getMaxAppealNum();
                int appealNum = 0;  //已申诉次数
                //根据接触流水查询已申诉次数
                AppealDealExample example = new AppealDealExample();
                AppealDealExample.Criteria criteria = example.createCriteria();
                criteria.andCheckTypeEqualTo((String) reqMap.get("checkType"));
                criteria.andTouchIdEqualTo((String) reqMap.get("touchId"));
                appealNum = appealDealMapper.countByExample(example);
                if (appealNum >= maxAppealNum) {
                    appealDealResponse.setRspdesc("超过最大申诉次数！");
                    return appealDealResponse;
                } else {
                    //查询子流程
                    Map<String, String> subProcessParams = new HashMap<String, String>();
                    subProcessParams.put("parentProcessId", mainProcessId);
                    appealProcessResponse = appealProcessService.queryAppealProcess(subProcessParams, 0, 0);
                    if (appealProcessResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                        appealDealResponse.setRspdesc("子流程查询异常");
                        return appealDealResponse;
                    }
                    if (appealProcessResponse.getRspcode().equals(WebUtil.FAIL)) {
                        appealDealResponse.setRspdesc("请联系管理员添加子流程");
                        return appealDealResponse;
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
                        if (appealNodeResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                            appealDealResponse.setRspdesc("申诉节点查询异常");
                            return appealDealResponse;
                        }
                        if (appealNodeResponse.getRspcode().equals(WebUtil.FAIL)) {
                            appealDealResponse.setRspdesc("请联系管理员添加申诉节点");
                            return appealDealResponse;
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
                                    if (appealNodeResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                                        appealDealResponse.setRspdesc("申诉节点查询异常");
                                        return appealDealResponse;
                                    }
                                    if (appealNodeResponse.getRspcode().equals(WebUtil.FAIL)) {
                                        appealDealResponse.setRspdesc("请联系管理员添加申诉节点");
                                        return appealDealResponse;
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
            AppealDeal appealDeal = new AppealDeal();
            appealDeal.setTenantId(reqMap.get("tenantId").toString());
            appealDeal.setProvinceId(reqMap.get("provinceId").toString());
            appealDeal.setCheckType(reqMap.get("checkType").toString());
            appealDeal.setTouchId(reqMap.get("touchId").toString());
            if (null != reqMap.get("wrkfmShowSwftno") && !"".equals(reqMap.get("wrkfmShowSwftno"))) {
                appealDeal.setWrkfmShowSwftno(reqMap.get("wrkfmShowSwftno").toString());
            }
            appealDeal.setInspectionId(reqMap.get("inspectionId").toString());
            appealDeal.setPlanId(reqMap.get("planId").toString());
            appealDeal.setTemplateId(reqMap.get("templateId").toString());
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

            appealDealResponse = createAppeal(appealDeal);
            if (!appealDealResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                return appealDealResponse;
            }

            //更新质检结果（申诉信息、质检状态）
            if (Constants.QM_CHECK_TYPE.VOICE.equals(reqMap.get("checkType").toString())) {
                VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
                voiceCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                voiceCheckResult.setAppealId(appealId);
                voiceCheckResult.setAppealNum(1);
                voiceCheckResult.setAppealTime(currentTime);
                voiceCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEALING);

                VoiceCheckResultResponse voiceCheckResultResponse = updateVoiceAppealInfo(voiceCheckResult);
                if (!voiceCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    appealDealResponse.setRspcode(voiceCheckResultResponse.getRspcode());
                    appealDealResponse.setRspdesc(voiceCheckResultResponse.getRspdesc());
                    return appealDealResponse;
                }
            }
            if (Constants.QM_CHECK_TYPE.ORDER.equals(reqMap.get("checkType").toString())) {
                OrderCheckResult orderCheckResult = new OrderCheckResult();
                orderCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                orderCheckResult.setAppealId(appealId);
                orderCheckResult.setAppealNum(1);
                orderCheckResult.setAppealTime(currentTime);
                orderCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEALING);

                OrderCheckResultResponse orderCheckResultResponse = updateOrderAppealInfo(orderCheckResult);
                if (!orderCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    appealDealResponse.setRspcode(orderCheckResultResponse.getRspcode());
                    appealDealResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                    return appealDealResponse;
                }
            }
            //提交成功
            appealDealResponse.setRspcode(WebUtil.SUCCESS);
            appealDealResponse.setRspdesc("提交成功");
        } catch (Exception e) {
            logger.error("申诉提交异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉提交异常!");
        }
        return appealDealResponse;
    }

    @Override
    public AppealDealResponse queryAppeal(Map params, int start, int limit) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AppealDealResponse appealDealResponse = null;
        AppealDealExample example = new AppealDealExample();
        try {
            AppealDealExample.Criteria criteria = example.createCriteria();
            if (null != params.get("checkType") && !"".equals(params.get("checkType"))) {
                criteria.andCheckTypeEqualTo((String) params.get("checkType"));
            }
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                criteria.andTouchIdEqualTo((String) params.get("touchId"));
            }
            if (null != params.get("inspectionId") && !"".equals(params.get("inspectionId"))) {
                criteria.andInspectionIdEqualTo((String) params.get("inspectionId"));
            }
            if (null != params.get("appealId") && !"".equals(params.get("appealId"))) {
                criteria.andAppealIdEqualTo((String) params.get("appealId"));
            }
            if (null != params.get("appealStatus") && !"".equals(params.get("appealStatus"))) {
                criteria.andAppealStatusEqualTo((String) params.get("appealStatus"));
            }
            if (null != params.get("appealStaffId") && !"".equals(params.get("appealStaffId"))) {
                criteria.andAppealStaffIdEqualTo((String) params.get("appealStaffId"));
            }
            if (null != params.get("appealTimeBegin") && !"".equals(params.get("appealTimeBegin")) && null != params.get("appealTimeEnd") && !"".equals(params.get("appealTimeEnd"))) {
                criteria.andAppealTimeBetween(sdf.parse((String) params.get("appealTimeBegin")), sdf.parse((String) params.get("appealTimeEnd")));
            }
            if (null != params.get("staffId") && !"".equals(params.get("staffId"))) {
                criteria.andUserIdEqualTo((String) params.get("staffId"));
            }

            //排序（按申诉时间降序排序）
            example.setOrderByClause("APPEAL_TIME desc");

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<UnionAppealDeal> list = appealDealMapper.unionSelectByExample(example);
                Page<UnionAppealDeal> pagelist = (Page) list;
                appealDealResponse = new AppealDealResponse(pagelist);
            } else {
                appealDealResponse = new AppealDealResponse();
                List<UnionAppealDeal> list = appealDealMapper.unionSelectByExample(example);
                appealDealResponse.setData(list);
            }

            if (null != appealDealResponse.getData() && appealDealResponse.getData().size() > 0) {
                appealDealResponse.setRspcode(WebUtil.SUCCESS);
                appealDealResponse.setRspdesc("查询成功");
            } else {
                appealDealResponse.setRspcode(WebUtil.FAIL);
                appealDealResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉流程查询异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉流程查询异常");
        }
        return appealDealResponse;
    }

    @Override
    public AppealDealResponse dealAppeal(Map<String, Object> reqMap) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
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
            if (preProcessId.equals(currentProcessId) && preNodeId == currentNodeId) {  //申诉末节点
                //更新申诉流程状态
                AppealDeal appealDeal = new AppealDeal();
                appealDeal.setAppealId(appealId);
                if (approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                    appealDeal.setAppealStatus(Constants.QM_APPEAL_STATUS.PASS);
                } else {
                    appealDeal.setAppealStatus(Constants.QM_APPEAL_STATUS.REJECT);
                }
                appealDealResponse = updateAppeal(appealDeal);
                if (!appealDealResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    return appealDealResponse;
                }
                //查询当前子流程名称
                Map<String, String> params = new HashMap<String, String>();
                params.put("processId", preProcessId);
                AppealProcessResponse appealProcessResponse = appealProcessService.queryAppealProcess(params, 0, 0);
                if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    appealDealResponse.setRspcode(appealProcessResponse.getRspcode());
                    appealDealResponse.setRspdesc(appealProcessResponse.getRspdesc());
                    return appealDealResponse;
                }
                //新增审批记录
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

                    AppealDealRecordResponse appealDealRecordResponse = createAppealRecord(appealDealRecord);
                    if (!appealDealRecordResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        appealDealResponse.setRspcode(appealDealRecordResponse.getRspcode());
                        appealDealResponse.setRspdesc(appealDealRecordResponse.getRspdesc());
                        return appealDealResponse;
                    }
                }

                //更新质检结果（质检状态）
                if (Constants.QM_CHECK_TYPE.VOICE.equals(reqMap.get("checkType").toString())) {
                    VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
                    voiceCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                    if (approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                        voiceCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_PASS);
                    } else {
                        voiceCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_DENY);
                    }

                    VoiceCheckResultResponse voiceCheckResultResponse = updateVoiceAppealInfo(voiceCheckResult);
                    if (!voiceCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        appealDealResponse.setRspcode(voiceCheckResultResponse.getRspcode());
                        appealDealResponse.setRspdesc(voiceCheckResultResponse.getRspdesc());
                        return appealDealResponse;
                    }
                }
                if (Constants.QM_CHECK_TYPE.ORDER.equals(reqMap.get("checkType").toString())) {
                    OrderCheckResult orderCheckResult = new OrderCheckResult();
                    orderCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                    if (approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                        orderCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_PASS);
                    } else {
                        orderCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_DENY);
                    }

                    OrderCheckResultResponse orderCheckResultResponse = updateOrderAppealInfo(orderCheckResult);
                    if (!orderCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        appealDealResponse.setRspcode(orderCheckResultResponse.getRspcode());
                        appealDealResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                        return appealDealResponse;
                    }
                }
                //更新质检池状态（申诉通过重新质检）
                if (approveStatus.equals(Constants.QM_APPROVE_STATUS.PASS)) {
                    //更新语音质检池
                    if (Constants.QM_CHECK_TYPE.VOICE.equals(reqMap.get("checkType").toString())) {
                        VoicePool voicePool = new VoicePool();
                        voicePool.setTouchId(reqMap.get("touchId").toString());
                        voicePool.setCheckStaffId(null);
                        voicePool.setCheckStaffName(null);
                        voicePool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.RECHECKING));  //待复检
                        voicePool.setIsOperate(Constants.QM_DISTRIBUTE_STATUS.NO);   //待分配
                        voicePool.setOperateTime(null);

                        VoicePoolResponse voicePoolResponse = voicePoolRecheckUpdate(voicePool);
                        if (!voicePoolResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                            appealDealResponse.setRspcode(voicePoolResponse.getRspcode());
                            appealDealResponse.setRspdesc(voicePoolResponse.getRspdesc());
                            return appealDealResponse;
                        }
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

                        WorkformPoolResponse workformPoolResponse = orderPoolRecheckUpdate(workformPool);
                        if (!workformPoolResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                            appealDealResponse.setRspcode(workformPoolResponse.getRspcode());
                            appealDealResponse.setRspdesc(workformPoolResponse.getRspdesc());
                            return appealDealResponse;
                        }
                    }
                }
            } else {  //非末子节点
                int processNum = 1;             //子流程数
                int currentProcessOrderNo = 1;  //当前流程序号
                int currentProcessNodeNum = 1;  //当前流程子节点数
                int currentNodeOrderNo = 1;     //当前节点序号
                //查询子流程
                Map<String, String> mainProcessParams = new HashMap<String, String>();
                mainProcessParams.put("parentProcessId", reqMap.get("mainProcessId").toString());
                mainProcessParams.put("mainProcessFlag", Constants.QM_APPEAL_PROCESS_TYPE.SUB);
                AppealProcessResponse appealProcessResponse = appealProcessService.queryAppealProcess(mainProcessParams, 0, 0);
                if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    appealDealResponse.setRspcode(appealProcessResponse.getRspcode());
                    appealDealResponse.setRspdesc(appealProcessResponse.getRspdesc());
                    return appealDealResponse;
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
                        appealDealResponse.setRspcode(appealNodeResponse.getRspcode());
                        appealDealResponse.setRspdesc(appealNodeResponse.getRspdesc());
                        return appealDealResponse;
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

                //更新申诉流程
                AppealDeal appealDeal = new AppealDeal();
                appealDeal.setAppealId(appealId);
                if (approveStatus.equals(Constants.QM_APPROVE_STATUS.DENY)) {
                    appealDeal.setAppealStatus(Constants.QM_APPEAL_STATUS.REJECT);  //申诉过程中驳回则更新申诉状态
                }
                appealDeal.setPreNodeDealStaffId(reqMap.get("staffId").toString());
                appealDeal.setPreProcessId(preProcessId);
                appealDeal.setPreNodeId(preNodeId);
                appealDeal.setCurrentProcessId(currentProcessId);
                appealDeal.setCurrentNodeId(currentNodeId);
                appealDeal.setCurrentNodeName(currentNodeName);
                appealDeal.setNextProcessId(nextProcessId);
                appealDeal.setNextNodeId(nextNodeId);

                appealDealResponse = updateAppeal(appealDeal);
                if (!appealDealResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    return appealDealResponse;
                }

                //驳回则更新质检结果（申诉状态）
                if (approveStatus.equals(Constants.QM_APPROVE_STATUS.DENY)) {
                    if (Constants.QM_CHECK_TYPE.VOICE.equals(reqMap.get("checkType").toString())) {
                        VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
                        voiceCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                        voiceCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_DENY);

                        VoiceCheckResultResponse voiceCheckResultResponse = updateVoiceAppealInfo(voiceCheckResult);
                        if (!voiceCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                            appealDealResponse.setRspcode(voiceCheckResultResponse.getRspcode());
                            appealDealResponse.setRspdesc(voiceCheckResultResponse.getRspdesc());
                            return appealDealResponse;
                        }
                    }
                    if (Constants.QM_CHECK_TYPE.ORDER.equals(reqMap.get("checkType").toString())) {
                        OrderCheckResult orderCheckResult = new OrderCheckResult();
                        orderCheckResult.setInspectionId(reqMap.get("inspectionId").toString());
                        orderCheckResult.setResultStatus(Constants.QM_CHECK_RESULT.APPEAL_DENY);

                        OrderCheckResultResponse orderCheckResultResponse = updateOrderAppealInfo(orderCheckResult);
                        if (!orderCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                            appealDealResponse.setRspcode(orderCheckResultResponse.getRspcode());
                            appealDealResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                            return appealDealResponse;
                        }
                    }
                }

                //新增审批记录
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

                AppealDealRecordResponse appealDealRecordResponse = createAppealRecord(appealDealRecord);
                if (!appealDealRecordResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    appealDealResponse.setRspcode(appealDealRecordResponse.getRspcode());
                    appealDealResponse.setRspdesc(appealDealRecordResponse.getRspdesc());
                    return appealDealResponse;
                }
            }
            appealDealResponse.setRspcode(WebUtil.SUCCESS);
            appealDealResponse.setRspdesc("审批成功");
        } catch (Exception e) {
            logger.error("审批异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("审批异常!");
        }
        return appealDealResponse;
    }

    private AppealDealResponse createAppeal(AppealDeal appealDeal) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        try {
            int result = appealDealMapper.insertSelective(appealDeal);
            if (result > 0) {
                appealDealResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                appealDealResponse.setRspcode(WebUtil.FAIL);
                appealDealResponse.setRspdesc("申诉信息新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉信息新增异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉信息新增异常");
        }
        return appealDealResponse;
    }

    private AppealDealResponse updateAppeal(AppealDeal appealDeal) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        try {
            int result = appealDealMapper.updateByPrimaryKeySelective(appealDeal);
            if (result > 0) {
                appealDealResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                appealDealResponse.setRspcode(WebUtil.FAIL);
                appealDealResponse.setRspdesc("申诉流程更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉流程更新异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉流程更新异常");
        }
        return appealDealResponse;
    }

    private VoiceCheckResultResponse updateVoiceAppealInfo(VoiceCheckResult voiceCheckResult) throws Exception {
        VoiceCheckResultResponse voiceCheckResultResponse = new VoiceCheckResultResponse();
        try {
            int result = voiceCheckResultMapper.updateByPrimaryKeySelective(voiceCheckResult);
            if (result > 0) {
                voiceCheckResultResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                voiceCheckResultResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultResponse.setRspdesc("语音质检结果申诉信息更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音质检结果申诉信息更新异常", e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("语音质检结果申诉信息更新异常");
        }
        return voiceCheckResultResponse;
    }

    private OrderCheckResultResponse updateOrderAppealInfo(OrderCheckResult orderCheckResult) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        try {
            int result = orderCheckResultMapper.updateAppealInfoByInspectionId(orderCheckResult);
            if (result > 0) {
                orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultResponse.setRspdesc("工单质检结果申诉信息更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检结果申诉信息更新异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("工单质检结果申诉信息更新异常");
        }
        return orderCheckResultResponse;
    }

    private AppealDealRecordResponse createAppealRecord(AppealDealRecord appealDealRecord) throws Exception {
        AppealDealRecordResponse appealDealRecordResponse = new AppealDealRecordResponse();
        try {
            int result = appealDealRecordMapper.insertSelective(appealDealRecord);
            if (result > 0) {
                appealDealRecordResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                appealDealRecordResponse.setRspcode(WebUtil.FAIL);
                appealDealRecordResponse.setRspdesc("审批记录新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("审批记录新增异常", e);
            appealDealRecordResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealRecordResponse.setRspdesc("审批记录新增异常");
        }
        return appealDealRecordResponse;
    }

    private VoicePoolResponse voicePoolRecheckUpdate(VoicePool voicePool) throws Exception {
        VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
        try {
            int result = voicePoolMapper.recheckUpdate(voicePool);
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

    private WorkformPoolResponse orderPoolRecheckUpdate(WorkformPool workformPool) throws Exception {
        WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
        try {
            int result = workformPoolMapper.recheckUpdate(workformPool);
            if (result > 0) {
                workformPoolResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                workformPoolResponse.setRspcode(WebUtil.FAIL);
                workformPoolResponse.setRspdesc("工单质检池更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检池更新异常", e);
            workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workformPoolResponse.setRspdesc("工单质检池更新异常");
        }
        return workformPoolResponse;
    }
}
