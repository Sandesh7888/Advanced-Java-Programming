package com.main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadphoto")
@MultipartConfig
public class UploadPhoto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Part part = req.getPart("photo");

        if (part == null) {
            resp.getWriter().println("No file uploaded! Part is null.");
            return;
        }

        InputStream inputStream = part.getInputStream();

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecommerce", "postgres", "root");
            PreparedStatement ps = con.prepareStatement("insert into customerimg values(?,?,?)");

            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, name);
            ps.setBinaryStream(3, inputStream, part.getSize());

            int res = ps.executeUpdate();

            if (res > 0) {
                resp.getWriter().print("<html><body><h1>Photo uploaded successfully..!</h1></body></html>");
            } else {
                resp.getWriter().print("<html><body><h1>Uploading photo failed...</h1></body></html>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
