package com.zark.easyframe.common.job;

import java.util.List;

public class JobState implements Cloneable {

    private String         jobUUId;
    private int            currentStageIndex;
    private JobStage       currentStage;
    private List<JobStage> allStages;

    public int getCurrentStageIndex() {
        return currentStageIndex;
    }

    public void setCurrentStageIndex(int currentStageIndex) {
        this.currentStageIndex = currentStageIndex;
    }

    public JobStage getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(JobStage currentStage) {
        this.currentStage = currentStage;
    }

    public List<JobStage> getAllStages() {
        return allStages;
    }

    public void setAllStages(List<JobStage> allStages) {
        this.allStages = allStages;
    }

    @Override
    public JobState clone() {
        try {
            return (JobState) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone error", e);
        }
    }

    public String getJobUUId() {
        return jobUUId;
    }

    public void setJobUUId(String jobUUId) {
        this.jobUUId = jobUUId;
    }

}
