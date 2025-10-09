package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadtheDriver {
	public static void main (String[] args) throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "root");
			System.out.println(con);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
