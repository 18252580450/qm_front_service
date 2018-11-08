package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.domain.AppealNode;
import com.asiainfo.qm.manage.service.AppealNodeService;
import com.asiainfo.qm.manage.vo.AppealProcessResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 17:23 2018/11/8
 * @ Description：${description}
 */
@Service
public class AppealNodeServiceImpl implements AppealNodeService {
    @Override
    public AppealProcessResponse queryAppealNode(Map params, int start, int limit) throws Exception {
        return null;
    }

    @Override
    public AppealProcessResponse createAppealNode(AppealNode appealNode) throws Exception {
        return null;
    }

    @Override
    public AppealProcessResponse updateAppealNode(AppealNode appealNode) throws Exception {
        return null;
    }

    @Override
    public AppealProcessResponse deleteAppealNode(Map params) throws Exception {
        return null;
    }
}
