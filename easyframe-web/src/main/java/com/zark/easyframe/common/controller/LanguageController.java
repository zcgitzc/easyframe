package com.zark.easyframe.common.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.zark.easyframe.common.exception.ExceptionControllerAdvice;

@Controller
@RequestMapping("lang")
public class LanguageController extends ExceptionControllerAdvice {

	@RequestMapping("changeLang")
	public void changeLang(String lang, HttpServletRequest request) {
		if (lang != null && lang.equals("zh")) {
			Locale locale = new Locale("zh", "CN");
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			request.setAttribute("language", lang);
		} else if (lang != null && lang.equals("en")) {
			Locale locale = new Locale("en", "US");
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			request.setAttribute("language", lang);
		} else {
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
			lang = LocaleContextHolder.getLocale().getLanguage();
			request.setAttribute("language", lang);
		}
	}

}
