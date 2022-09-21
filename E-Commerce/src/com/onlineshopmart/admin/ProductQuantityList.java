package com.onlineshopmart.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductQuantityList {
	
	public void viewProductQuantyityList(int prod_id,Connection con,Scanner sc) {
				try {
					String query = "SELECT * FROM product WHERE productid=?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, prod_id);
					ResultSet res = ps.executeQuery();
				if(res.next()) {
					System.out.println("\nProduct details from database\nProduct Name:- "+res.getString("name")+"\nQuantity:- "+res.getInt("quantity"));
				}else {
					System.out.println("Product not found");
				}
				
				
				}catch(SQLException e) {
				 e.printStackTrace();
				}
			}

		}

