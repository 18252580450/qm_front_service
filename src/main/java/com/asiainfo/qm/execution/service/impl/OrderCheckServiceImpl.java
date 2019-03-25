package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.WorkformPoolMapper;
import com.asiainfo.qm.execution.domain.WorkformPool;
import com.asiainfo.qm.execution.service.OrderCheckResultDetailService;
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
    private OrderCheckResultDetailService orderCheckResultDetailService;

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
        //质检结果状态（新增、暂存、复检、复检保存）
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
                //查询工单质检结果详细信息表，存在暂存数据则更新，反之插入
                Map<String, Object> detailParams = new HashMap<>();
                detailParams.put("tenantId", orderCheckInfo.get("tenantId"));
                detailParams.put("touchId", orderCheckInfo.get("touchId"));
                detailParams.put("inspectionId", inspectionId);
                OrderCheckResultDetailResponse orderCheckResultDetailResponse = orderCheckResultDetailService.querySavedResult(detailParams, 0, 0);
                if (orderCheckResultDetailResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                    orderCheckResponse.setRspcode(orderCheckResultDetailResponse.getRspcode());
                    orderCheckResponse.setRspdesc(orderCheckResultDetailResponse.getRspdesc());
                    return orderCheckResponse;
                }
                if (null != orderCheckResultDetailResponse.getData() && orderCheckResultDetailResponse.getData().size() > 0) {
                    for (OrderCheckResultDetail orderCheckResultDetail : orderCheckResultDetailResponse.getData()
                    ) {
                        for (Map<String, Object> checkLink : checkLinkData
                        ) {
                            if (checkLink.get("checkLink").toString().equals(orderCheckResultDetail.getCheckLink())) {
                                checkLink.put("updateFlag", "0");
                                break;
                            }
                        }
                    }
                }
            }

            //原质检流水
            String originInspectionId = inspectionId;
            //复检
            if (checkStatus.equals(Constants.QM_CHECK_FLAG.RECHECK) || checkStatus.equals(Constants.QM_CHECK_FLAG.RECHECK_SAVE)) {
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

            //重置之前质检的最新质检结果标志（复检时）
            if (!inspectionId.equals(originInspectionId)) {
                OrderCheckResult resetResult = new OrderCheckResult();
                resetResult.setTouchId(orderCheckInfo.get("touchId").toString());
                resetResult.setLastResultFlag("0");
                orderCheckResultResponse = resetLastResultFlag(resetResult);
                if (orderCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                    orderCheckResponse.setRspcode(orderCheckResultResponse.getRspcode());
                    orderCheckResponse.setRspdesc(orderCheckResultResponse.getRspdesc());
                    return orderCheckResponse;
                }
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
                    orderCheckResultDetail.setCheckedStaffId(checkLink.get("checkedStaffId").toString());
                    orderCheckResultDetail.setCheckedStaffName(checkLink.get("checkedStaffNm").toString());
                    orderCheckResultDetail.setCheckedDepartId(checkLink.get("checkedDepartId").toString());
                    orderCheckResultDetail.setCheckedDepartName(checkLink.get("checkedDepartNm").toString());
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
            if (checkStatus.equals(Constants.QM_CHECK_FLAG.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_FLAG.RECHECK)) {
                //计划内质检
                if (orderCheckInfo.get("checkModel").toString().equals(Constants.QM_CHECK_MODEL.WITHIN_PLAN)) {
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
                //计划外质检
                if (orderCheckInfo.get("checkModel").toString().equals(Constants.QM_CHECK_MODEL.BEYOND_PLAN)) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> workFormInfo = (Map<String, Object>) reqMap.get("workFormInfo");
                    WorkformPoolResponse workformPoolResponse = insertWorkFormPool(workFormInfo, orderCheckInfo);
                    if (!workformPoolResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        orderCheckResponse.setRspcode(workformPoolResponse.getRspcode());
                        orderCheckResponse.setRspdesc(workformPoolResponse.getRspdesc());
                        return orderCheckResponse;
                    }
                }
            }

            orderCheckResponse.setRspcode(WebUtil.SUCCESS);
            if (checkStatus.equals(Constants.QM_CHECK_FLAG.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_FLAG.RECHECK)) {
                orderCheckResponse.setRspdesc("提交成功");
            } else {
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
            int result = orderCheckResultMapper.resetLastResultFlag(orderCheckResult);
            if (result > 0) {
                orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                orderCheckResultResponse.setRspdesc("最新质检结果标识重置失败");
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
            }
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
        String resultStatus = Constants.QM_CHECK_RESULT.TEMP_SAVE;
        switch (checkStatus) {
            case Constants.QM_CHECK_FLAG.NEW_BUILD:
                resultStatus = Constants.QM_CHECK_RESULT.NEW_BUILD;
                break;
            case Constants.QM_CHECK_FLAG.RECHECK:
                resultStatus = Constants.QM_CHECK_RESULT.RECHECK;
                break;
        }
        try {
            int result = 0;
            OrderCheckResult orderCheckResult = new OrderCheckResult();
            orderCheckResult.setTenantId(orderCheckInfo.get("tenantId").toString());
            orderCheckResult.setProvinceId(orderCheckInfo.get("provinceId").toString());
            orderCheckResult.setCallingNumber(orderCheckInfo.get("callingNumber").toString());
            orderCheckResult.setAcceptNumber(orderCheckInfo.get("acceptNumber").toString());
            orderCheckResult.setInspectionId(inspectionId);
            orderCheckResult.setOriginInspectionId(originInspectionId);
            orderCheckResult.setTouchId(orderCheckInfo.get("touchId").toString());
            orderCheckResult.setWrkfmShowSwftno(orderCheckInfo.get("wrkfmShowSwftno").toString());
            orderCheckResult.setPlanId(orderCheckInfo.get("planId").toString());
            orderCheckResult.setTemplateId(orderCheckInfo.get("templateId").toString());
            orderCheckResult.setCheckModel(orderCheckInfo.get("checkModel").toString());        //计划内or计划外
            orderCheckResult.setCheckStaffId(orderCheckInfo.get("checkStaffId").toString());
            orderCheckResult.setCheckStaffName(orderCheckInfo.get("checkStaffName").toString());
            orderCheckResult.setCheckStartTime(DateUtil.string2Date(checkStartTime));
            orderCheckResult.setCheckEndTime(currentTime);
            orderCheckResult.setCheckTime(Integer.parseInt(orderCheckInfo.get("checkTime").toString()));
            orderCheckResult.setScoreType(orderCheckInfo.get("scoreType").toString());
            orderCheckResult.setResultStatus(resultStatus);
            orderCheckResult.setLastResultFlag("1");      //最新质检结果
            orderCheckResult.setFinalScore(BigDecimal.valueOf(Double.parseDouble(orderCheckInfo.get("finalScore").toString())));
            orderCheckResult.setCheckComment(orderCheckInfo.get("checkComment").toString());
            orderCheckResult.setUnqualifiedNum(Integer.parseInt(orderCheckInfo.get("unqualifiedNum").toString()));

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

    private WorkformPoolResponse insertWorkFormPool(Map<String, Object> workForm, Map<String, Object> orderCheckInfo) throws Exception {
        WorkformPoolResponse workFormPoolResponse = new WorkformPoolResponse();
        try {
            WorkformPool workformPool = new WorkformPool();
            workformPool.setCheckedStaffId(workForm.get("checkedStaffId").toString());
            workformPool.setWrkfmId(Long.parseLong(orderCheckInfo.get("touchId").toString()));
            workformPool.setWrkfmShowSwftno(orderCheckInfo.get("wrkfmShowSwftno").toString());   //显示工单号
            workformPool.setProvinceId(orderCheckInfo.get("provinceId").toString());
            workformPool.setHandleDuration(Integer.parseInt(workForm.get("handleDuration").toString()));
            workformPool.setActualHandleDuration(Integer.parseInt(workForm.get("actualHandleDuration").toString()));
            workformPool.setCheckedTime(DateUtil.getCurrontTime());                              //抽取时间
            workformPool.setModfTime(DateUtil.string2Date(workForm.get("modfTime").toString())); //修改时间
            workformPool.setCrtTime(DateUtil.string2Date(workForm.get("crtTime").toString()));   //创建时间
            workformPool.setArcTime(DateUtil.string2Date(workForm.get("arcTime").toString()));   //归档时间
            workformPool.setSrvReqstTypeId(workForm.get("srvReqstTypeId").toString());           //服务请求类型id
            workformPool.setSrvReqstTypeNm(workForm.get("srvReqstTypeNm").toString());           //服务请求类型名称
            workformPool.setSrvReqstTypeFullNm(workForm.get("srvReqstTypeFullNm").toString());   //服务请求类型全称
            workformPool.setBizCntt(workForm.get("bizCntt").toString());                         //工单内容
            workformPool.setBizTitle(workForm.get("bizTitle").toString());                       //工单标题
            workformPool.setCustEmail(workForm.get("custEmail").toString());                     //客户账号
            workformPool.setCustName(workForm.get("custName").toString());                       //客户姓名
            workformPool.setCustNum(workForm.get("custNum").toString());                         //客户号码
            workformPool.setAcptStaffId(workForm.get("acptStaffId").toString());                 //立单人id
            workformPool.setAcptStaffNum(workForm.get("acptStaffNum").toString());               //立单人姓名
            workformPool.setIsOperate(Constants.QM_DISTRIBUTE_STATUS.TRUE);                      //分派状态
            workformPool.setOperateTime(DateUtil.getCurrontTime());                              //分派时间
            workformPool.setCheckStaffId(orderCheckInfo.get("checkStaffId").toString());         //质检员工号
            workformPool.setCheckStaffName(orderCheckInfo.get("checkStaffName").toString());     //质检员姓名
            workformPool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.CHECKED));     //质检状态标识
            workformPool.setPlanId("");                                                          //计划外质检不绑定planId
            workformPool.setTemplateId(orderCheckInfo.get("templateId").toString());             //模版id

            int result = workformPoolMapper.insertSelective(workformPool);
            if (result > 0) {
                workFormPoolResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                workFormPoolResponse.setRspcode(WebUtil.FAIL);
                workFormPoolResponse.setRspdesc("工单质检池插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检池插入异常", e);
            workFormPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workFormPoolResponse.setRspdesc("工单质检池插入异常");
        }
        return workFormPoolResponse;
    }
}
