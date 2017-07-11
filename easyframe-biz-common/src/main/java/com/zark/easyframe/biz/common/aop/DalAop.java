package com.zark.easyframe.biz.common.aop;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.zark.easyframe.biz.common.bo.UserBo;
import com.zark.easyframe.common.module.UserDo;

public class DalAop {

	private static final String CREATOR = "creator";
	private static final String MODIFIER = "modifier";
	private static final String GMT_CREATE = "gmtCreate";
	private static final String GMT_MODIFIED = "gmtModified";

	@Resource
	private UserBo userBo;

	public void beforeInsert(JoinPoint jp) {
		Object[] args = jp.getArgs();

		if (args != null && args.length > 0) {
			Object argument = args[0];
			BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
			if (beanWrapper.isWritableProperty(GMT_CREATE)) {
				beanWrapper.setPropertyValue(GMT_CREATE, new Date());
			}
			if (beanWrapper.isWritableProperty(GMT_MODIFIED)) {
				beanWrapper.setPropertyValue(GMT_MODIFIED, new Date());
			}
			if (beanWrapper.isWritableProperty(CREATOR)) {
				beanWrapper.setPropertyValue(CREATOR, getCurrUsername());
			}
			if (beanWrapper.isWritableProperty(MODIFIER)) {
				beanWrapper.setPropertyValue(MODIFIER, getCurrUsername());
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void beforeUpdate(JoinPoint jp) {

		Object[] args = jp.getArgs();
		if (args != null && args.length > 0) {
			Object argument = args[0];

			if (argument instanceof Map) {
				Map map = (Map) argument;
				map.put(GMT_MODIFIED, new Date());
				map.put(MODIFIER, getCurrUsername());
			} else {
				BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
				if (beanWrapper.isWritableProperty(GMT_MODIFIED)) {
					beanWrapper.setPropertyValue(GMT_MODIFIED, new Date());
				}
				if (beanWrapper.isWritableProperty(MODIFIER)) {
					beanWrapper.setPropertyValue(MODIFIER, getCurrUsername());
				}
			}
		}
	}

	private String getCurrUsername() {
		UserDo user;
		try {
			user = userBo.queryCurrUser();
			return user.getUsername();
		} catch (Exception e) {
			return "system";
		}
	}

}
