package com.zark.easyframe.common.job;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import com.zark.easyframe.common.job.annotation.Param;
import com.zark.easyframe.common.job.listener.JobStageListener;

public class DefaultJobStageFactoryBean implements FactoryBean<JobStage>, InitializingBean {

    private String                 name;
    private Object                 target;
    private String                 methodName;
    private boolean                enableProcessingListener = false;
    private List<JobStageListener> listeners;
    private JobStage               jobStage;

    @Override
    public JobStage getObject() throws Exception {
        return this.jobStage;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(target);
        Assert.notNull(methodName);
        JobStage jobStage = new JobStage();
        Method[] methods = ReflectionUtils.getUniqueDeclaredMethods(AopUtils.getTargetClass(target));
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                jobStage.setTargetObject(target);
                jobStage.setTargetMethod(method);
                jobStage.setName(name);
                jobStage.setEnableProcessingListener(enableProcessingListener);
                jobStage.setListeners(listeners);
                setParamKeysInfo(jobStage, method);
                this.jobStage = jobStage;
                return;
            }
        }
        throw new IllegalArgumentException("Can not find unique method : " + methodName);

    }

    private void setParamKeysInfo(JobStage jobStage, Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Class<?>[] parameterTypes = method.getParameterTypes();
        List<String> paramKeys = new ArrayList<String>();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            boolean paramFlag = false;
            Annotation[] annotations = parameterAnnotations[i];
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Param.class) {
                    Param param = (Param) annotation;
                    paramKeys.add(param.name());
                    paramFlag = true;
                    break;
                }
            }
            if (paramFlag) {
                continue;
            }
            if (JobContext.class.isAssignableFrom(parameterTypes[i])) {
                if (jobStage.isNeedContext()) {
                    throw new IllegalStateException("Find two JobContext in : " + methodName);
                }
                jobStage.setNeedContext(true);
                jobStage.setContextParamIndex(i);
                continue;
            }
            if (JobStageState.class.isAssignableFrom(parameterTypes[i])) {
                if (jobStage.isNeedStageState()) {
                    throw new IllegalStateException("Find two JobStageState in : " + methodName);
                }
                jobStage.setNeedStageState(true);
                jobStage.setStageStateParamIndex(i);
                continue;
            }
            throw new IllegalStateException("Can not defined param in : " + methodName + ", index : " + i);
        }
        jobStage.setParamKeys(paramKeys);
    }

    @Override
    public Class<? extends JobStage> getObjectType() {
        return JobStage.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public boolean isEnableProcessingListener() {
        return enableProcessingListener;
    }

    public void setEnableProcessingListener(boolean enableProcessingListener) {
        this.enableProcessingListener = enableProcessingListener;
    }

    public List<JobStageListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<JobStageListener> listeners) {
        this.listeners = listeners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
