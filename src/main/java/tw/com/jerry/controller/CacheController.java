package tw.com.jerry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tw.com.jerry.cache.CacheService;

@Controller
public class CacheController {
	
	@Autowired
	CacheService cacheService;
	
	@GetMapping("/cache/demo")
	public String demo() {
		return "cache/demo";
	}
	
	
	@GetMapping("/cache/getAllMember")
	public String getAllMember() {
		cacheService.getAllMember();
		return "cache/demo";
	}
	
}
