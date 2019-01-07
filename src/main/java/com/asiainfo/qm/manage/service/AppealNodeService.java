package com.asiainfo.qm.manage.service;

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

}
