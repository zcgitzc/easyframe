package com.zark.easyframe.biz.common.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zark.easyframe.common.module.JobDo;

/**
 * 任务调度管理类
 * 
 */
public class QuartzManager {
	private static final Logger logger = LoggerFactory.getLogger(QuartzManager.class);

	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

	private Scheduler scheduler;

	public QuartzManager() {
		super();
		try {
			this.scheduler = schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化任务调度
	 */
	public void initJob(JobDo job, @SuppressWarnings("rawtypes") Class cls) {
		logger.info("初始化任务调度");
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (null == trigger) {
				addQuartzJob(job, trigger, cls);
			}
		} catch (Exception e) {
			logger.error("初始化任务调度异常！" + e.getMessage(), e);
		}
	}

	/**
	 * 向任务调度中添加定时任务
	 * 
	 * @param job
	 *            定时任务信息
	 * @param trigger
	 *            定时调度触发器
	 */
	public void addQuartzJob(JobDo job, CronTrigger trigger, @SuppressWarnings("rawtypes") Class cls) {
		logger.info("向任务调度中添加定时任务");
		try {
			@SuppressWarnings("unchecked")
			JobDetail jobDetail = JobBuilder.newJob(cls).withIdentity(job.getJobName(), job.getJobGroup()).build();
			jobDetail.getJobDataMap().put(job.getJobName(), job);
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
			trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			logger.error("向任务调度中添加定时任务异常！" + e.getMessage(), e);
		}
	}

	/**
	 * 立即运行定时任务
	 * 
	 * @param job
	 *            定时任务信息
	 */
	public void runJob(JobDo job) {
		logger.info("立即运行任务调度中的定时任务");
		try {
			if (null == job) {
				logger.info("定时任务信息为空，无法立即运行");
				return;
			}
			JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
			if (null == jobKey) {
				logger.info("任务调度中不存在[" + job.getJobName() + "]定时任务，不予立即运行！");
				return;
			}
			scheduler.start();
		} catch (Exception e) {
			logger.error("立即运行任务调度中的定时任务异常！" + e.getMessage(), e);
		}
	}

	/**
	 * 修改任务调度中的定时任务
	 * 
	 * @param job
	 *            定时任务信息
	 * @param triggerKey
	 *            定时调度触发键
	 * @param trigger
	 *            定时调度触发器
	 */
	public void updateQuartzJob(JobDo job, String newCronExpresion) {
		logger.info("修改任务调度中的定时任务");
		try {
			TriggerKey triggerKey = new TriggerKey(job.getJobName(), job.getJobGroup());
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(newCronExpresion);
			CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
			logger.info("原始任务表达式:" + job.getCronExpression() + "，现在任务表达式:" + newCronExpresion);
			scheduler.rescheduleJob(triggerKey, cronTrigger);
		} catch (Exception e) {
			logger.error("修改任务调度中的定时任务异常！" + e.getMessage(), e);
		}
	}

	/**
	 * 暂停任务调度中的定时任务
	 * 
	 * @param job
	 *            定时任务信息
	 */
	public void pauseJob(JobDo job) {
		logger.info("暂停任务调度中的定时任务");
		try {
			if (null == job) {
				logger.info("暂停调度任务参数不正常！");
				return;
			}
			JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
			if (null == jobKey) {
				logger.info("任务调度中不存在[" + job.getJobName() + "]定时任务，不予进行暂停！");
				return;
			}
			scheduler.pauseJob(jobKey);
		} catch (Exception e) {
			logger.error("暂停任务调度中的定时任务异常！" + e.getMessage(), e);
		}
	}

	/**
	 * 恢复任务调度中的定时任务
	 * 
	 * @param job
	 *            定时任务信息
	 */
	public void resumeJob(JobDo job) {
		logger.info("恢复任务调度中的定时任务");
		try {
			if (null == job) {
				logger.info("恢复调度任务参数不正常！");
				return;
			}
			JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
			if (null == jobKey) {
				logger.info("任务调度中不存在[" + job.getJobName() + "]定时任务，不予进行恢复！");
				return;
			}
			scheduler.resumeJob(jobKey);
		} catch (Exception e) {
			logger.error("恢复任务调度中的定时任务异常！" + e.getMessage(), e);
		}
	}

	/**
	 * 删除任务调度中的定时任务
	 * 
	 * @param job
	 *            定时任务信息
	 */
	public void deleteJob(JobDo job) {
		logger.info("删除任务调度中的定时任务");
		try {
			if (null == job) {
				logger.info("删除调度任务参数不正常！");
				return;
			}
			JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
			if (null == jobKey) {
				logger.info("任务调度中不存在[" + job.getJobName() + "]定时任务，不予进行删除！");
				return;
			}
			scheduler.deleteJob(jobKey);
		} catch (Exception e) {
			logger.error("删除任务调度中的定时任务异常！" + e.getMessage(), e);
		}
	}

	/**
	 * 删除任务调度定时器
	 * 
	 */
	public void deleteJob(TriggerKey triggerKey) {
		logger.info("删除任务调度定时器");
		try {
			if (null == triggerKey) {
				logger.info("停止任务定时器参数不正常，不予进行停止！");
				return;
			}
			logger.info("停止任务定时器");
			scheduler.pauseTrigger(triggerKey);
			scheduler.unscheduleJob(triggerKey);
		} catch (Exception e) {
			logger.info("删除任务调度定时器异常！" + e.getMessage(), e);
		}
	}

	public static void main(String[] args) throws Exception {
		JobDo job = new JobDo();
		job.setJobGroup("test-group");
		job.setCronExpression("0/1 * * * * ?");
		job.setJobName("test-job");
		QuartzManager quartzManager = new QuartzManager();
		quartzManager.initJob(job, Class.forName("com.zark.easyframe.biz.common.job.JobTest"));
		quartzManager.runJob(job);
//		Thread.sleep(3000);
		quartzManager.pauseJob(job);
		Thread.sleep(30000);
		quartzManager.resumeJob(job);
//		Thread.sleep(3000);
		//quartzManager.updateQuartzJob(job, "0/3 * * * * ?");
		Thread.sleep(10000);
		quartzManager.deleteJob(job);
		Thread.sleep(3000);
		quartzManager.updateQuartzJob(job, "0/3 * * * * ?");

	}

	

}