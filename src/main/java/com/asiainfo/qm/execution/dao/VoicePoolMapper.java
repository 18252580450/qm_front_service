package com.asiainfo.qm.execution.dao;

import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.domain.VoicePoolExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface VoicePoolMapper {
    int countByExample(VoicePoolExample example);

    int deleteByExample(VoicePoolExample example);

    int deleteByPrimaryKey(String touchId);

    int insert(VoicePool record);

    int insertSelective(VoicePool record);

    List<VoicePool> selectByExample(VoicePoolExample example);

    VoicePool selectByPrimaryKey(String touchId);

    int updateByExampleSelective(@Param("record") VoicePool record, @Param("example") VoicePoolExample example);

    int updateByExample(@Param("record") VoicePool record, @Param("example") VoicePoolExample example);

    int updateByPrimaryKeySelective(VoicePool record);

    int updateByPrimaryKey(VoicePool record);

    int update(List<String> list);//新增方法

    int updateCheck(List<Map> list);//新增方法

    int updateByTouchId(VoicePool record); //根据语音流水号更新质检状态
}