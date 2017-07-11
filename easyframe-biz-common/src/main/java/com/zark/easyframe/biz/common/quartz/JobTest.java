package com.zark.easyframe.biz.common.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobTest implements Job {
	private static final Logger logger = LoggerFactory.getLogger(JobTest.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("job start...");
	}

	public void work() {
		logger.debug("spring job execute work method...");
	}
}