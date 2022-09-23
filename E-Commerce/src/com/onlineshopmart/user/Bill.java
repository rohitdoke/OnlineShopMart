package com.onlineshopmart.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class Bill {
	
	int user_id,productid,productQuqantity;;
	
	public Bill(int productid,int productQuqantity) {
		this.productid=productid;
		this.productQuqantity=productQuqantity;
	}
	
	
	public void generateBill(Connection con ,Scanner sc) throws SQLException
	{
		System.out.println("*********************************************************************");
		System.out.println("   ***Your Bill Info*** ");
		System.out.println("*********************************************************************");
		
				Login l=new Login();
				l.getUserInfo( con, sc);
				user_id = l.getUserId(con, sc);
				System.out.println("----------------------------------------");
				System.out.println("   ***Your Date Info*** ");
				System.out.println("----------------------------------------");
				LocalDate date=LocalDate.now();		
				System.out.println("Billing Date:     "+date);
	
				LocalTime time= LocalTime.now();
				System.out.println("Billing Time:     "+time);
				System.out.println("--------------------------------------------------------------------------");
	
				                     
	

				System.out.println("--------------------------------------------------------------------------");
				System.out.println("Your Cart Product");
				System.out.println("--------------------------------------------------------------------------");	
				PreparedStatement preparedStatement3 =con.prepareStatement("select * from cart");
				ResultSet rs2=preparedStatement3.executeQuery();
				
				
				
				while(rs2.next())
				{
					
					System.out.println(" Productid "+rs2.getInt(1)+"\tName="+rs2.getString(2)+"\tPrice="+rs2.getFloat(4)+"\tQuantity="+rs2.getInt(5)+"\tDescription="+rs2.getString(3));
					
					
				}
				
				System.out.println("--------------------------------------------------------------------------");		
					
				
			System.out.println("");	
			
			Statement statement = con.createStatement();
			ResultSet rs5=statement.executeQuery("select Sum(quantity) from cart"); 
			rs5.next();
			Integer sum=Integer.parseInt(rs5.getString(1));
			System.out.println("TotalProduct:"+sum);
			
			Statement statement2 = con.createStatement();
			ResultSet rs6=statement2.executeQuery("select sum( quantity*price) from cart;"); 
			rs6.next();
			
			Float totalPrice=Float.parseFloat(rs6.getString(1));
			System.out.println("TotalPrice:"+totalPrice);
			
			Statement statement3 = con.createStatement();
			
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			PreparedStatement preparedStatement11 =con.prepareStatement("INSERT INTO order1 (product_id,user_id ,qty,order_date,order_id) VALUES (?,?,?,?,?)");		
			preparedStatement11.setInt(1,productid); 
			preparedStatement11.setInt(2, user_id);
			preparedStatement11.setInt(3, productQuqantity);
			preparedStatement11.setString(4, myFormatObj.format(myDateObj));
			Integer orderid=getOrderId(5);
			preparedStatement11.setInt(5, orderid);
		
			preparedStatement11.execute();
			
			statement3.execute("DELETE FROM cart  ");
	
	System.out.println("                         ***Order confirmed***                            ");
	System.out.println("           __________________________________________________            ");
	System.out.println("           *************THANK YOU!! Visit Again**************");
	

}
public Integer getOrderId(int len) {
		
		
		String s = "";
		int ranNo;
		
		for (int i = 0; i < len; i++) {
			
			ranNo = new Random().nextInt(9);
			s = s.concat(Integer.toString(ranNo));
		}
		Integer id=Integer.parseInt(s);
		return id;
	}
}
