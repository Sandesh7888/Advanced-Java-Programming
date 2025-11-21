package com.main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Integers;



@WebServlet("/getimage")
public class DisplayPhoto extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecommerce","postgres", "root");

            PreparedStatement statement = con.prepareStatement("select photo from customerimg where id = ?");
			statement.setInt(1, Integer.parseInt(id));
			
			ResultSet executeQuery =  statement.executeQuery();
			
			if (executeQuery.next()) {
				byte[] bytes = executeQuery.getBytes("photo");
				
				resp.setContentType("image/jpeg");
				resp.setContentLength(bytes.length);
				
				ServletOutputStream outputStream = resp.getOutputStream();
				outputStream.write(bytes);
				outputStream.flush();
				outputStream.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}