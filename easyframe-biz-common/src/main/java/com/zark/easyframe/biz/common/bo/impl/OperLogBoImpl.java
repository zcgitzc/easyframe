package com.zark.easyframe.biz.common.bo.impl;

import javax.annotation.Resource;

import com.zark.easyframe.biz.common.bo.OperLogBo;
import com.zark.easyframe.common.mapper.OperLogDoMapperExt;
import com.zark.easyframe.common.module.OperLogDo;

public class OperLogBoImpl implements OperLogBo {
	@Resource
	private OperLogDoMapperExt operLogDoMapperExt;

	@Override
	public void addOperLog(OperLogDo operLogDo) {
		operLogDoMapperExt.insertSelective(operLogDo);
	}

}
