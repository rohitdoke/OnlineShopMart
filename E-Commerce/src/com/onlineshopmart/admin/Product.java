package com.onlineshopmart.admin;

public class Product {
	private Integer	productid , quantity;
	private String name; 
	private String description; 
	private float price;
	public Product(Integer productid, Integer quantity, String name, String description, float price) {
		super();
		this.productid = productid;
		this.quantity = quantity;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", quantity=" + quantity + ", name=" + name + ", description="
				+ description + ", price=" + price + "]";
	}
	

}
