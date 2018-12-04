package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.QmStrategyElement;
import com.asiainfo.qm.manage.domain.QmStrategyElementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QmStrategyElementMapper {
    int countByExample(QmStrategyElementExample example);

    int deleteByExample(QmStrategyElementExample example);

    int deleteByPrimaryKey(String elementId);

    int insert(QmStrategyElement record);

    int insertSelective(QmStrategyElement record);

    List<QmStrategyElement> selectByExample(QmStrategyElementExample example);

    QmStrategyElement selectByPrimaryKey(String elementId);

    int updateByExampleSelective(@Param("record") QmStrategyElement record, @Param("example") QmStrategyElementExample example);

    int updateByExample(@Param("record") QmStrategyElement record, @Param("example") QmStrategyElementExample example);

    int updateByPrimaryKeySelective(QmStrategyElement record);

    int updateByPrimaryKey(QmStrategyElement record);
}