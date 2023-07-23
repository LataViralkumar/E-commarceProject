package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.controller.dao.CartDao;
import com.ecommerce.controller.dao.OrderedTableDao;
import com.ecommerce.controller.dao.UserDao;
import com.ecommerce.model.OrderedTable;
import com.ecommerce.model.UserModel;

@Controller
public class UserProfie {
	
	@Autowired(required = true)
	private UserDao userDao;
	
	@Autowired (required = true)
	private OrderedTableDao ot;
	
	@Autowired(required = true)
	private CartDao cartDao;

	
	@GetMapping("/userpage/profile")
	public ModelAndView getUserInfo() {
		
		ModelAndView modelAndView = new ModelAndView("userpage/userProfile");

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		if(email == null || email == "anonymousUser") {
			ModelAndView modelAnd =new ModelAndView("/index");
			return modelAnd ;
		}
		
		UserModel userModel = new UserModel();
		userModel = this.userDao.getUserMdeolByEmail(email);
//		System.out.println(userModel);
		
		 List<OrderedTable> orderedTables = new ArrayList<>();
		orderedTables = this.ot.SelectOderedItem(email);
		
		if(!orderedTables.isEmpty()) {
			this.cartDao.DeleteAllCartItemForUser(userModel);
		}
		
		modelAndView.addObject("model", userModel);
		modelAndView.addObject("orderItem", orderedTables);
		
		
		
		return modelAndView;
	}

}
