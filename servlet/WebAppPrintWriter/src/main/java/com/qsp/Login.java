package com.qsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login implements Servlet {

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
		// TODO Auto-generated method stub
		String username=req.getParameter("name");
		String password=req.getParameter("password");
		
		PrintWriter p=res.getWriter();


		p.write("<html><body>");
		p.write("<h1>Username :"+username+"<h1>");
		p.write("<h1>Password :"+password+"<h1>");
		p.write("</html></body>");
		
		
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated 
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
