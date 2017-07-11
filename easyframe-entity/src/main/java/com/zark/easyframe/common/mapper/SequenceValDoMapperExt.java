package com.zark.easyframe.common.mapper;

import org.springframework.stereotype.Repository;

import com.zark.easyframe.common.module.SequenceValDo;

@Repository
public interface SequenceValDoMapperExt extends SequenceValDoMapper {

	SequenceValDo lockSequenceByTypeAndKey(String sequenceName);
	
}