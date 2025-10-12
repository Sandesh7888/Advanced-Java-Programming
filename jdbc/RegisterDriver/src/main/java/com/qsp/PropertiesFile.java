package com.qsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    public static void main(String[] args) {
        try {
            // Load the properties file
            FileInputStream file = new FileInputStream("db.properties");
            Properties pro = new Properties();
            pro.load(file);

            // Retrieve and print each property
            String user = pro.getProperty("user");
            System.out.println("User: " + user);

            String password = pro.getProperty("password");
            System.out.println("Password: " + password);

            String URL = pro.getProperty("URL");
            System.out.println("URL: " + URL);

            String driverClassPath = pro.getProperty("driverClassPath");
            System.out.println("Driver Class Path: " + driverClassPath);

        } catch (FileNotFoundException e) {
            System.out.println("Properties file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading properties file.");
            e.printStackTrace();
        }
    }
}