package com.qsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FindById {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		System.out.println(emf);
		
		EntityManager em =emf.createEntityManager();//DML
		
		EntityTransaction et = em.getTransaction();//TCL
		
		Employee emp=em.find(Employee.class,101);
		
		
		if(emp!=null) {
			
			et.begin();

			System.out.println("id :"+emp.getId() );
			System.out.println("Name :"+emp.getName() );
			System.out.println("salary :"+emp.getSalary() );
			System.out.println("mobile number :"+emp.getMobile() );
			et.commit();
			
			
		}else {
			System.out.println("data not found");
		}
		
		et.begin();
		em.persist(emp);
		et.commit();
		
	}

}
