package com.qsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		System.out.println(emf);
		
		EntityManager em =emf.createEntityManager();//DML
		
		EntityTransaction et = em.getTransaction();//TCL
		
		Employee emp = em.find(Employee.class, 102);

		if (emp != null) {
		    et.begin();
		    
		    em.remove(emp);

		    et.commit();
		    System.out.println("DATA DELETEDs SUCCESSFULLY");
		} else {
		    System.out.println("DATA NOT FOUND");
		}

	}

}
