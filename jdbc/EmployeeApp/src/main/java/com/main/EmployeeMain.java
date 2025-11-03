package com.main;


import com.dao.EmployeeDAO;
import com.daoimpl.EmployeeDAOImpl;
import com.dto.Employee;
import com.exception.EmployeeNotFoundException;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = (EmployeeDAO) new EmployeeDAOImpl();

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1 : Save Data");
            System.out.println("2 : Update Data");
            System.out.println("3 : Delete Data");
            System.out.println("4 : Get Data By ID");
            System.out.println("5 : Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        dao.saveEmployee(new Employee(id, name, salary));
                        break;

                    case 2:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String uname = sc.nextLine();
                        System.out.print("Enter New Salary: ");
                        double usalary = sc.nextDouble();
                        dao.updateEmployee(new Employee(uid, uname, usalary));
                        break;

                    case 3:
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();
                        dao.deleteEmployee(did);
                        break;

                    case 4:
                        System.out.print("Enter ID to fetch: ");
                        int fid = sc.nextInt();
                        Employee emp = dao.getEmployeeById(fid);
                        System.out.println(emp);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (EmployeeNotFoundException | SQLException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }
}
