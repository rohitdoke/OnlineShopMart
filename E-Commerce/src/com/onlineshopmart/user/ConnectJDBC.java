package com.onlineshopmart.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
	public static Connection connection =null;
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb","root","root");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args)  throws SQLException{
		getConnection();
		Login login = new Login();
		login.getLogIn();
	} 
	
}
