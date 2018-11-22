package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.TplOpLog;
import com.asiainfo.qm.manage.domain.TplOpLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TplOpLogMapper {
    int countByExample(TplOpLogExample example);

    int deleteByExample(TplOpLogExample example);

    int deleteByPrimaryKey(String operateId);

    int insert(TplOpLog record);

    int insertSelective(TplOpLog record);

    List<TplOpLog> selectByExample(TplOpLogExample example);

    TplOpLog selectByPrimaryKey(String operateId);

    int updateByExampleSelective(@Param("record") TplOpLog record, @Param("example") TplOpLogExample example);

    int updateByExample(@Param("record") TplOpLog record, @Param("example") TplOpLogExample example);

    int updateByPrimaryKeySelective(TplOpLog record);

    int updateByPrimaryKey(TplOpLog record);
}