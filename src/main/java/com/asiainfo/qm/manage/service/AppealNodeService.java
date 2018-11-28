package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.AppealNode;
import com.asiainfo.qm.manage.vo.AppealNodeResponse;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 17:23 2018/11/8
 * @ Description：${description}
 */
public interface AppealNodeService {

    /**
     * 申诉节点查询
     */
    AppealNodeResponse queryAppealNode(Map params, int start, int limit) throws Exception;

    /**
     * 申诉节点新增
     */
    AppealNodeResponse addAppealNode(List<AppealNode> appealNodes) throws Exception;

    /**
     * 申诉节点修改
     */
    AppealNodeResponse updateAppealNode(List<AppealNode> appealNodes) throws Exception;

    /**
     * 申诉节点删除
     *
     * processIdList - 子节点的父流程id
     * appealNodes - 子节点列表（根据processId、nodeId、userId删除子节点）
     */
    AppealNodeResponse deleteAppealNode(List<String> processIdList, List<AppealNode> appealNodes) throws Exception;
}
