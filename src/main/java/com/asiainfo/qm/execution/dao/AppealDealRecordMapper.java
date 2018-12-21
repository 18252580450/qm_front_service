package com.asiainfo.qm.execution.dao;

import com.asiainfo.qm.execution.domain.AppealDealRecord;
import com.asiainfo.qm.execution.domain.AppealDealRecordExample;
import com.asiainfo.qm.execution.domain.AppealDealRecordKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppealDealRecordMapper {
    int countByExample(AppealDealRecordExample example);

    int deleteByExample(AppealDealRecordExample example);

    int deleteByPrimaryKey(AppealDealRecordKey key);

    int insert(AppealDealRecord record);

    int insertSelective(AppealDealRecord record);

    List<AppealDealRecord> selectByExample(AppealDealRecordExample example);

    AppealDealRecord selectByPrimaryKey(AppealDealRecordKey key);

    int updateByExampleSelective(@Param("record") AppealDealRecord record, @Param("example") AppealDealRecordExample example);

    int updateByExample(@Param("record") AppealDealRecord record, @Param("example") AppealDealRecordExample example);

    int updateByPrimaryKeySelective(AppealDealRecord record);

    int updateByPrimaryKey(AppealDealRecord record);
}