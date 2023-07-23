package com.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.controller.dao.HomepageProductView;
import com.ecommerce.fileUpload.FileUploadHelper;
import com.ecommerce.model.ProductTable;

@Controller
public class AddProductAdmin {
	
	@Autowired
	private HomepageProductView protudedao;
	
	@GetMapping("/Admin/AddProductAdmin")
	public String AddProductadmin() {	
		return "/Admin/AddProductByAdmin";
	}
	
	@PostMapping("/Admin/AddProductAdminFrom")
	public String AddProductadminForm( @RequestParam("productname") String productname,@RequestParam("productCatogory")  String productCatogory,
			@RequestParam("productDes") String productDes, @RequestParam("productColor") String productColor, @RequestParam("productSize") String productSize,
			@RequestParam("productQuntity") String productQuntity, @RequestParam("productPrice") String productPrice , @RequestParam("productfor") String productfor,
			@RequestParam("img1") MultipartFile file1,
			@RequestParam("img2") MultipartFile file2,
			@RequestParam("img3") MultipartFile file3,
			@RequestParam("img4") MultipartFile file4 
			) throws IOException{	
		
		ProductTable p = new ProductTable();
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println();
		System.out.println("------------------------------------------------------------------------");
		
		
		p.setProductCatogory(productCatogory);
		p.setProductColor(productColor);
		p.setProductDes(productDes);
		p.setProductFor(productfor);
		p.setProductPrice(Double.parseDouble(productPrice));
		p.setProductName(productname);
		p.setProductSize(Integer.parseInt(productSize));
		p.setProductStock(Integer.parseInt(productQuntity));
		p.setProductImg1(file1.getOriginalFilename());
		p.setProductImg2(file2.getOriginalFilename());
		p.setProductImg3(file3.getOriginalFilename());
		p.setProductImg4(file4.getOriginalFilename());
		
	  FileUploadHelper f = new FileUploadHelper();
	  
	  System.out.println(f.fileUpload_img(file1));
	  System.out.println(f.fileUpload_img(file2));
	  System.out.println(f.fileUpload_img(file3));
	  System.out.println(f.fileUpload_img(file4));
	  
	  this.protudedao.save(p);
	
		
		return "/Admin/AddProductByAdmin";
	}
	
}
