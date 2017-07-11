package com.zark.easyframe.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

public class MDCFilter implements Filter {
	// MDC填充的KEY
	public static final String HOST_IP = "HOST_IP";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取web.xml文件中的全局变量
		// filterConfig.getInitParameter("appkey");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// logback 添加 HOST_IP %X{HOST_IP}
		try {
			// 填充MDC
			MDC.put(MDCFilter.HOST_IP, StringUtils.isEmpty(request.getRemoteAddr()) ? "NOT_FOUND_IP" : request.getRemoteAddr());
			chain.doFilter(request, response);
		} finally {
			// 请求结束，注意清除MDC中的内容，否则会造成内存泄露问题
			MDC.remove(MDCFilter.HOST_IP);
		}
	}

	@Override
	public void destroy() {

	}

}
