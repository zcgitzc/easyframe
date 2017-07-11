package com.zark.easyframe.common.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zark.easyframe.biz.common.utils.EnvHelper;

@Controller
public class IndexController {
	@Resource
	private EnvHelper envHelper;

	@RequestMapping("home")
	public String home(HttpServletRequest request) {
		request.setAttribute("jsCssServer", envHelper.getJsCssServer());
		return "home";
	}
	

	@RequestMapping("index")
	public String index(HttpServletRequest request) {
		return "index";
	}
}
