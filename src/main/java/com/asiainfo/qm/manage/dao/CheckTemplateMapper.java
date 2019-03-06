package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.CheckTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckTemplateMapper {
    int countByExample(CheckTemplateExample example);

    int deleteByExample(CheckTemplateExample example);

    int deleteByPrimaryKey(String templateId);

    int insert(CheckTemplate record);

    int insertSelective(CheckTemplate record);

    List<CheckTemplate> selectByExample(CheckTemplateExample example);

    CheckTemplate selectByPrimaryKey(String templateId);

    int updateByExampleSelective(@Param("record") CheckTemplate record, @Param("example") CheckTemplateExample example);

    int updateByExample(@Param("record") CheckTemplate record, @Param("example") CheckTemplateExample example);

    int updateByPrimaryKeySelective(CheckTemplate record);

    int updateByPrimaryKey(CheckTemplate record);

    int update(List<String> list);//新增方法
    int updateTemplate(List<String> list);//新增方法
    int deleteTemplate(List<String> list);//新增方法
}