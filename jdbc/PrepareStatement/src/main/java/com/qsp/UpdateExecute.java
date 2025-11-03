package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateExecute {
	

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "root");
			
			PreparedStatement st= con.prepareStatement("insert into product values (?,?,?)");
			System.out.println("Enter id");
			st.setInt(1, sc.nextInt());
			System.out.println("Enter product name");
			sc.nextLine();
			st.setString(2,sc.nextLine());
			System.out.println("Enter price");
			st.setDouble(3,sc.nextDouble());
			
			int res=st.executeUpdate();
			
			System.out.println(res);
			System.out.println("execute query ");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.close();
			sc.close();
			
		}
		
		
		
		

	}

}
