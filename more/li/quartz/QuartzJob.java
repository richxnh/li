package li.quartz;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public abstract class QuartzJob implements Job {
    private String trigger;

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public void start() {
        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            JobDetail jobDetail = new JobDetailImpl("job_" + getClass().getName(), "job_group", this.getClass());
            CronTrigger cronTrigger = new CronTriggerImpl("trigger_" + getClass().getName(), "trigger_grop", getTrigger());
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}