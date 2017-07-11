package com.zark.easyframe.common.util.mail;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.zark.easyframe.common.util.VeloctiyTemplateUtil;

/**
 * 邮件发送
 */
public class SendMailUtil {

	private static final Logger logger = LoggerFactory.getLogger(SendMailUtil.class);

	private static final String EMAILENCODING = "UTF-8";
	private static JavaMailSender mailSender;
	private static String sender;

	public SendMailUtil() {
		super();
	}

	/**
	 * 简单邮件发送
	 * 
	 * @param messageInfo
	 */
	public static void sendSimpleMail(MailMessageInfo messageInfo) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		String sender2 = messageInfo.getFrom();
		if (StringUtils.isEmpty(sender2)) {
			sender2 = sender;
		}
		simpleMessage.setFrom(sender2);
		// 邮件标题
		simpleMessage.setSubject(messageInfo.getSubject());
		// 邮件内容
		simpleMessage.setText(messageInfo.getContent());
		// 设置多个收件人，也可以单独发送给一个人
		simpleMessage.setTo(messageInfo.getReceivers());
		simpleMessage.setCc(messageInfo.getCc());
		// 发送
		mailSender.send(simpleMessage);
		logger.info("mail sended from {}, to {}", sender, Arrays.toString(messageInfo.getReceivers()));
	}

	/**
	 * 获得邮件模板
	 * 
	 * @param templateName
	 * @param vars
	 * @return
	 */
	private static String getContent(String templateName, Map<String, Object> vars) {
		return VeloctiyTemplateUtil.getContent(templateName, vars);
	}

	/**
	 * 带附件的邮件发送
	 * 
	 * @param messageInfo
	 * @throws Exception
	 */
	public static void sendHtmlMail(MailMessageInfo messageInfo) throws Exception {

		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = mailSender.createMimeMessage();

		// multipart模式为true时发送附件 可以设置html格式
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, EMAILENCODING);
		String realSender = messageInfo.getFrom();
		if (StringUtils.isEmpty(realSender)) {
			realSender = sender;
		}
		// 设置多个收件人，也可以单独发送给一个人
		messageHelper.setFrom(realSender);
		messageHelper.setTo(messageInfo.getReceivers());
		messageHelper.setSubject(messageInfo.getSubject());

		String content = getContent(messageInfo.getTemplateName(), messageInfo.getVariables());
		logger.debug(content);
		messageHelper.setText(content, true);

		// 设置附件信息
		for (Map.Entry<String, String> entry : messageInfo.getAttachmentMaps().entrySet()) {
			String fileName = entry.getKey().toString();
			String filePath = entry.getValue().toString();

			FileSystemResource file = new FileSystemResource(new File(filePath)); // 读取附件
			messageHelper.addAttachment(MimeUtility.encodeWord(fileName), file);
		}
		mailSender.send(mailMessage);
	}

	@Resource
	public void setMailSender(JavaMailSender mailSender) {
		SendMailUtil.mailSender = mailSender;
	}

	public void setSender(String sender) {
		SendMailUtil.sender = sender;
	}
}
