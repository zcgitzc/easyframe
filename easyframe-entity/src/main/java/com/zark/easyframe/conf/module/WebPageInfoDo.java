package com.zark.easyframe.conf.module;

import java.util.Date;

public class WebPageInfoDo {
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
     * 标题
     *
     * @mbggenerated 2017-07-08
     */
    private String title;

    /**
     * 地址
     *
     * @mbggenerated 2017-07-08
     */
    private String url;

    /**
     * IP
     *
     * @mbggenerated 2017-07-08
     */
    private String ip;

    /**
     * 主机
     *
     * @mbggenerated 2017-07-08
     */
    private String host;

    /**
     * 内容
     *
     * @mbggenerated 2017-07-08
     */
    private byte[] content;

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
     * 标题
     * @return title 标题
     *
     * @mbggenerated 2017-07-08
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     *
     * @mbggenerated 2017-07-08
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 地址
     * @return url 地址
     *
     * @mbggenerated 2017-07-08
     */
    public String getUrl() {
        return url;
    }

    /**
     * 地址
     * @param url 地址
     *
     * @mbggenerated 2017-07-08
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * IP
     * @return ip IP
     *
     * @mbggenerated 2017-07-08
     */
    public String getIp() {
        return ip;
    }

    /**
     * IP
     * @param ip IP
     *
     * @mbggenerated 2017-07-08
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 主机
     * @return host 主机
     *
     * @mbggenerated 2017-07-08
     */
    public String getHost() {
        return host;
    }

    /**
     * 主机
     * @param host 主机
     *
     * @mbggenerated 2017-07-08
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * 内容
     * @return content 内容
     *
     * @mbggenerated 2017-07-08
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     *
     * @mbggenerated 2017-07-08
     */
    public void setContent(byte[] content) {
        this.content = content;
    }
}