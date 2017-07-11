package com.zark.easyframe.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ch.qos.logback.ext.spring.web.WebLogbackConfigurer;

public class LogbackListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 设置logback的配置项
		// System.setProperty("log.root.level", "INFO");
		//http://www.cnblogs.com/softidea/archive/2016/03/13/5271761.html
		//WebLogbackConfigurer.initLogging(event.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
