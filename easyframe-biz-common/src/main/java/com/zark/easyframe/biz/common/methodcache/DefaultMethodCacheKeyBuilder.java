package com.zark.easyframe.biz.common.methodcache;

import java.lang.reflect.Method;

public class DefaultMethodCacheKeyBuilder extends MethodCacheKeyBuilder {

	@Override
	public Object build(Method method, Object[] args) {
		return new DefaultMethodCacheKey(method, args);
	}

}
