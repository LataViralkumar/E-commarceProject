package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.controller.dao.HomepageProductView;
import com.ecommerce.model.ProductTable;

@Controller
public class DisplaySingleItemDescription {
   @Autowired
   private HomepageProductView homepageProductView;
   
   @GetMapping("userpage/ItemDescription/{id}")
	public ModelAndView viewSingleItemDescription(@PathVariable int id){
	    
		ProductTable p = new ProductTable();
		p = this.homepageProductView.getSingleItemById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userpage/ProductContent");
		modelAndView.addObject("ProductDescription", p);
		
		return modelAndView;
	}
   
	
}
