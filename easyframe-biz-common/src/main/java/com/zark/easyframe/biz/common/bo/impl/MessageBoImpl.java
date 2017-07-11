package com.zark.easyframe.biz.common.bo.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.zark.easyframe.biz.common.bo.MessageBo;
import com.zark.easyframe.biz.common.bo.MessageReceiverBo;
import com.zark.easyframe.biz.common.constants.MessageConstants;
import com.zark.easyframe.biz.common.constants.MessageConstants.SendMailType;
import com.zark.easyframe.common.mapper.MessageDoMapperExt;
import com.zark.easyframe.common.module.MessageDo;
import com.zark.easyframe.common.module.MessageReceiverDo;
import com.zark.easyframe.common.util.mail.MailMessageInfo;
import com.zark.easyframe.common.util.mail.SendMailUtil;

public class MessageBoImpl implements MessageBo {
	private static final Logger logger = LoggerFactory.getLogger(MessageBoImpl.class);

	@Resource
	private MessageDoMapperExt messageDoMapperExt;
	@Resource
	private MessageReceiverBo messageReceiverBo;

	@Override
	public void sendMail(MailMessageInfo messageInfo, SendMailType sendMailType) {
		checkParam(messageInfo);
		MessageDo messageDo = new MessageDo();
		messageDo.setTemplateName(messageInfo.getTemplateName());
		messageDo.setMessageType(messageInfo.getMessageType());
		messageDo.setStatus(MessageConstants.Status.SENDING.name());
		messageDo.setTitle(messageInfo.getSubject());
		messageDoMapperExt.insertSelective(messageDo);
		addMessageReceiver(messageDo.getId(), messageInfo);
		try {
			if (MessageConstants.SendMailType.SIMPLE_MAIL.equals(sendMailType)) {
				SendMailUtil.sendSimpleMail(messageInfo);
			} else if (MessageConstants.SendMailType.HTML_MAIL.equals(sendMailType)) {
				SendMailUtil.sendHtmlMail(messageInfo);
			}
			messageDo.setStatus(MessageConstants.Status.SENDED.name());
		} catch (Exception e) {
			logger.error(String.format("send mail to %s fail", StringUtils.join(messageInfo.getReceivers(), ";")), e);
			messageDo.setStatus(MessageConstants.Status.SEND_FAIL.name());
		} finally {
			messageDoMapperExt.updateByPrimaryKeySelective(messageDo);
		}
	}

	private void addMessageReceiver(Long messageId, MailMessageInfo messageInfo) {
		for (String receiver : messageInfo.getReceivers()) {
			MessageReceiverDo messageReceiverDo = new MessageReceiverDo();
			messageReceiverDo.setMessageId(messageId);
			messageReceiverDo.setReceiver(receiver);
			messageReceiverDo.setReceiverType(MessageConstants.MessageReceiverType.RECEIVER.name());
			messageReceiverBo.addMessageReceiver(messageReceiverDo);
		}
		if (messageInfo.getCc() != null) {
			for (String cc : messageInfo.getCc()) {
				MessageReceiverDo messageReceiverDo = new MessageReceiverDo();
				messageReceiverDo.setMessageId(messageId);
				messageReceiverDo.setReceiver(cc);
				messageReceiverDo.setReceiverType(MessageConstants.MessageReceiverType.CC.name());
				messageReceiverBo.addMessageReceiver(messageReceiverDo);
			}
		}
		if (messageInfo.getBcc() != null) {
			for (String bcc : messageInfo.getBcc()) {
				MessageReceiverDo messageReceiverDo = new MessageReceiverDo();
				messageReceiverDo.setMessageId(messageId);
				messageReceiverDo.setReceiver(bcc);
				messageReceiverDo.setReceiverType(MessageConstants.MessageReceiverType.BCC.name());
				messageReceiverBo.addMessageReceiver(messageReceiverDo);
			}
		}
	}

	private void checkParam(MailMessageInfo messageInfo) {
		Assert.notNull(messageInfo);
		Assert.notEmpty(messageInfo.getReceivers());
		Assert.notNull(messageInfo.getMessageType());
		Assert.notNull(messageInfo.getSubject());
	}

}
