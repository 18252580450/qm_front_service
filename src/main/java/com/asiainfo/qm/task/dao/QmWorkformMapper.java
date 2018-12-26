package com.asiainfo.qm.task.dao;

import com.asiainfo.qm.task.domain.QmWorkform;
import com.asiainfo.qm.task.domain.QmWorkformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QmWorkformMapper {
    int countByExample(QmWorkformExample example);

    int deleteByExample(QmWorkformExample example);

    int deleteByPrimaryKey(Long wrkfmId);

    int insert(QmWorkform record);

    int insertSelective(QmWorkform record);

    List<QmWorkform> selectByExample(QmWorkformExample example);

    QmWorkform selectByPrimaryKey(Long wrkfmId);

    int updateByExampleSelective(@Param("record") QmWorkform record, @Param("example") QmWorkformExample example);

    int updateByExample(@Param("record") QmWorkform record, @Param("example") QmWorkformExample example);

    int updateByPrimaryKeySelective(QmWorkform record);

    int updateByPrimaryKey(QmWorkform record);
}