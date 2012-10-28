package li.quartz;

import li.ioc.IocContext;
import li.model.Bean;

public class Quartz {
    private static boolean started = false;

    public synchronized static void start() {
        if (!started) {
            for (Bean bean : IocContext.getInstance().BEANS) {
                if (QuartzJob.class.isAssignableFrom(bean.type)) {
                    ((QuartzJob) bean.instance).start();
                }
            }
        }
        started = true;
    }
}