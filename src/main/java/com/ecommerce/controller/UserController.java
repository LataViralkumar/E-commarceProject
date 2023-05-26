package com.ecommerce.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ecommerce.controller.dao.UserDao;
import com.ecommerce.model.UserModel;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/signup")
	public String RegPage() {
		return "UserReg";
	}
	
	@PostMapping("/RegForm")
	public String userReg(@RequestParam("username") String Email ,
			@RequestParam("Conform_password") String UserPassword) {
		
		
		UserModel um = new UserModel();
		um.setEmail(Email);
		//um.setAddress(Address);
		um.setUserPassword(passwordEncoder.encode(UserPassword));
		//um.setUserPincode(UserPincode);
		um.setRoll("ROLE_USER");
		um.setEnabled(true);
		UserModel u =  this.userDao.save(um);
		System.out.println(u);
		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("")
		
		return "/login";
	}
	
	
}
