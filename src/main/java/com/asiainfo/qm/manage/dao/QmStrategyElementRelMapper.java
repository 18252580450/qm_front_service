package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.QmStrategyElementRel;
import com.asiainfo.qm.manage.domain.QmStrategyElementRelExample;
import com.asiainfo.qm.manage.domain.QmStrategyElementRelKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QmStrategyElementRelMapper {
    int countByExample(QmStrategyElementRelExample example);

    int deleteByExample(QmStrategyElementRelExample example);

    int deleteByPrimaryKey(QmStrategyElementRelKey key);

    int insert(QmStrategyElementRel record);

    int insertSelective(QmStrategyElementRel record);

    List<QmStrategyElementRel> selectByExample(QmStrategyElementRelExample example);

    QmStrategyElementRel selectByPrimaryKey(QmStrategyElementRelKey key);

    int updateByExampleSelective(@Param("record") QmStrategyElementRel record, @Param("example") QmStrategyElementRelExample example);

    int updateByExample(@Param("record") QmStrategyElementRel record, @Param("example") QmStrategyElementRelExample example);

    int updateByPrimaryKeySelective(QmStrategyElementRel record);

    int updateByPrimaryKey(QmStrategyElementRel record);
}