package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Delete {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", 
                "postgres", 
                "root"
            );

            System.out.println("Connection established: " + con);

            // Create a statement
            stmt = con.createStatement();

            // Define the DELETE query (example: delete from student where id = 1)
            String query = "DELETE FROM student WHERE id = 1";

            // Execute the DELETE query
            int rowsAffected = stmt.executeUpdate(query);
            System.out.println("Rows deleted: " + rowsAffected);

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred.");
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