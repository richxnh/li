package li.quartz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.xpath.XPathConstants;

import li.ioc.Ioc;
import li.util.Files;
import li.util.Reflect;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.simpl.SimpleJobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.w3c.dom.NodeList;

public class Quartz {
    /**
     * 初始化此类的时候启动Quartz
     */
    public Quartz() {
        start();
    }

    /**
     * 防止重复启动的标记
     */
    private static boolean started = false;

    /**
     * 启动Quartz,启动所有任务
     */
    private synchronized static void start() {
        if (!started) {
            try {
                Scheduler scheduler = getScheduler();
                Set<Entry<Class<? extends Job>, String>> jobs = getJobs().entrySet();
                for (Entry<Class<? extends Job>, String> entry : jobs) {
                    JobDetail jobDetail = new JobDetailImpl("job_" + entry.getKey().getName(), entry.getKey());
                    CronTrigger cronTrigger = new CronTriggerImpl("trigger_" + entry.getKey().getName(), Scheduler.DEFAULT_GROUP, entry.getValue());
                    scheduler.scheduleJob(jobDetail, cronTrigger);
                }
                scheduler.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        started = true;
    }

    /**
     * 扫描以qutarz.xml结尾的Quartz配置文件返回所有任务
     */
    private static Map<Class<? extends Job>, String> getJobs() {
        Map<Class<? extends Job>, String> jobs = new HashMap<Class<? extends Job>, String>();

        List<String> fileList = Files.list(Files.root(), "^.*config.xml$", true);// 搜索以config.xml结尾的文件
        for (String filePath : fileList) {
            NodeList beanNodes = (NodeList) Files.xpath(Files.build(filePath), "//task", XPathConstants.NODESET);
            for (int length = (null == beanNodes ? -1 : beanNodes.getLength()), i = 0; i < length; i++) {
                String type = (String) Files.xpath(beanNodes.item(i), "@class", XPathConstants.STRING);
                String trigger = (String) Files.xpath(beanNodes.item(i), "@trigger", XPathConstants.STRING);

                jobs.put((Class<? extends Job>) Reflect.getType(type), trigger);
            }
        }
        return jobs;
    }

    /**
     * 返回使用Ioc方式生成Job对象的Scheduler
     */
    private static Scheduler getScheduler() throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.setJobFactory(new SimpleJobFactory() {
            public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
                return Ioc.get(bundle.getJobDetail().getJobClass());
            }
        });
        return scheduler;
    }
}