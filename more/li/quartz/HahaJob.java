package li.quartz;

import java.util.Date;

import li.annotation.Bean;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Bean
public class HahaJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println(Thread.currentThread() + "\t" + new Date() + "\t" + "AAA");
    }
}