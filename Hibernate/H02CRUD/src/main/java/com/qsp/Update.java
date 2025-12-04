package com.qsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");//confi file connrction
		System.out.println(emf);
		
		EntityManager em =emf.createEntityManager();//DML
		
		EntityTransaction et = em.getTransaction();//TCL
		
		Employee emp1 = em.find(Employee.class, 102);
		
		

		if (emp1 != null) {
			emp1.setId(102);
			emp1.setName("sham");
			et.begin();
			em.merge(emp1);
			et.commit();
			
//		    et.begin();
//		    emp1.setName("amol");
//		    emp1.setSalary(6.0);
//		    emp1.setMobile(9876543210L);
//		    et.commit();
		    System.out.println("DATA UPDATED SUCCESSFULLY");
		} else {
		    System.out.println("DATA NOT FOUND");
		}

		

	}

}
