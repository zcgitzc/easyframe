package com.zark.easyframe.biz.common.vo;

import org.hibernate.validator.constraints.NotEmpty;

import com.zark.easyframe.common.datatransfer.annotation.TransferFrom;
import com.zark.easyframe.common.module.UserDo;


public class UserVo extends UserDo {
	@TransferFrom(from = "username", type = "Employee")
	@NotEmpty(message = "USERNAME_CANNOT_NULL")
	private String usernameText;

	public String getUsernameText() {
		return usernameText;
	}

	public void setUsernameText(String usernameText) {
		this.usernameText = usernameText;
	}

}
