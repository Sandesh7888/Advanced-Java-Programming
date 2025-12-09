package com.main;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Find {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("vikas").createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Student student = entityManager.find(Student.class, 101);

        if(student != null) {
            List<Subject> list = student.getSubject();
//            System.out.println(student);

            for(Subject sub : list) {
                System.out.println(sub);
            }
        } else {
            System.out.println("Student Not Found");
        }

        transaction.commit();
    }
}

