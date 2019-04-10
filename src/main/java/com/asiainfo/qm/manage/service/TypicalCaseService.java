package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.TypicalCase;
import com.asiainfo.qm.manage.vo.TypicalCaseResponse;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-04-09 11:05
 * @ Description：${description}
 */
public interface TypicalCaseService {

    /**
     * 典型案例查询
     */
    TypicalCaseResponse queryTypicalCase(Map params, int start, int limit) throws Exception;

    /**
     * 典型案例详情查询
     */
    TypicalCaseResponse queryTypicalCaseDetail(Map params, int start, int limit) throws Exception;

    /**
     * 典型案例新增
     */
    TypicalCaseResponse addTypicalCase(TypicalCase typicalCase) throws Exception;

    /**
     * 考评项删除
     * type 0删除指定类型案例 1删除具体案例
     */
    TypicalCaseResponse deleteTypicalCase(String type, List<String> idList) throws Exception;
}
