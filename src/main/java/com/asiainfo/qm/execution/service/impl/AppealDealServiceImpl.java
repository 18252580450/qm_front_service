package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.domain.AppealDeal;
import com.asiainfo.qm.execution.service.AppealDealService;
import com.asiainfo.qm.execution.vo.AppealDealResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-21 14:23
 * @ Description：${description}
 */
@Service
public class AppealDealServiceImpl implements AppealDealService {

    @Override
    public AppealDealResponse queryAppeal(Map params, int start, int limit) throws Exception {
        return null;
    }

    @Override
    public AppealDealResponse createAppeal(AppealDeal appealDeal) throws Exception {
        return null;
    }

    @Override
    public AppealDealResponse updateAppeal(AppealDeal appealDeal) throws Exception {
        return null;
    }

    @Override
    public AppealDealResponse deleteAppeal(List<String> idList) throws Exception {
        return null;
    }
}
