package com.qsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MaxOfsal {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		EntityTransaction et = em.getTransaction();
	
        Query query = em.createQuery("SELECT e.salary FROM Employee e ORDER BY e.salary DESC");
        
        query.setFirstResult(2);  
        query.setMaxResults(1);

        Object thirdMaxSalary = query.getSingleResult();
        System.out.println("Third Highest Salary: " + thirdMaxSalary);
   
	}
}
