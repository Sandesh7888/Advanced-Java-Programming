package com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Find {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		
		
		Bank bank = em.find(Bank.class,101);
		List<Account> list=bank.getAccounts();
		
		for(Account accounts :list) {
			System.out.println(accounts);
			
		}
		
		
		Account account = em.find(Account.class,201);
		Bank bank2 = account.getBank();
		String name=account.getName();
		System.out.println(bank2 + "\n"+ name );
	}

}
