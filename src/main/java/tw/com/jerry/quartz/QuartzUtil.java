package tw.com.jerry.quartz;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzUtil {
	
	// 任務排程
	@Autowired 
	Scheduler scheduler;
	
	/**
	 * 獲取Job資訊
	 * 
	 * @param name
	 * @param group
	 * @return
	 * @throws SchedulerException
	 */
	public String getJobInfo(String name, String group) throws SchedulerException {
		TriggerKey triggerKey = new TriggerKey(name, group);
		CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
				scheduler.getTriggerState(triggerKey).name());
	}

	/**
	 * 修改某個任務的執行時間
	 * 
	 * @param name
	 * @param group
	 * @param time
	 * @return
	 * @throws SchedulerException
	 */
	public boolean modifyJob(String name, String group, String time) throws SchedulerException {
		Date date = null;
		TriggerKey triggerKey = new TriggerKey(name, group);
		CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		String oldTime = cronTrigger.getCronExpression();
		if (!oldTime.equalsIgnoreCase(time)) {
			CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(time);
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
					.withSchedule(cronScheduleBuilder).build();
			date = scheduler.rescheduleJob(triggerKey, trigger);
		}
		return date != null;
	}

	/**
	 * 暫停所有任務
	 * 
	 * @throws SchedulerException
	 */
	public void pauseAllJob() throws SchedulerException {
		scheduler.pauseAll();
	}

	/**
	 * 暫停某個任務
	 * 
	 * @param name
	 * @param group
	 * @throws SchedulerException
	 */
	public void pauseJob(String name, String group) throws SchedulerException {
		JobKey jobKey = new JobKey(name, group);
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		if (jobDetail == null)
			return;
		scheduler.pauseJob(jobKey);
	}

	/**
	 * 恢復所有任務
	 * 
	 * @throws SchedulerException
	 */
	public void resumeAllJob() throws SchedulerException {
		scheduler.resumeAll();
	}

	/**
	 * 恢復某個任務
	 * 
	 * @param name
	 * @param group
	 * @throws SchedulerException
	 */
	public void resumeJob(String name, String group) throws SchedulerException {
		JobKey jobKey = new JobKey(name, group);
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		if (jobDetail == null)
			return;
		scheduler.resumeJob(jobKey);
	}

	/**
	 * 刪除某個任務
	 * 
	 * @param name
	 * @param group
	 * @throws SchedulerException
	 */
	public void deleteJob(String name, String group) throws SchedulerException {
		JobKey jobKey = new JobKey(name, group);
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		if (jobDetail == null)
			return;
		scheduler.deleteJob(jobKey);
	}
}
