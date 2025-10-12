package com.qsp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class EstablishCon {

    public static void main(String[] args) {
        Properties pro = new Properties();

        try (FileInputStream file = new FileInputStream("db.properties")) {
            // Load properties from file
            pro.load(file);

            // Load JDBC driver
            String driverClassPath = pro.getProperty("driverClassPath");
            Class.forName(driverClassPath);

            // Get URL and establish connection
            String url = pro.getProperty("URL");
            try (Connection con = DriverManager.getConnection(url, pro)) {
                System.out.println("Connection established successfully!");
                // You can add your DB operations here
            }

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}