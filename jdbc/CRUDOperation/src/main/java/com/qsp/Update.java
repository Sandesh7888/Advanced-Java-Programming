package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Update {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            // Load PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", 
                "postgres", 
                "root"
            );

            System.out.println("Connected to database.");

            // Create statement
            stmt = con.createStatement();

            // Define UPDATE query (example: update student set name = 'Sandesh' where id = 1)
            String query = "UPDATE student SET name = 'Sandesh' WHERE id = 1";

            // Execute update
            int rowsAffected = stmt.executeUpdate(query);
            System.out.println("Rows updated: " + rowsAffected);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error.");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}