package com.zark.easyframe.common.mapper;

import com.zark.easyframe.common.module.OperLogDo;
import com.zark.easyframe.common.module.OperLogDoExample;
import java.util.List;

public interface OperLogDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(OperLogDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(OperLogDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(OperLogDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<OperLogDo> selectByExample(OperLogDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    OperLogDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(OperLogDo record);
}