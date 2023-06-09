package com.ecommerce.login;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.model.UserModel;

public class CustomLogin implements UserDetails{
	
	
	private UserModel userModel;
	
	public CustomLogin(UserModel userModel) throws Exception {
		super();
		this.userModel = userModel;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userModel.getRoll());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() throws NullPointerException{
		return userModel.getUserPassword();
	}

	@Override
	public String getUsername() {
		return userModel.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
