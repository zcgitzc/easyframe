package com.zark.easyframe.common.message.handler;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 消息处理接口
 * 
 */
public interface MessageHandler<T> {/*

	// 处理方法
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	void handleMessage(String messageBody);

	void handle(T message);

	// MessageType messageType();
	// 处理的类型
	String getMessageType();

	// 处理的topic
	String getTopic();

*/}
