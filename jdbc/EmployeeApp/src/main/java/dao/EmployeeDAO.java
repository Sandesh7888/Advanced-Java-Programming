package dao;

import java.sql.SQLException;

import com.dto.Employee;
import com.exception.EmployeeNotFoundException;

public interface EmployeeDAO {
    void saveEmployee(Employee emp) throws SQLException;
    void updateEmployee(Employee emp) throws SQLException, EmployeeNotFoundException;
    void deleteEmployee(int id) throws SQLException, EmployeeNotFoundException;
    Employee getEmployeeById(int id) throws SQLException, EmployeeNotFoundException;
}
