package com.zark.easyframe.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zark.easyframe.biz.common.bo.UserBo;
import com.zark.easyframe.biz.common.vo.UserVo;
import com.zark.easyframe.common.argresolver.annotation.JsonParam;
import com.zark.easyframe.common.datatransfer.DataTransfer;
import com.zark.easyframe.common.exception.ExceptionControllerAdvice;
import com.zark.easyframe.common.module.UserDo;
import com.zark.easyframe.common.vo.DataResult;
import com.zark.easyframe.common.vo.Page;
import com.zark.easyframe.common.vo.QueryUserCond;

@Controller
@RequestMapping("user")
public class UserController extends ExceptionControllerAdvice {
	@Resource
	private UserBo userBo;
	@Resource
	private DataTransfer dataTransfer;

	@RequestMapping("queryAll")
	public DataResult<UserDo> queryAll(@JsonParam(required = false, value = "page") Page page, @JsonParam(value = "cond") QueryUserCond queryUserCond) {
		DataResult<UserDo> result = userBo.queryAll(page);
		List<UserVo> userVos = new ArrayList<UserVo>(result.getData().size());
		for (UserDo user : result.getData()) {
			UserVo userVo = new UserVo();
			BeanUtils.copyProperties(user, userVo);
			dataTransfer.transfer(userVo);
			userVos.add(userVo);
		}
		return result;
	}

	@RequestMapping("addUser")
	public void addUser(@JsonParam(value = "userDo") UserDo userDo) {
		userBo.addUser(userDo);
	}

	@RequestMapping("queryById")
	public UserDo queryById(Long id) {
		return userBo.queryById(id);
	}
	
	@RequestMapping("deleteById")
	public void deleteById(Long id) {
		userBo.deleteById(id);
	}
	
	@RequestMapping("updateById")
	public void updateById(@JsonParam(value = "userDo") UserDo userDo) {
		 userBo.updateById(userDo);
	}
	
}
