package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.StaticParams;
import com.asiainfo.qm.manage.domain.StaticParamsExample;
import com.asiainfo.qm.manage.domain.StaticParamsKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaticParamsMapper {

    //批量删除
    int deleteByIdList(List<String> ids);

    int countByExample(StaticParamsExample example);

    int deleteByExample(StaticParamsExample example);

    int deleteByPrimaryKey(StaticParamsKey key);

    int insert(StaticParams record);

    int insertSelective(StaticParams record);

    List<StaticParams> selectByExample(StaticParamsExample example);

    StaticParams selectByPrimaryKey(StaticParamsKey key);

    int updateByExampleSelective(@Param("record") StaticParams record, @Param("example") StaticParamsExample example);

    int updateByExample(@Param("record") StaticParams record, @Param("example") StaticParamsExample example);

    int updateByPrimaryKeySelective(StaticParams record);

    int updateByPrimaryKey(StaticParams record);
}