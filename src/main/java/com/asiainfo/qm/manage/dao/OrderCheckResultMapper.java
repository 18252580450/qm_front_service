package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.OrderCheckResult;
import com.asiainfo.qm.manage.domain.OrderCheckResultExample;
import com.asiainfo.qm.manage.domain.OrderCheckResultKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCheckResultMapper {
    int countByExample(OrderCheckResultExample example);

    int deleteByExample(OrderCheckResultExample example);

    int deleteByPrimaryKey(OrderCheckResultKey key);

    int insert(OrderCheckResult record);

    int insertSelective(OrderCheckResult record);

    List<OrderCheckResult> selectByExample(OrderCheckResultExample example);

    List<OrderCheckResult> queryFirstInspectionId(OrderCheckResult orderCheckResult);  //查询首次质检流水号

    OrderCheckResult selectByPrimaryKey(OrderCheckResultKey key);

    int updateByExampleSelective(@Param("record") OrderCheckResult record, @Param("example") OrderCheckResultExample example);

    int updateByExample(@Param("record") OrderCheckResult record, @Param("example") OrderCheckResultExample example);

    int updateByPrimaryKeySelective(OrderCheckResult record);

    int updateAppealInfoByInspectionId(OrderCheckResult record);  //根据质检流水更新申诉信息

    int resetLastResultFlag(OrderCheckResult record);   //重置之前质检的最新质检结果标志

    int updateByPrimaryKey(OrderCheckResult record);
}