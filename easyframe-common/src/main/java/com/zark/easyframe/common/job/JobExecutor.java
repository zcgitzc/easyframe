package com.zark.easyframe.common.job;

import java.util.Map;

public interface JobExecutor {

	void execute(JobDetail jobDetail, Map<String, Object> initParams);

}
