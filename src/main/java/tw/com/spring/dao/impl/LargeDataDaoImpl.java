package tw.com.spring.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.spring.entity.LargeDataEntity;

public interface LargeDataDaoImpl extends JpaRepository<LargeDataEntity, Integer> {

}
