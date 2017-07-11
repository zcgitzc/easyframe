package com.zark.easyframe.common.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zark.easyframe.common.module.JobStatusDo;

@Repository
public interface JobStatusDoMapperExt extends JobStatusDoMapper {

	JobStatusDo lockJobStatusByUUId(@Param("uuId") String uuId);
}