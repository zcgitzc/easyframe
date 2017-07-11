package com.zark.easyframe.common.mapper;

import com.zark.easyframe.common.module.JobDo;
import com.zark.easyframe.common.module.JobDoExample;
import java.util.List;

public interface JobDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(JobDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(JobDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(JobDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<JobDo> selectByExample(JobDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    JobDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(JobDo record);
}