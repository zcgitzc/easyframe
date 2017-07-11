	package com.zark.easyframe.common.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zark.easyframe.biz.common.constants.I18nConstants;
import com.zark.easyframe.biz.common.exception.AbstractBizException;
import com.zark.easyframe.biz.common.exception.CommonErrorCode;
import com.zark.easyframe.biz.common.utils.I18nUtil;
import com.zark.easyframe.common.vo.DataResult;

@ControllerAdvice
@ResponseBody
public class ExceptionControllerAdvice {
	private Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public DataResult<Object> ajaxError(Throwable error, HttpServletRequest request, HttpServletResponse response) {
		logger.error(error.getMessage(), error);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		// 业务异常
		if (error instanceof AbstractBizException) {
			BizExceptionAdapter exAdapter = new BizExceptionAdapter();
			String errorMsg = exAdapter.getErrorMessage(error);
			return new DataResult<Object>(true, errorMsg);

		}
		// 参数非法
		if (error instanceof IllegalArgumentException) {
			return new DataResult<Object>(true, I18nUtil.getI18nMessage(I18nConstants.Module.COMMON, CommonErrorCode.PARAM_ERROR.name()));
		}
		// 参数校验异常
		if (error instanceof BindException) {
			BindException bindException = (BindException) error;
			BindingResult result = bindException.getBindingResult();
			if (result.hasErrors()) {
				List<String> allErrorMsgs = new ArrayList<String>();
				for (FieldError fieldError : result.getFieldErrors()) {
					String errorMsg = I18nUtil.getI18nMessage(I18nConstants.Module.COMMON, fieldError.getDefaultMessage());
					allErrorMsgs.add(errorMsg);
				}
				return new DataResult<Object>(true, allErrorMsgs);
			}
		}
		// 未知异常（运行时异常）
		return new DataResult<Object>(true, I18nUtil.getI18nMessage(I18nConstants.Module.COMMON, CommonErrorCode.UN_KNOW_EXCEPTION.name()));
	}
}