package com.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.postgresql.Driver;

import com.util.DBConnection;

public class Controller implements ControllerDAO {
	Scanner sc=new Scanner(System.in);

	public void save () throws SQLException {
	
		
			Connection con = DBConnection.getConnection();	
			PreparedStatement st= con.prepareStatement("insert into student values (?,?,?)");
			
			System.out.println("Enter id");
			st.setInt(1, sc.nextInt());
			
			System.out.println("Enter product name");
			sc.nextLine();
			st.setString(2,sc.nextLine());
			
			System.out.println("Enter marks");
			st.setInt(3, sc.nextInt());
			
			st.addBatch();
			
			st.executeBatch();
			
			
		    System.out.println("data insert ");
		    
		
		
	}
	
	

	public void update() throws SQLException, IdNotFoundException {
	
		
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement st= con.prepareStatement("update student set name = ? where id=? ");
			
			System.out.println("Enter product name");
			st.setString(1,sc.nextLine());
			
			System.out.println("Enter id");
			st.setInt(2, sc.nextInt());
			
			int res =st.executeUpdate();
			
			
			if (res == 0) {
                throw new IdNotFoundException("Employee not found with ID: ");
            }
            System.out.println("updated successfully");
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 


		
	}
	
	
	public void delete() throws SQLException {

		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st= con.prepareStatement("delete from student  where id=? ");
			
			System.out.println("Enter id");
			st.setInt(1, sc.nextInt());
			
			boolean res = st.execute();
			
			if(res) {
				System.out.println("delete data successfully ");
			}else {
				System.out.println("id is not found");
				
			}
			
			
		} catch ( SQLException e) {
			
			e.printStackTrace();
		} 
		
		
		
	}
	public void getById() throws SQLException, IdNotFoundException   {
		
		
		
			Connection con = DBConnection.getConnection();
			
			PreparedStatement stm=con.prepareStatement("select * from student where id=?");
			System.out.println("Enter ID");
     		stm.setInt(1, sc.nextInt());
			
			ResultSet r=stm.executeQuery();
			
			if(r.next()) {
				while(r.next()) {
					System.out.print(r.getInt(1)+" ");
					System.out.print(r.getString(2)+" ");
					System.out.print(r.getInt(3)+" ");
					System.out.println(r.getInt(4)+" ");
					System.out.println("------------------------------");
				}
			}else {
                  throw new IdNotFoundException("id not found");
				
			}
			
			
		
		
		
    }
}


