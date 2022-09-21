package com.onlineshopmart.admin;

import java.sql.Connection;
import java.util.Scanner;

public interface AdminViewInterface {
	public void viewUserHistory(Connection con,Scanner sc);
	public void viewUserList(Connection con,Scanner sc);
}
