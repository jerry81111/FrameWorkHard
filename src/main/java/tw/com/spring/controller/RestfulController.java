package tw.com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tw.com.spring.dao.impl.MemberDaoImpl;
import tw.com.spring.entity.MemberEntity;
import tw.com.spring.util.JsonUtil;

@RestController
public class RestfulController {

	@Autowired
	MemberDaoImpl memberDaoImpl;
	
	@GetMapping("/rest/selectByMemberAccount/{account}")
	public String selectByMemberAccount(@PathVariable String account) {
		
		MemberEntity member = memberDaoImpl.findByAccount(account);
		
		return JsonUtil.objectToJson(member);
	}
	
}
