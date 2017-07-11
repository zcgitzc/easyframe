package com.zark.easyframe.conf.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zark.easyframe.biz.conf.bo.WebPageInfoBo;
import com.zark.easyframe.biz.conf.exception.BizConfException;
import com.zark.easyframe.biz.conf.exception.ConfErrorCode;
import com.zark.easyframe.common.exception.ExceptionControllerAdvice;
import com.zark.easyframe.common.util.jsoup.JsoupUtil;
import com.zark.easyframe.common.util.jsoup.entity.SimpleCondition;
import com.zark.easyframe.common.util.jsoup.entity.WebPageInfo;
import com.zark.easyframe.conf.dto.WebPageInfoCondDto;
import com.zark.easyframe.conf.module.WebPageInfoDo;

@Controller
@RequestMapping("webPageInfo")
public class WebPageInfoController extends ExceptionControllerAdvice {

	@Resource
	private WebPageInfoBo webPageInfoBo;

	@RequestMapping("queryAll")
	public List<WebPageInfoDo> queryAll(WebPageInfoCondDto condDto) {
		return webPageInfoBo.queryAll(condDto);
	}

	@RequestMapping("queryById")
	public WebPageInfoDo queryById(Long id) {
		return webPageInfoBo.queryById(id);
	}

	@RequestMapping("add")
	public WebPageInfo add(String url, SimpleCondition condition) {
		WebPageInfo webPageInfo = JsoupUtil.parseUrl(url, condition);
		if (webPageInfo == null) {
			throw new BizConfException("parse url error. url:" + url, ConfErrorCode.PARSE_URL_ERROR).set("url", url);
		}
		WebPageInfoDo webPageInfoDo = new WebPageInfoDo();
		BeanUtils.copyProperties(webPageInfo, webPageInfoDo);
		webPageInfoDo.setContent(webPageInfo.getContent().getBytes());
		webPageInfoBo.add(webPageInfoDo);
		return webPageInfo;
	}
}
