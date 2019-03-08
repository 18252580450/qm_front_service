package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.dao.TemplateDetailMapper;
import com.asiainfo.qm.manage.domain.CheckItemDetail;
import com.asiainfo.qm.manage.service.CheckItemDetailService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckItemDetailResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-01-14 14:02
 * @ Description：${description}
 */
@Service
public class CheckItemDetailImpl implements CheckItemDetailService {

    private static Logger logger = LoggerFactory.getLogger(CheckItemDetailImpl.class);

    @Autowired
    private TemplateDetailMapper templateDetailMapper;

    @Override
    public CheckItemDetailResponse queryCheckItemDetail(Map params, int start, int limit) throws Exception {
        CheckItemDetailResponse checkItemDetailResponse = null;
        try {
            CheckItemDetail checkItemDetail = new CheckItemDetail();
            if (null != params.get("tenantId") && !"".equals(params.get("tenantId"))) {
                checkItemDetail.setTenantId((String) params.get("tenantId"));
            }
            if (null != params.get("planId") && !"".equals(params.get("planId"))) {
                checkItemDetail.setPlanId((String) params.get("planId"));
            }

            checkItemDetailResponse = new CheckItemDetailResponse();

            List<CheckItemDetail> list = templateDetailMapper.unionSelectByExample(checkItemDetail);
            checkItemDetailResponse.setData(list);

            if (null != checkItemDetailResponse.getData() && checkItemDetailResponse.getData().size() > 0) {
                checkItemDetailResponse.setRspcode(WebUtil.SUCCESS);
                checkItemDetailResponse.setRspdesc("查询成功");
            } else {
                checkItemDetailResponse.setRspcode(WebUtil.FAIL);
                checkItemDetailResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            logger.error("查询异常", e);
            checkItemDetailResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemDetailResponse.setRspdesc("查询异常");
        }
        return checkItemDetailResponse;
    }
}
