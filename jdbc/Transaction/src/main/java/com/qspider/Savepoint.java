package com.qspider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Savepoint {
    public static void main(String[] args) {
        String booking_info = "INSERT INTO booking_info VALUES (102, 'Qatar', 'Pune', 'Dubai')";
        String passenger = "INSERT INTO passenger VALUES (102, 'Sandesh', 100, 'male')";
        String payment = "INSERT INTO payment VALUES (102, 5000, 'online')";

        Connection con = null;
        java.sql.Savepoint sp1 = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/transactions_data", 
                    "postgres", 
                    "root"
            );

            // Disable auto-commit for transaction control
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();

            // 1️⃣ Insert booking info
            stmt.executeUpdate(booking_info);
            System.out.println("Inserted booking info.");

            // Create a savepoint after booking_info
            sp1 = con.setSavepoint("AfterBooking");

            // 2️⃣ Insert passenger info
            stmt.executeUpdate(passenger);
            System.out.println("Inserted passenger info.");

            // 3️⃣ Insert payment info (simulate error or test rollback)
            stmt.executeUpdate(payment);
            System.out.println("Inserted payment info.");

            // ✅ If all successful, commit transaction
            con.commit();
            System.out.println("Transaction committed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null && sp1 != null) {
                    // Rollback to savepoint if something fails
                    con.rollback(sp1);
                    System.out.println("Rolled back to savepoint: AfterBooking");
                    con.commit(); // commit the rollback changes
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
