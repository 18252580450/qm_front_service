package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.TemplateDetail;
import com.asiainfo.qm.manage.domain.TemplateDetailExample;
import com.asiainfo.qm.manage.domain.TemplateDetailKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TemplateDetailMapper {
    int countByExample(TemplateDetailExample example);

    int deleteByExample(TemplateDetailExample example);

    int deleteByPrimaryKey(TemplateDetailKey key);

    int insert(TemplateDetail record);

    int insertSelective(TemplateDetail record);

    List<TemplateDetail> selectByExample(TemplateDetailExample example);

    TemplateDetail selectByPrimaryKey(TemplateDetailKey key);

    int updateByExampleSelective(@Param("record") TemplateDetail record, @Param("example") TemplateDetailExample example);

    int updateByExample(@Param("record") TemplateDetail record, @Param("example") TemplateDetailExample example);

    int updateByPrimaryKeySelective(TemplateDetail record);

    int updateByPrimaryKey(TemplateDetail record);

    int update(List<Map> list);//新增方法
}