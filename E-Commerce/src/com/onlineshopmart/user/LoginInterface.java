package com.onlineshopmart.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public interface LoginInterface {
	public void getLogIn(Connection con, Scanner sc, String username, String password);

	public int getUserId(Connection con, Scanner sc) throws SQLException;

	public ResultSet getUserInfo(Connection con, Scanner sc) throws SQLException;
}
