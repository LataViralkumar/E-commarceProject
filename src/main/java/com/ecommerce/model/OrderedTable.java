package com.ecommerce.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class OrderedTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Ordered_ID;

	@Column(nullable = false)
	private String UserName;
	
	@Column(nullable = false)
	private Integer Size;
	
	

	@Column(nullable = false)
	private String img1;
	
	
	@Column(nullable = false)
	private String ProductName;
	
	@Column(nullable = false)
	private Integer ProductID;
	
	@Column(nullable = false)
	private Integer ProductQty;
	
	@Column(nullable = false)
	private Double ProductPrize;
	
	@Column(nullable = false)
	private String Dev_address;
	
	@Column(nullable = false)
	private Integer Pincode;
	
	@Column(nullable = false)
	private String City;
	
	@Column(nullable = false)
	private String OrderStatus;
	
	@Column(nullable = false)
	private Date Ordered_date;
	
	@Column(nullable = false)
    private String Payment_Mode;
    
	@Column(nullable = false)
    private String Payment_status;
	
	@Column(nullable = false)
    private String Contact_No;
	
	@Column(nullable = false)
    private String color;
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getOrdered_ID() {
		return Ordered_ID;
	}

	public void setOrdered_ID(Integer ordered_ID) {
		Ordered_ID = ordered_ID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public Integer getProductQty() {
		return ProductQty;
	}

	public void setProductQty(Integer productQty) {
		ProductQty = productQty;
	}

	public Double getProductPrize() {
		return ProductPrize;
	}

	public void setProductPrize( Double double1) {
		ProductPrize = double1;
	}

	public String getDev_address() {
		return Dev_address;
	}

	public void setDev_address(String dev_address) {
		Dev_address = dev_address;
	}

	public Integer getPincode() {
		return Pincode;
	}

	public void setPincode(Integer pincode) {
		Pincode = pincode;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public Date getOrdered_date() {
		return Ordered_date;
	}

	public void setOrdered_date(Date ordered_date) {
		Ordered_date = ordered_date;
	}

	public String getPayment_Mode() {
		return Payment_Mode;
	}

	public void setPayment_Mode(String payment_Mode) {
		Payment_Mode = payment_Mode;
	}

	public String getPayment_status() {
		return Payment_status;
	}

	public void setPayment_status(String payment_status) {
		Payment_status = payment_status;
	}

	public String getContact_No() {
		return Contact_No;
	}

	public void setContact_No(String contact_No) {
		Contact_No = contact_No;
	}
	
	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public Integer getSize() {
		return Size;
	}

	public void setSize(Integer size) {
		Size = size;
	}

	

	public OrderedTable(Integer ordered_ID, String userName, Integer size, String img1, String productName,
			Integer productID, Integer productQty, Double productPrize, String dev_address, Integer pincode,
			String city, String orderStatus, Date ordered_date, String payment_Mode, String payment_status,
			String contact_No, String color) {
		super();
		Ordered_ID = ordered_ID;
		UserName = userName;
		Size = size;
		this.img1 = img1;
		ProductName = productName;
		ProductID = productID;
		ProductQty = productQty;
		ProductPrize = productPrize;
		Dev_address = dev_address;
		Pincode = pincode;
		City = city;
		OrderStatus = orderStatus;
		Ordered_date = ordered_date;
		Payment_Mode = payment_Mode;
		Payment_status = payment_status;
		Contact_No = contact_No;
		this.color = color;
	}

	public OrderedTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
