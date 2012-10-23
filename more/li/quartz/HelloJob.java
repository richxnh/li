package li.quartz;

import java.util.Date;

import li.annotation.Bean;
import li.annotation.Inject;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Bean
public class HelloJob extends QuartzJob {
	@Inject("${trigger.HelloJob}")
	private String trgger;

	public String getTrigger() {
		return this.trgger;
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(Thread.currentThread() + "\t" + new Date() + "\t" + "BBB");
	}
}