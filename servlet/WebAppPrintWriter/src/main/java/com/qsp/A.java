package com.qsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class A implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("class A"+req);
		System.out.println("class A"+res);
		
		
		PrintWriter p = res.getWriter();
		p.write("<html><body>");
		p.write("<h1>Info page<h1/>");
		p.write("</html></body>");	
	}

	@Override
	public String getServletInfo() {	
		return null;
	}
	@Override
	public void destroy() {
		System.out.println("close");	
	}
}
