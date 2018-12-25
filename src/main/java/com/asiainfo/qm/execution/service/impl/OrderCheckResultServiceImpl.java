package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.OrderCheckResultService;
import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.OrderCheckResultMapper;
import com.asiainfo.qm.manage.domain.OrderCheckResult;
import com.asiainfo.qm.manage.domain.OrderCheckResultExample;
import com.asiainfo.qm.manage.service.impl.CheckItemServiceImpl;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-11 16:24
 * @ Description：${description}
 */

@Service
public class OrderCheckResultServiceImpl implements OrderCheckResultService {

    private static Logger logger = LoggerFactory.getLogger(OrderCheckResultServiceImpl.class);
    @Autowired
    private OrderCheckResultMapper orderCheckResultMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public OrderCheckResultResponse queryOrderSavedResult(Map params, int start, int limit) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = null;
        OrderCheckResultExample example = new OrderCheckResultExample();
        try {
            OrderCheckResultExample.Criteria criteria = example.createCriteria();
            if (null != params.get("tenantId") && !"".equals(params.get("tenantId"))) {
                criteria.andTenantIdEqualTo((String) params.get("tenantId"));
            }
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                criteria.andTouchIdEqualTo((String) params.get("touchId"));
            }
            //筛选暂存质检结果
            criteria.andResultStatusEqualTo(Constants.QM_CHECK_RESULT.TEMP_SAVE);

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<OrderCheckResult> list = orderCheckResultMapper.selectByExample(example);
                Page<OrderCheckResult> pagelist = (Page) list;
                orderCheckResultResponse = new OrderCheckResultResponse(pagelist);
            } else {
                orderCheckResultResponse = new OrderCheckResultResponse();
                List<OrderCheckResult> list = orderCheckResultMapper.selectByExample(example);
                orderCheckResultResponse.setData(list);
            }

            if (null != orderCheckResultResponse.getData() && orderCheckResultResponse.getData().size() > 0) {
                orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
                orderCheckResultResponse.setRspdesc("查询成功");
            } else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("质检结果查询异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("质检结果查询异常");
        }
        return orderCheckResultResponse;
    }

    @Override
    public OrderCheckResultResponse addOrderCheckResult(List<OrderCheckResult> orderCheckResultList) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        String resultStatus = orderCheckResultList.get(0).getResultStatus();
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
                if (resultStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || resultStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                    orderCheckResultResponse.setRspdesc("提交成功");
                }
                if (resultStatus.equals(Constants.QM_CHECK_RESULT.TEMP_SAVE)) {
                    orderCheckResultResponse.setRspdesc("保存成功");
                }
            } else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                if (resultStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || resultStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                    orderCheckResultResponse.setRspdesc("提交失败");
                }
                if (resultStatus.equals(Constants.QM_CHECK_RESULT.TEMP_SAVE)) {
                    orderCheckResultResponse.setRspdesc("保存失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("工单质检异常");
        }
        return orderCheckResultResponse;
    }

    @Override
    public OrderCheckResultResponse updateOrderCheckResult(List<OrderCheckResult> orderCheckResultList) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        String resultStatus = orderCheckResultList.get(0).getResultStatus();
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
                if (resultStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || resultStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                    orderCheckResultResponse.setRspdesc("提交成功");
                }
                if (resultStatus.equals(Constants.QM_CHECK_RESULT.TEMP_SAVE)) {
                    orderCheckResultResponse.setRspdesc("保存成功");
                }
            } else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                if (resultStatus.equals(Constants.QM_CHECK_RESULT.NEW_BUILD) || resultStatus.equals(Constants.QM_CHECK_RESULT.RECHECK)) {
                    orderCheckResultResponse.setRspdesc("提交失败");
                }
                if (resultStatus.equals(Constants.QM_CHECK_RESULT.TEMP_SAVE)) {
                    orderCheckResultResponse.setRspdesc("保存失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("工单质检异常");
        }
        return orderCheckResultResponse;
    }

    @Override
    public OrderCheckResultResponse updateAppealInfo(OrderCheckResult orderCheckResult) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = new OrderCheckResultResponse();
        try {
            int result = orderCheckResultMapper.updateAppealInfoByInspectionId(orderCheckResult);
            if (result > 0) {
                orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
                orderCheckResultResponse.setRspdesc("申诉信息更新成功");
            } else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultResponse.setRspdesc("申诉信息更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉信息更新异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("申诉信息更新异常");
        }
        return orderCheckResultResponse;
    }

    @Override
    public OrderCheckResultResponse deleteOrderCheckResult(List<String> idList) throws Exception {
        return null;
    }
}
