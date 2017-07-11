package com.zark.easyframe.common.mapper;

import com.zark.easyframe.common.module.JobStatusDo;
import com.zark.easyframe.common.module.JobStatusDoExample;
import java.util.List;

public interface JobStatusDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(JobStatusDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(JobStatusDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(JobStatusDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<JobStatusDo> selectByExample(JobStatusDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    JobStatusDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(JobStatusDo record);
}