package com.asiainfo.qm.task.dao;

import com.asiainfo.qm.task.domain.QmBindRln;
import com.asiainfo.qm.task.domain.QmBindRlnExample;
import com.asiainfo.qm.task.domain.QmBindRlnKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QmBindRlnMapper {
    int countByExample(QmBindRlnExample example);

    int deleteByExample(QmBindRlnExample example);

    int deleteByPrimaryKey(QmBindRlnKey key);

    int insert(QmBindRln record);

    int insertSelective(QmBindRln record);

    List<QmBindRln> selectByExample(QmBindRlnExample example);

    QmBindRln selectByPrimaryKey(QmBindRlnKey key);

    int updateByExampleSelective(@Param("record") QmBindRln record, @Param("example") QmBindRlnExample example);

    int updateByExample(@Param("record") QmBindRln record, @Param("example") QmBindRlnExample example);

    int updateByPrimaryKeySelective(QmBindRln record);

    int updateByPrimaryKey(QmBindRln record);
}