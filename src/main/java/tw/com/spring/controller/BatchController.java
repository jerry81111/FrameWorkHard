package tw.com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tw.com.spring.dao.impl.LargeDataDaoImpl;
import tw.com.spring.entity.LargeDataEntity;

@Controller
public class BatchController {
	
	@Autowired
	LargeDataDaoImpl largeDataDao;
	
	
	
	@GetMapping("/batch/demo")
	public String demo() {
		return "batch/demo";
	}
	
	
	@GetMapping("/batch/insertBatch")
	public String getAllMember() {
		LargeDataEntity largeDataPo= new LargeDataEntity();
		largeDataPo.setNumber(1);
		largeDataPo.setText("1");
		largeDataDao.save(largeDataPo);
		return "batch/demo";
	}
	
}
