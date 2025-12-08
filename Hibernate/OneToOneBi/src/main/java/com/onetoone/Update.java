package com.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {

	public static void main(String[] args) {
		EntityManager entitymanager	=Persistence.createEntityManagerFactory("vikas").createEntityManager();
		EntityTransaction  transaction  =entitymanager.getTransaction();
		
		Mobile mobile = entitymanager.find(Mobile.class, 101);
		
		Battery battery1 =entitymanager.find(Battery.class,202);
		
		transaction.begin();
		
		mobile.setBattery(battery1);
//		entitymanager.merge()
		transaction.commit();


	}

}
