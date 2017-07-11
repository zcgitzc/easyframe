package com.zark.easyframe.biz.common.methodcache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zark.easyframe.biz.common.methodcache.DefaultMethodCacheKeyBuilder;
import com.zark.easyframe.biz.common.methodcache.MethodCacheKeyBuilder;

/**
 * 在实现类上使用此注解,可使用Requset级别缓存
 * 
 * <pre>
 * 默认使用方法的method和args作为缓存的键值
 * 若方法的参数中存在未重载hashCode()和equals()的,默认实现已做兼容,但建议自定义MethodCacheKeyBuilder
 * </pre>
 * 
 * @author yc 2015年4月2日 下午5:34:40
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodCache {

	boolean enable() default true;

	Class<? extends MethodCacheKeyBuilder> builder() default DefaultMethodCacheKeyBuilder.class;

}
