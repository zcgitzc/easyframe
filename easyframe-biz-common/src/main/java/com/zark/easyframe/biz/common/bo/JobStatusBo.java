package com.zark.easyframe.biz.common.bo;

import com.zark.easyframe.common.module.JobStatusDo;

public interface JobStatusBo {
	JobStatusDo createNewJobStatus(String jobName);

	void updateJobStatus(JobStatusDo jobStatus);

	JobStatusDo lockJobStatusByUUId(String uuId);

	JobStatusDo getStatusById(Long id, boolean castException);
}
