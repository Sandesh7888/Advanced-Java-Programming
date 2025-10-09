package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			System.out.println(con);
			Statement statement =con.createStatement();
			statement.execute("Create table Student(id int, name varchar2(100), email varchar(100), sub varchar2(100)");
			System.out.println("data create");
		}finally {
			con.close();
		}
	}

}
