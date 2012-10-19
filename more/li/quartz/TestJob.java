package li.quartz;

public class TestJob extends Job {
	public void execute() {
		System.out.println("li.quartz.TestJob.execute()");
	}
}