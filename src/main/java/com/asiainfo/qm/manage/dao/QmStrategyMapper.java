package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.QmStrategy;
import com.asiainfo.qm.manage.domain.QmStrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QmStrategyMapper {
    int countByExample(QmStrategyExample example);

    int deleteByExample(QmStrategyExample example);

    int deleteByPrimaryKey(String pId);

    int insert(QmStrategy record);

    int insertSelective(QmStrategy record);

    List<QmStrategy> selectByExample(QmStrategyExample example);

    QmStrategy selectByPrimaryKey(String pId);

    int updateByExampleSelective(@Param("record") QmStrategy record, @Param("example") QmStrategyExample example);

    int updateByExample(@Param("record") QmStrategy record, @Param("example") QmStrategyExample example);

    int updateByPrimaryKeySelective(QmStrategy record);

    int updateByPrimaryKey(QmStrategy record);
}