package com.zark.easyframe.common.mapper;

import com.zark.easyframe.common.module.UserDo;
import com.zark.easyframe.common.module.UserDoExample;
import java.util.List;

public interface UserDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(UserDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(UserDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(UserDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<UserDo> selectByExample(UserDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    UserDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(UserDo record);
}