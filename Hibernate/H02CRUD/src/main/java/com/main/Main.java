package com.main;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		EmployeeCRUD crud = new EmployeeCRUD();
		
		while(true) {
			System.out.println("\n===== Employee Management =====");
			System.out.println("1 : Insert Employee");
			System.out.println("2 : Update Employee based on ID");
			System.out.println("3 : Remove Employee based on ID");
			System.out.println("4 : Display All Employees");
			System.out.println("5 : Get Min Salary Employee");
			System.out.println("6 : Exit");
			System.out.print("Enter choice : ");

			int choice = sc.nextInt();

			switch(choice) {
			case 1:
				crud.insertEmployee();
				break;
				
			case 2:
				crud.updateEmployee();
				break;
				
			case 3:
				crud.removeEmployee();
				break;
				
			case 4:
				crud.displayAllEmployees();
				break;

			case 5:
				crud.getMinSalaryEmployee();
				break;

			case 6:
				System.out.println("Thank you!");
				System.exit(0);

			default:
				System.out.println("Invalid Choice... Try Again");
			}
		}
	}
}
