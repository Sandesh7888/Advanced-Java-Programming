package com.qsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculateDMI")
public class CalculateDMI extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String weight=req.getParameter("weight");
		String height=req.getParameter("height");
		
		double weight1=Double.parseDouble(weight);
		double height1=Double.parseDouble(height);
		
		Double result= weight1 /(height1*height1);
		
		req.setAttribute("weight", weight1);
		req.setAttribute("height", height1);
		req.setAttribute("result", result);
		
		RequestDispatcher rd= req.getRequestDispatcher("display");
		
		rd.forward(req, resp);
		
	}

}
