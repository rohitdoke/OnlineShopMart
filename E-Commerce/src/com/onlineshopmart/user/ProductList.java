package com.onlineshopmart.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.onlineshopmart.admin.Product;

public class ProductList implements ProductListInterface {
	@Override
	public void getProductList(Connection con, Scanner sc) throws SQLException {

		PreparedStatement preparedStatement1 = con.prepareStatement("select * from product");

		ResultSet rs = preparedStatement1.executeQuery();

		System.out.println("==============================================================================");
		System.out.println("Products Informaton");
		System.out.println("==============================================================================");

		List<Product> productList = new ArrayList<Product>();

		while (rs.next()) {

			productList.add(new Product(rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(1)));

		}
		System.out.println("\nAll Available Product List\n");
		System.out.format("%10s %13s %13s %13s %13s", "Name", "Discription", "Price", "Quantity", "Product Id");
		System.out.println();
		
		for (int i = 0; i < productList.size(); i++) {
			System.out.format("%10s %13s %13s %13s %13s", productList.get(i).getName(),
					productList.get(i).getDescription(), productList.get(i).getPrice(),
					productList.get(i).getQuantity(), productList.get(i).getProductid());
			System.out.println();
			// System.out.println(p1);

		}
		System.out.println("*********************************************************************");

	}

	
		

	
}
