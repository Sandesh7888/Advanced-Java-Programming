package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Update {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			 con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
			Statement st=con.createStatement();
			boolean r=st.execute("update student set email='admin@gmail.com' where id=2");
			System.out.println("data delete "+r);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			con.close();
			
		}

	}

}
