package com.onlineshopmart.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login implements LoginInterface {
	public static String username = null;
	public static String password = null;

	@Override
	public void getLogIn(Connection con, Scanner sc, String username, String password)

	{
		try {
			String query = "SELECT username,password FROM user WHERE username=? AND password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				System.out.println("---------------------------------------------------");
				System.out.println("Log In Successfully ðŸ˜€ ðŸ˜€ ðŸ˜€ ");
				System.out.println("ðŸ˜Š  WELCOME ðŸ˜Š");
			} else {
				System.out.println(
						"Sorry ðŸ˜¢ðŸ˜¢ , You entered Invalid username OR password please check once and try again ðŸ™�ðŸ™�");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getUserId(Connection con, Scanner sc) throws SQLException {
		PreparedStatement preparedStatement2 = con.prepareStatement("select userid from user where username=?");

		preparedStatement2.setString(1, username);
		ResultSet resultSet2 = preparedStatement2.executeQuery();
		if (resultSet2.next()) {
			return resultSet2.getInt("userid");
		} else {
			return 0;
		}
	}

	@Override
	public ResultSet getUserInfo(Connection con, Scanner sc) throws SQLException {

		PreparedStatement preparedStatement2 = con
				.prepareStatement("select userid,firstname,lastname,mobilenumber,address from user where username=?");

		preparedStatement2.setString(1, username);
		ResultSet resultSet2 = preparedStatement2.executeQuery();

		while (resultSet2.next()) {

			System.out.println("----------------------------------------");
			System.out.println("   ***Customer Info*** ");
			System.out.println("----------------------------------------");

			System.out.println("Customer ID:      " + resultSet2.getInt(1));
			System.out.println("Customer Name:    " + resultSet2.getString(2));
			System.out.println("Customer Address:    " + resultSet2.getString(5));
			System.out.println("Customer Mobile:    " + resultSet2.getString(2));
		}

		return resultSet2;
	}
}
