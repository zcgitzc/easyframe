package com.zark.easyframe.common.job.listener;

import com.zark.easyframe.common.job.JobContext;
import com.zark.easyframe.common.job.JobStageState;
import com.zark.easyframe.common.job.JobState;

public interface JobStageListener {

    String getName();

    void jobStageExecuteSuccess(JobContext jobContext, JobStageState stageState, Object returnVal);

    void jobStageExecuteFail(JobContext jobContext, JobStageState stageState, Exception exception);

    void jobStageToBeExecuted(JobContext jobContext);

    void jobStageExecuting(JobState jobState, JobStageState stageState);
}
