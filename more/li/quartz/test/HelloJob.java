package li.quartz.test;

import java.util.Date;

import li.quartz.QuartzJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob extends QuartzJob {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(Thread.currentThread() + "\t" + new Date() + "\t" + "BBB");
	}
}