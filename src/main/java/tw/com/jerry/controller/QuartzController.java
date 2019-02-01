package tw.com.jerry.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.jerry.quartz.QuartzService;
import tw.com.jerry.quartz.QuartzUtil;

@Controller
@RequestMapping("/quartz")
public class QuartzController {

	@Autowired 
	QuartzUtil quartzUtil;
	
	@Autowired
	QuartzService quartzService;
	
	
	@GetMapping("/demo")
	public String demo() {
		try {
			quartzService.startJob();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return "quartz/demo";
	}
	
	@GetMapping("/getJob")
	public String getJob() {
		try {
			System.out.println(quartzUtil.getJobInfo("job1", "group1"));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return "quartz/demo";
	}
	
	@GetMapping("/pause")
	public String pause() {
		try {
			quartzUtil.pauseAllJob();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return "quartz/demo";
	}
	
	@GetMapping("/resume")
	public String resume() {
		try {
			quartzUtil.resumeAllJob();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return "quartz/demo";
	}
	
}
