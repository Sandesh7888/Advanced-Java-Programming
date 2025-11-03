package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class batchProcessing {
	public static void main(String []arg) throws SQLException {
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			 con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo?user=postgres&password=root");
			PreparedStatement stm= con.prepareStatement("insert into product values(?,?,?)");
			
			stm.setInt(1, 6);
			stm.setString(2, "Cherry");
			stm.setDouble(3, 66);
			
			stm.addBatch();
			
			stm.setInt(1, 7);
			stm.setString(2, "banana");
			stm.setDouble(3, 66);
			
			stm.addBatch();
			
			stm.setInt(1, 8);
			stm.setString(2, "pineApple");
			stm.setDouble(3, 66);
			
			stm.addBatch();
			int arr[] =stm.executeBatch();
			System.out.println(arr);
			
			
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}finally {

		}
		
		
	}

}
