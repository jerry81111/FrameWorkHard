package tw.com.spring.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.spring.entity.FunctionEntity;

public interface FunctionDaoImpl  extends JpaRepository<FunctionEntity, String>{

}
