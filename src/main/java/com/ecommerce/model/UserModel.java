	package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "UserTable")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserId;
	
	@Column(nullable = false)
	private String UserName;
	
	@Column(unique = true , nullable = false)
	private String Email;
	private String Address;
	private Integer UserPincode;
	private String Roll;
	private boolean Enabled;
	
	
	@Column(nullable = false)
	private String UserPassword;

	private long UserContactNo;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "UserID")
	
	private List<CartItems> userID = new ArrayList<>();


	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Integer getUserPincode() {
		return UserPincode;
	}

	public void setUserPincode(Integer userPincode) {
		UserPincode = userPincode;
	}

	public String getRoll() {
		return Roll;
	}

	public void setRoll(String roll) {
		Roll = roll;
	}

	public boolean isEnabled() {
		return Enabled;
	}

	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}

	public String getUserPassword() throws NullPointerException {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public long getUserContactNo() {
		return UserContactNo;
	}

	public void setUserContactNo(long userContactNo) {
		UserContactNo = userContactNo;
	}

	public UserModel(Integer userId, String userName, String email, String address, Integer userPincode, String roll,
			boolean enabled, String userPassword, long userContactNo) {
		super();
		UserId = userId;
		UserName = userName;
		Email = email;
		Address = address;
		UserPincode = userPincode;
		Roll = roll;
		Enabled = enabled;
		UserPassword = userPassword;
		UserContactNo = userContactNo;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserModel [UserId=" + UserId + ", UserName=" + UserName + ", Email=" + Email + ", Address=" + Address
				+ ", UserPincode=" + UserPincode + ", Roll=" + Roll + ", Enabled=" + Enabled + ", UserPassword="
				+ UserPassword + ", UserContactNo=" + UserContactNo + "]";
	}

	
		
}
