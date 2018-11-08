package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.CheckItem;
import com.asiainfo.qm.manage.domain.CheckItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckItemMapper {
    int countByExample(CheckItemExample example);

    int deleteByExample(CheckItemExample example);

    int deleteByPrimaryKey(String checkItemId);

    int insert(CheckItem record);

    int insertSelective(CheckItem record);

    List<CheckItem> selectByExample(CheckItemExample example);

    CheckItem selectByPrimaryKey(String checkItemId);

    int updateByExampleSelective(@Param("record") CheckItem record, @Param("example") CheckItemExample example);

    int updateByExample(@Param("record") CheckItem record, @Param("example") CheckItemExample example);

    int updateByPrimaryKeySelective(CheckItem record);

    int updateByPrimaryKey(CheckItem record);
}