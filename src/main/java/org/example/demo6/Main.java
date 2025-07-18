package org.example.demo6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.demo6.entity.Student;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager em = emf.createEntityManager();

        System.out.println("Done...");

        Student student = new Student(1004L, "Student 4", "Email 4", "Phone 4");

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        // Native query
        em.createNativeQuery("SELECT * FROM students", Student.class).getResultList().forEach(System.out::println);

        // JPQL
        em.createQuery("SELECT s FROM Student s", Student.class).getResultList().forEach(System.out::println);
    }
}
