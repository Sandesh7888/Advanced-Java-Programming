package com.oneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteEngine {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("vikas").createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Car car = entityManager.find(Car.class, 101);

        if(car != null && car.getEngine() != null) {
            transaction.begin();
            Engine engine = car.getEngine(); 
            car.setEngine(null);
            entityManager.remove(engine); 
            transaction.commit();
        } else {
            System.out.println("Car or engine not found");
        }
    }
}
