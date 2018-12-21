package com.asiainfo.qm.execution.dao;

import com.asiainfo.qm.execution.domain.AppealDealProcess;
import com.asiainfo.qm.execution.domain.AppealDealProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppealDealProcessMapper {
    int countByExample(AppealDealProcessExample example);

    int deleteByExample(AppealDealProcessExample example);

    int deleteByPrimaryKey(String appealId);

    int insert(AppealDealProcess record);

    int insertSelective(AppealDealProcess record);

    List<AppealDealProcess> selectByExample(AppealDealProcessExample example);

    AppealDealProcess selectByPrimaryKey(String appealId);

    int updateByExampleSelective(@Param("record") AppealDealProcess record, @Param("example") AppealDealProcessExample example);

    int updateByExample(@Param("record") AppealDealProcess record, @Param("example") AppealDealProcessExample example);

    int updateByPrimaryKeySelective(AppealDealProcess record);

    int updateByPrimaryKey(AppealDealProcess record);
}