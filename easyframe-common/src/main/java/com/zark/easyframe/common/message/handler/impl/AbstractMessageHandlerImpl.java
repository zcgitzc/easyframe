package com.zark.easyframe.common.message.handler.impl;

import java.lang.reflect.ParameterizedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.zark.easyframe.common.message.handler.MessageHandler;

public abstract class AbstractMessageHandlerImpl<T> implements MessageHandler<T> {/*

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final Class<T> clazz;

	private String topic;
	private String messageType;

	@SuppressWarnings("unchecked")
	public AbstractMessageHandlerImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Override
	public final void handleMessage(String messageBody) {
		T message = JSONObject.parseObject(messageBody, clazz);
		handle(message);
	}

*/}
