package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.Driver;

public class GetData {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new Driver());
			Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo?user=postgres&password=root");

			PreparedStatement stm=con.prepareStatement("select * from product where id=?");
     		stm.setInt(1, 2);
			
			ResultSet r=stm.executeQuery();
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getDouble(3));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
