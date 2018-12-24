package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.domain.AppealDealRecord;
import com.asiainfo.qm.execution.service.AppealDealRecordService;
import com.asiainfo.qm.execution.vo.AppealDealRecordResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-21 14:24
 * @ Description：${description}
 */
@Service
public class AppealDealRecordServiceImpl implements AppealDealRecordService {

    @Override
    public AppealDealRecordResponse queryAppeal(Map params, int start, int limit) throws Exception {
        return null;
    }

    @Override
    public AppealDealRecordResponse createAppeal(AppealDealRecord appealDeal) throws Exception {
        return null;
    }

    @Override
    public AppealDealRecordResponse updateAppeal(AppealDealRecord appealDeal) throws Exception {
        return null;
    }

    @Override
    public AppealDealRecordResponse deleteAppeal(List<String> idList) throws Exception {
        return null;
    }
}
