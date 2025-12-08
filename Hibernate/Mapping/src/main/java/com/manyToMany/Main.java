package com.manyToMany;

import java.util.ArrayList;
import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("vikas").createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Objects
        Student student = new Student();
        student.setName("Sandesh");

        Subject subject1 = new Subject();
        subject1.setSubjectName("Java");

        Subject subject2 = new Subject();
        subject2.setSubjectName("SQL");

        // Add subjects into list
        ArrayList<Subject> list = new ArrayList<>();
        list.add(subject1);
        list.add(subject2);

        student.setSubjects(list);

        et.begin();
        em.persist(subject1);
        em.persist(subject2);
        em.persist(student);
        et.commit();

        System.out.println("Data saved successfully!");
    }
}
