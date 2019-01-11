package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.WorkformPoolMapper;
import com.asiainfo.qm.execution.domain.WorkformPool;
import com.asiainfo.qm.execution.service.OrderCheckResultService;
import com.asiainfo.qm.execution.service.OrderCheckService;
import com.asiainfo.qm.execution.vo.OrderCheckResponse;
import com.asiainfo.qm.execution.vo.OrderCheckResultDetailResponse;
import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;
import com.asiainfo.qm.execution.vo.WorkformPoolResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.OrderCheckResultDetailMapper;
import com.asiainfo.qm.manage.dao.OrderCheckResultMapper;
import com.asiainfo.qm.manage.domain.OrderCheckResult;
import com.asiainfo.qm.manage.domain.OrderCheckResultDetail;
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
 * @ Date       ：Created in 2019-01-05 10:55
 * @ Description：${description}
 */

@Service
public class OrderCheckServiceImpl implements OrderCheckService {

    private static Logger logger = LoggerFactory.getLogger(OrderCheckResultServiceImpl.class);
    @Autowired
    private OrderCheckResultMapper orderCheckResultMapper;
    @Autowired
    private OrderCheckResultDetailMapper orderCheckResultDetailMapper;
    @Autowired
    private WorkformPoolMapper workformPoolMapper;
    @Autowired
    private OrderCheckResultService orderCheckResultService;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public OrderCheckResponse orderCheck(Map<String, Object> reqMap) throws Exception {
        OrderCheckResponse orderCheckResponse = new OrderCheckResponse();
        @SuppressWarnings("unchecked")
        Map<String, Object> orderCheckInfo = (Map<String, Object>) reqMap.get("orderCheckInfo");
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> checkLinkData = (ArrayList<Map<String, Object>>) reqMap.get("checkLinkData");
        //工单质检结果详情更新列表
        List<OrderCheckResultDetail> orderCheckResultDetailUpdateList = new ArrayList<OrderCheckResultDetail>();
        //工单质检结果详情新增列表
        List<OrderCheckResultDetail> orderCheckResultDetailAddList = new ArrayList<OrderCheckResultDetail>();
        //质检流水
        String inspectionId = String.valueOf(sequenceUtils.getSequence("t_qm_order_check_result"));
        //质检结果状态（新增、暂存、复检）
        String checkStatus = orderCheckInfo.get("resultStatus").toString();
        //质检开始时间
        Date currentTime = DateUtil.getCurrontTime();
        String tmpStr = orderCheckInfo.get("checkStartTime").toString();
        String checkStartTime = tmpStr.substring(0, 10) + " " + tmpStr.substring(11);
        boolean updateFlag = false; //质检结果更新标志
        try {
            //查询工单质检结果信息表，存在暂存数据则更新质检结果，反之插入
            Map<String, Object> params = new HashMap<>();
            params.put("tenantId", orderCheckInfo.get("tenantId"));
            params.put("touchId", orderCheckInfo.get("touchId"));
            params.put("resultStatus", Constants.QM_CHECK_RESULT.TEMP_SAVE);
            OrderCheckResultResponse orderCheckResultResponse = orderCheckResultService.queryOrderCheckResult(params, 0, 0);
            if (orderCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                orderCheckResponse.setRspcode(orderCheckResultResponse.getRspcode());
                orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                return orderCheckResponse;
            }
            if (null != orderCheckResultResponse.getData() && orderCheckResultResponse.getData().size() > 0) {
                //若有保存数据，则流水号为保存时生成的流水
                inspectionId = orderCheckResultResponse.getData().get(0).getInspectionId();
                updateFlag = true;
                for (OrderCheckResult orderCheckResult : orderCheckResultResponse.getData()
                ) {
                    for (Map<String, Object> checkLink : checkLinkData
                    ) {
                        if (checkLink.get("checkLink").toString().equals(orderCheckResult.getCheckLink())) {
                            checkLink.put("updateFlag", "0");
                            break;
                        }
                    }
                }
            }
            //原质检流水
            String originInspectionId = inspectionId;
            //复检
            if (checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                //查询原质检流水号
                orderCheckResultResponse = orderCheckResultService.queryOriginInspectionId(orderCheckInfo);
                if (orderCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                    orderCheckResponse.setRspcode(orderCheckResultResponse.getRspcode());
                    orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                    return orderCheckResponse;
                }
                if (null != orderCheckResultResponse.getData() && orderCheckResultResponse.getData().size() > 0) {
                    originInspectionId = orderCheckResultResponse.getData().get(0).getInspectionId();
                }
            }

            //重置之前质检的最新质检结果标志
            OrderCheckResult resetResult = new OrderCheckResult();
            resetResult.setTouchId(orderCheckInfo.get("touchId").toString());
            resetResult.setLastResultFlag("0");
            orderCheckResultResponse = resetLastResultFlag(resetResult);
            if (orderCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                orderCheckResponse.setRspcode(orderCheckResultResponse.getRspcode());
                orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                return orderCheckResponse;
            }

            //工单质检结果更新or新增
            orderCheckResultResponse = updateOrAddOrderResult(orderCheckInfo, inspectionId, originInspectionId, updateFlag);
            if (!orderCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                orderCheckResponse.setRspcode(orderCheckResultResponse.getRspcode());
                orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                return orderCheckResponse;
            }

            //考评环节详细信息
            for (Map checkLink : checkLinkData
            ) {
                @SuppressWarnings("unchecked")
                List<Map> checkItemScoreList = (ArrayList<Map>) checkLink.get("checkItemScoreList");
                for (Map checkItem : checkItemScoreList
                ) {
                    OrderCheckResultDetail orderCheckResultDetail = new OrderCheckResultDetail();

                    orderCheckResultDetail.setCheckLink(checkLink.get("checkLink").toString());
                    orderCheckResultDetail.setNodeType(checkItem.get("nodeType").toString());
                    orderCheckResultDetail.setNodeId(checkItem.get("nodeId").toString());
                    orderCheckResultDetail.setNodeName(checkItem.get("nodeName").toString());
                    orderCheckResultDetail.setTenantId(orderCheckInfo.get("tenantId").toString());
                    orderCheckResultDetail.setInspectionId(inspectionId);
                    orderCheckResultDetail.setTouchId(orderCheckInfo.get("touchId").toString());
                    orderCheckResultDetail.setCheckStaffId(orderCheckInfo.get("checkStaffId").toString());
                    orderCheckResultDetail.setCheckStaffName(orderCheckInfo.get("checkStaffName").toString());
                    orderCheckResultDetail.setCheckDepartId(orderCheckInfo.get("checkDepartId").toString());
                    orderCheckResultDetail.setCheckDepartName(orderCheckInfo.get("checkDepartName").toString());
                    orderCheckResultDetail.setCheckStartTime(DateUtil.string2Date(checkStartTime));
                    orderCheckResultDetail.setCheckEndTime(currentTime);
                    orderCheckResultDetail.setScoreType(orderCheckInfo.get("scoreType").toString());
                    orderCheckResultDetail.setScoreScope(Integer.parseInt(checkItem.get("scoreScope").toString()));
                    orderCheckResultDetail.setMinScore(Integer.parseInt(checkItem.get("minScore").toString()));
                    orderCheckResultDetail.setMaxScore(Integer.parseInt(checkItem.get("maxScore").toString()));
                    orderCheckResultDetail.setRealScore(BigDecimal.valueOf(Double.parseDouble(checkItem.get("realScore").toString())));

                    if (checkLink.containsKey("updateFlag") && checkLink.get("updateFlag").toString().equals("0")) {
                        orderCheckResultDetailUpdateList.add(orderCheckResultDetail);
                    } else {
                        orderCheckResultDetailAddList.add(orderCheckResultDetail);
                    }
                }
            }

            //工单质检结果详细信息更新
            if (!orderCheckResultDetailUpdateList.isEmpty()) {
                OrderCheckResultDetailResponse orderCheckResultDetailResponse = updateOrderDetail(orderCheckResultDetailUpdateList);
                if (!orderCheckResultDetailResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    orderCheckResponse.setRspcode(orderCheckResultDetailResponse.getRspcode());
                    orderCheckResponse.setRspdesc(orderCheckResultDetailResponse.getRspdesc());
                    return orderCheckResponse;
                }
            }

            //工单质检结果详细信息新增
            if (!orderCheckResultDetailAddList.isEmpty()) {
                OrderCheckResultDetailResponse orderCheckResultDetailResponse = addOrderDetail(orderCheckResultDetailAddList);
                if (!orderCheckResultDetailResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    orderCheckResponse.setRspcode(orderCheckResultDetailResponse.getRspcode());
                    orderCheckResponse.setRspdesc(orderCheckResultDetailResponse.getRspdesc());
                    return orderCheckResponse;
                }
            }

            //更新工单质检池（质检暂存不更新质检池）
            if (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                WorkformPool workformPool = new WorkformPool();
                workformPool.setWrkfmId(Long.parseLong(orderCheckInfo.get("touchId").toString()));
                workformPool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.CHECKED));

                WorkformPoolResponse workformPoolResponse = updateWorkFormPool(workformPool);
                if (!workformPoolResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    orderCheckResponse.setRspcode(workformPoolResponse.getRspcode());
                    orderCheckResponse.setRspdesc(workformPoolResponse.getRspdesc());
                    return orderCheckResponse;
                }
            }

            orderCheckResponse.setRspcode(WebUtil.SUCCESS);
            if (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                orderCheckResponse.setRspdesc("提交成功");
            }
            if (checkStatus.equals(Constants.QM_CHECK_RESULT.TEMP_SAVE)) {
                orderCheckResponse.setRspdesc("保存成功");
            }
        } catch (Exception e) {
            logger.error("工单质检异常", e);
            orderCheckResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResponse.setRspdesc("工单质检异常!");
        }
        return orderCheckResponse;
    }

    private OrderCheckResultResponse resetLastResultFlag(OrderCheckResult orderCheckResult) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        try {
            orderCheckResultMapper.resetLastResultFlag(orderCheckResult);
            orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("最新质检结果标识重置异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("最新质检结果标识重置异常");
        }
        return orderCheckResultResponse;
    }

    /*
     * 更新工单质检结果
     * orderCheckInfo 工单考评项基本信息
     * inspectionId 质检流水
     * originInspectionId 原质检流水
     * isUpdate true：更新 false：新增
     */
    private OrderCheckResultResponse updateOrAddOrderResult(Map<String, Object> orderCheckInfo, String inspectionId, String originInspectionId, Boolean isUpdate) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        //质检开始时间
        Date currentTime = DateUtil.getCurrontTime();
        String tmpStr = orderCheckInfo.get("checkStartTime").toString();
        String checkStartTime = tmpStr.substring(0, 10) + " " + tmpStr.substring(11);
        //质检结果状态（新增、暂存、复检）
        String checkStatus = orderCheckInfo.get("resultStatus").toString();
        try {
            int result = 0;
            OrderCheckResult orderCheckResult = new OrderCheckResult();
            orderCheckResult.setTenantId(orderCheckInfo.get("tenantId").toString());
            orderCheckResult.setCallingNumber(orderCheckInfo.get("callingNumber").toString());
            orderCheckResult.setAcceptNumber(orderCheckInfo.get("acceptNumber").toString());
            orderCheckResult.setInspectionId(inspectionId);
            orderCheckResult.setOriginInspectionId(originInspectionId);
            orderCheckResult.setTouchId(orderCheckInfo.get("touchId").toString());
            orderCheckResult.setCheckLink("1001");   //待删除字段
            orderCheckResult.setPlanId(orderCheckInfo.get("planId").toString());
            orderCheckResult.setTemplateId(orderCheckInfo.get("templateId").toString());
            orderCheckResult.setCheckModel(orderCheckInfo.get("checkModel").toString());        //默认计划内质检
            orderCheckResult.setCheckedStaffId(orderCheckInfo.get("checkedStaffId").toString());
            orderCheckResult.setCheckedStaffName(orderCheckInfo.get("checkedStaffName").toString());
            orderCheckResult.setCheckedDepartId(orderCheckInfo.get("checkedDepartId").toString());
            orderCheckResult.setCheckedDepartName(orderCheckInfo.get("checkedDepartName").toString());
            orderCheckResult.setCheckStaffId(orderCheckInfo.get("checkStaffId").toString());
            orderCheckResult.setCheckStaffName(orderCheckInfo.get("checkStaffName").toString());
            orderCheckResult.setCheckDepartId(orderCheckInfo.get("checkDepartId").toString());
            orderCheckResult.setCheckDepartName(orderCheckInfo.get("checkDepartName").toString());
            orderCheckResult.setCheckStartTime(DateUtil.string2Date(checkStartTime));
            orderCheckResult.setCheckEndTime(currentTime);
            orderCheckResult.setCheckTime(Integer.parseInt(orderCheckInfo.get("checkTime").toString()));
            orderCheckResult.setScoreType(orderCheckInfo.get("scoreType").toString());
            orderCheckResult.setResultStatus(checkStatus);
            orderCheckResult.setLastResultFlag("1");      //最新质检结果
            orderCheckResult.setFinalScore(BigDecimal.valueOf(Double.parseDouble(orderCheckInfo.get("finalScore").toString())));
            orderCheckResult.setCheckComment(orderCheckInfo.get("checkComment").toString());

            if (isUpdate) {
                result = orderCheckResultMapper.updateByPrimaryKeySelective(orderCheckResult);
            } else {
                result = orderCheckResultMapper.insertSelective(orderCheckResult);
            }

            if (result > 0) {
                orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                if (isUpdate) {
                    orderCheckResultResponse.setRspdesc("工单质检结果更新失败");
                } else {
                    orderCheckResultResponse.setRspdesc("工单质检结果新增失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            if (isUpdate) {
                logger.error("工单质检结果更新异常", e);
                orderCheckResultResponse.setRspdesc("工单质检结果更新异常");
            } else {
                logger.error("工单质检结果新增异常", e);
                orderCheckResultResponse.setRspdesc("工单质检结果新增异常");
            }
        }
        return orderCheckResultResponse;
    }

    /*
     * 更新工单质检详情
     */
    private OrderCheckResultDetailResponse updateOrderDetail(List<OrderCheckResultDetail> orderCheckResultDetailList) throws Exception {
        OrderCheckResultDetailResponse orderCheckResultDetailResponse = new OrderCheckResultDetailResponse();
        try {
            int result = 0;
            for (OrderCheckResultDetail orderCheckResultDetail : orderCheckResultDetailList
            ) {
                result = orderCheckResultDetailMapper.updateByPrimaryKeySelective(orderCheckResultDetail);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                orderCheckResultDetailResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                orderCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultDetailResponse.setRspdesc("工单质检结果详细信息更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检结果详细信息更新异常", e);
            orderCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultDetailResponse.setRspdesc("工单质检结果详细信息更新异常");
        }
        return orderCheckResultDetailResponse;
    }

    /*
     * 新增工单质检详情
     */
    private OrderCheckResultDetailResponse addOrderDetail(List<OrderCheckResultDetail> orderCheckResultDetailList) throws Exception {
        OrderCheckResultDetailResponse orderCheckResultDetailResponse = new OrderCheckResultDetailResponse();
        try {
            int result = 0;
            for (OrderCheckResultDetail orderCheckResultDetail : orderCheckResultDetailList
            ) {
                result = orderCheckResultDetailMapper.insertSelective(orderCheckResultDetail);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                orderCheckResultDetailResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                orderCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultDetailResponse.setRspdesc("工单质检结果详细信息新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检结果详细信息新增异常", e);
            orderCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultDetailResponse.setRspdesc("工单质检结果详细信息新增异常");
        }
        return orderCheckResultDetailResponse;
    }

    private WorkformPoolResponse updateWorkFormPool(WorkformPool workformPool) throws Exception {
        WorkformPoolResponse workFormPoolResponse = new WorkformPoolResponse();
        try {
            int result = workformPoolMapper.updateByWorkFormId(workformPool);
            if (result > 0) {
                workFormPoolResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                workFormPoolResponse.setRspcode(WebUtil.FAIL);
                workFormPoolResponse.setRspdesc("工单质检池更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检池更新异常", e);
            workFormPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workFormPoolResponse.setRspdesc("工单质检池更新异常");
        }
        return workFormPoolResponse;
    }
}
