package com.qsp;


import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DisplayAllRecords {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		
		
		Query query=  em.createQuery("select e from Employee e");
		
		
		
		query.getResultList().forEach(System.out::println);
		
		
		
		
		
	
		
	}

}
