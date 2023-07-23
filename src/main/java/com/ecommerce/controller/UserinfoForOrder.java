package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.controller.dao.CartDao;
import com.ecommerce.controller.dao.OrderedTableDao;
import com.ecommerce.controller.dao.UserDao;
import com.ecommerce.model.CartItems;
import com.ecommerce.model.OrderedTable;
import com.ecommerce.model.UserModel;

@Controller
public class UserinfoForOrder {
	
	@Autowired
	private UserDao ud;
	
	
	@Autowired 
	private OrderedTableDao orderedTableDao;
	
	@Autowired
	private CartDao cartDao;
	
	@GetMapping("/userpage/UserInfoForOrder")
	public ModelAndView  userInforoder( ) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
//		System.out.println(email);
		
		UserModel user = new UserModel();
		
		user = this.ud.getUserMdeolByEmail(email);
		
		List<CartItems> c = this.cartDao.SelectItemForDisplayByUserId(user);
		
		
		System.out.println("+++++++++++++++++++++");
		System.out.println(user);
		System.out.println("+++++++++++++++++++++");
		
		ModelAndView modelAndView = new ModelAndView("/userpage/UserInfoForOrder");
		
		int rs = 0;
		for (CartItems cartItems : c) {
			rs+=cartItems.getProductAmmount();
		}
		rs = rs + 50;
		System.out.println(rs);
		
		modelAndView.addObject("totalAmmount", rs);
		modelAndView.addObject("product", c);
		modelAndView.addObject("user", user);
		
		
		return modelAndView;
	}
	
	@GetMapping("/userpage/addressForDilivary")
	public ModelAndView getDetailForOrder( @RequestParam("name") String name , @RequestParam("address1") String address1 , @RequestParam("address2") String address2
			,@RequestParam("city") String city ,  @RequestParam("pincode") String pincode) {
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		String AddressConcate = name+" , " + address1 + " , " + address2+ " , " + city + " , " + pincode ;
		
		UserModel user = new UserModel();
		
		user = this.ud.getUserMdeolByEmail(email);
		
		List<CartItems> c = this.cartDao.SelectItemForDisplayByUserId(user);
		
		
//		System.out.println(AddressConcate);
		Date Ordered_date = new Date();
		String OderedStatus = "Placed";
		String Payment_Mode = "Pay on Delivary";
		String Payment_status = "Pending";
		
		
		List<OrderedTable> orderTable = new ArrayList<>();
		
		
		for (CartItems cartItems : c) {
			
			
			OrderedTable orderedTable = new OrderedTable();
			orderedTable.setCity(city);
			orderedTable.setOrdered_date(Ordered_date);
			orderedTable.setOrderStatus(OderedStatus);
			orderedTable.setPayment_Mode(Payment_Mode);
			orderedTable.setContact_No("9574855107");
			orderedTable.setDev_address(AddressConcate);
			orderedTable.setPayment_status(Payment_status);
			orderedTable.setPincode(Integer.parseInt(pincode));
			
			
			
			orderedTable.setProductID(cartItems.getProductID().getProduct_Id());
		
			orderedTable.setProductName(cartItems.getProductID().getProductName());
			
			orderedTable.setProductPrize(cartItems.getProductID().getProductPrice());
			
			orderedTable.setProductQty(cartItems.getProductQty());
			
			orderedTable.setSize(cartItems.getProductSize());
			
			orderedTable.setImg1(cartItems.getProductImg());
			
			orderedTable.setColor(cartItems.getColor());
			
			
			orderedTable.setUserName(email);
			
			orderTable.add(orderedTable);
		}
		
		
		this.orderedTableDao.saveAll(orderTable);
		this.ud.setAddressForDelivary(AddressConcate,email);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/userpage/OrderedPlaced");
		
		return modelAndView;
	}
	
	
	
	
}


