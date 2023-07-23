package com.ecommerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	
	@Column(nullable = false , columnDefinition = " default '1'" )
	private Integer ProductQty = 1;
	
	@Column(nullable = false)
	private String ProductName;
	
	@Column(nullable = false)
	private String ProductImg;
	
	@Column(nullable = false)
	private String color;
	

	@Column(nullable = false)
	private Double ProductAmmount;
	
	@Column(nullable = false)
	private Integer ProductSize;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserModel UserID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ProductTable productID;

	
	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Double getProductAmmount() {
		return ProductAmmount;
	}

	public void setProductAmmount(Double productAmmount) {
		ProductAmmount = productAmmount;
	}

	public Integer getProductSize() {
		return ProductSize;
	}

	public void setProductSize(Integer productSize) {
		ProductSize = productSize;
	}


	public Integer getCart_id() {
		return Cart_id;
	}

	public void setCart_id(Integer cart_id) {
		Cart_id = cart_id;
	}

	public Integer getProductQty() {
		return ProductQty;
	}

	public void setProductQty(Integer productQty) {
		ProductQty = productQty;
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
	
	public String getProductImg() {
		return ProductImg;
	}

	public void setProductImg(String productImg) {
		ProductImg = productImg;
	}

	
	public CartItems(Integer cart_id, Integer productQty, String productName, String productImg, String color,
			Double productAmmount, Integer productSize, UserModel userID, ProductTable productID) {
		super();
		Cart_id = cart_id;
		ProductQty = productQty;
		ProductName = productName;
		ProductImg = productImg;
		this.color = color;
		ProductAmmount = productAmmount;
		ProductSize = productSize;
		UserID = userID;
		this.productID = productID;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
	

	
		
}
