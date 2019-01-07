package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.OrderCheckResultService;
import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;
import com.asiainfo.qm.manage.dao.OrderCheckResultMapper;
import com.asiainfo.qm.manage.domain.OrderCheckResult;
import com.asiainfo.qm.manage.domain.OrderCheckResultExample;
import com.asiainfo.qm.manage.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public OrderCheckResultResponse queryOrderCheckResult(Map params, int start, int limit) throws Exception {
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
            if (null != params.get("resultStatus") && !"".equals(params.get("resultStatus"))) {
                criteria.andResultStatusEqualTo((String) params.get("resultStatus"));
            }

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
    public OrderCheckResultResponse queryOriginInspectionId(Map params) throws Exception {
        OrderCheckResultResponse orderCheckResultResponse = null;
        OrderCheckResult orderCheckResult = new OrderCheckResult();
        try {
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                orderCheckResult.setTouchId(params.get("touchId").toString());
            }
            orderCheckResultResponse = new OrderCheckResultResponse();

            List<OrderCheckResult> list = orderCheckResultMapper.queryFirstInspectionId(orderCheckResult);
            orderCheckResultResponse.setData(list);

            if (null != orderCheckResultResponse.getData() && orderCheckResultResponse.getData().size() > 0) {
                orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
                orderCheckResultResponse.setRspdesc("查询成功");
            } else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("原质检流水查询异常", e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("原质检流水查询异常");
        }
        return orderCheckResultResponse;
    }
}
