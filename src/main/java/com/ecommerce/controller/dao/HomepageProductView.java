package com.ecommerce.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.ProductTable;

@EnableJpaRepositories
public interface HomepageProductView extends CrudRepository<ProductTable, Integer> {
	 
	@Query("select u from ProductTable u WHERE u.Product_Id =:pid ")
	public	ProductTable getSingleItemById( @Param(value = "pid") Integer pid);
	
	@Query("select u from ProductTable u WHERE u.ProductCatogory =:catagory ")
	public	List<ProductTable> getItemByCatagory( @Param(value = "catagory") String catagory);
}
