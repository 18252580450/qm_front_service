package com.asiainfo.qm.execution.dao;

import com.asiainfo.qm.execution.domain.Pool;
import com.asiainfo.qm.execution.domain.PoolExample;
import com.asiainfo.qm.execution.domain.PoolKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoolMapper {
    int countByExample(PoolExample example);

    int deleteByExample(PoolExample example);

    int deleteByPrimaryKey(PoolKey key);

    int insert(Pool record);

    int insertSelective(Pool record);

    List<Pool> selectByExample(PoolExample example);

    Pool selectByPrimaryKey(PoolKey key);

    int updateByExampleSelective(@Param("record") Pool record, @Param("example") PoolExample example);

    int updateByExample(@Param("record") Pool record, @Param("example") PoolExample example);

    int updateByPrimaryKeySelective(Pool record);

    int updateByPrimaryKey(Pool record);
}