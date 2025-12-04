package com.main;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.qsp.Employee;

public class EmployeeCRUD {

	EntityManager em = Persistence.createEntityManagerFactory("vikas").createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in);

	// Insert Employee
	public void insertEmployee() {
		Employee e = new Employee();

		System.out.print("Enter ID : ");
		e.setId(sc.nextInt());
		System.out.print("Enter Name : ");
		e.setName(sc.next());
		System.out.print("Enter Salary : ");
		e.setSalary(sc.nextDouble());
		System.out.print("Enter Mobile : ");
		e.setMobile(sc.nextLong());

		et.begin();
		em.persist(e);
		et.commit();
		System.out.println("Employee Inserted Successfully");
	}

	// Update Employee based on ID
	public void updateEmployee() {
		System.out.print("Enter ID to Update : ");
		int id = sc.nextInt();

		Employee e = em.find(Employee.class, id);

		if(e != null) {
			System.out.print("Enter New Salary : ");
			double sal = sc.nextDouble();

			et.begin();
			e.setSalary(sal);
			et.commit();
			System.out.println("Employee Updated Successfully");
		} else {
			System.out.println("Employee Not Found");
		}
	}

	// Remove based on ID
	public void removeEmployee() {
		System.out.print("Enter ID to Remove : ");
		int id = sc.nextInt();

		Employee e = em.find(Employee.class, id);

		if(e != null) {
			et.begin();
			em.remove(e);
			et.commit();
			System.out.println("Employee Removed Successfully");
		} else {
			System.out.println("Employee Not Found");
		}
	}

	// Display All
	public void displayAllEmployees() {
		Query query = em.createQuery("SELECT e FROM Employee e");
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);
	}

	// Get Min Salary Employee
	public void getMinSalaryEmployee() {
		Query query = em.createQuery("SELECT e FROM Employee e WHERE e.salary = (SELECT MIN(e.salary) FROM Employee e)");
		Employee emp = (Employee) query.getSingleResult();
		System.out.println("Employee with Minimum Salary: " + emp);
	}
}
