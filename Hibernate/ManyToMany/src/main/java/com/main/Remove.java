package com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Remove {
	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		Student student = entityManager.find(Student.class, 101);
		
		List<Subject> list= student.getSubject();
		
		
		
		transaction.begin();
		list.remove(0);
		transaction.commit();
		
		
		System.out.println(student);
		
		
		
	}

}
