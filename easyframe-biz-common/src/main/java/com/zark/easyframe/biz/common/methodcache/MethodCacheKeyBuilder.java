package com.zark.easyframe.biz.common.methodcache;

import java.lang.reflect.Method;

public abstract class MethodCacheKeyBuilder {

	public abstract Object build(Method method, Object[] args);
}
