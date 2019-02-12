package tw.com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import tw.com.spring.cache.CacheService;
import tw.com.spring.constant.RoleConstant;
import tw.com.spring.dao.impl.FunctionDaoImpl;
import tw.com.spring.dao.impl.MemberDaoImpl;
import tw.com.spring.entity.FunctionEntity;
import tw.com.spring.entity.MemberEntity;
import tw.com.spring.util.JsonUtil;

@Controller
public class JpaController {

	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	MemberDaoImpl memberDaoImpl;

	@Autowired
	FunctionDaoImpl functionDaoImpl;

	@Autowired
	CacheService cacheService;

	static final String URL_ALLMEMBER = "http://localhost:8080/jpa/restful/getAllMember";

	@GetMapping("/jpa/signUpPage")
	public String signUpPage(Model model) {
		model.addAttribute("member", new MemberEntity());
		return "jpa/signUp";
	}

	@PostMapping("/jpa/signUp")
	public String signUp(@ModelAttribute MemberEntity member) {
		String newPassword = member.getPassword();
		member.setPassword(passwordEncoder.encode(newPassword));
		member.setRole(RoleConstant.ADMIN);
		member.setMema(newPassword);
		memberDaoImpl.save(member);
		return "jpa/demo";
	}

	// API
	@GetMapping("/jpa/query/member")
	public List<MemberEntity> query() {
		List<MemberEntity> member = memberDaoImpl.findAll();
		return member;
	}

	@PostMapping("/jpa/insert/member")
	public void insert(@RequestBody MemberEntity member) {
		memberDaoImpl.save(member);
	}

	@GetMapping("/jpa/restful/getAllMember")
	public @ResponseBody String getAllMember() {
		List<MemberEntity> allMember = cacheService.getAllMember();
		String jsonAllMember = JsonUtil.objectToJson(allMember);
		return jsonAllMember;
	}

	@GetMapping("/jpa/getAllMember")
	public @ResponseBody String callApiGetAllMember() {
		String allMember = restTemplate.getForObject(URL_ALLMEMBER, String.class);
		System.out.println("CALL API");
		return allMember;
	}

	@GetMapping("/jpa/getAllFunction")
	public @ResponseBody String getAllFunction() {
		List<FunctionEntity> functions = functionDaoImpl.findAll();
		return JsonUtil.objectToJson(functions);
	}

}
