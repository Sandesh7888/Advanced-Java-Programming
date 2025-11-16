package com.qsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String salary = req.getParameter("salary");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        
        int id1 = Integer.parseInt(id);
        long mobile1 =Long.parseLong(mobile);
        double salary1= Double.parseDouble(salary);
        
        Connection con=null;
        try {
			Class.forName("org.postgresql.Driver");
			 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/register","postgres","root");
			
			PreparedStatement ps= con.prepareStatement("insert into product values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, id1 );
			ps.setString(2, name);
			ps.setLong(3, mobile1);
			ps.setDouble(4, salary1);
			ps.setString(5, email);
			ps.setString(6, username);
			ps.setString(5, password);
			
			int result=ps.executeUpdate();
			
			if(result>0) {
				  resp.getWriter().println("<h3 style='color:red'>Registration success!</h3>");
				  RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login.html");
					requestDispatcher.forward(req, resp);
			  }else {
				  resp.getWriter().println("<h3 style='color:red'>Registration failed! Try again.</h3>");
	                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Register.html");
	                requestDispatcher.include(req, resp);
			  }
			
		} catch (ClassNotFoundException | SQLException e) {
			
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
}