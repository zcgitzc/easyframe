package com.zark.easyframe.common.argresolver;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.zark.easyframe.common.argresolver.annotation.JsonParam;

public class JsonParamArgumentResolver implements HandlerMethodArgumentResolver {
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(JsonParam.class) != null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object resolveArgument(MethodParameter methodParam, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		Enumeration<?> paramEnums = request.getParameterNames();
		List<String> paramNames = new ArrayList<String>();
		Object result = null;
		while (paramEnums.hasMoreElements()) {
			// 参数名称
			String paramName = (String) paramEnums.nextElement();
			paramNames.add(paramName);
			// 参数值
			String paramValue = webRequest.getParameterValues(paramName)[0];
			Annotation annotation = methodParam.getParameterAnnotations()[0];
			if (annotation.annotationType() == JsonParam.class) {
				JsonParam jsonParam = (JsonParam) annotation;
				if (jsonParam.value().equals(paramName)) {
					Class<?> paramType = methodParam.getParameterType();
					try {
						Type type = methodParam.getGenericParameterType();

						if (MapWapper.class.isAssignableFrom(paramType)) {
							MapWapper<?, ?> jsonMap = (MapWapper<?, ?>) paramType.newInstance();
							MapType mapType = (MapType) getJavaType(HashMap.class);
							if (type instanceof ParameterizedType) {
								mapType = (MapType) mapType.narrowKey((Class<?>) ((ParameterizedType) type).getActualTypeArguments()[0]);
								mapType = (MapType) mapType.narrowContentsBy((Class<?>) ((ParameterizedType) type).getActualTypeArguments()[1]);
							}
							jsonMap.setInnerMap(mapper.<Map> readValue(paramValue, mapType));
							result = jsonMap;
						}
						JavaType javaType = getJavaType(paramType);
						if (Collection.class.isAssignableFrom(paramType)) {
							javaType = javaType.narrowContentsBy((Class<?>) ((ParameterizedType) type).getActualTypeArguments()[0]);
						}
						result = mapper.readValue(paramValue, javaType);
					} catch (IOException | IllegalAccessException | InstantiationException e) {
						throw new JsonMappingException("Could not read request json parameter", e);
					}
				}
			}
		}

		Annotation annotation = methodParam.getParameterAnnotations()[0];
		if (annotation.annotationType() == JsonParam.class) {
			JsonParam jsonParam = (JsonParam) annotation;
			if (jsonParam.required() && !paramNames.contains(jsonParam.value())) {
				throw new RuntimeException("required json param not found. name:" + jsonParam.value());
			}
		}
		return result;
	}

	protected JavaType getJavaType(Class<?> clazz) {
		return TypeFactory.defaultInstance().constructFromCanonical(clazz.getCanonicalName());
	}
}
