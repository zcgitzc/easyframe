package com.zark.easyframe.common.job;

import java.util.HashMap;
import java.util.Map;

public class JobContext {

    private final JobState      jobState;
    private Map<String, Object> jobDataMap = new HashMap<String, Object>();

    public JobContext(JobState jobState){
        this.jobState = jobState;
    }

    public void put(String key, Object value) {
        jobDataMap.put(key, value);
    }

    public Object get(String key) {
        return jobDataMap.get(key);
    }

    public JobState getJobState() {
        return jobState;
    }

}
