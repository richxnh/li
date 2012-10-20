package li.quartz.test;

import li.quartz.QuartzJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob extends QuartzJob {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("hello");
	}
}