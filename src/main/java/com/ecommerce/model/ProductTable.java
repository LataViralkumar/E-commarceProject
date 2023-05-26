package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "producttable")
public class ProductTable {

	
	@Id
	@Column(name ="Product_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Product_Id;
	
	@Column(name ="ProductName" , unique = true  , nullable = false ,length=50)
	private String  ProductName;
	
	@Column(name ="ProductColor", nullable = false , length=20)
	private String  ProductColor;
	
	@Column(name ="ProductSize" , nullable = false , length=20)
	private Integer ProductSize;
	
	@Column(name ="ProductStock" , nullable = false)
	private Integer ProductStock;
	
	@Column(name ="ProductCatogory" , nullable = false , length=50)
	private String ProductCatogory;
	
	@Column(name ="ProductDes" , nullable = false)
	private String ProductDes;
	
	@Column(name ="ProductImg1" , nullable = false)
	private String ProductImg1;
	
	@Column(name ="ProductImg2" , nullable = false)
	private String ProductImg2;
	
	@Column(name ="ProductImg3" , nullable = false)
	private String ProductImg3;
	
	@Column(name ="ProductImg4" , nullable = false)
	private String ProductImg4;
	
	@Column(name ="ProductFor" , nullable = false)
	private String ProductFor;
	
	@Column(name ="ProductPrice" , nullable = false)
	private Integer ProductPrice;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "productID")
	private List<CartItems> productID = new ArrayList<>();
	
	
	public List<CartItems> getProductID() {
		return productID;
	}
	public void setProductID(List<CartItems> productID) {
		this.productID = productID;
	}
	public Integer getProduct_Id() {
		return Product_Id;
	}
	public void setProduct_Id(Integer product_Id) {
		Product_Id = product_Id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductColor() {
		return ProductColor;
	}
	public void setProductColor(String productColor) {
		ProductColor = productColor;
	}
	public Integer getProductSize() {
		return ProductSize;
	}
	public void setProductSize(Integer productSize) {
		ProductSize = productSize;
	}
	public Integer getProductStock() {
		return ProductStock;
	}
	public void setProductStock(Integer productStock) {
		ProductStock = productStock;
	}
	public String getProductCatogory() {
		return ProductCatogory;
	}
	public void setProductCatogory(String productCatogory) {
		ProductCatogory = productCatogory;
	}
	public String getProductDes() {
		return ProductDes;
	}
	public void setProductDes(String productDes) {
		ProductDes = productDes;
	}
	public String getProductImg1() {
		return ProductImg1;
	}
	public void setProductImg1(String productImg1) {
		ProductImg1 = productImg1;
	}
	public String getProductImg2() {
		return ProductImg2;
	}
	public void setProductImg2(String productImg2) {
		ProductImg2 = productImg2;
	}
	public String getProductImg3() {
		return ProductImg3;
	}
	public void setProductImg3(String productImg3) {
		ProductImg3 = productImg3;
	}
	public String getProductImg4() {
		return ProductImg4;
	}
	public void setProductImg4(String productImg4) {
		ProductImg4 = productImg4;
	}
	public String getProductFor() {
		return ProductFor;
	}
	public void setProductFor(String productFor) {
		ProductFor = productFor;
	}
	public Integer getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(Integer productPrice) {
		ProductPrice = productPrice;
	}
	public ProductTable(Integer product_Id, String productName, String productColor, Integer productSize,
			Integer productStock, String productCatogory, String productDes, String productImg1, String productImg2,
			String productImg3, String productImg4, String productFor, Integer productPrice) {
		super();
		Product_Id = product_Id;
		ProductName = productName;
		ProductColor = productColor;
		ProductSize = productSize;
		ProductStock = productStock;
		ProductCatogory = productCatogory;
		ProductDes = productDes;
		ProductImg1 = productImg1;
		ProductImg2 = productImg2;
		ProductImg3 = productImg3;
		ProductImg4 = productImg4;
		ProductFor = productFor;
		ProductPrice = productPrice;
	}
	public ProductTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductTable [Product_Id=" + Product_Id + ", ProductName=" + ProductName + ", ProductColor="
				+ ProductColor + ", ProductSize=" + ProductSize + ", ProductStock=" + ProductStock
				+ ", ProductCatogory=" + ProductCatogory + ", ProductDes=" + ProductDes + ", ProductImg1=" + ProductImg1
				+ ", ProductImg2=" + ProductImg2 + ", ProductImg3=" + ProductImg3 + ", ProductImg4=" + ProductImg4
				+ ", ProductFor=" + ProductFor + ", ProductPrice=" + ProductPrice + "]";
	}
	
	
	
	
	
}
