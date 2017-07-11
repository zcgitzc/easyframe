package com.zark.easyframe.biz.common.aop;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.zark.easyframe.biz.common.annotation.OperLog;
import com.zark.easyframe.biz.common.bo.OperLogBo;
import com.zark.easyframe.biz.common.constants.OperLogConstants;
import com.zark.easyframe.common.module.OperLogDo;

public class OperLogAop {
	private static final Logger logger = LoggerFactory.getLogger(OperLogAop.class);

	@Resource
	private OperLogBo operLogBo;

	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		logger.debug("start execute method:" + methodName);
		try {
			Object result = joinPoint.proceed();
			addLogToDb(joinPoint, true, null);
			return result;
		} catch (Throwable e) {
			addLogToDb(joinPoint, false, e.getMessage());
			throw e;
		}
	}

	private void addLogToDb(ProceedingJoinPoint joinPoint, boolean isSuccess, String errorMessage) {
		String methodName = joinPoint.getSignature().getName();
		String targetName = joinPoint.getTarget().getClass().getName();
		Class<?> targetClass;
		try {
			targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					OperLog operLog = method.getAnnotation(OperLog.class);
					if (operLog != null) {
						String params = "";
						if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
							if (joinPoint.getArgs()[0] == null) {
								params += "";
							} else {
								params += JSON.toJSONString(joinPoint.getArgs()[0]);
							}
						}
						if (operLog.addToDb()) {
							OperLogDo operLogDo = new OperLogDo();
							operLogDo.setDescription(operLog.description());
							operLogDo.setOperType(operLog.operType());
							operLogDo.setStatus(isSuccess ? OperLogConstants.Status.SUCCESS.name() : OperLogConstants.Status.FAILURE.name());
							operLogDo.setErrorMsg(errorMessage);
							operLogDo.setParams(params);
							operLogBo.addOperLog(operLogDo);
						}
						logger.info("execute method {} success . params : {}", method.getName(), params);
						break;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			logger.error("aop add log error. class not found . class : {}", targetName, e);
		}
	}
}
