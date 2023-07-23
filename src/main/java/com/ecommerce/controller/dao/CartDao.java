package com.ecommerce.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.CartItems;
import com.ecommerce.model.ProductTable;
import com.ecommerce.model.UserModel;

import jakarta.transaction.Transactional;



public  interface  CartDao extends JpaRepository<CartItems, Integer>{

	
	//@Query(value = "select * from cart_items", nativeQuery = true)
	
//	@Query( value = "insert into cart_items (userid_user_id ,productid_product_id) values(?1,?2)" , nativeQuery = true)
//	public void insertMyData( int uid , int pid);
//	
//	@Query("select u from CartItems u WHERE u.UserID =:user  and productID=:p")
//	public void  SelectItemForDisplayByUserId(@Param(value= "user") UserModel user , @Param(value= "p") ProductTable p);
	
	@Query("select u from CartItems u WHERE u.UserID =:user")
	public List<CartItems> SelectItemForDisplayByUserId(@Param(value= "user") UserModel user);
	
	
//	delete from Book b where b.title=:title
//	delete from cart_items where cart_id=5;
	
//	@Query("delete from CartItems u WHERE u.Cart_id =:id ")
//	@Modifying
//	@Query("select u from CartItems u WHERE u.Cart_id=:id")
	
	@Modifying
	@Transactional
	@Query("DELETE  FROM CartItems WHERE UserID=:id and productID=:p")
	public int DeleteCartItem(UserModel id , ProductTable p);
	
	
	@Modifying
	@Transactional
	@Query("DELETE  FROM CartItems WHERE UserID=:id")
	public int DeleteAllCartItemForUser(UserModel id);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE CartItems SET ProductQty=:qty  WHERE UserID=:id and productID=:p")
	public int UpdateCartItem(int qty , UserModel id , ProductTable p);
	
	
	
	
	
}
