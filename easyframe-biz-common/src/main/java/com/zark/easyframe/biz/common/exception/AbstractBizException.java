package com.zark.easyframe.biz.common.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import com.zark.easyframe.biz.common.constants.I18nConstants;
import com.zark.easyframe.common.exception.ErrorCode;

public abstract class AbstractBizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public abstract I18nConstants.Module getModelCode();

	private ErrorCode errorCode;

	private final Map<String, Object> properties = new LinkedHashMap<String, Object>();

	public AbstractBizException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public AbstractBizException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	private void copyExceptionProperties(Throwable cause) {
		if (cause instanceof AbstractBizException) {
			AbstractBizException se = (AbstractBizException) cause;
			for (String key : se.getProperties().keySet()) {
				properties.put(key, se.getProperties().get(key));
			}
		}
	}

	public AbstractBizException(Throwable cause, ErrorCode errorCode) {
		super(cause);
		this.errorCode = errorCode;
		copyExceptionProperties(cause);

	}

	public AbstractBizException(String message, Throwable cause, ErrorCode errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
		copyExceptionProperties(cause);
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public I18nConstants.Module getModule() {
		return getModelCode();
	}

	public AbstractBizException setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String name) {
		return (T) properties.get(name);
	}

	public AbstractBizException set(String name, Object value) {
		properties.put(name, value);
		return this;
	}

	public String getLocalMessage() {
		return super.getMessage();
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder(128);
		sb.append("\r\n\tmessage=[").append(super.getMessage()).append("]");
		if (errorCode != null) {
			sb.append("\r\n\terrorCode=").append(errorCode.toString());
		}
		if (!properties.isEmpty()) {
			for (Map.Entry<String, Object> entry : properties.entrySet()) {
				sb.append("\r\n\t").append(entry.getKey()).append("=[").append(entry.getValue()).append("]");
			}
		}
		sb.append("\r\n\t---");
		return sb.toString();
	}
}
