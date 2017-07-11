package com.zark.easyframe.common.job.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.ReflectionUtils;

import com.zark.easyframe.common.job.JobContext;
import com.zark.easyframe.common.job.JobDetail;
import com.zark.easyframe.common.job.JobExecutor;
import com.zark.easyframe.common.job.JobStage;
import com.zark.easyframe.common.job.JobStageState;
import com.zark.easyframe.common.job.JobState;
import com.zark.easyframe.common.job.listener.JobListener;
import com.zark.easyframe.common.job.listener.JobStageListener;

public abstract class AbstractJobExecutor implements JobExecutor {

	private ThreadLocal<JobDetail> jobDetailLocal = new ThreadLocal<JobDetail>();
	private Logger logger = LoggerFactory.getLogger(AbstractJobExecutor.class);
	private AsyncTaskExecutor executor = new SimpleAsyncTaskExecutor("JobStageExecuting");

	protected void doExecute(JobDetail jobDetail, Map<String, Object> initParams) {
		JobState jobState = initJobState(jobDetail);
		JobContext jobContext = new JobContext(jobState);
		if (initParams != null) {
			for (Map.Entry<String, Object> paramEntry : initParams.entrySet()) {
				jobContext.put(paramEntry.getKey(), paramEntry.getValue());
			}
		}
		try {
			jobDetailLocal.set(jobDetail);
			notifyJobStart(jobContext);
			Object returnVal = null;
			for (int i = 0; i < jobDetail.getJobStages().size(); i++) {
				JobStage jobStage = jobDetail.getJobStages().get(i);
				JobStageState stageState;
				synchronized (jobContext) {
					jobState.setCurrentStage(jobStage);
					jobState.setCurrentStageIndex(i);
					stageState = initJobStageState(jobStage);
				}
				returnVal = doInvokeStage(jobContext, jobStage, stageState);
			}
			notifyJobSuccess(jobContext, returnVal);
		} catch (Exception e) {
			notifyJobFailure(jobContext, e);
			logger.error("execute job failure, reason : " + e.getMessage(), e);
		} finally {
			notifyJobFinish(jobContext);
			jobDetailLocal.remove();
		}
	}

	protected Object doInvokeStage(JobContext jobContext, JobStage jobStage, JobStageState stageState) throws Exception {
		Object[] args = getArguments(jobStage, jobContext, stageState);
		notifyJobStageStart(jobStage, jobContext);
		try {
			stageState.setExecuting(true);
			notifyJobStageExecuting(jobStage, jobContext, stageState);
			Object returnVal = ReflectionUtils.invokeMethod(jobStage.getTargetMethod(), jobStage.getTargetObject(), args);
			notifyJobStageSuccess(jobStage, jobContext, stageState, returnVal);
			return returnVal;
		} catch (Exception e) {
			notifyJobStageFailure(jobStage, jobContext, stageState, e);
			throw e;
		} finally {
			stageState.setExecuting(false);
		}

	}

	/**
	 * 使用该方法，需要仔细考虑并发
	 * 
	 * @param jobStage
	 * @param jobContext
	 * @param stageState
	 */
	protected void notifyJobStageExecuting(final JobStage jobStage, final JobContext jobContext, final JobStageState stageState) {
		final List<JobStageListener> listeners = jobStage.getListeners();
		if (listeners == null || listeners.isEmpty() || !jobStage.isEnableProcessingListener()) {
			return;
		}
		executor.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					JobState clonedJobState;
					JobStageState clonedStageState;
					synchronized (jobContext) {
						clonedJobState = (JobState) jobContext.getJobState().clone();
						clonedStageState = stageState.clone();
					}
					if (!clonedStageState.isExecuting()) {
						return;
					}
					for (JobStageListener listener : listeners) {
						try {
							listener.jobStageExecuting(clonedJobState, clonedStageState);
						} catch (Exception e) {
							e.printStackTrace();
							logger.error("TriggerStageListener '" + listener.getName() + "' threw exception: " + e.getMessage(), e);
						}
					}
				}
			}
		});

	}

	protected void notifyJobStageSuccess(JobStage jobStage, JobContext jobContext, JobStageState stageState, Object returnVal) {
		List<JobStageListener> listeners = jobStage.getListeners();
		if (listeners == null || listeners.isEmpty()) {
			return;
		}
		for (JobStageListener listener : listeners) {
			try {
				listener.jobStageExecuteSuccess(jobContext, stageState, returnVal);
			} catch (Exception e) {
				logger.error("TriggerStageListener '" + listener.getName() + "' threw exception: " + e.getMessage(), e);
			}
		}
	}

	protected void notifyJobStageFailure(JobStage jobStage, JobContext jobContext, JobStageState stageState, Exception exception) {
		List<JobStageListener> listeners = jobStage.getListeners();
		if (listeners == null || listeners.isEmpty()) {
			return;
		}
		for (JobStageListener listener : listeners) {
			try {
				listener.jobStageExecuteFail(jobContext, stageState, exception);
			} catch (Exception e) {
				logger.error("TriggerStageListener '" + listener.getName() + "' threw exception: " + e.getMessage(), e);
			}
		}
	}

	protected void notifyJobStageStart(JobStage jobStage, JobContext jobContext) {
		List<JobStageListener> listeners = jobStage.getListeners();
		if (listeners == null || listeners.isEmpty()) {
			return;
		}
		for (JobStageListener listener : listeners) {
			try {
				listener.jobStageToBeExecuted(jobContext);
			} catch (Exception e) {
				logger.error("TriggerStageListener '" + listener.getName() + "' threw exception: " + e.getMessage(), e);
			}
		}
	}

	protected void notifyJobStart(JobContext jobContext) {
		List<JobListener> jobListeners = jobDetailLocal.get().getListeners();
		if (jobListeners == null || jobListeners.isEmpty()) {
			return;
		}
		for (JobListener listener : jobListeners) {
			try {
				listener.jobToBeExecuted(jobContext);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("TriggerListener '" + listener.getName() + "' threw exception: " + e.getMessage(), e);
			}
		}
	}

	protected void notifyJobFinish(JobContext jobContext) {
		List<JobListener> jobListeners = jobDetailLocal.get().getListeners();
		if (jobListeners == null || jobListeners.isEmpty()) {
			return;
		}
		for (JobListener listener : jobListeners) {
			try {
				listener.jobFinish(jobContext);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("TriggerListener '" + listener.getName() + "' threw exception: " + e.getMessage(), e);
			}
		}

	}

	protected void notifyJobSuccess(JobContext context, Object returnVal) {
		List<JobListener> jobListeners = jobDetailLocal.get().getListeners();
		if (jobListeners == null || jobListeners.isEmpty()) {
			return;
		}
		for (JobListener listener : jobListeners) {
			try {
				listener.jobExecuteSuccess(context, returnVal);
			} catch (Exception e) {
				logger.error("TriggerListener '" + listener.getName() + "' threw exception: " + e.getMessage(), e);
			}
		}
	}

	protected void notifyJobFailure(JobContext context, Exception jobException) {
		List<JobListener> jobListeners = jobDetailLocal.get().getListeners();
		if (jobListeners == null || jobListeners.isEmpty()) {
			return;
		}
		for (JobListener listener : jobListeners) {
			try {
				listener.jobExecuteFail(context, jobException);
			} catch (Exception e) {
				logger.error("TriggerListener '" + listener.getName() + "' threw exception: " + e.getMessage(), e);
			}
		}
	}

	protected JobStageState initJobStageState(JobStage jobStage) {
		JobStageState jobStageState = new JobStageState();
		jobStageState.setCurrentDealed(0);
		jobStageState.setSum(0);
		return jobStageState;
	}

	protected JobState initJobState(JobDetail jobDetail) {
		JobState jobState = new JobState();
		jobState.setJobUUId(UUID.randomUUID().toString());
		jobState.setAllStages(jobDetail.getJobStages());
		return jobState;
	}

	private Object[] getArguments(JobStage jobStage, JobContext jobContext, JobStageState jobStageState) {
		int argLength = jobStage.getParamKeys().size();
		if (jobStage.isNeedContext()) {
			argLength++;
		}
		if (jobStage.isNeedStageState()) {
			argLength++;
		}
		Object[] arguments = new Object[argLength];
		for (int i = 0, keyIndex = 0; i < argLength; i++) {
			if (jobStage.isNeedContext() && i == jobStage.getContextParamIndex()) {
				arguments[i] = jobContext;
				continue;
			}
			if (jobStage.isNeedStageState() && i == jobStage.getStageStateParamIndex()) {
				arguments[i] = jobStageState;
				continue;
			}
			arguments[i] = jobContext.get(jobStage.getParamKeys().get(keyIndex++));
		}
		return arguments;
	}

	public AsyncTaskExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(AsyncTaskExecutor executor) {
		this.executor = executor;
	}

}
