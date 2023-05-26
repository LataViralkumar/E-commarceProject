package com.ecommerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class CartItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Cart_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserModel UserID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ProductTable productID;

	public Integer getCart_id() {
		return Cart_id;
	}

	public void setCart_id(Integer cart_id) {
		Cart_id = cart_id;
	}

	public UserModel getUserID() {
		return UserID;
	}

	public void setUserID(UserModel userID) {
		UserID = userID;
	}

	public ProductTable getProductID() {
		return productID;
	}

	public void setProductID(ProductTable productID) {
		this.productID = productID;
	}

	public CartItems(Integer cart_id, UserModel userID, ProductTable productID) {
		super();
		Cart_id = cart_id;
		UserID = userID;
		this.productID = productID;
	}

	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
		
}
