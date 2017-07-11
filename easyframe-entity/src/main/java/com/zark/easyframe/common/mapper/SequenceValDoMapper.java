package com.zark.easyframe.common.mapper;

import com.zark.easyframe.common.module.SequenceValDo;
import com.zark.easyframe.common.module.SequenceValDoExample;
import java.util.List;

public interface SequenceValDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(SequenceValDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(SequenceValDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(SequenceValDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<SequenceValDo> selectByExample(SequenceValDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    SequenceValDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(SequenceValDo record);
}