package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class RegisterDriver {

	public static void main(String[] args) {
		Driver driver=new Driver();
		
		try {
			DriverManager.registerDriver(driver);
			System.out.println("Driver sw loaded");
			Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
