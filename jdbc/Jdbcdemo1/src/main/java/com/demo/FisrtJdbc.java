//load briver/register driver -->forname mathon static method java.lang pakeage	
//established connection getconnection method   type data java.sql ->DriverManageger class -->getconnection   return connection -->connection is interface
//create statement preped statement java.sql 
//execute query ,execute
//close connection
package com.demo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FisrtJdbc {
	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "root");
			System.out.println(con);
			Statement statement =con.createStatement();//
			
//			statement.execute("update emp set sal=1500000 where id=3");
			statement.execute("insert into emp values(4,'devid',210000,4566,10)");
			System.out.println("data set");
		}finally {
			con.close();
		}
	}

}
