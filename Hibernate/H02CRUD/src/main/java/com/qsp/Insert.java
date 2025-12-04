package com.qsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		System.out.println(emf);
		
		EntityManager em =emf.createEntityManager();//DML
		
		EntityTransaction et = em.getTransaction();//TCL
		
		Employee emp=new Employee();
		
		emp.setId(105);
		emp.setName("tejas");
		emp.setSalary(11.5);
		emp.setMobile(1234567896L);
		
		et.begin();
		em.persist(emp);
		et.commit();
		
	}

}
