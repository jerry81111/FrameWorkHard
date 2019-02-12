package tw.com.spring.async;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig {

	private static int COREPOOLSIZE = 3;
	private static int MAXPOOLSIZE = 3;
	private static int QUEUECAPACITY = 100;

	@Bean(name = "asyncExecutor")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(COREPOOLSIZE);
		executor.setMaxPoolSize(MAXPOOLSIZE);
		executor.setQueueCapacity(QUEUECAPACITY);
		executor.setThreadNamePrefix("AsynchThread-");
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setAwaitTerminationSeconds(60);
		executor.initialize();
		return executor;
	}

}
