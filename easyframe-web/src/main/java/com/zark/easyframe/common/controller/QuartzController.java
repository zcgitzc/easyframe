package com.zark.easyframe.common.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zark.easyframe.biz.common.bo.JobBo;
import com.zark.easyframe.common.exception.ExceptionControllerAdvice;
import com.zark.easyframe.common.module.JobDo;

@Controller
@RequestMapping("quartz")
public class QuartzController extends ExceptionControllerAdvice {
	@Resource
	private JobBo jobBo;

	@RequestMapping("queryAll")
	public List<JobDo> queryAll() {
		return jobBo.queryAll();
	}

	@RequestMapping("addJob")
	public void addJob(JobDo jobDo) {
		jobBo.addJob(jobDo);
	}

	@RequestMapping("deleteJob")
	public void deleteJob(Long id) {
		jobBo.deleteJob(id);
	}

	@RequestMapping("updateJob")
	public void updateJob(JobDo jobDo) {
		jobBo.updateJob(jobDo);
	}

	@RequestMapping("pauseJob")
	public void pauseJob(Long id) {
		jobBo.pauseJob(id);
	}

	@RequestMapping("resumeJob")
	public void resumeJob(Long id) {
		jobBo.resumeJob(id);
	}

	@RequestMapping("startJob")
	public void startJob(Long id) {
		jobBo.startJob(id);
	}

}
