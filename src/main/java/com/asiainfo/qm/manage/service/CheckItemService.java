package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.CheckItem;
import com.asiainfo.qm.manage.vo.CheckItemResponse;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 14:22 2018/11/1
 * @ Description：${description}
 */
public interface CheckItemService {

    CheckItemResponse queryCheckItem(Map params, int start, int limit)throws Exception;

    CheckItemResponse createCheckItem(CheckItem checkItem)throws Exception;

    CheckItemResponse updateCheckItem(Map params)throws Exception;

    CheckItemResponse deleteCheckItem(List<String> idList)throws Exception;

    CheckItemResponse copyCheckItem(Map params)throws  Exception;

    CheckItemResponse pasteCheckItem(Map params)throws Exception;
}
