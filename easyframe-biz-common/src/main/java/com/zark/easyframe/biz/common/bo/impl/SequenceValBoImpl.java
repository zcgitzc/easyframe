package com.zark.easyframe.biz.common.bo.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.zark.easyframe.biz.common.bo.LockBo;
import com.zark.easyframe.biz.common.bo.SequenceValBo;
import com.zark.easyframe.common.mapper.SequenceValDoMapperExt;
import com.zark.easyframe.common.module.SequenceValDo;
import com.zark.easyframe.common.module.SequenceValDoExample;

public class SequenceValBoImpl implements SequenceValBo {

	@Resource
	private SequenceValDoMapperExt sequenceValMapperExt;

	@Resource
	private LockBo locksBo;

	private static final String LOCK_VALUE = "COMMON_FOR_SEQUENCE";

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long getNextVal(final String sequenceName) {
		SequenceValDo sequenceValDo = doLockSequence(sequenceName);
		if (sequenceValDo == null) {
			doCreateIfNotExists(sequenceName);
			sequenceValDo = doLockSequence(sequenceName);
		}
		sequenceValDo.setCurrVal(sequenceValDo.getCurrVal() + 1);
		doUpdateSequence(sequenceValDo);
		return sequenceValDo.getCurrVal();
	}

	/**
	 * 由于存在并发，因此在上锁后再检查一次，如果存在就忽略，否则做插入
	 * 
	 * @param sequenceName
	 *            序列名称
	 */
	private void doCreateIfNotExists(String sequenceName) {
		locksBo.lock(LOCK_VALUE, LOCK_VALUE);
		if (isSequenceExists(sequenceName)) {
			return;
		}
		doCreateSequence(sequenceName);
	}

	private boolean isSequenceExists(String sequenceName) {
		SequenceValDoExample example = new SequenceValDoExample();
		example.createCriteria().andSequenceNameEqualTo(sequenceName);
		return sequenceValMapperExt.countByExample(example) > 0;
	}

	private void doCreateSequence(String sequenceName) {
		SequenceValDo sequenceValDo = new SequenceValDo();
		sequenceValDo.setSequenceName(sequenceName);
		sequenceValDo.setCurrVal(0L);
		sequenceValMapperExt.insertSelective(sequenceValDo);
	}

	private void doUpdateSequence(SequenceValDo sequenceVal) {
		Assert.notNull(sequenceVal);
		sequenceValMapperExt.updateByPrimaryKeySelective(sequenceVal);
	}

	private SequenceValDo doLockSequence(String sequenceName) {
		return sequenceValMapperExt.lockSequenceByTypeAndKey(sequenceName);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long getNextBatchVal(String sequenceName, int batchSize) {
		SequenceValDo sequenceValDo = doLockSequence(sequenceName);
		if (sequenceValDo == null) {
			doCreateIfNotExists(sequenceName);
			sequenceValDo = doLockSequence(sequenceName);
		}
		long currentValue = sequenceValDo.getCurrVal();
		sequenceValDo.setCurrVal(sequenceValDo.getCurrVal() + batchSize);
		doUpdateSequence(sequenceValDo);
		return currentValue;
	}

}
