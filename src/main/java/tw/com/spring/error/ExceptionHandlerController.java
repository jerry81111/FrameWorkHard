package tw.com.spring.error;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException( HttpServletRequest req, Exception e) {
		
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("handler","Exception");
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error/error");
        
		return mav;
	}
	
	@ExceptionHandler(FileNotFoundException.class)
	public ModelAndView handleFileNotFoundException( HttpServletRequest req, Exception e) {
		
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("handler","FileNotFoundException");
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error/error");
        
		return mav;
	}
}

