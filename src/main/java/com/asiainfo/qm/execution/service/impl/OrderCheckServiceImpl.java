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
        //工单质检结果更新列表
        List<OrderCheckResult> orderCheckResultUpdateList = new ArrayList<OrderCheckResult>();
        //工单质检结果新增列表
        List<OrderCheckResult> orderCheckResultAddList = new ArrayList<OrderCheckResult>();
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
        try {
            String rspCode = WebUtil.SUCCESS;
            //查询工单质检结果信息表，存在暂存数据则更新质检结果，反之插入
            Map<String, Object> params = new HashMap<>();
            params.put("tenantId", orderCheckInfo.get("tenantId"));
            params.put("touchId", orderCheckInfo.get("touchId"));
            params.put("resultStatus", Constants.QM_CHECK_RESULT.TEMP_SAVE);
            OrderCheckResultResponse orderCheckResultResponse = orderCheckResultService.queryOrderCheckResult(params, 0, 0);
            if (orderCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                rspCode = WebUtil.FAIL;
                orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
            }
            if (null != orderCheckResultResponse.getData() && orderCheckResultResponse.getData().size() > 0) {
                //若有保存数据，则流水号为保存时生成的流水
                inspectionId = orderCheckResultResponse.getData().get(0).getInspectionId();
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
                    rspCode = WebUtil.FAIL;
                    orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                }
                if (null != orderCheckResultResponse.getData() && orderCheckResultResponse.getData().size() > 0) {
                    originInspectionId = orderCheckResultResponse.getData().get(0).getInspectionId();
                }
            }

            //工单质检结果
            for (Map checkLink : checkLinkData
            ) {
                OrderCheckResult orderCheckResult = new OrderCheckResult();

                orderCheckResult.setTenantId(orderCheckInfo.get("tenantId").toString());
                orderCheckResult.setCallingNumber(orderCheckInfo.get("callingNumber").toString());
                orderCheckResult.setAcceptNumber(orderCheckInfo.get("acceptNumber").toString());
                orderCheckResult.setInspectionId(inspectionId);
                orderCheckResult.setOriginInspectionId(originInspectionId);
                orderCheckResult.setTouchId(orderCheckInfo.get("touchId").toString());
                orderCheckResult.setCheckLink(checkLink.get("checkLink").toString());
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
                orderCheckResult.setFinalScore(BigDecimal.valueOf(Double.parseDouble(checkLink.get("finalScore").toString())));
                orderCheckResult.setCheckComment(checkLink.get("checkComment").toString());

                if (checkLink.containsKey("updateFlag") && checkLink.get("updateFlag").toString().equals("0")) {
                    orderCheckResultUpdateList.add(orderCheckResult);
                } else {
                    orderCheckResultAddList.add(orderCheckResult);
                }

                //考评环节详细信息
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

            //重置之前质检的最新质检结果标志
            if (rspCode.equals(WebUtil.SUCCESS)) {
                OrderCheckResult orderCheckResult = new OrderCheckResult();
                orderCheckResult.setTouchId(orderCheckInfo.get("touchId").toString());
                orderCheckResult.setLastResultFlag("0");
                orderCheckResultResponse = resetLastResultFlag(orderCheckResult);
                if (orderCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                    rspCode = WebUtil.FAIL;
                    orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                }
            }

            //工单质检结果更新
            if (!orderCheckResultUpdateList.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
                orderCheckResultResponse = updateOrderCheckResult(orderCheckResultUpdateList);
                rspCode = orderCheckResultResponse.getRspcode();
                if (!rspCode.equals(WebUtil.SUCCESS)) {
                    orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                }
            }

            //工单质检结果新增
            if (!orderCheckResultAddList.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
                orderCheckResultResponse = addOrderCheckResult(orderCheckResultAddList);
                rspCode = orderCheckResultResponse.getRspcode();
                if (!rspCode.equals(WebUtil.SUCCESS)) {
                    orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                }
            }

            //工单质检结果详细信息更新
            if (!orderCheckResultDetailUpdateList.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
                OrderCheckResultDetailResponse orderCheckResultDetailResponse = updateOrderCheckResultDetail(orderCheckResultDetailUpdateList);
                rspCode = orderCheckResultDetailResponse.getRspcode();
                if (!rspCode.equals(WebUtil.SUCCESS)) {
                    orderCheckResponse.setRspdesc(orderCheckResultDetailResponse.getRspdesc());
                }
            }

            //工单质检结果详细信息新增
            if (!orderCheckResultDetailAddList.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
                OrderCheckResultDetailResponse orderCheckResultDetailResponse = addOrderCheckResultDetail(orderCheckResultDetailAddList);
                rspCode = orderCheckResultDetailResponse.getRspcode();
                if (!rspCode.equals(WebUtil.SUCCESS)) {
                    orderCheckResponse.setRspdesc(orderCheckResultDetailResponse.getRspdesc());
                }
            }

            //更新工单质检池（质检暂存不更新质检池）
            if (rspCode.equals(WebUtil.SUCCESS) && (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK))) {
                WorkformPool workformPool = new WorkformPool();
                workformPool.setWrkfmId(Long.parseLong(orderCheckInfo.get("touchId").toString()));
                workformPool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.CHECKED));

                WorkformPoolResponse workformPoolResponse = updateWorkFormPool(workformPool);
                rspCode = workformPoolResponse.getRspcode();
                if (!rspCode.equals(WebUtil.SUCCESS)) {
                    orderCheckResponse.setRspdesc(workformPoolResponse.getRspdesc());
                }
            }

            orderCheckResponse.setRspcode(rspCode);
            if (rspCode.equals(WebUtil.SUCCESS)) {
                if (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                    orderCheckResponse.setRspdesc("提交成功");
                }
                if (checkStatus.equals(Constants.QM_CHECK_RESULT.TEMP_SAVE)) {
                    orderCheckResponse.setRspdesc("保存成功");
                }
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

    private OrderCheckResultResponse updateOrderCheckResult(List<OrderCheckResult> orderCheckResultList) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        try {
            int result = 0;
            for (OrderCheckResult orderCheckResult : orderCheckResultList
            ) {
                result = orderCheckResultMapper.updateByPrimaryKeySelective(orderCheckResult);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultResponse.setRspdesc("工单质检结果更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检结果更新异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("工单质检结果更新异常");
        }
        return orderCheckResultResponse;
    }

    private OrderCheckResultResponse addOrderCheckResult(List<OrderCheckResult> orderCheckResultList) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        try {
            int result = 0;
            for (OrderCheckResult orderCheckResult : orderCheckResultList
            ) {
                result = orderCheckResultMapper.insertSelective(orderCheckResult);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultResponse.setRspdesc("工单质检结果新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检结果新增异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("工单质检结果新增异常");
        }
        return orderCheckResultResponse;
    }

    private OrderCheckResultDetailResponse updateOrderCheckResultDetail(List<OrderCheckResultDetail> orderCheckResultDetailList) throws Exception {
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

    private OrderCheckResultDetailResponse addOrderCheckResultDetail(List<OrderCheckResultDetail> orderCheckResultDetailList) throws Exception {
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
