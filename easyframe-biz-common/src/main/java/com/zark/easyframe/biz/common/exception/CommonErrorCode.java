package com.zark.easyframe.biz.common.exception;

import com.zark.easyframe.common.exception.ErrorCode;

public enum CommonErrorCode implements ErrorCode {
	// 参数错误
	PARAM_ERROR,
	// 用户名已存在
	USERNAME_EXISTS,
	// 类没有找到:%s
	CLASS_NOT_FOUND,
	// 任务已经存在 任务组：%s 任务名称：%s
	JOB_EXISTS,
	// 只有未开始的任务才能启动
	START_JOB_STATUS_ERROR,
	// 只有运行中的任务才能暂停
	PAUSE_JOB_STATUS_ERROR,
	// 只有暂停的任务才能恢复
	RESUME_JOB_STATUS_ERROR,
	// 未知异常
	UN_KNOW_EXCEPTION,
	// 登录失败
	LOGIN_FAIL,
	//发送消息失败
	SEND_NOTIFY_ERROR
	;

}
