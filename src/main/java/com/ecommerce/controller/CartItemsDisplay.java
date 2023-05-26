package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.controller.dao.CartDao;
import com.ecommerce.controller.dao.UserDao;
import com.ecommerce.model.CartItems;
import com.ecommerce.model.UserModel;

@Controller
public class CartItemsDisplay {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private  CartDao cartDao;

	@GetMapping("/userpage/cart_item")
	public ModelAndView goCart() {
		
		String username  = SecurityContextHolder.getContext().getAuthentication().getName();
		
		UserModel user = new UserModel();
		
		user = this.userDao.getUserMdeolByEmail(username);
		
		List<CartItems> c = this.cartDao.SelectItemForDisplayByUserId(user);

		ModelAndView modelAndView = new ModelAndView("/userpage/cart_item");
		modelAndView.addObject("product", c);
		
		
		return modelAndView;
	}
}
