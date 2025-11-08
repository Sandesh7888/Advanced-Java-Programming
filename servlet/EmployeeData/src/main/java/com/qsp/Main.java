package com.qsp;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Main implements Servlet  {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("server start");
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		PrintWriter p= res.getWriter();
		p.write("<html><body>");
		p.write("<h1>UserName: "+username+"<h1>");
		p.write("<h1>Password: "+password+"<h1>");
		p.write("</html></body>");
		
		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/servletDatabase","postgres","root");
			
			PreparedStatement ps=con.prepareStatement("insert into emplogin  values(?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ps.execute();
		
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
		
	}

}
