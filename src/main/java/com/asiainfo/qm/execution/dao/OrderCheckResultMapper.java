package com.asiainfo.qm.execution.dao;

import com.asiainfo.qm.execution.domain.OrderCheckResult;
import com.asiainfo.qm.execution.domain.OrderCheckResultExample;
import com.asiainfo.qm.execution.domain.OrderCheckResultKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCheckResultMapper {
    int countByExample(OrderCheckResultExample example);

    int deleteByExample(OrderCheckResultExample example);

    int deleteByPrimaryKey(OrderCheckResultKey key);

    int insert(OrderCheckResult record);

    int insertSelective(OrderCheckResult record);

    List<OrderCheckResult> selectByExample(OrderCheckResultExample example);

    OrderCheckResult selectByPrimaryKey(OrderCheckResultKey key);

    int updateByExampleSelective(@Param("record") OrderCheckResult record, @Param("example") OrderCheckResultExample example);

    int updateByExample(@Param("record") OrderCheckResult record, @Param("example") OrderCheckResultExample example);

    int updateByPrimaryKeySelective(OrderCheckResult record);

    int updateByPrimaryKey(OrderCheckResult record);
}