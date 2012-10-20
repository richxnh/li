package li.quartz.test;

import li.quartz.QuartzJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HahaJob extends QuartzJob {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("haha");
	}
}