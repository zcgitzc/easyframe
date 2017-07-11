package com.zark.easyframe.common.module;

import java.util.Date;

public class JobStatusDo {
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
     * 修改时间
     *
     * @mbggenerated 2017-07-08
     */
    private Date gmtCreate;

    /**
     * 创建时间
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
     * 分类
     *
     * @mbggenerated 2017-07-08
     */
    private String category;

    /**
     * 当前阶段
     *
     * @mbggenerated 2017-07-08
     */
    private String currentStage;

    /**
     * 当前阶段数
     *
     * @mbggenerated 2017-07-08
     */
    private Integer currentStageNum;

    /**
     * 总阶段数
     *
     * @mbggenerated 2017-07-08
     */
    private Integer totalStageNum;

    /**
     * 当前处理数
     *
     * @mbggenerated 2017-07-08
     */
    private Integer currentDealedNum;

    /**
     * 当前总数
     *
     * @mbggenerated 2017-07-08
     */
    private Integer currentTotalNum;

    /**
     * 是否有错
     *
     * @mbggenerated 2017-07-08
     */
    private String hasError;

    /**
     * 返回值
     *
     * @mbggenerated 2017-07-08
     */
    private String returnValue;

    /**
     * 异常类
     *
     * @mbggenerated 2017-07-08
     */
    private String exceptionClass;

    /**
     * 异常信息
     *
     * @mbggenerated 2017-07-08
     */
    private String errorMessage;

    /**
     * 异常属性
     *
     * @mbggenerated 2017-07-08
     */
    private String exceptionProperties;

    /**
     * 完成时间
     *
     * @mbggenerated 2017-07-08
     */
    private Date finshDate;

    /**
     * 开始时间
     *
     * @mbggenerated 2017-07-08
     */
    private Date startDate;

    /**
     * 状态
     *
     * @mbggenerated 2017-07-08
     */
    private String status;

    /**
     * UUID
     *
     * @mbggenerated 2017-07-08
     */
    private String jobUuid;

    /**
     * 异常枚举类
     *
     * @mbggenerated 2017-07-08
     */
    private String exceptionCodeClass;

    /**
     * 异常枚举名称
     *
     * @mbggenerated 2017-07-08
     */
    private String exceptionCodeEnumName;

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
     * 修改时间
     * @return gmt_create 修改时间
     *
     * @mbggenerated 2017-07-08
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 修改时间
     * @param gmtCreate 修改时间
     *
     * @mbggenerated 2017-07-08
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 创建时间
     * @return gmt_modified 创建时间
     *
     * @mbggenerated 2017-07-08
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 创建时间
     * @param gmtModified 创建时间
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
     * 分类
     * @return category 分类
     *
     * @mbggenerated 2017-07-08
     */
    public String getCategory() {
        return category;
    }

    /**
     * 分类
     * @param category 分类
     *
     * @mbggenerated 2017-07-08
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 当前阶段
     * @return current_stage 当前阶段
     *
     * @mbggenerated 2017-07-08
     */
    public String getCurrentStage() {
        return currentStage;
    }

    /**
     * 当前阶段
     * @param currentStage 当前阶段
     *
     * @mbggenerated 2017-07-08
     */
    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage == null ? null : currentStage.trim();
    }

    /**
     * 当前阶段数
     * @return current_stage_num 当前阶段数
     *
     * @mbggenerated 2017-07-08
     */
    public Integer getCurrentStageNum() {
        return currentStageNum;
    }

    /**
     * 当前阶段数
     * @param currentStageNum 当前阶段数
     *
     * @mbggenerated 2017-07-08
     */
    public void setCurrentStageNum(Integer currentStageNum) {
        this.currentStageNum = currentStageNum;
    }

    /**
     * 总阶段数
     * @return total_stage_num 总阶段数
     *
     * @mbggenerated 2017-07-08
     */
    public Integer getTotalStageNum() {
        return totalStageNum;
    }

    /**
     * 总阶段数
     * @param totalStageNum 总阶段数
     *
     * @mbggenerated 2017-07-08
     */
    public void setTotalStageNum(Integer totalStageNum) {
        this.totalStageNum = totalStageNum;
    }

    /**
     * 当前处理数
     * @return current_dealed_num 当前处理数
     *
     * @mbggenerated 2017-07-08
     */
    public Integer getCurrentDealedNum() {
        return currentDealedNum;
    }

    /**
     * 当前处理数
     * @param currentDealedNum 当前处理数
     *
     * @mbggenerated 2017-07-08
     */
    public void setCurrentDealedNum(Integer currentDealedNum) {
        this.currentDealedNum = currentDealedNum;
    }

    /**
     * 当前总数
     * @return current_total_num 当前总数
     *
     * @mbggenerated 2017-07-08
     */
    public Integer getCurrentTotalNum() {
        return currentTotalNum;
    }

    /**
     * 当前总数
     * @param currentTotalNum 当前总数
     *
     * @mbggenerated 2017-07-08
     */
    public void setCurrentTotalNum(Integer currentTotalNum) {
        this.currentTotalNum = currentTotalNum;
    }

    /**
     * 是否有错
     * @return has_error 是否有错
     *
     * @mbggenerated 2017-07-08
     */
    public String getHasError() {
        return hasError;
    }

    /**
     * 是否有错
     * @param hasError 是否有错
     *
     * @mbggenerated 2017-07-08
     */
    public void setHasError(String hasError) {
        this.hasError = hasError == null ? null : hasError.trim();
    }

    /**
     * 返回值
     * @return return_value 返回值
     *
     * @mbggenerated 2017-07-08
     */
    public String getReturnValue() {
        return returnValue;
    }

    /**
     * 返回值
     * @param returnValue 返回值
     *
     * @mbggenerated 2017-07-08
     */
    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue == null ? null : returnValue.trim();
    }

    /**
     * 异常类
     * @return exception_class 异常类
     *
     * @mbggenerated 2017-07-08
     */
    public String getExceptionClass() {
        return exceptionClass;
    }

    /**
     * 异常类
     * @param exceptionClass 异常类
     *
     * @mbggenerated 2017-07-08
     */
    public void setExceptionClass(String exceptionClass) {
        this.exceptionClass = exceptionClass == null ? null : exceptionClass.trim();
    }

    /**
     * 异常信息
     * @return error_message 异常信息
     *
     * @mbggenerated 2017-07-08
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 异常信息
     * @param errorMessage 异常信息
     *
     * @mbggenerated 2017-07-08
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }

    /**
     * 异常属性
     * @return exception_properties 异常属性
     *
     * @mbggenerated 2017-07-08
     */
    public String getExceptionProperties() {
        return exceptionProperties;
    }

    /**
     * 异常属性
     * @param exceptionProperties 异常属性
     *
     * @mbggenerated 2017-07-08
     */
    public void setExceptionProperties(String exceptionProperties) {
        this.exceptionProperties = exceptionProperties == null ? null : exceptionProperties.trim();
    }

    /**
     * 完成时间
     * @return finsh_date 完成时间
     *
     * @mbggenerated 2017-07-08
     */
    public Date getFinshDate() {
        return finshDate;
    }

    /**
     * 完成时间
     * @param finshDate 完成时间
     *
     * @mbggenerated 2017-07-08
     */
    public void setFinshDate(Date finshDate) {
        this.finshDate = finshDate;
    }

    /**
     * 开始时间
     * @return start_date 开始时间
     *
     * @mbggenerated 2017-07-08
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 开始时间
     * @param startDate 开始时间
     *
     * @mbggenerated 2017-07-08
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 状态
     * @return status 状态
     *
     * @mbggenerated 2017-07-08
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     *
     * @mbggenerated 2017-07-08
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * UUID
     * @return job_uuid UUID
     *
     * @mbggenerated 2017-07-08
     */
    public String getJobUuid() {
        return jobUuid;
    }

    /**
     * UUID
     * @param jobUuid UUID
     *
     * @mbggenerated 2017-07-08
     */
    public void setJobUuid(String jobUuid) {
        this.jobUuid = jobUuid == null ? null : jobUuid.trim();
    }

    /**
     * 异常枚举类
     * @return exception_code_class 异常枚举类
     *
     * @mbggenerated 2017-07-08
     */
    public String getExceptionCodeClass() {
        return exceptionCodeClass;
    }

    /**
     * 异常枚举类
     * @param exceptionCodeClass 异常枚举类
     *
     * @mbggenerated 2017-07-08
     */
    public void setExceptionCodeClass(String exceptionCodeClass) {
        this.exceptionCodeClass = exceptionCodeClass == null ? null : exceptionCodeClass.trim();
    }

    /**
     * 异常枚举名称
     * @return exception_code_enum_name 异常枚举名称
     *
     * @mbggenerated 2017-07-08
     */
    public String getExceptionCodeEnumName() {
        return exceptionCodeEnumName;
    }

    /**
     * 异常枚举名称
     * @param exceptionCodeEnumName 异常枚举名称
     *
     * @mbggenerated 2017-07-08
     */
    public void setExceptionCodeEnumName(String exceptionCodeEnumName) {
        this.exceptionCodeEnumName = exceptionCodeEnumName == null ? null : exceptionCodeEnumName.trim();
    }
}