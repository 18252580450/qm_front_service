package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.TemplateDetailMapper;
import com.asiainfo.qm.manage.domain.TemplateDetail;
import com.asiainfo.qm.manage.domain.TemplateDetailExample;
import com.asiainfo.qm.manage.service.CheckTemplateDetailService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.TemplateDetailResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-12 16:14
 * @ Description：${description}
 */

@Service
public class CheckTemplateDetailServiceImpl implements CheckTemplateDetailService {

    private static Logger logger = LoggerFactory.getLogger(CheckTemplateDetailServiceImpl.class);

    @Autowired
    private TemplateDetailMapper templateDetailMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public TemplateDetailResponse queryTemplateDetail(Map params, int start, int limit) throws Exception {
        TemplateDetailResponse templateDetailResponse = null;
        TemplateDetailExample example = new TemplateDetailExample();
        try {
            TemplateDetailExample.Criteria criteria = example.createCriteria();
            if (null != params.get("tenantId") && !"".equals(params.get("tenantId"))) {
                criteria.andTenantIdEqualTo((String) params.get("tenantId"));
            }
            if (null != params.get("templateId") && !"".equals(params.get("templateId"))) {
                criteria.andTemplateIdEqualTo((String) params.get("templateId"));
            }

            templateDetailResponse = new TemplateDetailResponse();
            List<TemplateDetail> list = templateDetailMapper.selectByExample(example);
            templateDetailResponse.setData(list);

            if (null != templateDetailResponse.getData() && templateDetailResponse.getData().size() > 0) {
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("查询成功");
            } else {
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            logger.error("查询异常", e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("查询异常");
        }
        return templateDetailResponse;
    }
}
