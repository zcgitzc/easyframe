package com.zark.easyframe.biz.common.notify;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.zark.easyframe.biz.common.exception.BizCommonException;
import com.zark.easyframe.biz.common.exception.CommonErrorCode;
import com.zark.easyframe.common.message.handler.MessageHandler;

/**
 * Notify消息监听器
 * 
 * @author nathan.yuhm 2014年5月13日 下午8:45:08
 */
public class NotifyMessageListener{ /*implements MessageListenerConcurrently, ApplicationContextAware {

	private static final Logger logger = LoggerFactory.getLogger(NotifyMessageListener.class);

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		MessageExt message = msgs.get(0);
		logger.info("Receive message, topic : {},   message id : {}", new Object[] { message.getTopic(), message.getMsgId() });
		String msgString = getMsgString(message, context);
		logger.info("receiveMessage -> {}", msgString);
		try {
			handleMessage(message);
		} catch (Throwable e) {
			logger.error("Handle message : " + message.getMsgId() + " failure, for reason : " + e.getMessage(), e);
			return ConsumeConcurrentlyStatus.RECONSUME_LATER;
		}
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

	private void handleMessage(MessageExt message) {
		String body = new String(message.getBody());
		MessageHandler<?> messageHandler = getMessageHandler(message.getTopic(), message.getTags());
		Long current = System.currentTimeMillis();
		messageHandler.handleMessage(body);
		logger.info("Handle message success, topic : {}, message type : {},  message id : {}, time cost : {}", new Object[] { message.getTopic(), message.getTags(), message.getMsgId(),
				System.currentTimeMillis() - current });
	}

	@SuppressWarnings("rawtypes")
	private MessageHandler<?> getMessageHandler(String topic, String messageType) {
		Collection<MessageHandler> beans = applicationContext.getBeansOfType(MessageHandler.class).values();
		for (MessageHandler handler : beans) {
			if (handler.getTopic().equals(topic) && handler.getMessageType().equals(messageType)) {
				return handler;
			}
		}
		throw new BizCommonException("can't find MessageHandler! ", CommonErrorCode.PARAM_ERROR).set("messageType", messageType);
	}

	private String getMsgString(MessageExt message, ConsumeConcurrentlyContext context) {
		StringBuilder generalInfo = new StringBuilder();
		generalInfo.append(message.getClass().getSimpleName()).append("{");
		generalInfo.append(", topic=").append(message.getTopic());
		generalInfo.append(", tags=").append(new String(message.getTags()));
		generalInfo.append(", body=").append(new String(message.getBody()));
		generalInfo.append(", brokerName=").append(new String(context.getMessageQueue().getBrokerName()));
		generalInfo.append("}");
		return generalInfo.toString();
	}
*/}
