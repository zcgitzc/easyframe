package com.zark.easyframe.biz.common.bo;

import java.util.List;

import com.zark.easyframe.common.module.JobDo;

public interface JobBo {
	void addJob(JobDo jobDo);

	void pauseJob(Long id);

	void resumeJob(Long id);

	void deleteJob(Long id);

	void startJob(Long id);

	void updateJob(JobDo jobDo);

	List<JobDo> queryAll();
}
