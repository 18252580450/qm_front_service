package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.OrderCheckResultDetailService;
import com.asiainfo.qm.execution.service.OrderCheckResultService;
import com.asiainfo.qm.execution.vo.OrderCheckResultDetailResponse;
import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;
import com.asiainfo.qm.manage.dao.OrderCheckResultDetailMapper;
import com.asiainfo.qm.manage.domain.OrderCheckResultDetail;
import com.asiainfo.qm.manage.domain.OrderCheckResultDetailExample;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-19 16:01
 * @ Description：${description}
 */
@Service
public class OrderCheckResultDetailServiceImpl implements OrderCheckResultDetailService {

    private static Logger logger = LoggerFactory.getLogger(OrderCheckResultDetailServiceImpl.class);
    @Autowired
    private OrderCheckResultDetailMapper orderCheckResultDetailMapper;
    @Autowired
    private OrderCheckResultService orderCheckResultService;

    @Override
    public OrderCheckResultDetailResponse querySavedResult(Map params, int start, int limit) throws Exception {
        OrderCheckResultDetailResponse orderCheckResultDetailResponse = null;
        OrderCheckResultDetailExample example = new OrderCheckResultDetailExample();
        try {
            String inspectionId = ""; //暂存结果的质检流水号
            //通过质检结果表查询质检流水号
            Map<String, Object> param = new HashMap<>();
            param.put("tenantId", params.get("tenantId"));
            param.put("touchId", params.get("touchId"));
            param.put("resultStatus", Constants.QM_CHECK_RESULT.TEMP_SAVE);
            OrderCheckResultResponse orderCheckResultResponse = orderCheckResultService.queryOrderCheckResult(param, 0, 0);
            if (orderCheckResultResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                orderCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultDetailResponse.setRspdesc("获取暂存质检结果异常");
                return orderCheckResultDetailResponse;
            }
            if (null != orderCheckResultResponse.getData() && orderCheckResultResponse.getData().size() > 0) {
                inspectionId = orderCheckResultResponse.getData().get(0).getInspectionId();
                OrderCheckResultDetailExample.Criteria criteria = example.createCriteria();
                criteria.andInspectionIdEqualTo(inspectionId);

                if (0 != limit) {
                    PageHelper.offsetPage(start, limit);
                    List<OrderCheckResultDetail> list = orderCheckResultDetailMapper.selectByExample(example);
                    Page<OrderCheckResultDetail> pagelist = (Page) list;
                    orderCheckResultDetailResponse = new OrderCheckResultDetailResponse(pagelist);
                } else {
                    orderCheckResultDetailResponse = new OrderCheckResultDetailResponse();
                    List<OrderCheckResultDetail> list = orderCheckResultDetailMapper.selectByExample(example);
                    orderCheckResultDetailResponse.setData(list);
                }

                if (null != orderCheckResultDetailResponse.getData() && orderCheckResultDetailResponse.getData().size() > 0) {
                    orderCheckResultDetailResponse.setRspcode(WebUtil.SUCCESS);
                } else {
                    orderCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                    orderCheckResultDetailResponse.setRspdesc("无数据");
                }
            } else {
                orderCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultDetailResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("质检结果详情查询异常", e);
            orderCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultDetailResponse.setRspdesc("质检结果详情查询异常");
        }
        return orderCheckResultDetailResponse;
    }

    @Override
    public OrderCheckResultDetailResponse queryOrderCheckResultDetail(Map params, int start, int limit) throws Exception {
        OrderCheckResultDetailResponse orderCheckResultDetailResponse = null;
        OrderCheckResultDetailExample example = new OrderCheckResultDetailExample();
        try {
            String inspectionId = params.get("inspectionId").toString();
            OrderCheckResultDetailExample.Criteria criteria = example.createCriteria();
            criteria.andInspectionIdEqualTo(inspectionId);

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<OrderCheckResultDetail> list = orderCheckResultDetailMapper.selectByExample(example);
                Page<OrderCheckResultDetail> pagelist = (Page) list;
                orderCheckResultDetailResponse = new OrderCheckResultDetailResponse(pagelist);
            } else {
                orderCheckResultDetailResponse = new OrderCheckResultDetailResponse();
                List<OrderCheckResultDetail> list = orderCheckResultDetailMapper.selectByExample(example);
                orderCheckResultDetailResponse.setData(list);
            }

            if (null != orderCheckResultDetailResponse.getData() && orderCheckResultDetailResponse.getData().size() > 0) {
                orderCheckResultDetailResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                orderCheckResultDetailResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultDetailResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("质检结果详情查询异常", e);
            orderCheckResultDetailResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultDetailResponse.setRspdesc("质检结果详情查询异常");
        }
        return orderCheckResultDetailResponse;
    }

}
