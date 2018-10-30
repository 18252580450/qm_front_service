package com.asiainfo.qm.manage.dao;

import com.asiainfo.qm.manage.domain.DemoUser;

public interface DemoUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DemoUser record);

    int insertSelective(DemoUser record);

    DemoUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DemoUser record);

    int updateByPrimaryKey(DemoUser record);
}