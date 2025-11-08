package com.qsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Register extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter p=res.getWriter();

		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String mobile=req.getParameter("mobile");
		String salary=req.getParameter("salary");
		String email=req.getParameter("email");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
	
		
		int id1= Integer.parseInt(id);
		long mobile1 = Long.parseLong(mobile);
		double salary1 =Double.parseDouble(salary);

		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/servletDatabase","postgres","root");
			
			PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
			ps.setInt(1, id1);
			ps.setString(2, name);
			ps.setLong(3,mobile1);
			ps.setDouble(4,salary1);
			ps.setString(5, email);
			ps.setString(6, username);
			ps.setString(7, password);
			
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		p.write("<html><body>");
		p.write("<h1> id	 : "+id1+"<h1>");
		p.write("<h1> name : "+name+"<h1>");
		p.write("<h1> mobile : "+mobile+"<h1>");
		p.write("<h1>salary : "+salary1+" LPA <h1>");
		p.write("<h1>email : "+email+" <h1>");
		p.write("<h1> usrname : "+username+"<h1>");
		p.write("</html></body>");
		
		
		
		
	}

}
