package com.onlineshopmart.user;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Cart implements CartInterface{
	
	int user_id,productid,productQuqantity;
	
	public Cart(int user_id) {
		this.user_id=user_id;
	}
	@Override
	public void addCart(Connection con ,Scanner sc) throws SQLException
	{
		System.out.println("*********************************************************************");
		System.out.println("Product cart");
		System.out.println("*********************************************************************");
	
		
		
		Character key='y';
		do {
			System.out.println("please Enter product id to add into cart: ");
			
				productid=sc.nextInt();
				
									
			System.out.println("please Enter the Quantity");
			productQuqantity=sc.nextInt();
			
			
			

			  
			    PreparedStatement preparedStatement1 =con.prepareStatement("INSERT INTO cart (productid,name ,description ,price)"
						+"SELECT productid,name ,description ,price FROM product where productid=?");
				
				preparedStatement1.setInt(1,productid ); 
			
				
				preparedStatement1.execute();

				
				 PreparedStatement preparedStatement21 =con.
				 prepareStatement("UPDATE `ecommercedb`.`cart` SET `userid` = ? WHERE productid=? ");
				 
				 preparedStatement21.setInt(1,user_id );
				 preparedStatement21.setInt(2,productid );
				 
				 preparedStatement21.execute();
				 
				
				PreparedStatement preparedStatement2 =con.prepareStatement("UPDATE `ecommercedb`.`cart` SET `quantity` = ? WHERE productid=? ");
				
				preparedStatement2.setInt(1,productQuqantity );
				preparedStatement2.setInt(2,productid );
				
				  preparedStatement2.execute();
				  
				  
				PreparedStatement preparedStatement3 =con.prepareStatement("UPDATE ecommercedb.product SET quantity = quantity-? WHERE productid=? ");
				  
				preparedStatement3.setInt(1,productQuqantity );
				preparedStatement3.setInt(2,productid );
				preparedStatement3.execute();
			System.out.println("Product added");
			
			System.out.println("Do you want add product press 'y'");
			
			key=sc.next().charAt(0);
			
		}while(key=='y');
		
		
		
		
		System.out.println("What Do You Want ");
		
		System.out.println("1.Delete the product");
		System.out.println("2.display Cart");
			
		System.out.println("Please Enter the choice");
		Integer input=sc.nextInt();
		
		try {
				switch (input)
				{
					
					case 1 :
						
						removeCartProduct(con ,sc);
					
							break;
					case 2 :
							displayCart( con,sc);
							break;
				
					default :
				System.out.println("Invalid Input ");
				}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}		
		@Override
		public ResultSet displayCart(Connection con,Scanner sc) throws SQLException
		{
			System.out.println("*********************************************************************");	
			System.out.println("Your Cart Product");
			System.out.println("*********************************************************************");	
			PreparedStatement preparedStatement3 =con.prepareStatement("select * from cart");
			ResultSet rs=preparedStatement3.executeQuery();
			
			
			
			while(rs.next())
			{
				
				System.out.println(" Productid "+rs.getInt(1)+"\tName="+rs.getString(2)+"\tPrice="+rs.getFloat(4)+"\tQuantity="+rs.getInt(5)+"\tDescription="+rs.getString(3));
				
				
			}
			
			
			System.out.println("Please Enter the choice");
			System.out.println("What Do You Want ");
			System.out.println("1.Buy");
			System.out.println("2.Delete the product");
			System.out.println("3.Add the product");
			
			Integer input=sc.nextInt();
			
			try {
					switch (input)
					{
						case 1 :
								Bill bill= new Bill(productid,productQuqantity);
								
								bill.generateBill(con,sc);
								break;
					
						case 2 :
							
							removeCartProduct(con ,sc);
						
								break;
						case 3 :
							ProductList productList1=new ProductList();
							productList1.getProductList(con, sc);	
							addCart(con,sc);
								break;
						
					
						default :
					System.out.println("Invalid Input ");
					}		
			} catch (Exception e) {
				e.printStackTrace();
			}
			return rs;
		}
		

	@Override
	public void removeCartProduct(Connection con, Scanner sc) throws SQLException
	{
		
		System.out.println("************************************************************************");
		System.out.println("You Want delete product");
		System.out.println("************************************************************************");

		Character key='y';
		do {
		
			System.out.println("please Enter product id to delete Product: ");
		
			Integer productid=sc.nextInt();
			
			
			PreparedStatement preparedStatement1 =con.prepareStatement("select quantity FROM cart WHERE productid=?");
			preparedStatement1.setInt(1,productid );
			ResultSet rs=preparedStatement1.executeQuery();
			rs.next();
			Integer i=rs.getInt(1);
			
			PreparedStatement preparedStatement3 =con.prepareStatement("UPDATE ecommercedb.product SET quantity = quantity+? WHERE productid=? ");
			  
			preparedStatement3.setInt(1,i);
			preparedStatement3.setInt(2,productid );
			preparedStatement3.execute();
			
			
			
			PreparedStatement preparedStatement =con.prepareStatement("DELETE FROM cart WHERE productid=?");
			
			
			preparedStatement.setInt(1,productid );
			
			  preparedStatement.execute();
		
			  System.out.println("Product Deleted successully");
		
			  System.out.println("Do you want delete product press 'y'");
			  
			  key=sc.next().charAt(0);
		
		}while(key=='y');
		
		System.out.println("************************************************************************");

		
		System.out.println("What Do You Want ");
		
		
		System.out.println("1.Add the product");
		System.out.println("2.Display cart");
		System.out.println("3.Exit");
		System.out.println("Please Enter the choice");
		Integer input=sc.nextInt();
		
		try {
				switch (input)
				{
					
					case 1 :
						ProductList productList1=new ProductList();
						productList1.getProductList(con, sc);
							addCart(con,sc);
							
					
							break;
					case 2 :
						displayCart(con,sc);
						
							break;
					case 3 :
						System.exit(0);
						break;
					default :
							System.out.println("Invalid Input ");
							break;
				}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}