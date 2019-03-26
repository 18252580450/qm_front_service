package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.UserPermission;
import com.asiainfo.qm.manage.domain.UserPermissionExample;
import com.asiainfo.qm.manage.domain.UserPermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPermissionMapper {
    int countByExample(UserPermissionExample example);

    int deleteByExample(UserPermissionExample example);

    int deleteByPrimaryKey(UserPermissionKey key);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    List<UserPermission> selectByExample(UserPermissionExample example);

    UserPermission selectByPrimaryKey(UserPermissionKey key);

    int updateByExampleSelective(@Param("record") UserPermission record, @Param("example") UserPermissionExample example);

    int updateByExample(@Param("record") UserPermission record, @Param("example") UserPermissionExample example);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);

    List<UserPermission> qryUserPermission(List list);
}