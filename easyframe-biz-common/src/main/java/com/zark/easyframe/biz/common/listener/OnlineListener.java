package com.zark.easyframe.biz.common.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zark.easyframe.biz.common.constants.SystemConstants;
import com.zark.easyframe.common.module.UserDo;

public class OnlineListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
	private static final Logger logger = LoggerFactory.getLogger(OnlineListener.class);

	// 声明一个ServletContext对象
	private ServletContext application = null;

	/**
	 * 给session赋值时触发
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// 如果登陆成功，则将用户名保存在列表之中
		@SuppressWarnings("unchecked")
		Set<UserDo> allOnlineUser = (Set<UserDo>) this.application.getAttribute("onLineUsers");
		if (se.getValue() instanceof UserDo) {
			allOnlineUser.add((UserDo) se.getValue());
		}
		this.application.setAttribute("allOnlineUser", allOnlineUser);
	}

	/**
	 * 移除session值时触发
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		refreshCurrUser(se.getSession());
	}

	/**
	 * 替换session值时触发
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

	/**
	 * session创建时触发
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
	}

	/**
	 * session销毁时被触发
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		refreshCurrUser(se.getSession());
	}

	/**
	 * 服务器启动
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.debug("server start ... ");
		// 容器初始化时，向application中存放一个空的容器
		this.application = sce.getServletContext();
		this.application.setAttribute("allOnlineUser", new HashSet<UserDo>());

	}

	/**
	 * 服务器销毁
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.debug("server shutdown ... ");
	}

	private void refreshCurrUser(HttpSession session) {
		// 将用户名称从列表中删除
		@SuppressWarnings("unchecked")
		Set<UserDo> allOnlineUser = (Set<UserDo>) this.application.getAttribute("onLineUsers");
		UserDo user;
		try {
			user = (UserDo) session.getAttribute(SystemConstants.SessionKey.CURR_USER.name());
			allOnlineUser.remove(user);
			this.application.setAttribute("allOnlineUser", allOnlineUser);
		} catch (Exception e) {

		}
	}

}
