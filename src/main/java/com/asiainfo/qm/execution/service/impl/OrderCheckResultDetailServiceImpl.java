package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.service.OrderCheckResultDetailService;
import com.asiainfo.qm.execution.vo.OrderCheckResultDetailResponse;
import com.asiainfo.qm.manage.dao.OrderCheckResultDetailMapper;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.OrderCheckResultDetail;
import com.asiainfo.qm.manage.domain.OrderCheckResultDetailExample;
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
 * @ Date       ：Created in 2018-12-19 16:01
 * @ Description：${description}
 */
@Service
public class OrderCheckResultDetailServiceImpl implements OrderCheckResultDetailService {

    private static Logger logger = LoggerFactory.getLogger(OrderCheckResultDetailServiceImpl.class);
    @Autowired
    private OrderCheckResultDetailMapper orderCheckResultDetailMapper;

    @Override
    public OrderCheckResultDetailResponse queryOrderCheckResultDetail(Map params, int start, int limit) throws Exception {
        OrderCheckResultDetailResponse orderCheckResultDetailResponse = null;
        OrderCheckResultDetailExample example = new OrderCheckResultDetailExample();
        try {
            OrderCheckResultDetailExample.Criteria criteria = example.createCriteria();
            if (null != params.get("tenantId") && !"".equals(params.get("tenantId"))) {
                criteria.andTenantIdEqualTo((String) params.get("tenantId"));
            }
            if (null != params.get("inspectionId") && !"".equals(params.get("inspectionId"))) {
                criteria.andInspectionIdEqualTo((String) params.get("inspectionId"));
            }
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                criteria.andTouchIdEqualTo((String) params.get("touchId"));
            }
            if (null != params.get("checkLink") && !"".equals(params.get("checkLink"))) {
                criteria.andCheckLinkEqualTo((String) params.get("checkLink"));
            }
            if (null != params.get("nodeId") && !"".equals(params.get("nodeId"))) {
                criteria.andNodeIdEqualTo((String) params.get("nodeId"));
            }

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
                orderCheckResultDetailResponse.setRspdesc("查询成功");
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
