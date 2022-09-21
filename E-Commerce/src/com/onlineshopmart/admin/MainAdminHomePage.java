package com.onlineshopmart.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class MainAdminHomePage {
	public static Connection con= null ;
	public static Scanner sc = null;
	
	
	public static Connection getConnection() {
		
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb","root","@Dhere1611");
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				return con;
			}
	public static Scanner getScanner() {
		return new Scanner(System.in);
	}

	public static void main(String[] args) {
		AdminOperation adminOperation = new AdminOperation();
		adminOperation.adminOperation(getConnection(),getScanner());
	}
}
