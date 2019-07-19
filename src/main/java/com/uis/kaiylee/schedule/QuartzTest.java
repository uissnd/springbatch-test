package com.uis.kaiylee.schedule;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	@Test
	public void helloJob() throws SchedulerException, InterruptedException {
		
		JobDetail jobDetail = newJob(HelloJob.class).build();
		Trigger trigger = newTrigger().build();

		Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
		sched.start();
		sched.scheduleJob(jobDetail, trigger);
		Thread.sleep(3*1000);
		sched.shutdown(true);

	}
	
}
