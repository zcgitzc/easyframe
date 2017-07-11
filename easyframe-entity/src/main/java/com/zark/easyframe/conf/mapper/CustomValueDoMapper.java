package com.zark.easyframe.conf.mapper;

import com.zark.easyframe.conf.module.CustomValueDo;
import com.zark.easyframe.conf.module.CustomValueDoExample;
import java.util.List;

public interface CustomValueDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(CustomValueDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(CustomValueDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(CustomValueDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<CustomValueDo> selectByExample(CustomValueDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    CustomValueDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(CustomValueDo record);
}