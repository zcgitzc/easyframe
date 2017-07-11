package com.zark.easyframe.biz.common.exception;

import com.zark.easyframe.biz.common.constants.I18nConstants;
import com.zark.easyframe.common.exception.ErrorCode;

public class BizCommonException extends AbstractBizException {
	private static final long serialVersionUID = 1L;

	public BizCommonException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}
	
	public BizCommonException(String message, Throwable cause, ErrorCode errorCode) {
		super(message, errorCode);
	}

	@Override
	public I18nConstants.Module getModelCode() {
		return I18nConstants.Module.COMMON;
	}

}
