package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.AppealProcess;
import com.asiainfo.qm.manage.domain.AppealProcessDetail;
import com.asiainfo.qm.manage.domain.AppealProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppealProcessMapper {
    int countByExample(AppealProcessExample example);

    int deleteByExample(AppealProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(AppealProcess record);

    int insertSelective(AppealProcess record);

    List<AppealProcess> selectByExample(AppealProcessExample example);

    List<AppealProcessDetail> unionSelectByExample(AppealProcessDetail appealProcessDetail);

    AppealProcess selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") AppealProcess record, @Param("example") AppealProcessExample example);

    int updateByExample(@Param("record") AppealProcess record, @Param("example") AppealProcessExample example);

    int updateByPrimaryKeySelective(AppealProcess record);

    int updateByPrimaryKey(AppealProcess record);
}