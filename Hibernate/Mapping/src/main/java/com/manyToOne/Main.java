package com.manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManager entityManager = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		Product product =new Product();
		product.setId(101);
		product.setName("Laptop");
		product.setPrice(35550.0);
		
		Review r1=new Review();
		r1.setId(201);
		r1.setHeading("good review");
		r1.setMsg("Product is good");
		r1.setProduct(product);
		
		Review r2=new Review();
		r2.setId(202);
		r2.setHeading("bad review");
		r2.setMsg("Product is bad");
		r2.setProduct(product);	
		
		transaction.begin();
		entityManager.persist(product);
		entityManager.persist(r2);
		entityManager.persist(r1);
		transaction.commit();
	}

}
