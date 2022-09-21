package com.onlineshopmart.admin;

public class UserInfo {
	private Integer userid;
	private String firstname,lastname,mobilenumber,address,username,password;
	public UserInfo(Integer userid, String firstname, String lastname, String mobilenumber, String address, String username,String password)
	{
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilenumber = mobilenumber;
		this.address = address;
		this.username = username;
		this.password = password;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", mobilenumber="
				+ mobilenumber + ", address=" + address + ", username=" + username + ", password=" + password + "]";
	}
	
}
