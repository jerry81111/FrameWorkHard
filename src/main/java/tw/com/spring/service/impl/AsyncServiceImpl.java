package tw.com.spring.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import tw.com.spring.service.AsyncService;

@Service
public class AsyncServiceImpl implements AsyncService {

	@Async("asyncExecutor")
	@Override
	public void doWork() {
		 try {
		        Thread.sleep(10 * 1000);
		        System.out.println("completed work, sent email");
		    }
		    catch (InterruptedException e) {
		        System.err.println(e.getMessage());
		    }

	}

}
