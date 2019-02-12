package tw.com.spring.cache;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import tw.com.spring.dao.impl.FunctionDaoImpl;
import tw.com.spring.dao.impl.MemberDaoImpl;
import tw.com.spring.entity.FunctionEntity;
import tw.com.spring.entity.MemberEntity;

@CacheConfig
@Service
public class CacheService {

	@Autowired
	MemberDaoImpl memberDaoImpl;

	@Autowired
	FunctionDaoImpl functionDaoImpl;

	@CacheEvict(value = { "member", "functiontest" }, allEntries = true)
	public void refreshCache() {
	}

	@Cacheable(value = "member")
	public List<MemberEntity> getAllMember() {
		return memberDaoImpl.findAll();
	}

	@Cacheable(value = "functiontest")
	public Map<String, FunctionEntity> getAllFunction() {
		List<FunctionEntity> functions = functionDaoImpl.findAll();
		Map<String, FunctionEntity> functionsMap = functions.stream()
				.collect(Collectors.toMap(func -> func.getName().toUpperCase(), func -> func));
		return functionsMap;
	}

}
