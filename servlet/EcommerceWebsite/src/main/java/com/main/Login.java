package com.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecommerce?user=postgres&password=root");
			
			
			PreparedStatement statement=connection.prepareStatement("select * from customer where username=? and password=?");
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet executequery=statement.executeQuery();
			
			
			if(executequery.next()) {
				
				
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("Home.jsp");
				requestDispatcher.forward(req, resp);
				
			}else {
				
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login.jsp");
				requestDispatcher.include(req, resp);
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}