package li.quartz;

import li.ioc.IocContext;
import li.model.Bean;

public class Quartz {
	public static void start() {
		for (Bean bean : IocContext.getInstance().BEANS) {
			if (QuartzJob.class.isAssignableFrom(bean.type)) {
				((QuartzJob) bean.instance).start();
			}
		}
	}
}