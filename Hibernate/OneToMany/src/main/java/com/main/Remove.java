package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Remove {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Bank bank = em.find(Bank.class, 101);
		
		
//		Account account = em.find(Account.class, 202);
//		account.setBank(null);
		
		et.begin();
//		em.remove(account);
		em.remove(bank);
		et.commit();
		
		
		
		
		

	}

}
