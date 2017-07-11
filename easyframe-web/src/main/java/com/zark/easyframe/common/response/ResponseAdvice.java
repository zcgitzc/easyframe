package com.zark.easyframe.common.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.zark.easyframe.common.vo.DataResult;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body instanceof DataResult) {
			return body;
		}
		DataResult<Object> dataResult = new DataResult<Object>();	
		if (body instanceof List<?>) {
			dataResult.setData((List<Object>) body);
			dataResult.setTotalCount(((List<Object>) body).size());
			return dataResult;
		}

		List<Object> list = new ArrayList<Object>();
		if (body != null) {
			list.add(body);
			dataResult.setTotalCount(1);
		}
		dataResult.setData(list);
		return dataResult;
	}
}
