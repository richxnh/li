package li.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HahaJob extends QuartzJob {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.err.println(Thread.currentThread() + "\t" + new Date() + "\t" + "AAA");
	}
}