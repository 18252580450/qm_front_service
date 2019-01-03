package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.VoiceCheckResult;
import com.asiainfo.qm.manage.domain.VoiceCheckResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoiceCheckResultMapper {
    int countByExample(VoiceCheckResultExample example);

    int deleteByExample(VoiceCheckResultExample example);

    int deleteByPrimaryKey(String inspectionId);

    int insert(VoiceCheckResult record);

    int insertSelective(VoiceCheckResult record);

    List<VoiceCheckResult> selectByExample(VoiceCheckResultExample example);

    List<VoiceCheckResult> queryFirstInspectionId(VoiceCheckResult voiceCheckResult);  //查询首次质检流水号

    VoiceCheckResult selectByPrimaryKey(String inspectionId);

    int updateByExampleSelective(@Param("record") VoiceCheckResult record, @Param("example") VoiceCheckResultExample example);

    int updateByExample(@Param("record") VoiceCheckResult record, @Param("example") VoiceCheckResultExample example);

    int updateByPrimaryKeySelective(VoiceCheckResult record);

    int updateByPrimaryKey(VoiceCheckResult record);

    int resetLastResultFlag(VoiceCheckResult record);   //重置之前质检的最新质检结果标志
}