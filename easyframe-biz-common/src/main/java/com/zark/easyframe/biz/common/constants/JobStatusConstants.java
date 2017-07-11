package com.zark.easyframe.biz.common.constants;

public interface JobStatusConstants {

	enum JobSystemParam {
		//
		JobStatus("__JobStatus"),
		//
		Locale("__Locale");

		private final String value;

		JobSystemParam(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	enum JobListenerName {
		/** 本地语言 */
		LOCALE_LISTENER,
		/** 生命周期管理 */
		LIFE_CYCLE_LISTENER,
		/** 缓存 */
		CACHE_LINSTER,
		/** 阶段 */
		STAGE_LISTENER;
	}

	enum JobStatus {
		/** 新建 */
		NEW,
		/** 运行中 */
		EXECUTING,
		/** 完成 */
		FINISHED;
	}

	enum JobName {
		/** 测试JOB */
		TEST_JOB_EXECUTE_NAME;
	}
}
