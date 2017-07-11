package com.zark.easyframe.common.module;

import java.util.Date;

public class JobDo {
    /**
     * 主键
     *
     * @mbggenerated 2017-07-08
     */
    private Long id;

    /**
     * 是否删除
     *
     * @mbggenerated 2017-07-08
     */
    private String isDeleted;

    /**
     * 创建者
     *
     * @mbggenerated 2017-07-08
     */
    private String creator;

    /**
     * 修改者
     *
     * @mbggenerated 2017-07-08
     */
    private String modifier;

    /**
     * 创建时间
     *
     * @mbggenerated 2017-07-08
     */
    private Date gmtCreate;

    /**
     * 修改时间
     *
     * @mbggenerated 2017-07-08
     */
    private Date gmtModified;

    /**
     * 描述信息
     *
     * @mbggenerated 2017-07-08
     */
    private String description;

    /**
     * 任务名称
     *
     * @mbggenerated 2017-07-08
     */
    private String jobName;

    /**
     * 任务组
     *
     * @mbggenerated 2017-07-08
     */
    private String jobGroup;

    /**
     * 任务状态
     *
     * @mbggenerated 2017-07-08
     */
    private String jobStatus;

    /**
     * 表达式
     *
     * @mbggenerated 2017-07-08
     */
    private String cronExpression;

    /**
     * 触发类
     *
     * @mbggenerated 2017-07-08
     */
    private String triggerClass;

    /**
     * 主键
     * @return id 主键
     *
     * @mbggenerated 2017-07-08
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     *
     * @mbggenerated 2017-07-08
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 是否删除
     * @return is_deleted 是否删除
     *
     * @mbggenerated 2017-07-08
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除
     * @param isDeleted 是否删除
     *
     * @mbggenerated 2017-07-08
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * 创建者
     * @return creator 创建者
     *
     * @mbggenerated 2017-07-08
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建者
     * @param creator 创建者
     *
     * @mbggenerated 2017-07-08
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 修改者
     * @return modifier 修改者
     *
     * @mbggenerated 2017-07-08
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改者
     * @param modifier 修改者
     *
     * @mbggenerated 2017-07-08
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 创建时间
     * @return gmt_create 创建时间
     *
     * @mbggenerated 2017-07-08
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 创建时间
     * @param gmtCreate 创建时间
     *
     * @mbggenerated 2017-07-08
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 修改时间
     * @return gmt_modified 修改时间
     *
     * @mbggenerated 2017-07-08
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 修改时间
     * @param gmtModified 修改时间
     *
     * @mbggenerated 2017-07-08
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 描述信息
     * @return description 描述信息
     *
     * @mbggenerated 2017-07-08
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述信息
     * @param description 描述信息
     *
     * @mbggenerated 2017-07-08
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 任务名称
     * @return job_name 任务名称
     *
     * @mbggenerated 2017-07-08
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 任务名称
     * @param jobName 任务名称
     *
     * @mbggenerated 2017-07-08
     */
    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    /**
     * 任务组
     * @return job_group 任务组
     *
     * @mbggenerated 2017-07-08
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * 任务组
     * @param jobGroup 任务组
     *
     * @mbggenerated 2017-07-08
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }

    /**
     * 任务状态
     * @return job_status 任务状态
     *
     * @mbggenerated 2017-07-08
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * 任务状态
     * @param jobStatus 任务状态
     *
     * @mbggenerated 2017-07-08
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus == null ? null : jobStatus.trim();
    }

    /**
     * 表达式
     * @return cron_expression 表达式
     *
     * @mbggenerated 2017-07-08
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * 表达式
     * @param cronExpression 表达式
     *
     * @mbggenerated 2017-07-08
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    /**
     * 触发类
     * @return trigger_class 触发类
     *
     * @mbggenerated 2017-07-08
     */
    public String getTriggerClass() {
        return triggerClass;
    }

    /**
     * 触发类
     * @param triggerClass 触发类
     *
     * @mbggenerated 2017-07-08
     */
    public void setTriggerClass(String triggerClass) {
        this.triggerClass = triggerClass == null ? null : triggerClass.trim();
    }
}