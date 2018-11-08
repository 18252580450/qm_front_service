package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.domain.AppealProcess;
import com.asiainfo.qm.manage.service.AppealProcessService;
import com.asiainfo.qm.manage.vo.AppealProcessResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 15:07 2018/11/8
 * @ Description：${description}
 */
@Service
public class AppealProcessServiceImpl implements AppealProcessService {
    @Override
    public AppealProcessResponse queryAppealProcess(Map params, int start, int limit) throws Exception {
        return null;
    }

    @Override
    public AppealProcessResponse createAppealProcess(AppealProcess appealProcess) throws Exception {
        return null;
    }

    @Override
    public AppealProcessResponse updateAppealProcess(AppealProcess appealProcess) throws Exception {
        return null;
    }

    @Override
    public AppealProcessResponse deleteAppealMainProcess(List<String> idList) throws Exception {
        return null;
    }

    @Override
    public AppealProcessResponse deleteAppealSubProcess(String id) throws Exception {
        return null;
    }
}
