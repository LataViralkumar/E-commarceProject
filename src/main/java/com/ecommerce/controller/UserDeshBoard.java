package com.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ecommerce.controller.dao.HomepageProductView;
import com.ecommerce.controller.dao.UserDao;
import com.ecommerce.model.ProductTable;
import com.ecommerce.model.UserModel;

@Controller
public class UserDeshBoard {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HomepageProductView homepageProductView;
	
	@GetMapping("userpage/")
	public ModelAndView  userDesh() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		if(email == null || email == "anonymousUser") {
			ModelAndView modelAndView =new ModelAndView("/index");
			return modelAndView;
		}
		UserModel user = new UserModel();
		user = this.userDao.getUserMdeolByEmail(email);
		
		ModelAndView modelAndView =new ModelAndView("userpage/UserDash");
		
//		System.out.println("----------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!-------------------------------");
//		System.out.println(email);
//		System.out.println(user);
//		System.out.println("----------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!-------------------------------");
		modelAndView.addObject("user", user);
		
		ArrayList<ProductTable> pt = new ArrayList<>();
		pt = (ArrayList<ProductTable>)this.homepageProductView.findAll();
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("product", pt);
		return modelAndView;
	}
	
	
	


}
