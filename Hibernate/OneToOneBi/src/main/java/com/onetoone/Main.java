package com.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
	EntityManager entitymanager	=Persistence.createEntityManagerFactory("vikas").createEntityManager();
	
	EntityTransaction  transaction  =entitymanager.getTransaction();
	
	Mobile mobile=new Mobile();
	mobile.setId(102);
	mobile.setName("iPhone");
	mobile.setPrice(50000.00);
	
	
	
	Battery battery=new Battery();
	battery.setId(205);
	battery.setHp(75000L);
	
	battery.setMobile(mobile);
	mobile.setBattery(battery);
	
	transaction.begin();
	entitymanager.persist(mobile);
	entitymanager.persist(battery);
	transaction.commit();
	
	

	}

}
