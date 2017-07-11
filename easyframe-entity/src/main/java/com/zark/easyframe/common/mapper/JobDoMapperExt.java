package com.zark.easyframe.common.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zark.easyframe.common.module.JobDo;

@Repository
public interface JobDoMapperExt extends JobDoMapper {
	JobDo queryByGroupAndName(@Param("groupName") String groupName, @Param("jobName") String jobName);

	JobDo lockById(@Param("id") Long id);
}