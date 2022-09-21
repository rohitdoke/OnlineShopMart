package com.onlineshopmart.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin  implements AdminLoginInterface{
	
	@Override
	public void adminLogin(String username, String password,Connection con,Scanner sc) {
		try {
			String query = "SELECT * FROM admin WHERE username=? AND password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				System.out.println("---------------------------------------------------");
				System.out.println("Log In Successfully 😀 😀 😀 ");
				System.out.println("😊  WELCOME 😊");
				adminFeatures(con,sc);
			}else {
				System.out.println("Sorry 😢😢 , You entered Invalid username OR password please check once and try again 🙏🙏");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void loadMain(Connection con,Scanner sc) {
		
		int ch=0;
		do {
			System.out.println("Welcome to Online Shop Mart Admin Panel");
			System.out.println("===================================================");
			System.out.println("1. Admin Login\n2. Exit\nChoose your option:");
			System.out.println("---------------------------------------------------");
			ch = sc.nextInt();
			switch(ch) {
			case 1: String username,password;
					System.out.println("Enter your username and password : ");
					System.out.println("Enter your username :\t");
					username = sc.next();
					System.out.println("Enter your password :\t");
					password = sc.next();
					new AdminLogin().adminLogin(username,password,con,sc);
					break;
					
			case 2: System.exit(0);
					break;
			
			default: System.out.println("Inavlid input");
			break;
			}
		}while(ch!=2);
	}
	@Override
	public void adminFeatures(Connection con,Scanner sc) {
		
		int choice=0;
		do {
			System.out.println("---------------------------------------------------");
			System.out.println("1. See user List\n2. Check User Order History \n3. Update Product Database based on Column Name\n4. Admin Operation On Product Database\n5. Exist\nEnter your choice\t");
			System.out.println("---------------------------------------------------");
			choice = sc.nextInt();
			
			switch(choice) {
				
			case 1: 
				AdminView adminView = new AdminView();
				adminView.viewUserList(con,sc);
				break;
					
			case 2:
				AdminView adminView1 = new AdminView();
				adminView1.viewUserHistory(con, sc);
				break;
				
			case 3: 
				System.out.println("\nEnter the Product Id");
				int product_id = sc.nextInt();
				ProductUpdate productUpdate = new ProductUpdate();
				productUpdate.updateProduct(product_id, con, sc);
				break;
					
			case 4:
				AdminOperation adminOperation = new AdminOperation();
				adminOperation.adminOperation(con,sc);
				break;
			case 5: 
				System.out.println("Existing From Admin Features...................\n");
				System.out.println("---------------------------------------------------");
				//new AdminView();
				break;
					
			}
			
		}while(choice!=5);
	}

}
