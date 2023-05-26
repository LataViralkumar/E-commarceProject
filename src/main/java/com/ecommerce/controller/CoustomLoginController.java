package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoustomLoginController {
	
	@RequestMapping("/login")
	public String coustomLoginFrom() {
		return "/login";
	}
	@RequestMapping("/sign_up")
	public String sign_up() {
		return "/sign_up";
	}

}
