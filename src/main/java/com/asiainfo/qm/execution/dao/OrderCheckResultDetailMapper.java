package com.asiainfo.qm.execution.dao;

import com.asiainfo.qm.execution.domain.OrderCheckResultDetail;
import com.asiainfo.qm.execution.domain.OrderCheckResultDetailExample;
import com.asiainfo.qm.execution.domain.OrderCheckResultDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCheckResultDetailMapper {
    int countByExample(OrderCheckResultDetailExample example);

    int deleteByExample(OrderCheckResultDetailExample example);

    int deleteByPrimaryKey(OrderCheckResultDetailKey key);

    int insert(OrderCheckResultDetail record);

    int insertSelective(OrderCheckResultDetail record);

    List<OrderCheckResultDetail> selectByExample(OrderCheckResultDetailExample example);

    OrderCheckResultDetail selectByPrimaryKey(OrderCheckResultDetailKey key);

    int updateByExampleSelective(@Param("record") OrderCheckResultDetail record, @Param("example") OrderCheckResultDetailExample example);

    int updateByExample(@Param("record") OrderCheckResultDetail record, @Param("example") OrderCheckResultDetailExample example);

    int updateByPrimaryKeySelective(OrderCheckResultDetail record);

    int updateByPrimaryKey(OrderCheckResultDetail record);
}