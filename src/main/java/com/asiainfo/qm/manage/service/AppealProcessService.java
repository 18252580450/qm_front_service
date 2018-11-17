package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.AppealProcess;
import com.asiainfo.qm.manage.vo.AppealProcessResponse;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 15:07 2018/11/8
 * @ Description：${description}
 */
public interface AppealProcessService {

    /**
     * 申诉流程查询
     */
    AppealProcessResponse queryAppealProcess(Map params, int start, int limit)throws Exception;

    /**
     * 申诉流程(主）新增
     */
    AppealProcessResponse createAppealProcess(AppealProcess appealProcess)throws Exception;

    /**
     * 申诉流程(子流程）新增
     */
    AppealProcessResponse addSubAppealProcess(AppealProcess appealProcess)throws Exception;

    /**
     * 申诉流程修改
     */
    AppealProcessResponse updateAppealProcess(AppealProcess appealProcess)throws Exception;

    /**
     * 申诉主流程删除
     */
    AppealProcessResponse deleteAppealMainProcess(List<String> idList)throws Exception;

    /**
     * 申诉子流程删除
     */
    AppealProcessResponse deleteAppealSubProcess(String id)throws Exception;

}
