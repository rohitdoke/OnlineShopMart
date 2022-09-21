package com.onlineshopmart.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public interface CartInterface {
	public void addCart(Connection con ,Scanner sc) throws SQLException;
	public ResultSet displayCart(Connection con,Scanner sc) throws SQLException;
	public void removeCartProduct(Connection con, Scanner sc) throws SQLException;
}
