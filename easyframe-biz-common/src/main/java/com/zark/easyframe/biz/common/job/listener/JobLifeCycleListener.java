package com.zark.easyframe.biz.common.job.listener;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.zark.easyframe.biz.common.bo.JobStatusBo;
import com.zark.easyframe.biz.common.constants.CommonConstants;
import com.zark.easyframe.biz.common.constants.JobStatusConstants;
import com.zark.easyframe.biz.common.exception.AbstractBizException;
import com.zark.easyframe.common.job.JobContext;
import com.zark.easyframe.common.job.impl.JobListenerSupport;
import com.zark.easyframe.common.module.JobStatusDo;

public class JobLifeCycleListener extends JobListenerSupport {

	@Resource
	private JobStatusBo jobStatusBo;

	private Logger logger = LoggerFactory.getLogger(JobLifeCycleListener.class);

	@Override
	public String getName() {
		return JobStatusConstants.JobListenerName.LIFE_CYCLE_LISTENER.name();
	}

	@Override
	public void jobToBeExecuted(JobContext jobContext) {
		logger.info("Job {} begin to be executed", jobContext.getJobState().getJobUUId());
		JobStatusDo jobStatus = getJobStatus(jobContext);
		jobStatus.setStartDate(new Date());
		jobStatus.setTotalStageNum(jobContext.getJobState().getAllStages().size());
		jobStatus.setStatus(JobStatusConstants.JobStatus.EXECUTING.name());
		jobStatus.setJobUuid(jobContext.getJobState().getJobUUId());
		jobStatusBo.updateJobStatus(jobStatus);
	}

	@Override
	public void jobExecuteSuccess(JobContext jobContext, Object returnVal) {
		logger.info("Job {} execute success", jobContext.getJobState().getJobUUId());
		JobStatusDo jobStatus = getJobStatus(jobContext);
		setJobStatusToFinished(jobStatus);
		jobStatus.setReturnValue(JSON.toJSONString(returnVal));
		jobStatusBo.updateJobStatus(jobStatus);
	}

	@Override
	public void jobExecuteFail(JobContext jobContext, Exception jobException) {
		logger.info("Job " + jobContext.getJobState().getJobUUId() + " execute failure", jobException);
		JobStatusDo jobStatus = getJobStatus(jobContext);
		setJobStatusToFinished(jobStatus);
		jobStatus.setHasError(CommonConstants.CommonBoolean.Y.name());
		jobStatus.setExceptionClass(jobException.getClass().getName());
		if (jobException instanceof AbstractBizException) {
			AbstractBizException exception = (AbstractBizException) jobException;
			jobStatus.setExceptionProperties(JSON.toJSONString(exception.getProperties()));
			Class<?> errorCodeClass = exception.getErrorCode().getClass();
			jobStatus.setExceptionCodeClass(errorCodeClass.getName());
			if (errorCodeClass.isEnum()) {
				Enum<?> errorCodeEnum = (Enum<?>) exception.getErrorCode();
				jobStatus.setExceptionCodeEnumName(errorCodeEnum.name());
			}
		}
		jobStatusBo.updateJobStatus(jobStatus);
	}

	@Override
	public void jobFinish(JobContext jobContext) {
		logger.info("Job {} is finished ", jobContext.getJobState().getJobUUId());
	}

	private void setJobStatusToFinished(JobStatusDo jobStatus) {
		jobStatus.setCurrentDealedNum(jobStatus.getCurrentTotalNum());
		jobStatus.setFinshDate(new Date());
		jobStatus.setStatus(JobStatusConstants.JobStatus.FINISHED.name());
	}

	private JobStatusDo getJobStatus(JobContext jobContext) {
		return (JobStatusDo) jobContext.get(JobStatusConstants.JobSystemParam.JobStatus.getValue());
	}
}
