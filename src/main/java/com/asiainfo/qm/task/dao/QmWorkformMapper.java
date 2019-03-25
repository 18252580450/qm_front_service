package com.asiainfo.qm.task.dao;

import com.asiainfo.qm.execution.domain.QmWorkForm;
import com.asiainfo.qm.task.domain.QmWorkform;
import com.asiainfo.qm.task.domain.QmWorkformExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QmWorkformMapper {
    int countByExample(QmWorkformExample example);

    int deleteByExample(QmWorkformExample example);

    int deleteByPrimaryKey(Long wrkfmId);

    int insert(QmWorkform record);

    int insertSelective(QmWorkform record);

    List<QmWorkform> selectByExample(QmWorkformExample example);

    List<QmWorkForm> queryBeyondPlanWorkForm(QmWorkForm record);

    QmWorkform selectByPrimaryKey(Long wrkfmId);

    int updateByExampleSelective(@Param("record") QmWorkform record, @Param("example") QmWorkformExample example);

    List<QmWorkform> selectByExampleForAutoExract(@Param("tableName")String tableName,@Param("example") QmWorkformExample example,@Param("limit")Integer limit);

    int updateByExample(@Param("record") QmWorkform record, @Param("example") QmWorkformExample example);

    int updateByPrimaryKeySelective(QmWorkform record);

    int updateByPrimaryKey(QmWorkform record);
}