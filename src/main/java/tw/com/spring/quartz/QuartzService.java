package tw.com.spring.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartzService {
	
	// 任務排程
	@Autowired
	Scheduler scheduler;
	
	/**
	 * 開始執行所有任務
	 * 
	 * @throws SchedulerException
	 */
	public void startJob() throws SchedulerException {
		startJob1(scheduler);
		startJob2(scheduler);
		scheduler.start();
	}

	private void startJob1(Scheduler scheduler) throws SchedulerException {
		// 通過JobBuilder構建JobDetail例項，JobDetail規定只能是實現Job介面的例項
		// JobDetail 是具體Job例項
		JobDetail jobDetail = JobBuilder.newJob(Job1.class).withIdentity("job1", "group1").build();
		// 基於表示式構建觸發器
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
		// CronTrigger表示式觸發器 繼承於Trigger
		// TriggerBuilder 用於構建觸發器例項
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job1", "group1")
				.withSchedule(cronScheduleBuilder).build();
		scheduler.scheduleJob(jobDetail, cronTrigger);
	}

	private void startJob2(Scheduler scheduler) throws SchedulerException {
		JobDetail jobDetail = JobBuilder.newJob(Job2.class).withIdentity("job2", "group2").build();
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/5 * * * ?");
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job2", "group2")
				.withSchedule(cronScheduleBuilder).build();
		scheduler.scheduleJob(jobDetail, cronTrigger);
	}
}
