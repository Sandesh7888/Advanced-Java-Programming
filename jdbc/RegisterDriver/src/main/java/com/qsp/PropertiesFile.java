package com.qsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		
		
		try {
			FileInputStream file=new FileInputStream("db.properties");
			Properties pro=new Properties();
			pro.load(file);
			
			String user=pro.getProperty("user");
			System.out.println(user);
			
			String password=pro.getProperty("password");
			System.out.println(user);
			
			String URL=pro.getProperty("URL");
			System.out.println(user);
			
			String driverClassPath=pro.getProperty("driverClassPath");
			System.out.println(driverClassPath);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
