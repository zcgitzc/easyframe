package com.zark.easyframe.common.module;

import java.util.Date;

public class OperLogDo {
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
     * 业务ID
     *
     * @mbggenerated 2017-07-08
     */
    private Long businessId;

    /**
     * 操作类型
     *
     * @mbggenerated 2017-07-08
     */
    private String operType;

    /**
     * 参数
     *
     * @mbggenerated 2017-07-08
     */
    private String params;

    /**
     * 状态
     *
     * @mbggenerated 2017-07-08
     */
    private String status;

    /**
     * 错误信息
     *
     * @mbggenerated 2017-07-08
     */
    private String errorMsg;

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
     * 业务ID
     * @return business_id 业务ID
     *
     * @mbggenerated 2017-07-08
     */
    public Long getBusinessId() {
        return businessId;
    }

    /**
     * 业务ID
     * @param businessId 业务ID
     *
     * @mbggenerated 2017-07-08
     */
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    /**
     * 操作类型
     * @return oper_type 操作类型
     *
     * @mbggenerated 2017-07-08
     */
    public String getOperType() {
        return operType;
    }

    /**
     * 操作类型
     * @param operType 操作类型
     *
     * @mbggenerated 2017-07-08
     */
    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    /**
     * 参数
     * @return params 参数
     *
     * @mbggenerated 2017-07-08
     */
    public String getParams() {
        return params;
    }

    /**
     * 参数
     * @param params 参数
     *
     * @mbggenerated 2017-07-08
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
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
     * 错误信息
     * @return error_msg 错误信息
     *
     * @mbggenerated 2017-07-08
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 错误信息
     * @param errorMsg 错误信息
     *
     * @mbggenerated 2017-07-08
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }
}