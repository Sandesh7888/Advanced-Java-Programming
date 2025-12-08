package com.onetoone;

import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Find {

	public static void main(String[] args) {
		
		EntityManager entitymanager	=Persistence.createEntityManagerFactory("vikas").createEntityManager();
		
//		EntityTransaction  transaction  =entitymanager.getTransaction();
		
		Mobile mobile = entitymanager.find(Mobile.class, 101);
//		 Battery battery = entitymanager.find(Battery.class, 201);
		
		System.out.println(mobile);
//		System.out.println(battery);
		
		
		

	}

}
