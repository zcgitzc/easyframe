package com.zark.easyframe.common.job.impl;

import com.zark.easyframe.common.job.JobContext;
import com.zark.easyframe.common.job.listener.JobListener;

public abstract class JobListenerSupport implements JobListener {

	@Override
	public void jobExecuteFail(JobContext jobContext, Exception jobException) {
	}

	@Override
	public void jobExecuteSuccess(JobContext jobContext, Object returnVal) {
	}

	@Override
	public void jobFinish(JobContext jobContext) {
	}

	@Override
	public void jobToBeExecuted(JobContext jobContext) {
	}

}
