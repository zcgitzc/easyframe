package com.zark.easyframe.common.job;

import java.lang.reflect.Method;
import java.util.List;

import com.zark.easyframe.common.job.listener.JobStageListener;


public class JobStage {

    private String                 name;
    private Object                 targetObject;
    private Method                 targetMethod;
    private boolean                enableProcessingListener = false;
    private List<JobStageListener> listeners;
    private List<String>           paramKeys;
    private boolean                needContext              = false;
    private int                    contextParamIndex        = 0;
    private boolean                needStageState           = false;
    private int                    StageStateParamIndex     = 0;

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(Method targetMethod) {
        this.targetMethod = targetMethod;
    }

    public List<String> getParamKeys() {
        return paramKeys;
    }

    public void setParamKeys(List<String> paramKeys) {
        this.paramKeys = paramKeys;
    }

    public boolean isNeedContext() {
        return needContext;
    }

    public void setNeedContext(boolean needContext) {
        this.needContext = needContext;
    }

    public int getContextParamIndex() {
        return contextParamIndex;
    }

    public void setContextParamIndex(int contextParamIndex) {
        this.contextParamIndex = contextParamIndex;
    }

    public boolean isNeedStageState() {
        return needStageState;
    }

    public void setNeedStageState(boolean needStageState) {
        this.needStageState = needStageState;
    }

    public int getStageStateParamIndex() {
        return StageStateParamIndex;
    }

    public void setStageStateParamIndex(int stageStateParamIndex) {
        StageStateParamIndex = stageStateParamIndex;
    }

    public List<JobStageListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<JobStageListener> listeners) {
        this.listeners = listeners;
    }

    public boolean isEnableProcessingListener() {
        return enableProcessingListener;
    }

    public void setEnableProcessingListener(boolean enableProcessingListener) {
        this.enableProcessingListener = enableProcessingListener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
