package com.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException{

        String id1 = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile1 = req.getParameter("mobile");
        String username = req.getParameter("register");
        String password = req.getParameter("pass");

        int id = Integer.parseInt(id1);
        long mobile = Long.parseLong(mobile1);
        
        
        Connection con = null;

        try {
           

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ecommerce",
                    "postgres",
                    "root"
            );

            PreparedStatement p = con.prepareStatement(
                "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?)"
            );

            p.setInt(1, id);
            p.setString(2, name);
            p.setString(3, email);
            p.setLong(4, mobile);
            p.setString(5, username);
            p.setString(6, password);

            p.executeUpdate();

            resp.getWriter().print("Register Successful!");

        } catch (Exception e) {
            e.printStackTrace();
//            resp.getWriter().print("Error: " + e.getMessage());
        } 
    }
}

