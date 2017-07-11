package com.zark.easyframe.common.job;

import java.util.List;

import com.zark.easyframe.common.job.listener.JobListener;


public class JobDetail {

    private List<JobStage>    jobStages;
    private String            name;
    private List<JobListener> listeners;

    public List<JobStage> getJobStages() {
        return jobStages;
    }

    public void setJobStages(List<JobStage> jobStages) {
        this.jobStages = jobStages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JobListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<JobListener> listeners) {
        this.listeners = listeners;
    }

}
