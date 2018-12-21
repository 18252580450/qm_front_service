package com.asiainfo.qm.execution.dao;

import com.asiainfo.qm.execution.domain.AppealDealProcessRecord;
import com.asiainfo.qm.execution.domain.AppealDealProcessRecordExample;
import com.asiainfo.qm.execution.domain.AppealDealProcessRecordKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppealDealProcessRecordMapper {
    int countByExample(AppealDealProcessRecordExample example);

    int deleteByExample(AppealDealProcessRecordExample example);

    int deleteByPrimaryKey(AppealDealProcessRecordKey key);

    int insert(AppealDealProcessRecord record);

    int insertSelective(AppealDealProcessRecord record);

    List<AppealDealProcessRecord> selectByExample(AppealDealProcessRecordExample example);

    AppealDealProcessRecord selectByPrimaryKey(AppealDealProcessRecordKey key);

    int updateByExampleSelective(@Param("record") AppealDealProcessRecord record, @Param("example") AppealDealProcessRecordExample example);

    int updateByExample(@Param("record") AppealDealProcessRecord record, @Param("example") AppealDealProcessRecordExample example);

    int updateByPrimaryKeySelective(AppealDealProcessRecord record);

    int updateByPrimaryKey(AppealDealProcessRecord record);
}