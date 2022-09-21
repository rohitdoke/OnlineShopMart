package com.onlineshopmart.admin;

import java.sql.Connection;
import java.util.Scanner;

public interface AdminLoginInterface {
	public void adminLogin(String username, String password,Connection con,Scanner sc);
	public void loadMain(Connection con,Scanner sc);
	public void adminFeatures(Connection con,Scanner sc);
}
