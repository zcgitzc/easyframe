package com.zark.easyframe.biz.common.bo.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.zark.easyframe.biz.common.bo.JobBo;
import com.zark.easyframe.biz.common.bo.LockBo;
import com.zark.easyframe.biz.common.constants.JobConstants;
import com.zark.easyframe.biz.common.constants.LockConstants;
import com.zark.easyframe.biz.common.exception.BizCommonException;
import com.zark.easyframe.biz.common.exception.CommonErrorCode;
import com.zark.easyframe.biz.common.quartz.QuartzManager;
import com.zark.easyframe.common.mapper.JobDoMapperExt;
import com.zark.easyframe.common.module.JobDo;
import com.zark.easyframe.common.module.JobDoExample;

public class JobBoImpl implements JobBo {
	private Logger logger = LoggerFactory.getLogger(JobBoImpl.class);

	@Resource
	private JobDoMapperExt jobDoMapperExt;
	@Resource
	private QuartzManager quartzManager;
	@Resource
	private LockBo lockBo;

	@Override
	public void addJob(JobDo jobDo) {
		Assert.notNull(jobDo, "addJob : jobDo can not be null");
		Assert.notNull(jobDo.getCronExpression(), "addJob : cronExpression can not be null");
		Assert.notNull(jobDo.getTriggerClass(), "addJob : triggerClass can not be null");
		Assert.notNull(jobDo.getJobName(), "addJob : jobName can not be null");
		Assert.notNull(jobDo.getJobGroup(), "addJob : jobGroup can not be null");

		lockBo.lock(LockConstants.LockType.ADD_JOB.name(), jobDo.getJobGroup() + "_" + jobDo.getJobName());
		JobDo dbJob = jobDoMapperExt.queryByGroupAndName(jobDo.getJobGroup(), jobDo.getJobName());

		if (dbJob != null) {
			throw new BizCommonException(String.format("job jobGroup : %s ,jobName : %s is exists", jobDo.getJobGroup(), jobDo.getJobName()), CommonErrorCode.JOB_EXISTS).set("jobGroup", jobDo.getJobGroup()).set(
					"jobName", jobDo.getJobName());
		}
		jobDo.setJobStatus(JobConstants.JobStatus.WAIT_START.name());
		try {
			quartzManager.initJob(jobDo, Class.forName(jobDo.getTriggerClass()));
		} catch (ClassNotFoundException e) {
			throw new BizCommonException("class not found : triggerClass:" + jobDo.getTriggerClass(), CommonErrorCode.CLASS_NOT_FOUND).set("triggerClass", jobDo.getTriggerClass());
		}
		jobDoMapperExt.insertSelective(jobDo);
	}

	@Override
	public void pauseJob(Long id) {
		Assert.notNull(id, "pauseJob : job id can not be null");
		JobDo jobDo = jobDoMapperExt.lockById(id);
		if (!JobConstants.JobStatus.WAIT_START.name().equals(jobDo.getJobStatus())) {
			throw new BizCommonException("only starting job can pause. job id : " + id, CommonErrorCode.PAUSE_JOB_STATUS_ERROR);
		}
		jobDo.setJobStatus(JobConstants.JobStatus.PAUSE.name());
		quartzManager.pauseJob(jobDo);
		jobDoMapperExt.updateByPrimaryKeySelective(jobDo);
	}

	@Override
	public void resumeJob(Long id) {
		Assert.notNull(id, "resumeJob : job id can not be null");
		JobDo jobDo = jobDoMapperExt.lockById(id);
		if (!JobConstants.JobStatus.WAIT_START.name().equals(jobDo.getJobStatus())) {
			throw new BizCommonException("only pause job can resume. job id : " + id, CommonErrorCode.RESUME_JOB_STATUS_ERROR);
		}
		jobDo.setJobStatus(JobConstants.JobStatus.STARTING.name());
		quartzManager.resumeJob(jobDo);
		jobDoMapperExt.updateByPrimaryKeySelective(jobDo);
	}

	@Override
	public void deleteJob(Long id) {
		Assert.notNull(id, "deleteJob : job id can not be null");
		JobDo jobDo = jobDoMapperExt.lockById(id);
		jobDo.setJobStatus(JobConstants.JobStatus.DELETED.name());
		quartzManager.deleteJob(jobDo);
		jobDoMapperExt.updateByPrimaryKeySelective(jobDo);
	}

	@Override
	public void startJob(Long id) {
		Assert.notNull(id, "startJob : job id can not be null");
		JobDo jobDo = jobDoMapperExt.lockById(id);
		if (!JobConstants.JobStatus.WAIT_START.name().equals(jobDo.getJobStatus())) {
			throw new BizCommonException("only wait start job can start. job id : " + id, CommonErrorCode.START_JOB_STATUS_ERROR);
		}
		jobDo.setJobStatus(JobConstants.JobStatus.STARTING.name());
		quartzManager.runJob(jobDo);
		jobDoMapperExt.updateByPrimaryKeySelective(jobDo);
	}

	@Override
	public void updateJob(JobDo jobDo) {
		Assert.notNull(jobDo, "updateJob : jobDo can not be null");
		Assert.notNull(jobDo.getId(), "updateJob : job id can not be null");
		Assert.notNull(jobDo.getCronExpression(), "updateJob : cronExpression can not be null");
		JobDo dbJob = jobDoMapperExt.lockById(jobDo.getId());
		quartzManager.updateQuartzJob(dbJob, jobDo.getCronExpression());
		// 原来任务如果是暂停的话，修改之后会被重新启动
		if (JobConstants.JobStatus.PAUSE.name().equals(dbJob.getJobStatus())) {
			dbJob.setJobStatus(JobConstants.JobStatus.STARTING.name());
			jobDoMapperExt.updateByPrimaryKeySelective(jobDo);
		}
	}

	@Override
	public List<JobDo> queryAll() {
		return jobDoMapperExt.selectByExample(new JobDoExample());
	}

	@PostConstruct
	public void initDbJob() {
		List<JobDo> jobDos = this.queryAll();
		for (JobDo jobDo : jobDos) {
			if (JobConstants.JobStatus.WAIT_START.name().equals(jobDo.getJobStatus()) || JobConstants.JobStatus.STARTING.name().equals(jobDo.getJobStatus())
					|| JobConstants.JobStatus.PAUSE.name().equals(jobDo.getJobStatus())) {
				try {
					quartzManager.initJob(jobDo, Class.forName(jobDo.getTriggerClass()));
				} catch (ClassNotFoundException e) {
					logger.info("exists db job start fail class not found. job id:" + jobDo.getId());
				}
				if (JobConstants.JobStatus.STARTING.name().equals(jobDo.getJobStatus())) {
					quartzManager.runJob(jobDo);
				}
				if (JobConstants.JobStatus.PAUSE.name().equals(jobDo.getJobStatus())) {
					quartzManager.runJob(jobDo);
					quartzManager.pauseJob(jobDo);
				}
			}
		}
	}
}
