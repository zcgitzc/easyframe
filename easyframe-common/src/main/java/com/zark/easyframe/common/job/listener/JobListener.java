package com.zark.easyframe.common.job.listener;

import com.zark.easyframe.common.job.JobContext;


public interface JobListener {

    /**
     * 监听器名称
     * 
     * @return
     */
    String getName();

    /**
     * job执行成功时回调
     * 
     * @param context
     * @param returnVal
     */
    void jobExecuteSuccess(JobContext jobContext, Object returnVal);

    /**
     * job执行失败时回调
     * 
     * @param context
     * @param jobException
     */
    void jobExecuteFail(JobContext jobContext, Exception jobException);

    /**
     * job启动时回调
     * 
     * @param jobContext
     */
    void jobToBeExecuted(JobContext jobContext);

    /**
     * job结束时回调
     * 
     * @param jobContext
     */
    void jobFinish(JobContext jobContext);

}
