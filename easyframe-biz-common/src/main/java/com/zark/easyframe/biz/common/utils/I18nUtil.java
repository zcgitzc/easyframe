package com.zark.easyframe.biz.common.utils;

import java.util.Locale;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.zark.easyframe.biz.common.constants.I18nConstants;
import com.zark.easyframe.biz.common.exception.CommonErrorCode;

public class I18nUtil {
	private static final String SUFFIX = ".properties";
	private static Logger logger = LoggerFactory.getLogger(I18nUtil.class);

	public static String getI18nMessage(I18nConstants.Module module, String key) {
		Assert.notNull(module, "Module can not be null");
		Assert.notNull(key, "Key can not be null");
		Properties properties = new Properties();
		Locale locale = getLocale();
		String language = locale.getLanguage();// 返回国家的语言
		String country = locale.getCountry();// 返回国家地区代码
		String filePath = "i18n/" + module.name().toLowerCase() + "_" + language + "_" + country + SUFFIX;
		try {
			properties.load(I18nUtil.class.getClassLoader().getResourceAsStream(filePath));
		} catch (Exception e) {
			throw new RuntimeException("can not find properties. filePath =" + filePath);
		}
		String result = properties.getProperty(key);
		return result;
	}

	private static Locale getLocale() {
		HttpServletRequest request = null;
		try {
			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		} catch (Exception e1) {
			logger.error("get request error...");
		}
		Locale locale = null;
		if (request != null) {
			locale = (Locale) request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		}
		if (request == null || locale == null) {
			locale = LocaleContextHolder.getLocale();
		}
		return locale;
	}

	public static void main(String[] args) {
		System.out.println(I18nUtil.getI18nMessage(I18nConstants.Module.COMMON, CommonErrorCode.PARAM_ERROR.name()));

	}
}
