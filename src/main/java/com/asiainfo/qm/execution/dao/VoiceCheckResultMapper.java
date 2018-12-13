package com.asiainfo.qm.execution.dao;

import com.asiainfo.qm.execution.domain.VoiceCheckResult;
import com.asiainfo.qm.execution.domain.VoiceCheckResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoiceCheckResultMapper {
    int countByExample(VoiceCheckResultExample example);

    int deleteByExample(VoiceCheckResultExample example);

    int deleteByPrimaryKey(String inspectionId);

    int insert(VoiceCheckResult record);

    int insertSelective(VoiceCheckResult record);

    List<VoiceCheckResult> selectByExample(VoiceCheckResultExample example);

    VoiceCheckResult selectByPrimaryKey(String inspectionId);

    int updateByExampleSelective(@Param("record") VoiceCheckResult record, @Param("example") VoiceCheckResultExample example);

    int updateByExample(@Param("record") VoiceCheckResult record, @Param("example") VoiceCheckResultExample example);

    int updateByPrimaryKeySelective(VoiceCheckResult record);

    int updateByPrimaryKey(VoiceCheckResult record);
}