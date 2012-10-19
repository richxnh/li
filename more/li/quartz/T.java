package li.quartz;

public class T {
	public static void main(String[] args) {
		Job job = new TestJob();
		job.start();
	}
}