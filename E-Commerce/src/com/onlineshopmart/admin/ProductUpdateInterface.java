package com.onlineshopmart.admin;

import java.sql.Connection;
import java.util.Scanner;

public interface ProductUpdateInterface {
	public void updateProduct(int product_id,Connection con,Scanner sc);
	public void updateColumnTable(String columnName,String columnValue,int prod_id,Connection con,Scanner sc);
}
