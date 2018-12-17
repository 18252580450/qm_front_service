package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.VoiceCheckResultDetail;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetailExample;
import com.asiainfo.qm.manage.domain.VoiceCheckResultDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoiceCheckResultDetailMapper {
    int countByExample(VoiceCheckResultDetailExample example);

    int deleteByExample(VoiceCheckResultDetailExample example);

    int deleteByPrimaryKey(VoiceCheckResultDetailKey key);

    int insert(VoiceCheckResultDetail record);

    int insertSelective(VoiceCheckResultDetail record);

    List<VoiceCheckResultDetail> selectByExample(VoiceCheckResultDetailExample example);

    VoiceCheckResultDetail selectByPrimaryKey(VoiceCheckResultDetailKey key);

    int updateByExampleSelective(@Param("record") VoiceCheckResultDetail record, @Param("example") VoiceCheckResultDetailExample example);

    int updateByExample(@Param("record") VoiceCheckResultDetail record, @Param("example") VoiceCheckResultDetailExample example);

    int updateByPrimaryKeySelective(VoiceCheckResultDetail record);

    int updateByPrimaryKey(VoiceCheckResultDetail record);
}