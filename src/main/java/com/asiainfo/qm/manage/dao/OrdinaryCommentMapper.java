package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.OrdinaryComment;
import com.asiainfo.qm.manage.domain.OrdinaryCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdinaryCommentMapper {
    int countByExample(OrdinaryCommentExample example);

    int deleteByExample(OrdinaryCommentExample example);

    //通过主键进行删除,这里最多只会删除一条数据
    //单个字段做主键时,可以直接写主键的值
   //联合主键时,key可以是实体类,也可以是Map
    int deleteByPrimaryKey(String commentId);

    int insert(OrdinaryComment record);

    int insertSelective(OrdinaryComment record);

    List<OrdinaryComment> selectByExample(OrdinaryCommentExample example);

    OrdinaryComment selectByPrimaryKey(String commentId);

    int updateByExampleSelective(@Param("record") OrdinaryComment record, @Param("example") OrdinaryCommentExample example);

    int updateByExample(@Param("record") OrdinaryComment record, @Param("example") OrdinaryCommentExample example);

    //根据主键进行更新
//只会更新不是null的数据
    int updateByPrimaryKeySelective(OrdinaryComment record);

    //根据主键进行更新,这里最多只会更新一条数据
   //参数为实体类
    int updateByPrimaryKey(OrdinaryComment record);
}