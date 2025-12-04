package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");//confi file connrction
		System.out.println(emf);
		
		EntityManager em =emf.createEntityManager();//DML
		
		EntityTransaction et = em.getTransaction();//TCL
		
		Student student=new Student(3,"sham",4561237880L);
		
		et.begin();
		em.persist(student);
		et.commit();
		
		
		

	}

}
