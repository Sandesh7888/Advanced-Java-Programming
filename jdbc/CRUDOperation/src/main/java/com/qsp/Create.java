package com.qsp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Create {

	public static void main(String[] args) throws Exception {
		
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

		System.out.println(con);
		
		Statement stm= con.createStatement();
		stm.execute("Create table user ( id int primary key, name varchar2(100 ), num number(12)");
		con.close();
		
	}

}
