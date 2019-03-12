package tw.com.spring.database;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void initDb() {
		String sqlStatements[] = {
				"insert into member (account,password,role,mema) values('jerry', '$2a$10$m6/oO5oUcL8NwgiwH7Ov7Ob1AWKF53uB67gV0Ri80yxtzwK.xCDba', 'ROLE_ADMIN','1')",
				"insert into member (account,password,role,mema) values('Rita', '$2a$10$kh3RVvoFGlE.1wRnKXjH5eYGX/qKMbFyN5wQP7IFjVxEEIjOyAiy6', 'ROLE_ADMIN','2')",
				"insert into member (account,password,role,mema) values('Alex', '$2a$10$sNcCfWPv/IKU5Wa9tbbvSO1s8E5aku/apuMj3IG.iBd/7v4lzWl5y', 'ROLE_ADMIN','2')",
				"insert into function_name (name) values('jpa')",
				"insert into function_name (name) values('quartz')",
				"insert into function_name (name,url) values('exceptionHandler','/error/demo')",
				"insert into function_name (name) values('cache')",
				"insert into function_name (name) values('async')",
				"insert into function_name (name) values('batch')",
				"insert into function_name (name) values('file')",
				"insert into function_name (name,url) values('swagger','/swagger-ui.html')",
				"insert into function_name (name,url) values('h2','h2')"
		};

		Arrays.asList(sqlStatements).forEach(sql -> {
			jdbcTemplate.execute(sql);
		});

		// Query test data and print results
	}
}
