package tw.com.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import tw.com.spring.cache.CacheService;
import tw.com.spring.entity.FunctionEntity;

@Controller
public class LoginController {

	@Autowired
	CacheService cacheService;

	@GetMapping(value = { "/", "/welcome" })
	public String home() {
		return "login/welcome";
	}

	@GetMapping(value = { "/login" })
	public String login() {
		return "login/login";
	}

	@GetMapping(value = { "/home" })
	public String start(Model model) {
		Map<String, FunctionEntity> beforeFunctions = null;
		try {
			beforeFunctions = cacheService.getAllFunction();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> afterFunctions = beforeFunctions.entrySet().stream()
				.map(function -> function.getValue().getName().toUpperCase()).collect(Collectors.toList());
		model.addAttribute("allFunctionName", afterFunctions);
		model.addAttribute("command", new FunctionEntity());
		return "login/home";
	}

	@GetMapping(value = { "/dispatchToDemo" })
	public String dispatchToDemo(@ModelAttribute FunctionEntity functionPo) {

		String destination = "redirect:/home";
		if (!StringUtils.isEmpty(functionPo.getName())) {
			
			functionPo=cacheService.getAllFunction().get(functionPo.getName());
			
			if (functionPo.getUrl() != null) {
				destination = "redirect:"+functionPo.getUrl();
			} else {
				destination = functionPo.getName() + "/demo";
			}
		}
		return destination;
	}
}
