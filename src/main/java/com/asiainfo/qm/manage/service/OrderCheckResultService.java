package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.execution.vo.OrderCheckResultResponse;
import java.util.List;
import java.util.Map;


public interface OrderCheckResultService {

    OrderCheckResultResponse selectByParams(Map params, int start, int limit)throws Exception;

}
