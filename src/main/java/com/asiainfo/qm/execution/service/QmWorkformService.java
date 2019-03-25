package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.QmWorkformResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-20 19:47
 * @ Description：${description}
 */
public interface QmWorkformService {

    QmWorkformResponse queryWorkForm(Map params, int start, int limit)throws Exception;
}
