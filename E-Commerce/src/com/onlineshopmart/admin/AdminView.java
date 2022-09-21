package com.onlineshopmart.admin;

import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminView implements AdminViewInterface {
	@Override
	public void viewUserHistory(Connection con,Scanner sc) {
		try {
			//String query = "SELECT * FROM order1";
			String joinedquery = "SELECT o.*,u.firstname,u.lastname,p.name FROM ecommercedb.order1 o \r\n"
					+ "JOIN ecommercedb.user u ON (o.user_id=u.userid) \r\n"
					+ "JOIN ecommercedb.product p ON (o.product_id=p.productid)";
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(joinedquery);
			List<Order> list = new ArrayList<>();
			while(res.next()) {
				list.add(new Order(res.getInt("product_id"),res.getInt("user_id"), res.getInt("qty"),res.getString("order_date"),res.getInt("order_id"),res.getString("firstname"),res.getString("lastname"),res.getString("name")));
			}
			System.out.println("\nAll  Users History List which Buy Product \n");
			System.out.format("%7s %10s %7s %27s %10s %13s %13s %7s","product_id","user_id","qty","order_date","order_id","firstname","lastname","name");
			System.out.println();
			for(int i=0;i<list.size();i++) {
				System.out.format("%7s %10s %7s %27s %10s %13s %13s %7s",list.get(i).getProduct_id(),list.get(i).getUser_id(),list.get(i).getQty(),list.get(i).getOrder_date(),list.get(i).getOrder_id(),list.get(i).getFirstname(),list.get(i).getLastname(),list.get(i).getName());
				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}
	@Override
	public void viewUserList(Connection con,Scanner sc) {
		try {
			String query = "SELECT * FROM user";
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(query);
			List<UserInfo> userList = new ArrayList<>();
			while(res.next()) {
				userList.add(new UserInfo(res.getInt("userid"), res.getString("firstname"), res.getString("lastname"), res.getString("mobilenumber"),
						res.getString("address"), res.getString("username"), res.getString("password")));
			}
			
			System.out.println("\nAll Registered Users List\n");
			System.out.format("%7s %15s %15s %15s %15s %15s %15s","UserId","FistName","LastName","Mobile Number","Address","Username","Password");
			System.out.println();
			for(int i=0; i<userList.size();i++) {
				System.out.format("%7s %15s %15s %15s %15s %15s %15s",userList.get(i).getUserid(),userList.get(i).getFirstname()
						,userList.get(i).getLastname(),userList.get(i).getMobilenumber()
						,userList.get(i).getAddress(),userList.get(i).getUsername()
						,userList.get(i).getPassword());
				System.out.println();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
