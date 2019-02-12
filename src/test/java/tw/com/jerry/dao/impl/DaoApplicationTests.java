package tw.com.jerry.dao.impl;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import tw.com.spring.dao.impl.MemberDaoImpl;
import tw.com.spring.entity.MemberEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoApplicationTests {

	@Autowired
	MemberDaoImpl memberDaoImpl;



	@Test
	public void memberTest() {
		MemberEntity member = memberDaoImpl.findByAccount("jerry");
		assertEquals("DAO TEST : ", member.getAccount(), "jerry");
	}

	@Test
	public void callApiTest() throws Exception {
		TestRestTemplate restTemplate = new TestRestTemplate();
		final String baseUrl = "http://127.0.0.1:8080/jpa/restful/getAllMember";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

}
