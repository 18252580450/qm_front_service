package com.asiainfo.qm.task.dao;

import com.asiainfo.qm.task.domain.QmBindRln;
import com.asiainfo.qm.task.domain.QmBindRlnExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface QmBindRlnMapper {
    int countByExample(QmBindRlnExample example);

    int deleteByExample(QmBindRlnExample example);

    int insert(QmBindRln record);

    int insertSelective(QmBindRln record);

    List<QmBindRln> selectByExample(QmBindRlnExample example);

    int updateByExampleSelective(@Param("record") QmBindRln record, @Param("example") QmBindRlnExample example);

    int updateByExample(@Param("record") QmBindRln record, @Param("example") QmBindRlnExample example);

    int deleteByIds(List<Map<String,Object>> list);
}