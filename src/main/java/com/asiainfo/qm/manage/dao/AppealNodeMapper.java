package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.AppealNode;
import com.asiainfo.qm.manage.domain.AppealNodeExample;
import com.asiainfo.qm.manage.domain.AppealNodeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppealNodeMapper {
    int countByExample(AppealNodeExample example);

    int deleteByExample(AppealNodeExample example);

    int deleteByPrimaryKey(AppealNodeKey key);

    int insert(AppealNode record);

    int insertSelective(AppealNode record);

    List<AppealNode> selectByExample(AppealNodeExample example);

    AppealNode selectByPrimaryKey(AppealNodeKey key);

    int updateByExampleSelective(@Param("record") AppealNode record, @Param("example") AppealNodeExample example);

    int updateByExample(@Param("record") AppealNode record, @Param("example") AppealNodeExample example);

    int updateByPrimaryKeySelective(AppealNode record);

    int updateByPrimaryKey(AppealNode record);
}