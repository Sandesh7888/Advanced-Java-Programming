package com.qsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayResult extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double weight=(double)req.getAttribute("weight");
		double height=(double)req.getAttribute("height");
		double result=(double)req.getAttribute("result");
		
		PrintWriter pw=resp.getWriter();
		
		if(result<18) {
			pw.write("<html><head>");
			pw.write("<h1>over weight<h1><br>");
			pw.write("<h1>Weight : "+weight+"<h1>");
			pw.write("<h1>Height : "+height+"<h1>");
			pw.write("<h1>Result : "+result+"<h1>");
			pw.write("</html></head>");
			
		}else  if(result>18){
			pw.write("<html><head>");
			pw.write("<h1>Under weight<h1>");			
			pw.write("<h1>Weight :"+weight+"<h1>");
			pw.write("<h1>Height :"+height+"<h1>");
			pw.write("<h1>Result :"+result+"<h1>");
			pw.write("</html></head>");
			
		}else {
			pw.write("<html><head>");
			pw.write("<h1>Under weight<h1>");
			pw.write("<h1>Weight"+weight+"<h1>");
			pw.write("<h1>Height"+height+"<h1>");
			pw.write("<h1>Result"+result+"<h1>");
			pw.write("</html></head>");
			
		}
		
		
	}

}
