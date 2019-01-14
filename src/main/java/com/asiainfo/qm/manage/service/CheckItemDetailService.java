package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.vo.CheckItemDetailResponse;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-01-14 14:00
 * @ Description：${description}
 */
public interface CheckItemDetailService {

    /**
     * 考评模版、考评模版详细、考评项联表查询
     */
    CheckItemDetailResponse queryCheckItemDetail(Map params, int start, int limit) throws Exception;
}
