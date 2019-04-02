package com.asiainfo.qm.task.dao;

import com.asiainfo.qm.execution.domain.QmVoiceRecord;
import com.asiainfo.qm.task.domain.QmVoice;
import com.asiainfo.qm.task.domain.QmVoiceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QmVoiceMapper {
    int countByExample(QmVoiceExample example);

    int deleteByExample(QmVoiceExample example);

    int deleteByPrimaryKey(String touchId);

    int insert(QmVoice record);

    int insertSelective(QmVoice record);

    List<QmVoice> selectByExample(@Param("example") QmVoiceExample example);

    List<QmVoiceRecord> queryBeyondPlanVoice(QmVoiceRecord record);

    List<QmVoice> selectByExampleForAutoExract(@Param("tableName")String tableName,@Param("example") QmVoiceExample example,@Param("limit")Integer limit);

    QmVoice selectByPrimaryKey(String touchId);

    int updateByExampleSelective(@Param("record") QmVoice record, @Param("example") QmVoiceExample example);

    int updateByExample(@Param("record") QmVoice record, @Param("example") QmVoiceExample example);

    int updateByPrimaryKeySelective(QmVoice record);

    int updateByPrimaryKey(QmVoice record);
}