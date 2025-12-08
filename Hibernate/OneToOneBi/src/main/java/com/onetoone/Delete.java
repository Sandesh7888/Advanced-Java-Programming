package com.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		EntityManager entitymanager	=Persistence.createEntityManagerFactory("vikas").createEntityManager();
		EntityTransaction  transaction  =entitymanager.getTransaction();
		
		Mobile mobile = entitymanager.find(Mobile.class, 101);
		mobile.setBattery(null);
		
		Battery battery =entitymanager.find(Battery.class,201);
		
		transaction.begin();
		entitymanager.remove(mobile);
		entitymanager.remove(battery);
		transaction.commit();

	}

}

