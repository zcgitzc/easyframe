package com.zark.easyframe.common.job;

public class JobStageState implements Cloneable {

    private volatile int     currentDealed;
    private volatile int     sum;
    private volatile boolean isExecuting = false;

    public int getCurrentDealed() {
        return currentDealed;
    }

    public void setCurrentDealed(int currentDealed) {
        this.currentDealed = currentDealed;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean isExecuting() {
        return isExecuting;
    }

    public void setExecuting(boolean isExecuting) {
        this.isExecuting = isExecuting;
    }

    @Override
    public JobStageState clone() {
        try {
            return (JobStageState) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone error", e);
        }
    }
}
