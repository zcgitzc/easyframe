package com.zark.easyframe.biz.common.bo.impl;

import javax.annotation.Resource;

import com.zark.easyframe.biz.common.bo.MessageReceiverBo;
import com.zark.easyframe.common.mapper.MessageReceiverDoMapperExt;
import com.zark.easyframe.common.module.MessageReceiverDo;

public class MessageReceiverBoImpl implements MessageReceiverBo {
	@Resource
	private MessageReceiverDoMapperExt messageReceiverDoMapperExt;

	@Override
	public void addMessageReceiver(MessageReceiverDo messageReceiverDo) {
		messageReceiverDoMapperExt.insertSelective(messageReceiverDo);
	}

}
