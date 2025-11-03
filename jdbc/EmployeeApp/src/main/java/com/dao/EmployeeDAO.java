package com.dao;


import com.dto.Employee;
import com.exception.EmployeeNotFoundException;
import java.sql.SQLException;

public interface EmployeeDAO {
    void saveEmployee(Employee emp) throws SQLException;
    void updateEmployee(Employee emp) throws SQLException, EmployeeNotFoundException;
    void deleteEmployee(int id) throws SQLException, EmployeeNotFoundException;
    Employee getEmployeeById(int id) throws SQLException, EmployeeNotFoundException;
}
