package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.vo.WorkformPoolResponse;
import java.util.List;
import java.util.Map;


public interface WorkformPoolService {

    WorkformPoolResponse selectByParams(Map params, int start, int limit)throws Exception;

    WorkformPoolResponse update(List<String> idList) throws Exception;

    WorkformPoolResponse updateCheck(List<Map> list) throws Exception;
}
