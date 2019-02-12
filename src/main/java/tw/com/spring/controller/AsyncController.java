package tw.com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.spring.service.AsyncService;

@Controller
public class AsyncController {

	@Autowired
	AsyncService asyncService;

	@GetMapping("/async/demo")
	public String demo() {
		return "async/demo";
	}

	@GetMapping("/async/doAsyncWork")
	public @ResponseBody String doAsyncWork() {
		asyncService.doWork();
		return "Your request has been queued.";
	}

}
