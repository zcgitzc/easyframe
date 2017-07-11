package com.zark.easyframe.biz.common.constants;

public interface MessageConstants {
	enum Status {
		SENDING, SENDED, SEND_FAIL
	}

	enum MessageReceiverType {
		CC, RECEIVER, BCC
	}

	enum SendMailType {
		SIMPLE_MAIL, HTML_MAIL;
	}

	enum MessageType {
		TEST_SEND_SIMPLE_MAIL, TEST_SEND_HTML_MAIL;
	}
}
