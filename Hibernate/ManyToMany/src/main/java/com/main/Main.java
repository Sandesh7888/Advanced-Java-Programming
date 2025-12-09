package com.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		Student student1 =new Student();
		student1.setId(101);
		student1.setName("miller");
		student1.setMobile(9865472552L);
		
		Student student2 =new Student();
		student2.setId(102);
		student2.setName("Allen");
		student2.setMobile(9865472552L);
		
		Subject subject1=new Subject();
		subject1.setId(201);
		subject1.setName("java");
		subject1.setAuthor("James Gosling");
		
		Subject subject2=new Subject();
		subject2.setId(202);
		subject2.setName("SQL");
		subject2.setAuthor("	Donald D. Chamberlin & Raymond F. Boyce");
		
		List<Subject> list1= new ArrayList<Subject>();
		list1.add(subject1);
		list1.add(subject2);
		
		List<Student> list2= new ArrayList<Student>();
		list2.add(student2);
		list2.add(student1);
		
		student1.setSubject(list1);
		student2.setSubject(list1);
		
		subject1.setStudent(list2);
		subject2.setStudent(list2);
		
		transaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(subject1);
		entityManager.persist(subject2);
		transaction.commit();
		
		
		
		
		
		
	}

}
