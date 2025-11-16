package com.qsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		
		
		
		if(username.equals("sandesh") && password.equals("12345")) {
			resp.getWriter().write("<html><body>logged</body></html>");
		}else {
			
			resp.getWriter().write("<html><body>not logged</body></html>");
			RequestDispatcher r= req.getRequestDispatcher("login.html");
			r.include(req, resp);
		}
		
		
		
		
	}
}
