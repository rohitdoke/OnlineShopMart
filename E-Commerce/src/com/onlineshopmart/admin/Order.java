package com.onlineshopmart.admin;

public class Order {
	Integer product_id;
	Integer user_id ,qty;
	String order_date;
	Integer order_id;
	String firstname,lastname,name;
	public Order(Integer product_id, Integer user_id, Integer qty, String order_date, Integer order_id,
			String firstname, String lastname, String name) {
		super();
		this.product_id = product_id;
		this.user_id = user_id;
		this.qty = qty;
		this.order_date = order_date;
		this.order_id = order_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.name = name;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Order [product_id=" + product_id + ", user_id=" + user_id + ", qty=" + qty + ", order_date="
				+ order_date + ", order_id=" + order_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", name=" + name + "]";
	}
	
	
	
	
	
}
