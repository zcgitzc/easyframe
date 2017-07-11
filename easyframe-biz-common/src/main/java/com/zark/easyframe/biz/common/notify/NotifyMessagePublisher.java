package com.zark.easyframe.biz.common.notify;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.zark.easyframe.biz.common.constants.RocketMetaQConstants;
import com.zark.easyframe.biz.common.exception.BizCommonException;
import com.zark.easyframe.biz.common.exception.CommonErrorCode;
import com.zark.easyframe.common.message.MessagePublisher;

/**
 * 基于Notify的消息发布器
 * 
 * @author nathan.yuhm 2014年5月13日 下午8:12:12
 */
public class NotifyMessagePublisher implements MessagePublisher {/*

	private static final Logger logger = LoggerFactory.getLogger(NotifyMessagePublisher.class);

	@Resource
	private DefaultMQProducer defaultMQProducer;

	*//**
	 * 如果有事物则发送事物消息，无事物则发送异步消息
	 * 
	 * @param msg
	 * @param sendMsgMethod
	 * @throws Exception
	 *//*
	private void sendNotifyMsg(Message msg, String sendMsgMethod) {
		if (TransactionSynchronizationManager.isActualTransactionActive()) {
			TransactionSynchronizationManager.registerSynchronization(new NotifySendTransactionSynchronization(msg));
		} else {
			doSendMessage(msg);
		}
	}

	@Override
	public void publishWithTranstraction(String topic, String messageType, Object notifyObj) {
		publishWithTranstraction(topic, messageType, notifyObj, null);
	}

	@Override
	public void publishWithTranstraction(String topic, String messageType, Object notifyObj, String businessNo) {
		// 先组装MESSAGE，减少commit之前才报错的几率。
		Message msg = buildMessage(notifyObj, topic, messageType);
		if (businessNo != null) {
			msg.putUserProperty(RocketMetaQConstants.MessagePropertyKey.KEY_NOTIFY_BUSINESS_NO.name(), businessNo);
		}
		if (TransactionSynchronizationManager.isSynchronizationActive()) {
			logger.info("Register publish:{}.{} to TransactionSynchronizationManager", topic, messageType);
			TransactionSynchronizationManager.registerSynchronization(new NotifyPublisherSynchronization(msg));
		} else {
			doSendMessage(msg);
		}
	}

	private class NotifySendTransactionSynchronization extends TransactionSynchronizationAdapter {

		private final Message message;

		public NotifySendTransactionSynchronization(Message message) {
			this.message = message;
		}

		@Override
		public void afterCompletion(int status) {
			try {
				if (status == STATUS_COMMITTED) {
					doSendMessage(message);
				}
			} catch (Throwable e) {
				logger.error("async notify send message error", e);
			}
		}
	}

	private class NotifyPublisherSynchronization extends TransactionSynchronizationAdapter {

		private final Message message;

		public NotifyPublisherSynchronization(Message message) {
			this.message = message;
		}

		@Override
		public void beforeCommit(boolean readOnly) {
			doSendMessage(message);
		}
	}

	private void doSendMessage(final Message message) {
		try {
			defaultMQProducer.send(message, new SendCallback() {

				@Override
				public void onSuccess(SendResult sendResult) {
					logger.info(String.format("publish message success. topic = {}  messageType = {}", message.getTopic(), message.getTags()));
				}

				@Override
				public void onException(Throwable e) {
					logger.error(String.format("publish message failure. topic = {}  messageType = {}", message.getTopic(), message.getTags()));
				}
			});
		} catch (MQClientException | RemotingException | InterruptedException e) {
			throw new BizCommonException("doSendMessage error." + String.format("publish message failure. topic = {}  messageType = {}", message.getTopic(), message.getTags()), CommonErrorCode.SEND_NOTIFY_ERROR);
		}
	}

	@Override
	public void publishWithTranstractionAfterCommit(String topic, String messageType, Object notifyObj) {
		publishWithTranstractionAfterCommit(topic, messageType, notifyObj, null);
	}

	@Override
	public void publishWithTranstractionAfterCommit(String topic, String messageType, Object notifyObj, String businessNo) {
		// 先组装MESSAGE，减少commit之前才报错的几率。
		Message msg = buildMessage(notifyObj, topic, messageType);
		if (businessNo != null) {
			msg.putUserProperty(RocketMetaQConstants.MessagePropertyKey.KEY_NOTIFY_BUSINESS_NO.name(), businessNo);
		}
		sendNotifyMsg(msg, messageType);
	}

	private Message buildMessage(Object notifyObj, String topic, String messageType) {
		return new Message(topic, messageType, JSON.toJSONString(notifyObj).getBytes());
	}

	@Override
	public void publish(String topic, String messageType, Object notifyObj) {
		doSendMessage(buildMessage(notifyObj, topic, messageType));
	}

	public DefaultMQProducer getDefaultMQProducer() {
		return defaultMQProducer;
	}

	public void setDefaultMQProducer(DefaultMQProducer defaultMQProducer) {
		this.defaultMQProducer = defaultMQProducer;
	}

*/}
