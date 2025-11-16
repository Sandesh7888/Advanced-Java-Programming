package com.qsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUser extends HttpServlet {
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		String username=req.getParameter("uername");
//		String password =req.getParameter("password");
//		
//		PrintWriter p= resp.getWriter();
//		
//		if(username.equals("onkar123") && password.equals("123456")) {
//				p.write("<html><body>");
//			    p.write("<h1>Login succesfully<h1>"+username);
//			    p.write("<h1><h1>"+password);
//			    p.write("</html></body>");
//		}else {
//				p.write("<html><body>");
//			    p.write("<h1>invalid username password");
//			    p.write("</html></body>");
//			
//		}
//		
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username=req.getParameter("uername");
		String password =req.getParameter("password");	
	
			    p.write("</html></body>");
		}else {
				p.write("<html><body>");
			    p.write("<h1>invalid username password");
			    p.write("</html></body>");
			
		}
	}
	
	

}
