package com.qsp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alldata")
public class AllData extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("star");
		
		 ArrayList<String> list = new ArrayList<String>();
		    list.add("Hello");
		    list.add("Hi");
		    list.add("Bye");
		    list.add("OK");
		    
		    req.setAttribute("arraylist", list);
		    
		    RequestDispatcher rd=req.getRequestDispatcher("dispay.jsp");
		    rd.forward(req, resp);
		
		
	}

}
