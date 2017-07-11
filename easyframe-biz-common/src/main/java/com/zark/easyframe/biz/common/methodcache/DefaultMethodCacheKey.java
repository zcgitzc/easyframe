package com.zark.easyframe.biz.common.methodcache;

import java.lang.reflect.Method;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class DefaultMethodCacheKey {

	private Method method;

	private Object[] args;

	public DefaultMethodCacheKey(Method method, Object[] args) {
		this.method = method;
		this.args = args;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + argHashCode(args);
		return result;
	}

	private int argHashCode(Object arg) {
		if (null == arg) {
			return 0;
		}
		if (arg instanceof Object[]) {
			Object[] args = (Object[]) arg;
			int hashCode = 0;
			for (Object obj : args) {
				hashCode += argHashCode(obj);
			}
			return hashCode;
		} else {
			try {
				if (arg.getClass().getMethod("hashCode").getDeclaringClass().equals(Object.class)) {
					return HashCodeBuilder.reflectionHashCode(arg);
				}
				return arg.hashCode();
			} catch (SecurityException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof DefaultMethodCacheKey) {
			DefaultMethodCacheKey other = (DefaultMethodCacheKey) obj;
			return methodEquals(this.method, other.method) && argEquals(this.args, other.args);
		}
		return false;
	}

	private boolean methodEquals(Method method, Method otherMethod) {
		if (method == null) {
			return otherMethod == null;
		} else {
			return method.equals(otherMethod);
		}
	}

	private boolean argEquals(Object arg, Object otherArg) {
		if (null == arg) {
			return null == otherArg;
		} else {
			if (null == otherArg) {
				return false;
			}
			if (arg instanceof Object[] && otherArg instanceof Object[]) {
				Object[] args = (Object[]) arg;
				Object[] otherArgs = (Object[]) otherArg;
				if (args.length == otherArgs.length) {
					for (int i = 0; i < args.length; i++) {
						if (!argEquals(args[i], otherArgs[i])) {
							return false;
						}
					}
					return true;
				}
				return false;
			} else {
				return arg.equals(otherArg) || EqualsBuilder.reflectionEquals(arg, otherArg);
			}
		}
	}
}
