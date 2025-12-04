package com.qsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetById {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		
		
//		Query query=  em.createQuery("select e from Emplyee e where e.id=?1");
//		query.setParameter(1,101);
//		query.getResultList().forEach(n->System.out.println(n));
		
		Query query=  em.createQuery("select e from Employee e where e.id= :myid");
		
		query.setParameter("myid",101);
		query.getResultList().forEach(n->System.out.println(n));
		
		
		
		
		
		
		
	
		
	}

}
