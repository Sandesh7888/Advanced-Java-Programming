package com.oneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Display {

	public static void main(String[] args) {
		
		
		EntityManager entitymanager = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		
		EntityTransaction transction = entitymanager.getTransaction();
		
		Bank bank = entitymanager.find(Bank.class, 101);
		
		if(bank !=null) {
			System.out.println(bank);
			bank.getAccounts().forEach(System.out::println);
		}
		
		
	

	}

}