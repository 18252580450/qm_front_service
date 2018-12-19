package com.asiainfo.qm.execution.web;

import com.asiainfo.qm.execution.domain.WorkformPool;
import com.asiainfo.qm.execution.service.OrderCheckResultDetailService;
import com.asiainfo.qm.execution.service.OrderCheckResultService;
import com.asiainfo.qm.execution.service.WorkformPoolService;
import com.asiainfo.qm.execution.vo.OrderCheckResultDetailResponse;
import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;
import com.asiainfo.qm.execution.vo.OrderCheckResultServiceResponse;
import com.asiainfo.qm.execution.vo.WorkformPoolResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.OrderCheckResult;
import com.asiainfo.qm.manage.domain.OrderCheckResultDetail;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 17:11
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/orderCheck/")
public class OrderCheckController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(OrderCheckController.class);

    @Autowired
    private OrderCheckResultService orderCheckResultService;
    @Autowired
    private OrderCheckResultDetailService orderCheckResultDetailService;
    @Autowired
    private WorkformPoolService workformPoolService;

    @Autowired
    private SequenceUtils sequenceUtils;

    @ApiOperation(value = "前端调用接口进行工单质检", notes = "qm_configservice工单质检", response = OrderCheckResultServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice", commandKey = "orderCheck", threadPoolKey = "orderCheckThread", fallbackMethod = "fallbackOrderCheck", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public OrderCheckResultServiceResponse orderCheck(@RequestBody Map<String, Object> reqMap) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        OrderCheckResultServiceResponse orderCheckResultServiceResponse = new OrderCheckResultServiceResponse();
        @SuppressWarnings("unchecked")
        Map<String, Object> orderCheckInfo = (Map<String, Object>) reqMap.get("orderCheckInfo");
        @SuppressWarnings("unchecked")
        List<Map> checkLinkData = (ArrayList<Map>) reqMap.get("checkLinkData");
        List<OrderCheckResult> orderCheckResultList = new ArrayList<OrderCheckResult>();
        List<OrderCheckResultDetail> orderCheckResultDetailList = new ArrayList<OrderCheckResultDetail>();
        String checkStatus = orderCheckInfo.get("resultStatus").toString();
        Date currentTime = DateUtil.getCurrontTime();
        String tmpStr = orderCheckInfo.get("checkStartTime").toString();
        String checkStartTime = tmpStr.substring(0, 10) + " " + tmpStr.substring(11);
        boolean updateFlag = false; //更新标志
        try {
            //查询工单质检结果信息表，质检结果已存在（暂存数据）则更新质检结果，反之插入
            orderCheckResultResponse = orderCheckResultService.queryOrderCheckResult(orderCheckInfo, 0, 0);
            if (null != orderCheckResultResponse.getData() && orderCheckResultResponse.getData().size() > 0) {
                updateFlag = true;
            }
            //更新工单质检结果信息表
            for (Map checkLink : checkLinkData
            ) {
                OrderCheckResult orderCheckResult = new OrderCheckResult();

                orderCheckResult.setTenantId(orderCheckInfo.get("tenantId").toString());
                orderCheckResult.setCallingNumber(orderCheckInfo.get("callingNumber").toString());
                orderCheckResult.setAcceptNumber(orderCheckInfo.get("acceptNumber").toString());
                orderCheckResult.setInspectionId(orderCheckInfo.get("inspectionId").toString());
                orderCheckResult.setOriginInspectionId(orderCheckInfo.get("originInspectionId").toString());
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

                orderCheckResultList.add(orderCheckResult);

                //考评环节详细信息表
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
                    orderCheckResultDetail.setInspectionId(orderCheckInfo.get("inspectionId").toString());
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

                    orderCheckResultDetailList.add(orderCheckResultDetail);
                }
            }

            if (updateFlag) {
                orderCheckResultResponse = orderCheckResultService.updateOrderCheckResult(orderCheckResultList);
            } else {
                orderCheckResultResponse = orderCheckResultService.addOrderCheckResult(orderCheckResultList);
            }

            //更新工单质检结果详细信息表
            if (orderCheckResultResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                OrderCheckResultDetailResponse orderCheckResultDetailResponse = new OrderCheckResultDetailResponse();
                if (updateFlag) {
                    orderCheckResultDetailResponse = orderCheckResultDetailService.updateOrderCheckResultDetail(orderCheckResultDetailList);
                } else {
                    orderCheckResultDetailResponse = orderCheckResultDetailService.addOrderCheckResultDetail(orderCheckResultDetailList);
                }

                if (!orderCheckResultDetailResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                    orderCheckResultResponse.setRspdesc("提交失败");
                }

                //更新工单质检池（质检暂存不更新质检池）
                if (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) && orderCheckResultDetailResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    WorkformPool workformPool = new WorkformPool();
                    workformPool.setTouchId(orderCheckInfo.get("inspectionId").toString());
                    workformPool.setReserve1(Constants.QM_CHECK_STATUS.CHECKED);

                    WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
                    workformPoolResponse = workformPoolService.updateWorkFormPool(workformPool);
                    if (!workformPoolResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                        orderCheckResultResponse.setRspdesc("提交失败");
                    }
                }
            }
        } catch (Exception e) {
            logger.error("工单质检异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("工单质检异常!");
        }
        orderCheckResultServiceResponse.setResponse(orderCheckResultResponse);
        return orderCheckResultServiceResponse;
    }

    public OrderCheckResultServiceResponse fallbackOrderCheck(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("工单质检出错啦！");
        logger.error("");
        return new OrderCheckResultServiceResponse();
    }
}
