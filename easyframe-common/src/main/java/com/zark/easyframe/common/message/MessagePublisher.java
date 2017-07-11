package com.zark.easyframe.common.message;


/**
 * 消息发布器
 * 
 */
public interface MessagePublisher {/*

    *//**
     * 消息发送通用类
     * 
     * @param topic //发送的topic
     * @param messageType //发送的类型
     * @param notifyObj //发送的内容，会JSON化
     *//*
    void publish(String topic, String messageType, Object notifyObj);

    *//**
     * 基于事务的消息发送，会在commit之前才做发送。如果发送失败，会回滚事务。但是无法解决第一条发送成功，第二条发送失败，第一条无法退回的问题。
     * 
     * @param topic
     * @param messageType
     * @param notifyObj
     *//*
    void publishWithTranstraction(String topic, String messageType, Object notifyObj);

    *//**
     * 基于事务的消息发送，同时发送businessNo
     * 
     * @param topic
     * @param messageType
     * @param notifyObj
     * @param businessNo
     *//*
    void publishWithTranstraction(String topic, String messageType, Object notifyObj, String businessNo);

    *//**
     * 基于事务的消息发送，会在commit之后才做发送。缺点是如果发送失败，无法回滚主事务。
     * 
     * @param topic
     * @param messageType
     * @param notifyObj
     *//*
    void publishWithTranstractionAfterCommit(String topic, String messageType, Object notifyObj);

    *//**
     * 基于事务的消息发送，会在commit之后才做发送。缺点是如果发送失败，无法回滚主事务。
     * 
     * @param topic
     * @param messageType
     * @param notifyObj
     * @param businessNo 事务号
     *//*
    void publishWithTranstractionAfterCommit(String topic, String messageType, Object notifyObj, String businessNo);

*/}
