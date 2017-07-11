package com.zark.easyframe.common.datatransfer.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zark.easyframe.common.datatransfer.DataProvider;
import com.zark.easyframe.common.datatransfer.DataTransfer;
import com.zark.easyframe.common.datatransfer.annotation.TransferFrom;
import com.zark.easyframe.common.datatransfer.annotation.TransferSub;
import com.zark.easyframe.common.datatransfer.annotation.TransferTo;

@SuppressWarnings("rawtypes")
public class DefaultDataTransferImpl implements DataTransfer, ApplicationContextAware, InitializingBean {

	private ApplicationContext applicationContext;

	private Map<String, DataProvider> dataProviderMap;

	private Logger logger = LoggerFactory.getLogger(DefaultDataTransferImpl.class);

	@Override
	public void transfer(Object value) {
		if (value instanceof Collection) {
			transfer((Collection) value);
			return;
		}
		transfer(value.getClass(), Collections.singletonList(value));
	}

	@Override
	public void transfer(Collection<?> values) {
		if (values == null || values.isEmpty()) {
			return;
		}
		Iterator<?> iterator = values.iterator();
		transfer(iterator.next().getClass(), values);
	}

	@Override
	public void transfer(Class<?> clazz, Collection<?> values) {
		logger.debug("Begin to transfer");
		Long start = System.currentTimeMillis();
		List<TransferInfo> transferInfos = getTransferInfo(clazz);
		if (transferInfos == null || transferInfos.isEmpty()) {
			return;
		}
		Map<TransferInfo, Set<Object>> waitTransferData = getTransferData(transferInfos, values);

		doTransfer(waitTransferData, values);
		logger.debug("Transfer success, time cost : {}", System.currentTimeMillis() - start + "ms");
	}

	private void doTransfer(Map<TransferInfo, Set<Object>> waitTransferData, Collection<?> values) {
		Map<TransferInfo, Map<Object, Object>> transferredDataMap = new HashMap<DefaultDataTransferImpl.TransferInfo, Map<Object, Object>>();

		for (Map.Entry<TransferInfo, Set<Object>> entry : waitTransferData.entrySet()) {
			TransferInfo transferInfo = entry.getKey();
			if (transferInfo.isSub) {
				transfer(entry.getValue());
				continue;
			}
			Long start = System.currentTimeMillis();
			Map<Object, Object> transferredData = transferInfo.dataProvider.getTransferredData(new ArrayList<Object>(entry.getValue()));
			logger.debug("Get {} transferred time cost : {}", transferInfo.dataProvider.getType(), System.currentTimeMillis() - start + "ms");
			transferredDataMap.put(transferInfo, transferredData);
		}

		for (Object o : values) {
			BeanWrapper bw = new BeanWrapperImpl(o);
			for (Entry<TransferInfo, Map<Object, Object>> entry : transferredDataMap.entrySet()) {
				TransferInfo transferInfo = entry.getKey();
				if (transferInfo.isSub) {
					continue;
				}
				Object from = bw.getPropertyValue(transferInfo.fromField);
				Map<Object, Object> transferredData = transferredDataMap.get(transferInfo);
				if (from == null || transferredData == null) {
					continue;
				}
				bw.setPropertyValue(transferInfo.toField, transferredData.get(from));
			}

		}
	}

	@SuppressWarnings("unchecked")
	private Map<TransferInfo, Set<Object>> getTransferData(List<TransferInfo> transferInfos, Collection<?> values) {
		Map<TransferInfo, Set<Object>> result = new HashMap<TransferInfo, Set<Object>>();
		for (TransferInfo transferInfo : transferInfos) {
			result.put(transferInfo, new HashSet<Object>());
		}
		for (Object obj : values) {
			BeanWrapper bw = new BeanWrapperImpl(obj);
			for (TransferInfo transferInfo : transferInfos) {
				Object o = bw.getPropertyValue(transferInfo.fromField);
				if (o == null) {
					continue;
				}
				if (transferInfo.isColl) {
					result.get(transferInfo).addAll((Collection) o);
				} else {
					result.get(transferInfo).add(o);
				}
			}
		}
		return result;
	}

	private List<TransferInfo> getTransferInfo(Class<?> clazz) {
		List<TransferInfo> result = new ArrayList<TransferInfo>();
		if (clazz.getSuperclass() != Object.class) {
			result.addAll(getTransferInfo(clazz.getSuperclass()));
		}
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			TransferInfo transferInfo = doGetTransferInfo(field);
			if (transferInfo != null) {
				result.add(transferInfo);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private TransferInfo doGetTransferInfo(Field field) {
		Annotation[] annotations = field.getDeclaredAnnotations();

		for (Annotation annotation : annotations) {
			if (annotation.annotationType() == TransferFrom.class) {
				TransferInfo transferInfo = new TransferInfo();
				TransferFrom transferFrom = (TransferFrom) annotation;
				transferInfo.fromField = transferFrom.from();
				transferInfo.toField = field.getName();
				transferInfo.dataProvider = dataProviderMap.get(transferFrom.type());
				if (transferInfo.dataProvider == null) {
					throw new RuntimeException("Can not find data provider by type " + transferFrom.type());
				}
				return transferInfo;
			}
			if (annotation.annotationType() == TransferTo.class) {
				TransferInfo transferInfo = new TransferInfo();
				TransferTo transferTo = (TransferTo) annotation;
				transferInfo.fromField = field.getName();
				transferInfo.toField = transferTo.to();
				transferInfo.dataProvider = dataProviderMap.get(transferTo.type());
				return transferInfo;
			}
			if (annotation.annotationType() == TransferSub.class) {
				TransferInfo transferInfo = new TransferInfo();
				transferInfo.isSub = true;
				if (Collection.class.isAssignableFrom(field.getType())) {
					transferInfo.isColl = true;
				}
				transferInfo.fromField = field.getName();
				return transferInfo;
			}
		}
		return null;
	}

	private class TransferInfo {
		private String fromField;
		private String toField;
		private DataProvider<Object, Object> dataProvider;
		private boolean isSub = false;
		private boolean isColl = false;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, DataProvider> allDataProvider = applicationContext.getBeansOfType(DataProvider.class);
		dataProviderMap = new HashMap<String, DataProvider>(allDataProvider.size());
		for (DataProvider dataProvider : allDataProvider.values()) {
			dataProviderMap.put(dataProvider.getType(), dataProvider);
		}
	}
}
