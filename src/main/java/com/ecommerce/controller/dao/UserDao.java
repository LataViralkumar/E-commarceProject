package com.ecommerce.controller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;


import com.ecommerce.model.UserModel;

import jakarta.transaction.Transactional;


@EnableJpaRepositories
public interface UserDao  extends  JpaRepository<UserModel, Integer>{

//		@Query("select u from UserModel u")
//		public List<UserModel> getAll();
//		
//		@Query("select u from UserModel u WHERE u.UserName = :aaa")
//		public List<UserModel> getAllone(@Param("aaa") String UserName);
		
		@Query("select u from UserModel u WHERE u.Email =:Email ")
		public UserModel getUserMdeolByEmail(@Param("Email") String Email);
		

		@Transactional
		@Modifying(clearAutomatically = true)
		@Query("UPDATE  UserModel m SET m.Address=:address WHERE m.Email =:email")
		public int setAddressForDelivary( @Param("address") String address  , @Param("email") String email);
}
