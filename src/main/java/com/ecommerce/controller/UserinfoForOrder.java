package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserinfoForOrder {

	@PostMapping("/userpage/Userinfo")
	public String userInforoder() {
		return "/userpage/UserInfoForOrder";
	}
	
}
