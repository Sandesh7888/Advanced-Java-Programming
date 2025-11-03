package com.daoimpl;


import dao.EmployeeDAO;


import java.sql.*;

import com.dto.Employee;
import com.exception.EmployeeNotFoundException;
import com.util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void saveEmployee(Employee emp) throws SQLException {
        String query = "INSERT INTO employee VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setDouble(3, emp.getSalary());
            ps.executeUpdate();
            System.out.println("✅ Employee saved successfully!");
        }
    }

    @Override
    public void updateEmployee(Employee emp) throws SQLException, EmployeeNotFoundException {
        String query = "UPDATE employee SET name=?, salary=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getId());
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new EmployeeNotFoundException("Employee not found with ID: " + emp.getId());
            }
            System.out.println("✅ Employee updated successfully!");
        }
    }

    @Override
    public void deleteEmployee(int id) throws SQLException, EmployeeNotFoundException {
        String query = "DELETE FROM employee WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new EmployeeNotFoundException("Employee not found with ID: " + id);
            }
            System.out.println("✅ Employee deleted successfully!");
        }
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException, EmployeeNotFoundException {
        String query = "SELECT * FROM employee WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"));
            } else {
                throw new EmployeeNotFoundException("Employee not found with ID: " + id);
            }
        }
    }
}
