package com.zark.easyframe.biz.common.job;

import com.zark.easyframe.common.job.JobContext;
import com.zark.easyframe.common.job.annotation.Param;

public class TestJob {
	public void method1(@Param(name = "test") String test, JobContext jobContext) {
		System.out.println(test);
		System.out.println("method1 executing ... ");
		jobContext.put("method1", "method1 reuslt");
	}

	public void method2(@Param(name = "method1") String method1, JobContext jobContext) {
		System.out.println(method1);
		System.out.println("method2 executing ... ");
		jobContext.put("method2", "method2 reuslt");
	}

	public void method3(@Param(name = "method2") String method2, JobContext jobContext) {
		System.out.println(method2);
		System.out.println("method3 executing ... ");
		jobContext.put("method3", "method3 reuslt");
	}

	public void method4(@Param(name = "method3") String method3, JobContext jobContext) {
		System.out.println("method4 executing ... ");
		System.out.println(method3);
	}
}
