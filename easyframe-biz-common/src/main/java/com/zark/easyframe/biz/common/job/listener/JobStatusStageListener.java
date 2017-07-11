package com.zark.easyframe.biz.common.job.listener;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zark.easyframe.biz.common.bo.JobStatusBo;
import com.zark.easyframe.biz.common.constants.JobStatusConstants;
import com.zark.easyframe.biz.common.exception.BizCommonException;
import com.zark.easyframe.biz.common.exception.CommonErrorCode;
import com.zark.easyframe.common.job.JobContext;
import com.zark.easyframe.common.job.JobStageState;
import com.zark.easyframe.common.job.JobState;
import com.zark.easyframe.common.job.listener.JobStageListener;
import com.zark.easyframe.common.module.JobStatusDo;

public class JobStatusStageListener implements JobStageListener {

	@Resource
	private JobStatusBo jobStatusBo;

	@Override
	public String getName() {
		return JobStatusConstants.JobListenerName.STAGE_LISTENER.name();
	}

	@Override
	public void jobStageToBeExecuted(JobContext jobContext) {
		JobStatusDo jobStatus = getJobStatus(jobContext);
		JobState jobState = jobContext.getJobState();
		jobStatus.setCurrentStageNum((jobState.getCurrentStageIndex() + 1));
		jobStatus.setCurrentStage(jobState.getCurrentStage().getName());
		jobStatus.setCurrentDealedNum(0);
		jobStatus.setCurrentTotalNum(1);
		jobStatus.setStatus(JobStatusConstants.JobStatus.EXECUTING.name());
		jobStatusBo.updateJobStatus(jobStatus);
	}

	@Override
	public void jobStageExecuteFail(JobContext context, JobStageState stageState, Exception exception) {
		System.out.println("job stage execute fail");
	}

	@Override
	public void jobStageExecuteSuccess(JobContext jobContext, JobStageState stageState, Object returnVal) {
		JobStatusDo jobStatus = getJobStatus(jobContext);
		jobStatus.setCurrentDealedNum(jobStatus.getCurrentTotalNum());
		jobStatusBo.updateJobStatus(jobStatus);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void jobStageExecuting(JobState jobState, JobStageState stageState) {
		JobStatusDo jobStatus = jobStatusBo.lockJobStatusByUUId(jobState.getJobUUId());
		if (jobStatus == null) {
			throw new BizCommonException("uuid can not found. uuid:" + jobState.getJobUUId(), CommonErrorCode.PARAM_ERROR);
		}
		if (!jobState.getCurrentStage().getName().equals(jobStatus.getCurrentStage()) || JobStatusConstants.JobStatus.FINISHED.name().equals(jobStatus.getStatus())) {
			return;
		}
		jobStatus.setCurrentDealedNum(stageState.getCurrentDealed());
		jobStatus.setCurrentTotalNum(stageState.getSum());
		jobStatusBo.updateJobStatus(jobStatus);
	}

	private JobStatusDo getJobStatus(JobContext jobContext) {
		return (JobStatusDo) jobContext.get(JobStatusConstants.JobSystemParam.JobStatus.getValue());
	}
}
