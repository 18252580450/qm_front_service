package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.OrderCheckResultDetail;
import com.asiainfo.qm.manage.domain.OrderCheckResultDetailExample;
import com.asiainfo.qm.manage.domain.OrderCheckResultDetailKey;
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