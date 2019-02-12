package tw.com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("/throwException")
	public String throwError() throws Exception  {
		throw new Exception();
	}
	
}
