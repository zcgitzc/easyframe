package com.zark.easyframe.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.zark.easyframe.biz.common.constants.I18nConstants;
import com.zark.easyframe.biz.common.exception.AbstractBizException;
import com.zark.easyframe.biz.common.exception.BizCommonException;
import com.zark.easyframe.biz.common.utils.I18nUtil;

/**
 * @author karl on 16-2-5.
 */
public class BizExceptionAdapter implements ExceptionAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(BizExceptionAdapter.class);

	@Override
	public String getErrorMessage(Throwable exception) {
		AbstractBizException e = (AbstractBizException) exception;
		try {
			String tempString = getTempString(e);
			return String.format(tempString, e.getProperties().values().toArray());
		} catch (Throwable t) {
			LOGGER.error(String.format("BizCommonExceptionAdapter Error. Param[errorCode = %s, errorName]", e.getErrorCode().toString(), e.getErrorCode().toString()), t);
			return e.getErrorCode().toString();
		}
	}

	private String getTempString(AbstractBizException e) {
		ErrorCode errorCode = e.getErrorCode();
		I18nConstants.Module module = e.getModule();
		String i18nMessage = I18nUtil.getI18nMessage(module, errorCode.toString());
		if (StringUtils.isEmpty(i18nMessage)) {
			throw new RuntimeException("Can't find i18n: " + errorCode.toString());
		}
		return i18nMessage;
	}

	@Override
	public Class<? extends Throwable> getExceptionClass() {
		return BizCommonException.class;
	}

	@Override
	public void log(Logger logger, String logPrefix, Throwable exception) {
		BizCommonException e = (BizCommonException) exception;
		logger.error(logPrefix + e.getMessage(), e);
	}
}
