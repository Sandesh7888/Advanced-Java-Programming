package com.oneToMany;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
	EntityManager entitymanager = Persistence.createEntityManagerFactory("vikas").createEntityManager();
	
	EntityTransaction transcation = entitymanager.getTransaction();
	
	Bank bank = new Bank();
	bank.setId(101);
	bank.setName("ICICI");
	
	Accounts accounts = new Accounts();
	
	accounts.setId(201);
	accounts.setAccno(653879284);
	accounts.setBal(64358.90);
	
	Accounts accounts1 = new Accounts();
	
	accounts1.setId(202);
	accounts1.setAccno(65387922);
	accounts1.setBal(6478.45);
	
	ArrayList<Accounts> arr = new ArrayList<Accounts>();
	arr.add(accounts);
	arr.add(accounts1);
	
	bank.setAccounts(arr);
	
	transcation.begin();
	entitymanager.persist(bank);
	entitymanager.persist(accounts);
	entitymanager.persist(accounts1);
	transcation.commit();
	
	}

}