package com.asiainfo.qm.manage.service.impl;


import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.OrderCheckResultMapper;
import com.asiainfo.qm.manage.domain.OrderCheckResult;
import com.asiainfo.qm.manage.domain.OrderCheckResultExample;
import com.asiainfo.qm.manage.service.OrderCheckResultService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：wangcheng.
 * @ Date       ：Created in 14:22 2018/12/16
 * @ Description：${description}
 */
@Service
public class WorkCheckResultServiceImpl implements OrderCheckResultService {

    private static Logger logger = LoggerFactory.getLogger(WorkCheckResultServiceImpl.class);

    @Autowired
    private OrderCheckResultMapper orderCheckResultMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public OrderCheckResultResponse selectByParams(Map params, int start, int limit) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        OrderCheckResultResponse orderCheckResultResponse = null;
        OrderCheckResultExample orderCheckResultExample = new OrderCheckResultExample();
        try {
            OrderCheckResultExample.Criteria criteria= orderCheckResultExample.createCriteria();//在运行时动态生成查询语句
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                criteria.andWrkfmShowSwftnoEqualTo((String) params.get("touchId"));
            }
            if (null != params.get("originInspectionId") && !"".equals(params.get("originInspectionId"))) {
                criteria.andOriginInspectionIdEqualTo((String) params.get("originInspectionId"));
            }
            if (null != params.get("planId") && !"".equals(params.get("planId"))) {
                criteria.andPlanIdEqualTo((String) params.get("planId"));
            }
            if (null != params.get("lastResultFlag") && !"".equals(params.get("lastResultFlag"))) {
                criteria.andLastResultFlagEqualTo((String) params.get("lastResultFlag"));
            }
            if (null != params.get("checkStaffId") && !"".equals(params.get("checkStaffId"))) {
                criteria.andCheckStaffIdEqualTo((String) params.get("checkStaffId"));
            }
            if (null != params.get("qmStartTime") && !"".equals(params.get("qmStartTime")) && null != params.get("qmEndTime") && !"".equals(params.get("qmEndTime"))) {
                criteria.andCheckEndTimeBetween(sdf.parse((String) params.get("qmStartTime")), sdf.parse((String) params.get("qmEndTime")));
            }
            if (null != params.get("resultStatus") && !"".equals(params.get("resultStatus"))) {
                criteria.andResultStatusEqualTo((String) params.get("resultStatus"));
            }
            if (null != params.get("minScore") && !"".equals(params.get("minScore")) && null != params.get("maxScore") && !"".equals(params.get("maxScore"))) {
                criteria.andFinalScoreBetween(BigDecimal.valueOf(Double.parseDouble(params.get("minScore").toString())), BigDecimal.valueOf(Double.parseDouble(params.get("maxScore").toString())));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<OrderCheckResult> list = orderCheckResultMapper.selectByExample(orderCheckResultExample);
                Page<OrderCheckResult> pagelist = (Page)list;
                orderCheckResultResponse = new OrderCheckResultResponse(pagelist);
            } else {
                orderCheckResultResponse = new OrderCheckResultResponse();
                List<OrderCheckResult> list = orderCheckResultMapper.selectByExample(orderCheckResultExample);
                orderCheckResultResponse.setData(list);
            }

            if(null != orderCheckResultResponse.getData() && orderCheckResultResponse.getData().size() > 0){
                orderCheckResultResponse.setRspcode(WebUtil.SUCCESS);
                orderCheckResultResponse.setRspdesc("查询成功");
            }else {
                orderCheckResultResponse.setRspcode(WebUtil.FAIL);
                orderCheckResultResponse.setRspdesc("无数据");
            }
        }catch (Exception e){
            logger.error("查询异常",e);
            orderCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            orderCheckResultResponse.setRspdesc("查询异常");
        }
        return orderCheckResultResponse;
    }

}

