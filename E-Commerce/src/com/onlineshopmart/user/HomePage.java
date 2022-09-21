package com.onlineshopmart.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.onlineshopmart.admin.AdminLogin;

public class HomePage {
	public static Connection con = null;

	public static Scanner sc = null;

	public static Scanner getScanner() {
		return sc = new Scanner(System.in);

	}

	public static Connection getConnection() throws SQLException {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) throws SQLException {

		getScanner();
		getConnection();
		int ch = 0;
		do {
			System.out.println("Welcome OnlineShopMart");

			System.out.println("======================================================================");

			System.out.println("Please Enter the Choice");

			System.out.println("1.New User Registration");

			System.out.println("2.User Login");

			System.out.println("3.Admin Login");

			System.out.println("4.Exit");

			ch = sc.nextInt();

			switch (ch) {
			case 1:
				UserRegisteration userRegisteration1 = new UserRegisteration();
				userRegisteration1.getUserRegisteration(con, sc);
				break;

			case 2:
				String username, password;
				System.out.println("Enter your username and password : ");
				System.out.println("Enter your username :\t");
				username = sc.next();
				System.out.println("Enter your password :\t");
				password = sc.next();
				Login login1 = new Login();
				login1.getLogIn(con, sc, username, password);
				ProductList productList1 = new ProductList();
				productList1.getProductList(con, sc);
				Cart cart = new Cart(login1.getUserId(con, sc));
				cart.addCart(con, sc);

				break;
			case 3:
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.loadMain(getConnection(), getScanner());
				break;

			case 4:
				System.exit(0);
				System.out.println("You Existed From Online Shoping Mart");
				break;
			default:
				System.out.println("Invalid Input ");
				break;
			}
		} while (ch != 4);

	}
}
