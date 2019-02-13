package tw.com.spring.controller;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("/error/demo")
	public String demoPage() {
		return "error/demo";
	}

	@RequestMapping("/error/exception")
	public String throwException() throws Exception {
		throw new Exception();
	}
	@RequestMapping("/error/fileNotFoundException")
	public String throwFileNotFoundException() throws FileNotFoundException {
		throw new FileNotFoundException();
	}

}
