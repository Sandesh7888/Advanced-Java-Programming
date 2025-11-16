package com.qsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (session == null) {
            out.println("<h1>No Session Found</h1>");
            return;
        }

        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        out.println("<html><body>");
        out.println("<h1>Username: " + username + "</h1>");
        out.println("<h1>Password: " + password + "</h1>");
        out.println("</body></html>");
    }
}
