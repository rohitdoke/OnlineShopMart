package com.onlineshopmart.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Login implements UserInterface {
		public static String username =null;
		public static String password =null;
		
		public void getLogIn() {
			PreparedStatement preparedStatement =null;
			ResultSet resultSet =null;
			
		Map <String ,String> map = new LinkedHashMap<String,String>();
		Scanner scan = new Scanner(System.in);
		try {
			preparedStatement=ConnectJDBC.connection.prepareStatement("select * from user");
			resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				map.put(resultSet.getString(6), resultSet.getString(7));
				
			System.out.println("Enter username and password which you have entered during registration time 😊 😊 😊");	
			System.out.println();
			System.out.println("Enter the Username : ");
			username=scan.next();
			System.out.println("Enter the Password : ");
			password =scan.next();
			System.out.println("------------------------------------------------------------------------------------------------");
			
			Set <String > set = map.keySet();
			if(set.contains(username)) {
				if(password.equals(map.get(username))) {
			System.out.println("Log In Successfully 😀 😀 😀    /n "
					+ "😊  WELCOME 😊");
			System.out.println("-------------------------------------------------------------------------------------------------");
			
				}else {
					System.out.println("Sorry 😢 😢 , Invalid password entered, Pleased try again 🙏🙏");
					System.out.println("-----------------------------------------------------------------------------------------");
					getLogIn();
				}
			}else {
				System.out.println("Sorry 😢😢 , You entered Invalid username please check once and try again 🙏🙏");
				System.out.println("----------------------------------------------------------------------------------------------");
				getLogIn();
			}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
}
