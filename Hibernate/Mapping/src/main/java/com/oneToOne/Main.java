package com.oneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
		EntityManager entityManager = Persistence.createEntityManagerFactory("vikas").createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		Car car = new Car();
		car.setId(102);
		car.setName("Maruti");
		car.setPrice(10000000);
		
		Engine engine = new Engine();
		engine.setId(202);
		engine.setHp(2600);
		
		car.setEngine(engine);
		
		transaction.begin();
		entityManager.persist(car);
		entityManager.persist(engine);
		transaction.commit();
		
	}
}