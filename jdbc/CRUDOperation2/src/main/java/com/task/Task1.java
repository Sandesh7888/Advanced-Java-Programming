package com.task;


import java.sql.SQLException;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) throws SQLException, IdNotFoundException {
		
		Scanner sc= new Scanner(System.in);
		Task1 t=new Task1();
		ControllerDAO c=new Controller();
		
		
		boolean isLogged =true;
		while(isLogged) {
			System.out.println(" 1 : Save Data \n 2 : Update data \n 3 : Delete Data \n 4 : Get Data By ID  \n 5 : Exit");
			
		
		    System.out.println("Enter your choice");
		    int choice =sc.nextInt();
		    switch (choice) {
			case 1:  c.save();
				
				break;
            case 2: c.update();
				
				break;
			case 3: c.delete();
				
				break;
            case 4: c.getById();
				
				break;
			case 5: System.out.println("=============== end =============");
				isLogged =false;
			

			 	break;
			default: System.out.println("invalid choice");
				break;
			}
		    
		}
			
	}
	
	

	

}
