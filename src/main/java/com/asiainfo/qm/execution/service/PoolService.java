package com.asiainfo.qm.execution.service;

import com.asiainfo.qm.execution.domain.Pool;
import com.asiainfo.qm.execution.vo.PoolResponse;
import java.util.List;
import java.util.Map;


public interface PoolService {

    PoolResponse selectByParams(Map params, int start, int limit)throws Exception;

    PoolResponse deleteItems(List<String> idList) throws Exception;

}
