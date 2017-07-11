package com.zark.easyframe.common.mapper;

import com.zark.easyframe.common.module.LockDo;
import com.zark.easyframe.common.module.LockDoExample;
import java.util.List;

public interface LockDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(LockDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(LockDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(LockDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<LockDo> selectByExample(LockDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    LockDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(LockDo record);
}