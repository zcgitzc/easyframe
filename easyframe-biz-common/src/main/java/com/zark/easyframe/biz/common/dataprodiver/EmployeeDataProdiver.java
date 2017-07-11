package com.zark.easyframe.biz.common.dataprodiver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.zark.easyframe.biz.common.bo.UserBo;
import com.zark.easyframe.common.datatransfer.impl.AbstractDataProvider;
import com.zark.easyframe.common.module.UserDo;

public class EmployeeDataProdiver extends AbstractDataProvider<String, String> {
	@Resource
	private UserBo userBo;

	@Override
	public Map<String, String> getTransferredData(List<String> dataList) {
		Map<String, String> result = new HashMap<String, String>(dataList.size());
		for (String data : dataList) {
			UserDo user = userBo.queryByUsername(data);
			result.put(data, user.getId() + ":" + user.getUsername());
		}
		return result;
	}

}
