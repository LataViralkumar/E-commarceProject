package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.controller.dao.CartDao;
import com.ecommerce.controller.dao.HomepageProductView;
import com.ecommerce.controller.dao.UserDao;
import com.ecommerce.model.CartItems;
import com.ecommerce.model.ProductTable;
import com.ecommerce.model.UserModel;

@RestController
public class AddCartItem {
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HomepageProductView homepageProductView;
	
	@Autowired
	private CartDao cartDao;
	
	@GetMapping("/userpage/AddCartItems/{id}" )
	public void ProductAddInCart(@PathVariable int id) {
		

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		if(email == null || email == "anonymousUser") {
			return;
		}
		
		UserModel user = new UserModel();
		user = this.userDao.getUserMdeolByEmail(email);
		ProductTable p = new ProductTable();
		p = this.homepageProductView.getSingleItemById(id);

		CartItems c = new CartItems();
		c.setProductID(p);
		c.setUserID(user);	
		this.cartDao.save(c);

	}
	
	@GetMapping("/userpage/cart_item/{p_id}")
	@ResponseBody
	public String CartItemDeleteINdb(@PathVariable int p_id) {
		
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		
		UserModel user = new UserModel();
		
		user = this.userDao.getUserMdeolByEmail(username);
		
		ProductTable p = new ProductTable();
		p = this.homepageProductView.getSingleItemById(2);
	
		this.cartDao.DeleteCartItem(user,p);

		return "Item deleted";
	}
		
	
}
