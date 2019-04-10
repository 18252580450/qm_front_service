package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.TypicalCase;
import com.asiainfo.qm.manage.domain.TypicalCaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypicalCaseMapper {
    int countByExample(TypicalCaseExample example);

    int deleteByExample(TypicalCaseExample example);

    int deleteByPrimaryKey(String caseId);

    int insert(TypicalCase record);

    int insertSelective(TypicalCase record);

    List<TypicalCase> selectByExample(TypicalCaseExample example);

    List<TypicalCase> voiceUnionSelectByExample(TypicalCaseExample example);

    List<TypicalCase> orderUnionSelectByExample(TypicalCaseExample example);

    List<TypicalCase> selectByCaseType(TypicalCaseExample example);

    TypicalCase selectByPrimaryKey(String caseId);

    int updateByExampleSelective(@Param("record") TypicalCase record, @Param("example") TypicalCaseExample example);

    int updateByExample(@Param("record") TypicalCase record, @Param("example") TypicalCaseExample example);

    int updateByPrimaryKeySelective(TypicalCase record);

    int updateByPrimaryKey(TypicalCase record);
}