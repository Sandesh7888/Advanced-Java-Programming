package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RegisterDriver {

    public static void main(String[] args) {
        Connection con = null;

        try {
            // Load the PostgreSQL driver class dynamically
        	//
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded successfully.");

            //
            // Establish the connection
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", 
                "postgres", 
                "root"
            );
            System.out.println("Connection established: " + con);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error occurred.");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}