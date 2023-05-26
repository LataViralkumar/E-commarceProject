package com.ecommerce.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ecommerce.controller.dao.HomepageProductView;
import com.ecommerce.model.ProductTable;

@Controller
public class HomepageProductDisplay {
	
	@Autowired
	private  HomepageProductView homepageProductView;

	@GetMapping("/")
	public  ModelAndView HomePageViewProduct() {
		System.out.println("Hello index");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index");
		List<ProductTable> pt = new ArrayList<>();
		pt = (List<ProductTable>) this.homepageProductView.findAll();
		
		modelAndView.addObject("product", pt);
		System.out.println(pt);
		return modelAndView;
		}
}
