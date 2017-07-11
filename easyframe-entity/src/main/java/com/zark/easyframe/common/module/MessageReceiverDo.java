package com.zark.easyframe.common.module;

import java.util.Date;

public class MessageReceiverDo {
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
     * 接收类型
     *
     * @mbggenerated 2017-07-08
     */
    private String receiverType;

    /**
     * 消息ID
     *
     * @mbggenerated 2017-07-08
     */
    private Long messageId;

    /**
     * 接收者
     *
     * @mbggenerated 2017-07-08
     */
    private String receiver;

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
     * 接收类型
     * @return receiver_type 接收类型
     *
     * @mbggenerated 2017-07-08
     */
    public String getReceiverType() {
        return receiverType;
    }

    /**
     * 接收类型
     * @param receiverType 接收类型
     *
     * @mbggenerated 2017-07-08
     */
    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType == null ? null : receiverType.trim();
    }

    /**
     * 消息ID
     * @return message_id 消息ID
     *
     * @mbggenerated 2017-07-08
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     * 消息ID
     * @param messageId 消息ID
     *
     * @mbggenerated 2017-07-08
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /**
     * 接收者
     * @return receiver 接收者
     *
     * @mbggenerated 2017-07-08
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 接收者
     * @param receiver 接收者
     *
     * @mbggenerated 2017-07-08
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }
}