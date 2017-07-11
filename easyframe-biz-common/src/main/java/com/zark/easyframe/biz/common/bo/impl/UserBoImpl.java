package com.zark.easyframe.biz.common.bo.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zark.easyframe.biz.common.CommonBusiLogic;
import com.zark.easyframe.biz.common.annotation.OperLog;
import com.zark.easyframe.biz.common.bo.LockBo;
import com.zark.easyframe.biz.common.bo.UserBo;
import com.zark.easyframe.biz.common.constants.LockConstants;
import com.zark.easyframe.biz.common.constants.SystemConstants;
import com.zark.easyframe.biz.common.exception.BizCommonException;
import com.zark.easyframe.biz.common.exception.CommonErrorCode;
import com.zark.easyframe.biz.common.methodcache.annotation.MethodCache;
import com.zark.easyframe.common.mapper.UserDoMapperExt;
import com.zark.easyframe.common.module.UserDo;
import com.zark.easyframe.common.module.UserDoExample;
import com.zark.easyframe.common.vo.DataResult;
import com.zark.easyframe.common.vo.Page;

public class UserBoImpl implements UserBo {
	@Resource
	private UserDoMapperExt userDoMapperExt;
	@Resource
	private LockBo lockBo;

	@OperLog(addToDb = true, description = "UserBoImpl.queryAll", operType = "QUERY_ALL_USER")
	@MethodCache(enable = false)
	@Override
	public DataResult<UserDo> queryAll(Page page) {
		CommonBusiLogic.setPageBeginByPage(page);
		List<UserDo> userDos = userDoMapperExt.queryByPage(page, null);
		int count = userDoMapperExt.countByPage(null);
		return new DataResult<UserDo>(userDos, count, page.getCurrent());
	}

	@Override
	public UserDo queryByUsername(String username) {
		return userDoMapperExt.queryByUsername(username);
	}

	@Override
	public UserDo queryCurrUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		return (UserDo) session.getAttribute(SystemConstants.SessionKey.CURR_USER.name());
	}

	@OperLog(addToDb = true, description = "UserBoImpl.addUser", operType = "ADD_USER")
	@Override
	public void addUser(UserDo userDo) {
		lockBo.lock(LockConstants.LockType.ADD_USER.name(), userDo.getUsername());
		UserDo dbUser = this.queryByUsername(userDo.getUsername());
		if (dbUser != null) {
			throw new BizCommonException("username is exists", CommonErrorCode.USERNAME_EXISTS);
		}
		userDoMapperExt.insertSelective(userDo);
	}

	@Override
	public UserDo userLogin(UserDo userDo) {
		UserDoExample example = new UserDoExample();
		example.createCriteria().andUsernameEqualTo(userDo.getUsername()).andPasswordEqualTo(userDo.getPassword());
		List<UserDo> users = userDoMapperExt.selectByExample(example);
		if (CollectionUtils.isNotEmpty(users) && users.size() == 1) {
			return users.get(0);
		} else {
			throw new BizCommonException("login fail username:" + userDo.getUsername() + ",password:" + userDo.getPassword(), CommonErrorCode.LOGIN_FAIL);
		}
	}

	@Override
	public UserDo queryById(Long id) {
		return userDoMapperExt.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Long id) {
		Assert.notNull(id, "param id can not be null");
		UserDo userDo  = new UserDo();
		userDo.setId(id);
		userDoMapperExt.deleteByPrimaryKey(userDo);
	}

	@Override
	public void updateById(UserDo userDo) {
		Assert.notNull(userDo, "param userDo can not be null");
		Assert.notNull(userDo.getId(), "param id can not be null");
		userDoMapperExt.updateByPrimaryKeySelective(userDo);
	}
}
