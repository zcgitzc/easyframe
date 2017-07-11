package com.zark.easyframe.biz.conf.exception;

import com.zark.easyframe.biz.common.constants.I18nConstants;
import com.zark.easyframe.biz.common.exception.AbstractBizException;
import com.zark.easyframe.common.exception.ErrorCode;

public class BizConfException extends AbstractBizException {
	private static final long serialVersionUID = 1L;

	public BizConfException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

	public BizConfException(String message, Throwable cause, ErrorCode errorCode) {
		super(message, errorCode);
	}

	@Override
	public I18nConstants.Module getModelCode() {
		return I18nConstants.Module.CONF;
	}

}
