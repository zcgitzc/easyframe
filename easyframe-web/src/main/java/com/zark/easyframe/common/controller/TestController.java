package com.zark.easyframe.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zark.easyframe.biz.common.bo.JobStatusBo;
import com.zark.easyframe.biz.common.bo.MessageBo;
import com.zark.easyframe.biz.common.bo.UserBo;
import com.zark.easyframe.biz.common.constants.JobStatusConstants;
import com.zark.easyframe.biz.common.constants.MessageConstants;
import com.zark.easyframe.biz.common.exception.BizCommonException;
import com.zark.easyframe.biz.common.exception.CommonErrorCode;
import com.zark.easyframe.biz.common.job.JobExecuteHelper;
import com.zark.easyframe.biz.common.notify.publisher.bo.CommonSelfPublisherBo;
import com.zark.easyframe.biz.common.quartz.QuartzManager;
import com.zark.easyframe.biz.common.utils.DBUtil;
import com.zark.easyframe.biz.common.vo.UserVo;
import com.zark.easyframe.common.argresolver.annotation.JsonParam;
import com.zark.easyframe.common.exception.ExceptionControllerAdvice;
import com.zark.easyframe.common.mapper.UserDoMapperExt;
import com.zark.easyframe.common.module.JobStatusDo;
import com.zark.easyframe.common.module.UserDo;
import com.zark.easyframe.common.util.mail.MailMessageInfo;
import com.zark.easyframe.common.vo.DataResult;

@Controller
@RequestMapping("test")
public class TestController extends ExceptionControllerAdvice {
	@Resource
	private QuartzManager quartzManager;
	@Resource
	private MessageBo messageBo;
//	@Resource
//	private CommonSelfPublisherBo commonSelfPublisherBo;
	@Resource
	private UserBo userBo;
	@Resource
	private JobExecuteHelper jobExecuteHelper;
	@Resource
	private JobStatusBo jobStatusBo;

	private static final String TEMPLATE_PATH = "templates/testSendHtmlMail.vm";

	@RequestMapping("testException1")
	public DataResult<Object> testException() {
		System.out.println(1 / 0);
		return null;
	}

	@RequestMapping("testException2")
	public DataResult<Object> testException2() {
		throw new BizCommonException("param error", CommonErrorCode.PARAM_ERROR);
	}

	@RequestMapping("testDbUtil")
	public void testDbUtil() {
		List<UserDo> users = new ArrayList<UserDo>();
		UserDo user = new UserDo();
		user.setUsername("testDbUtil - username");
		user.setDescription("check base columns ");
		user.setCreator("zc");
		user.setModifier("user");

		UserDo user2 = new UserDo();
		user2.setUsername("testDbUtil - username - no creator");
		user2.setDescription("check base columns ");
		users.add(user2);
		DBUtil.insertBatch(UserDoMapperExt.class, users);
	}

	@RequestMapping("testValid")
	public String testValid(@Valid UserVo userVo) {
		return userVo.getUsernameText();
	}

	@RequestMapping("testRequestBody")
	public UserDo testRequestBody(@RequestBody UserDo userDo) {
		return userDo;
	}

	@RequestMapping("testComplexReponse")
	public Map<String, Map<String, List<UserDo>>> testComplexReponse() {
		Map<String, Map<String, List<UserDo>>> result = new HashMap<String, Map<String, List<UserDo>>>();
		Map<String, List<UserDo>> sub = new HashMap<String, List<UserDo>>();
		List<UserDo> userDos = new ArrayList<UserDo>();
		UserDo u = new UserDo();
		u.setCreator("system");
		u.setUsername("username");
		userDos.add(u);
		sub.put("b", userDos);
		result.put("a", sub);
		return result;
	}

	@RequestMapping("testResponsVoid")
	public void testResponseVoid(@RequestParam String username) {
		System.out.println("testResponseVoid");
	}

	@RequestMapping("testRequestJsonParam")
	public UserDo testRequestJsonParam(@JsonParam(value = "userDo") UserDo userDo) {
		System.out.println(userDo.getUsername());
		return userDo;
	}

	@RequestMapping("testSendSimpleMail")
	public void testSendSimpleMail() {
		MailMessageInfo mailMessageInfo = new MailMessageInfo();
		mailMessageInfo.setContent("在干吗？");
		mailMessageInfo.setSubject("来自外太空的信件");
		mailMessageInfo.setMessageType(MessageConstants.MessageType.TEST_SEND_SIMPLE_MAIL.name());
		mailMessageInfo.setReceivers(new String[] { "486289410@qq.com" });
		messageBo.sendMail(mailMessageInfo, MessageConstants.SendMailType.SIMPLE_MAIL);
	}

	@RequestMapping("testSendHtmlMail")
	public void testSendHtmlMail() {
		MailMessageInfo mailMessageInfo = new MailMessageInfo();
		mailMessageInfo.setSubject("来自外太空的信件");
		mailMessageInfo.setMessageType(MessageConstants.MessageType.TEST_SEND_HTML_MAIL.name());
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("test", "测试一下");
		mailMessageInfo.setTemplateName(TEMPLATE_PATH);
		mailMessageInfo.setVariables(values);

		Map<String, String> attachmentMaps = new HashMap<String, String>();
		attachmentMaps.put("mybatis-generate-plugin.jar", "C:\\mybatis-generate-plugin.jar");
		// key-文件名称 value-文件路径
		mailMessageInfo.setAttachmentMaps(attachmentMaps);

		mailMessageInfo.setReceivers(new String[] { "486289410@qq.com" });
		messageBo.sendMail(mailMessageInfo, MessageConstants.SendMailType.HTML_MAIL);
	}

//	@RequestMapping("testSendMetaQ")
//	public void testSendMetaQ() {
//		commonSelfPublisherBo.userRegisterSuccessNotify(111111L);
//	}

	@RequestMapping("testTransaction")
	public void testTransaction() {
		UserDo userDo = new UserDo();
		userDo.setUsername("testTransaction");
		userDo.setPassword("testTransaction");
		userBo.addUser(userDo);
	}

	@RequestMapping("testJobExecute")
	public JobStatusDo testJobExecute() {
		Map<String, Object> initParams = new HashMap<String, Object>();
		initParams.put("test", "test");
		return jobExecuteHelper.executeJob(JobStatusConstants.JobName.TEST_JOB_EXECUTE_NAME, initParams);
	}

}
