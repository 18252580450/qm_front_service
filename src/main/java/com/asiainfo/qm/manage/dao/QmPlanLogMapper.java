package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.QmPlanLog;
import com.asiainfo.qm.manage.domain.QmPlanLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QmPlanLogMapper {
    int countByExample(QmPlanLogExample example);

    int deleteByExample(QmPlanLogExample example);

    int deleteByPrimaryKey(String operateId);

    int insert(QmPlanLog record);

    int insertSelective(QmPlanLog record);

    List<QmPlanLog> selectByExample(QmPlanLogExample example);

    QmPlanLog selectByPrimaryKey(String operateId);

    int updateByExampleSelective(@Param("record") QmPlanLog record, @Param("example") QmPlanLogExample example);

    int updateByExample(@Param("record") QmPlanLog record, @Param("example") QmPlanLogExample example);

    int updateByPrimaryKeySelective(QmPlanLog record);

    int updateByPrimaryKey(QmPlanLog record);
}