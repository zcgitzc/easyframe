package com.zark.easyframe.common.job.impl;

import java.util.Map;
import java.util.concurrent.Executor;

import com.zark.easyframe.common.job.JobDetail;

public class DefaultThreadPoolJobExecutor extends AbstractJobExecutor {

    private Executor jobExecutor;

    @Override
    public void execute(final JobDetail jobDetail, final Map<String, Object> initParams) {
        jobExecutor.execute(new Runnable() {

            @Override
            public void run() {
                doExecute(jobDetail, initParams);
            }
        });
    }

    public Executor getJobExecutor() {
        return jobExecutor;
    }

    public void setJobExecutor(Executor jobExecutor) {
        this.jobExecutor = jobExecutor;
    }

}
