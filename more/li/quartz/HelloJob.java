package li.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob extends QuartzJob {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(Thread.currentThread() + "\t" + new Date() + "\t" + "BBB");
	}
}