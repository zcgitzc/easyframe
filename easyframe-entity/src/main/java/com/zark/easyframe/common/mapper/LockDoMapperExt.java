package com.zark.easyframe.common.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zark.easyframe.common.module.LockDo;

@Repository
public interface LockDoMapperExt extends LockDoMapper {
	LockDo getLock(@Param("type") String type, @Param("value") String value);
}