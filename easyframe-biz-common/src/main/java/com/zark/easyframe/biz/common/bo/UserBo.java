package com.zark.easyframe.biz.common.bo;

import com.zark.easyframe.common.module.UserDo;
import com.zark.easyframe.common.vo.DataResult;
import com.zark.easyframe.common.vo.Page;

public interface UserBo {
	DataResult<UserDo> queryAll(Page page);

	UserDo queryByUsername(String username);

	UserDo queryCurrUser();

	void addUser(UserDo userDo);

	UserDo userLogin(UserDo userDo);
	
	UserDo queryById(Long id);
	
	void deleteById(Long id);
	
	void updateById(UserDo userDo);
}
