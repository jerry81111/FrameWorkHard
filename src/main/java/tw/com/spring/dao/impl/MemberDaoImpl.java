package tw.com.spring.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.com.spring.entity.MemberEntity;

public interface MemberDaoImpl extends JpaRepository<MemberEntity, Integer> {

	List<MemberEntity> findAll();

	@Query(value = "SELECT * FROM member WHERE account = :account ", nativeQuery = true)
	MemberEntity findByAccount(@Param("account") String account);
}
