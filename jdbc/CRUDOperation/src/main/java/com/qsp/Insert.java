package com.qsp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

			System.out.println(con);
			
			Statement stm= con.createStatement();
		    boolean res=stm.execute("insert into student values (102,'smith',123456)");
		    System.out.println(res);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			con.close();
			
		}
		
		
	}

}
