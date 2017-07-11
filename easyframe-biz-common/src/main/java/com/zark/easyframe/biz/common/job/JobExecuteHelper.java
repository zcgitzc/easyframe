package com.zark.easyframe.biz.common.job;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zark.easyframe.biz.common.bo.JobStatusBo;
import com.zark.easyframe.biz.common.constants.JobStatusConstants;
import com.zark.easyframe.common.job.JobDetail;
import com.zark.easyframe.common.job.JobExecutor;
import com.zark.easyframe.common.module.JobStatusDo;

public class JobExecuteHelper implements ApplicationContextAware, InitializingBean {

	private ApplicationContext applicationContext;
	private Map<String, JobDetail> jobDetailMap = new HashMap<String, JobDetail>();

	@Resource
	private JobExecutor jobExecutor;
	@Resource
	private JobStatusBo jobStatusBo;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, JobDetail> allJobExecutors = applicationContext.getBeansOfType(JobDetail.class);
		for (JobDetail jobDetail : allJobExecutors.values()) {
			jobDetailMap.put(jobDetail.getName(), jobDetail);
		}
	}

	public JobStatusDo executeJob(JobStatusConstants.JobName jobName, Map<String, Object> initParams) {
		final JobDetail jobDetail = jobDetailMap.get(jobName.name());
		if (jobDetail == null) {
			throw new RuntimeException("Can not find job by " + jobName.name());
		}
		JobStatusDo jobStatus = jobStatusBo.createNewJobStatus(jobName.name());
		initParams.put(JobStatusConstants.JobSystemParam.JobStatus.getValue(), jobStatus);
		jobExecutor.execute(jobDetail, initParams);
		return jobStatus;
	}

}
