package com.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bank bank = new Bank();
		bank.setId(101);
		bank.setName("ICICI");

		Account account = new Account();
		account.setId(201);
		account.setBal(500.3);
		account.setName("Scott");
		account.setAccno(123456789);
		account.setBank(bank);

		Account account1 = new Account();
		account1.setId(202);
		account1.setBal(700.3);
		account1.setName("Smith");
		account1.setAccno(54621321);
		account1.setBank(bank);

		List<Account> list = new ArrayList<>();
		list.add(account);
		list.add(account1);
		bank.setAccounts(list);   

		et.begin();
		em.persist(bank);
		em.persist(account);
		em.persist(account1);
		et.commit();


	}

}
