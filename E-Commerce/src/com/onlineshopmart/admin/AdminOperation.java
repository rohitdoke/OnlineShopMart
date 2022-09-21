package com.onlineshopmart.admin;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AdminOperation {
	public void adminOperation(Connection con,Scanner sc) {
		int ch = 0;
		

		do {
			System.out.println("======================================================================\nDo you want to Perform Operation on Product Database\n======================================================================\n1. View Product Quantity List\n2. Add New Product into Product Database\n3. Delete Perticular Product From Product Database\n4. Exit\n======================================================================\n---------->>Select your Choice<<----------");
			ch = sc.nextInt();
			switch(ch) {
			case 1 :
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Please Enter Product Id ");
				System.out.println("----------------------------------------------------------------------");
				int product_id = sc.nextInt();
				ProductQuantityList quantityList = new ProductQuantityList();
				quantityList.viewProductQuantyityList(product_id,con,sc);
				System.out.println("----------------------------------------------------------------------");
				System.out.println("                                                                      ");
				System.out.println("                                                                      ");
				System.out.println("                                                                      ");
				System.out.println("                                                                      ");
				break;
				
			case 2 : 
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Add New Product into Product Database");
				System.out.println("----------------------------------------------------------------------");
				System.out.println(">>Enter the Product Id : ");
				Integer productid = sc.nextInt();
				System.out.println(">>Enter the Product Name : ");
				String name = sc.next();
				System.out.println(">>Enter the product Description : ");
				String description = sc.next();
				System.out.println(">>Enter the Product Price : ");
				float price = sc.nextFloat();
				System.out.println(">>Enter the Product Quantity : ");
				Integer quantity = sc.nextInt();
				Product p = new Product(productid, quantity, name, description, price);
				new AdminOperation().addProduct(p,con,sc);
				break;
				
			case 3 :
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Delete Product From Product Database");
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Enter Product Id :");
				int pid = sc.nextInt();
				new AdminOperation().deleteProduct(pid,con,sc);
				break;
		
			case 4 :
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Admin Operation Exit...");
				System.out.println("----------------------------------------------------------------------");
				break;
				
			default :
					System.out.println("Invalid Choice");
					break;
			}
		}while(ch!=4);
	}


	public void addProduct(Product p,Connection con,Scanner sc) {
		try {
			String s = "insert into product(productid,name,description,price,quantity)"+"values('"+p.getProductid()+"','"+p.getName()+"','"+p.getDescription()+"','"+p.getPrice()+"','"+p.getQuantity()+"')";
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate(s);
			if(i>0) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println("😀 😀  Record Sucessfully inserted  😀 😀");
				System.out.println("----------------------------------------------------------------------");
				System.out.println("                                                                      ");
				System.out.println("                                                                      ");
				System.out.println("                                                                      ");
				System.out.println("                                                                      ");
			}
			else {
				System.out.println("----------------------------------------------------------------------");
				System.out.println("😢😢  Record Not Inserted  😢😢");
				System.out.println("----------------------------------------------------------------------");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}



	
	public void deleteProduct(int product_id,Connection con,Scanner sc) {
		try {
			String s = "delete from product where productid = ? ";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, product_id);
			ps.executeUpdate();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("😀 😀  Record Deleted Sucessfully !  😀 😀");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("                                                                      ");
			System.out.println("                                                                      ");
			System.out.println("                                                                      ");
			System.out.println("                                                                      ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	
}
	
	

