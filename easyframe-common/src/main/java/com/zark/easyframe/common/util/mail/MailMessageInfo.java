package com.zark.easyframe.common.util.mail;

import java.util.HashMap;
import java.util.Map;

public class MailMessageInfo {
	private String subject;
	private String content;
	private String templateName;
	private String from;
	private String messageType;
	private String[] receivers;
	private String[] cc;
	private String[] bcc;
	private Map<String, String> attachmentMaps = new HashMap<String, String>();
	private Map<String, Object> variables = new HashMap<String, Object>(); // 填充模板集合

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[] getReceivers() {
		return receivers;
	}

	public void setReceivers(String[] receivers) {
		this.receivers = receivers;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Map<String, String> getAttachmentMaps() {
		return attachmentMaps;
	}

	public void setAttachmentMaps(Map<String, String> attachmentMaps) {
		this.attachmentMaps = attachmentMaps;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}

	public Map<String, Object> getVariables() {
		return this.variables;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

}
