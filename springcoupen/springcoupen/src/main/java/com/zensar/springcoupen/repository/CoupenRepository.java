package com.zensar.springcoupen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.springcoupen.entity.Coupen;


public interface CoupenRepository extends JpaRepository<Coupen, Integer> {
	List<Coupen> findByCoupenCode(String coupenCode);
	List<Coupen> findByCoupenCodeAndExpDate(String coupenCode, String expDate);
	
	
	//List<Coupen> test( String coupenCode);
	//@Query(value = "from Coupen c where c.coupenCode=:code")
	@Query(value = "select * from coupen c where c.coupen_code=:code",nativeQuery=true)
	List<Coupen> test(@Param("code") String CoupenCode);
	
	//List<Coupen> test1( String coupenCode,String expDate);
	//@Query(value = "from Coupen c where c.coupenCode=:code and c.expDate=:date")
	@Query(value = "select * from coupen c where c.coupen_code=:code and c.exp_date=:date",nativeQuery=true)
	List<Coupen> test1(@Param("code")String coupenCode,@Param("date")String expDate);
}
