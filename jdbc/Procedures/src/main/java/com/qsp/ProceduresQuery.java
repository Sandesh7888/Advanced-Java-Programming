package com.qsp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ProceduresQuery {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/proceduredb","postgres","root");
		CallableStatement call=con.prepareCall("select count_by_gender(?)");
		call.setString(1, "male");
		ResultSet r = call.executeQuery();
		r.next();
		System.out.println(r.getInt(1));
		
	}

}
