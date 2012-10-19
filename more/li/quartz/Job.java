package li.quartz;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

/**
 * Quartz定时任务的基类
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-10-18)
 */
public abstract class Job {
	/**
	 * 
	 */
	private String trigger;

	public String getTrigger() {
		return this.trigger;
	}

	public void start() {
		try {
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			long ctime = System.currentTimeMillis();
			JobDetail jobDetail = new JobDetailImpl() {
				public JobKey getKey() {
					return new JobKey("haha");
				}
				public Class<? extends org.quartz.Job> getJobClass() {
					return super.getJobClass();
				}
			};
			CronTrigger cronTrigger = new CronTriggerImpl();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void execute();
}