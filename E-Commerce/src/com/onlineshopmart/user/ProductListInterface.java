package com.onlineshopmart.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public interface ProductListInterface {
	public void getProductList(Connection con, Scanner sc) throws SQLException;

	public void addCart(Connection con, Scanner sc) throws SQLException;
}
