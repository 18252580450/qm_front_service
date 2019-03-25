package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.TemplateDetail;
import com.asiainfo.qm.manage.domain.TemplateDetailExample;
import com.asiainfo.qm.manage.domain.TemplateDetailKey;
import java.util.List;
import java.util.Map;

import com.asiainfo.qm.manage.domain.CheckItemDetail;
import org.apache.ibatis.annotations.Param;

public interface TemplateDetailMapper {
    int countByExample(TemplateDetailExample example);

    int deleteByExample(TemplateDetailExample example);

    int deleteByPrimaryKey(TemplateDetailKey key);

    int insert(TemplateDetail record);

    int insertSelective(TemplateDetail record);

    List<TemplateDetail> selectByExample(TemplateDetailExample example);

    List<CheckItemDetail> qryCheckItemByPlanId(CheckItemDetail checkItemDetail);

    List<CheckItemDetail> qryCheckItemByTemplateId(CheckItemDetail checkItemDetail);

//    TemplateDetail selectByPrimaryKey(TemplateDetailKey key);

    int updateByExampleSelective(@Param("record") TemplateDetail record, @Param("example") TemplateDetailExample example);

    int updateByExample(@Param("record") TemplateDetail record, @Param("example") TemplateDetailExample example);

    int updateByPrimaryKeySelective(TemplateDetail record);

    int updateByPrimaryKey(TemplateDetail record);

    int update(Map map);//新增方法
    List<TemplateDetail> selectByPrimaryKey(TemplateDetailKey templateDetailKey);//新增方法
    int deleteDetail(List<String> list);//新增方法

}