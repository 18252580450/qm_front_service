package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.OrderCheckResultDetailService;
import com.asiainfo.qm.execution.vo.OrderCheckResultDetailResponse;
import com.asiainfo.qm.manage.dao.OrderCheckResultDetailMapper;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.OrderCheckResultDetail;
import com.asiainfo.qm.manage.service.impl.CheckItemServiceImpl;
import com.asiainfo.qm.manage.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-19 16:01
 * @ Description：${description}
 */
@Service
public class OrderCheckResultDetailServiceImpl implements OrderCheckResultDetailService {

    private static Logger logger = LoggerFactory.getLogger(CheckItemServiceImpl.class);
    @Autowired
    private OrderCheckResultDetailMapper orderCheckResultDetailMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public OrderCheckResultDetailResponse queryOrderCheckResultDetail(Map params, int start, int limit) throws Exception {
        return null;
    }

    @Override
    public OrderCheckResultDetailResponse addOrderCheckResultDetail(List<OrderCheckResultDetail> orderCheckResultDetailList) throws Exception {
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
                orderCheckResultDetailResponse.setRspdesc("工单质检结果详细信息新增成功");
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

    @Override
    public OrderCheckResultDetailResponse updateOrderCheckResultDetail(List<OrderCheckResultDetail> orderCheckResultDetailList) throws Exception {
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
                orderCheckResultDetailResponse.setRspdesc("工单质检结果详细信息更新成功");
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
}
