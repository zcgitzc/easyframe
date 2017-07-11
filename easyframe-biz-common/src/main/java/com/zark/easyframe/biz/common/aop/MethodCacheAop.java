package com.zark.easyframe.biz.common.aop;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zark.easyframe.biz.common.methodcache.MethodCacheKeyBuilder;
import com.zark.easyframe.biz.common.methodcache.annotation.MethodCache;

public class MethodCacheAop {

	private static final Logger logger = LoggerFactory.getLogger(MethodCacheAop.class);
	private Map<Object, Object> objectMap = new ConcurrentHashMap<Object, Object>();

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Object key = null;
		Method method = null;
		try {
			MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
			Method interfaceMethod = methodSignature.getMethod();
			method = pjp.getTarget().getClass().getMethod(interfaceMethod.getName(), interfaceMethod.getParameterTypes());
			logger.debug("RequestCacheAspect doAround {}", method);
			MethodCache annotation = method.getAnnotation(MethodCache.class);
			if (annotation.enable()) {
				MethodCacheKeyBuilder builder = annotation.builder().newInstance();
				key = builder.build(method, pjp.getArgs());
				Object val = objectMap.get(key);
				if (null != val) {
					logger.debug("RequestCacheAspect get value from cache");
					return val;
				}
			}
		} catch (Throwable t) {
			logger.error(String.format("RequestCacheAspect ERROR, invoke %s", method), t);
		}
		Object result = pjp.proceed();
		if (null != key) {
			objectMap.put(key, result);
		}
		return result;
	}
}
