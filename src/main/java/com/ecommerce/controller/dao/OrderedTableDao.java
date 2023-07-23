package com.ecommerce.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ecommerce.model.OrderedTable;


@Service
@EnableJpaRepositories
public interface OrderedTableDao extends JpaRepository<OrderedTable, Integer>{

	
	@Query("select u from OrderedTable u WHERE u.UserName =:email")
	public List<OrderedTable> SelectOderedItem(@Param(value= "email") String email);
	
}
