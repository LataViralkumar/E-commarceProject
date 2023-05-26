package com.ecommerce.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ecommerce.controller.dao.UserDao;
import com.ecommerce.model.UserModel;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
			
		try {
			UserModel userdata = userDao.getUserMdeolByEmail(username);
			if(userdata == null) {
				return null;
			}
			CustomLogin customLogin = new CustomLogin(userdata);
			return customLogin;
		}	catch(Exception e) {e.printStackTrace();}
		
		return null;
		    
	}

}

