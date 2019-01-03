package com.asiainfo.qm.execution.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.domain.WorkformPool;
import com.asiainfo.qm.execution.service.OrderCheckResultDetailService;
import com.asiainfo.qm.execution.service.OrderCheckResultService;
import com.asiainfo.qm.execution.service.WorkformPoolService;
import com.asiainfo.qm.execution.vo.*;
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
import org.springframework.web.bind.annotation.*;

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
        OrderCheckResultDetailResponse orderCheckResultDetailResponse = new OrderCheckResultDetailResponse();
        OrderCheckResultServiceResponse orderCheckResultServiceResponse = new OrderCheckResultServiceResponse();
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
            orderCheckResultResponse = orderCheckResultService.queryOrderCheckResult(orderCheckInfo, 0, 0);
            if (orderCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                rspCode = WebUtil.FAIL;
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
                orderCheckResultResponse = orderCheckResultService.resetLastResultFlag(orderCheckResult);
                rspCode = orderCheckResultResponse.getRspcode();
            }

            //工单质检结果更新
            if (!orderCheckResultUpdateList.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
                orderCheckResultResponse = orderCheckResultService.updateOrderCheckResult(orderCheckResultUpdateList);
                rspCode = orderCheckResultResponse.getRspcode();
            }

            //工单质检结果新增
            if (!orderCheckResultAddList.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
                orderCheckResultResponse = orderCheckResultService.addOrderCheckResult(orderCheckResultAddList);
                rspCode = orderCheckResultResponse.getRspcode();
            }

            //工单质检结果详细信息更新
            if (!orderCheckResultDetailUpdateList.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
                orderCheckResultDetailResponse = orderCheckResultDetailService.updateOrderCheckResultDetail(orderCheckResultDetailUpdateList);
                rspCode = orderCheckResultDetailResponse.getRspcode();
            }

            //工单质检结果详细信息新增
            if (!orderCheckResultDetailAddList.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
                orderCheckResultDetailResponse = orderCheckResultDetailService.addOrderCheckResultDetail(orderCheckResultDetailAddList);
                rspCode = orderCheckResultDetailResponse.getRspcode();
            }

            //更新工单质检池（质检暂存不更新质检池）
            if (rspCode.equals(WebUtil.SUCCESS) && (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK))) {
                WorkformPool workformPool = new WorkformPool();
                workformPool.setWrkfmId(Long.parseLong(orderCheckInfo.get("touchId").toString()));
                workformPool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.CHECKED));

                WorkformPoolResponse workformPoolResponse = workformPoolService.updateWorkFormPool(workformPool);
                rspCode = workformPoolResponse.getRspcode();
            }

            //质检失败
            if (!rspCode.equals(WebUtil.SUCCESS)) {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                if (checkStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || checkStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                    orderCheckResultResponse.setRspdesc("提交失败");
                }
                if (checkStatus.equals(Constants.QM_CHECK_RESULT.TEMP_SAVE)) {
                    orderCheckResultResponse.setRspdesc("保存失败");
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

    @ApiOperation(value = "前端调用接口查询工单质检结果", notes = "qm_configservice查询工单质检结果", response = OrderCheckResultServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryOrderCheckResult", threadPoolKey = "queryOrderCheckResultThread", fallbackMethod = "fallbackQueryOrderCheckResult", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryOrderCheckResult", method = RequestMethod.GET)
    public OrderCheckResultServiceResponse queryOrderCheckResult(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        OrderCheckResultServiceResponse orderCheckResultServiceResponse = new OrderCheckResultServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            orderCheckResultResponse = orderCheckResultService.queryOrderCheckResult(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("工单质检结果数据查询异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("工单质检结果数据查询异常!");
        }
        orderCheckResultServiceResponse.setResponse(orderCheckResultResponse);
        return orderCheckResultServiceResponse;
    }

    public OrderCheckResultServiceResponse fallbackQueryOrderCheckResult(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("工单质检结果数据查询出错啦！");
        logger.error("");
        return new OrderCheckResultServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询工单质检结果详情", notes = "qm_configservice查询工单质检结果详情", response = OrderCheckResultDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryOrderCheckResultDetail", threadPoolKey = "queryOrderCheckResultDetailThread", fallbackMethod = "fallbackQueryOrderCheckResultDetail", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryOrderCheckResultDetail", method = RequestMethod.GET)
    public OrderCheckResultDetailServiceResponse queryOrderCheckResultDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        OrderCheckResultDetailResponse orderCheckResultDetailResponse = new OrderCheckResultDetailResponse();
        OrderCheckResultDetailServiceResponse orderCheckResultDetailServiceResponse = new OrderCheckResultDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            orderCheckResultDetailResponse = orderCheckResultDetailService.queryOrderCheckResultDetail(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("工单质检结果详情数据查询异常", e);
            orderCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultDetailResponse.setRspdesc("工单质检结果详情数据查询异常!");
        }
        orderCheckResultDetailServiceResponse.setResponse(orderCheckResultDetailResponse);
        return orderCheckResultDetailServiceResponse;
    }

    public OrderCheckResultDetailServiceResponse fallbackQueryOrderCheckResultDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("工单质检结果详情数据查询出错啦！");
        logger.error("");
        return new OrderCheckResultDetailServiceResponse();
    }

}
