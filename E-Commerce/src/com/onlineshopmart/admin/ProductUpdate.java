package com.onlineshopmart.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ProductUpdate implements ProductUpdateInterface {
	@Override
	public void updateProduct(int product_id,Connection con,Scanner sc) {
		int ch=0;
		do {
			System.out.println("---------------------------------------------------");
			System.out.println("What do you want to update?\n1. Name\n2.Description\n3.Price\n4.Quantity\n5.Exit");
			System.out.println("Enter your Choice");
			System.out.println("---------------------------------------------------");
			ch=sc.nextInt();
			
			switch(ch) {
				case 1: System.out.println("\nYou want to update name\nPlease eneter new name:\t");
						String nm = sc.next();
						updateColumnTable("name", nm, product_id,con,sc);
						break;
						
				case 2: System.out.println("You want to update Description\nPlease eneter new description:\t");
						String ds = sc.next();
						updateColumnTable("description", ds, product_id,con,sc);
						break;
						
				case 3: System.out.println("You want to update Price\nPlease eneter new price:\t");
						String prc = sc.next();
						updateColumnTable("price", prc, product_id,con,sc);
						break;
				
				case 4: System.out.println("You want to update Quantity\nPlease eneter new quantity:\t");
						String qty = sc.next();
						updateColumnTable("quantity", qty, product_id,con,sc);
						break;
				
				case 5: break;
				
			}
		}while(ch!=5);
		
		
	}
	
	@Override
	public void updateColumnTable(String columnName,String columnValue,int prod_id,Connection con,Scanner sc) {
		try {
			
			if(isFLoat(columnValue)) {
				String s = "update product set "+columnName+"=? where productid = ? ";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setFloat(1, Float.parseFloat(columnValue));
				ps.setInt(2, prod_id);
				ps.executeUpdate();
				System.out.println(columnName+" updated Sucessfully !");
				
			}else if(isInt(columnValue)) {
				String s = "update product set "+columnName+"=? where productid = ? ";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setInt(1, Integer.parseInt(columnValue));
				ps.setInt(2, prod_id);
				ps.executeUpdate();
				System.out.println(columnName+" updated Sucessfully !");
				
			}else {
				String s = "update product set "+columnName+"=? where productid = ? ";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setString(1, columnValue);
				ps.setInt(2, prod_id);
				ps.executeUpdate();
				System.out.println(columnName+" updated Sucessfully !");
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean isFLoat(String str) {
		try{
	        Float.parseFloat(str);
	        return true;
	    }catch(NumberFormatException e){
	    	return false;
	    }
	}
	
	public boolean isInt(String str) {
		try{
	        Integer.parseInt(str);
	        return true;
	    }catch(NumberFormatException e){
	    	return false;
	    }
	}

}
