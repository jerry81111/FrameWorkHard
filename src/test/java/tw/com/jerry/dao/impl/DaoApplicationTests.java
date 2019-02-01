package tw.com.jerry.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.com.jerry.entity.MemberEntity;

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

	
}

