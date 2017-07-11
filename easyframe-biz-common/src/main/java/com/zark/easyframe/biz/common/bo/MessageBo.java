package com.zark.easyframe.biz.common.bo;

import com.zark.easyframe.biz.common.constants.MessageConstants;
import com.zark.easyframe.common.util.mail.MailMessageInfo;

public interface MessageBo {
	void sendMail(MailMessageInfo messageInfo, MessageConstants.SendMailType sendMailType);

}
