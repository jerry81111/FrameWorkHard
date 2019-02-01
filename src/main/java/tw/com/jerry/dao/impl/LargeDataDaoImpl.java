package tw.com.jerry.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.jerry.entity.LargeDataEntity;

public interface LargeDataDaoImpl extends JpaRepository<LargeDataEntity, Integer> {

}
