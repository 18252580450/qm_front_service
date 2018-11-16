package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.QmPlan;
import com.asiainfo.qm.manage.domain.QmPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QmPlanMapper {
    int countByExample(QmPlanExample example);

    int deleteByExample(QmPlanExample example);

    int deleteByPrimaryKey(String planId);

    int insert(QmPlan record);

    int insertSelective(QmPlan record);

    List<QmPlan> selectByExample(QmPlanExample example);

    QmPlan selectByPrimaryKey(String planId);

    int updateByExampleSelective(@Param("record") QmPlan record, @Param("example") QmPlanExample example);

    int updateByExample(@Param("record") QmPlan record, @Param("example") QmPlanExample example);

    int updateByPrimaryKeySelective(QmPlan record);

    int updateByPrimaryKey(QmPlan record);
}