package com.zark.easyframe.biz.common.bo.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zark.easyframe.biz.common.CommonBusiLogic;
import com.zark.easyframe.biz.common.bo.JobStatusBo;
import com.zark.easyframe.biz.common.constants.CommonConstants;
import com.zark.easyframe.biz.common.constants.JobStatusConstants;
import com.zark.easyframe.common.mapper.JobStatusDoMapperExt;
import com.zark.easyframe.common.module.JobStatusDo;

public class JobStatusBoImpl implements JobStatusBo {

	@Resource
	private JobStatusDoMapperExt jobStatusDoMapperExt;

	@Override
	public JobStatusDo createNewJobStatus(String jobName) {
		JobStatusDo jobStatus = new JobStatusDo();
		jobStatus.setCategory(jobName);
		jobStatus.setStatus(JobStatusConstants.JobStatus.NEW.name());
		jobStatusDoMapperExt.insertSelective(jobStatus);
		return jobStatus;
	}

	@Override
	public void updateJobStatus(JobStatusDo jobStatus) {
		jobStatus.setErrorMessage(CommonBusiLogic.subStringByLength(jobStatus.getErrorMessage(), 4000));
		jobStatusDoMapperExt.updateByPrimaryKeySelective(jobStatus);
	}

	@Override
	public JobStatusDo lockJobStatusByUUId(String uuId) {
		return jobStatusDoMapperExt.lockJobStatusByUUId(uuId);
	}

	@Override
	public JobStatusDo getStatusById(Long id, boolean castException) {
		JobStatusDo jobStatus = jobStatusDoMapperExt.selectByPrimaryKey(id);
		if (castException && CommonConstants.CommonBoolean.Y.name().equals(jobStatus.getHasError())) {
			// throw doCastException(jobStatus);
			return jobStatus;
		}
		return jobStatus;
	}

	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// private RuntimeException doCastException(JobStatusDo jobStatus) {
	// try {
	// Class<?> exceptionClass = Class.forName(jobStatus.getExceptionClass());
	// // 如果是从国际化异常类抛出去的，则实例化为该类，否则以Runtime抛出去
	// if (GwsCommonException.class.isAssignableFrom(exceptionClass)) {
	// GwsErrorCode errorCode = null;
	// Class<?> errorCodeClass =
	// Class.forName(jobStatus.getExceptionCodeClass());
	// if (errorCodeClass.isEnum()) {
	// errorCode = (GwsErrorCode) Enum.valueOf((Class<? extends Enum>)
	// errorCodeClass, jobStatus.getExceptionCodeEnumName());
	// } else {
	// errorCode = (GwsErrorCode) errorCodeClass.newInstance();
	// }
	// GwsCommonException result = new
	// GwsCommonException(jobStatus.getErrorMessage(), errorCode);
	// Map<String, Object> property =
	// JSON.parse(jobStatus.getExceptionProperties(), LinkedHashMap.class);
	// for (Map.Entry<String, Object> entry : property.entrySet()) {
	// result.set(entry.getKey(), entry.getValue());
	// }
	// return result;
	// } else {
	// return new RuntimeException(jobStatus.getErrorMessage());
	// }
	// } catch (Exception e) {
	// throw new RuntimeException("Cast exception error", e);
	// }
	// }

}
