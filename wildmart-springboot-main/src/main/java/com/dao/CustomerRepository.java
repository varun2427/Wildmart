package com.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("from Customer e where e.emailId = :emailId and e.password = :password")
	public Customer login(@Param("emailId") String emailId, @Param("password") String password);

	@Query("from Customer c where c.custName = :custName")
	public Customer getCustomerByName(@Param("custName") String custName);

	@Query("from Customer e where e.emailId = :emailId")
	public Customer findByEmailId(@Param("emailId") String emailId);

	@Transactional
	@Modifying
	@Query("UPDATE Customer u SET u.password = :password WHERE u.mobileNumber = :mobileNumber")
	public int updatePass(@Param("mobileNumber") String phoneNum, @Param("password") String password);

	@Transactional
	@Modifying
	@Query("UPDATE Customer u SET u.password = :password WHERE u.emailId = :emailId")
	public int updatePassWithEmail(@Param("emailId") String emailId, @Param("password") String password);

	@Transactional
	@Modifying
	@Query("UPDATE Customer u SET u.password = :password WHERE u.emailId = :emailId")
	public int updateNewPass(@Param("emailId") String emailId, @Param("password") String passowrd);

}
