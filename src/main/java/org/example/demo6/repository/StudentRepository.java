package org.example.demo6.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.demo6.entity.Student;

import java.util.List;

public class StudentRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public List<Student> getStudents() {

        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public void addStudent(Student student) {

        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();
    }

    public void deleteStudent(Long id) {

        em.getTransaction().begin();

        em.remove(em.find(Student.class, id));

        em.getTransaction().commit();
    }

    public Student getStudentById(Long id) {

        return em.find(Student.class, id);
    }

    public void updateStudent(Student student) {

        em.getTransaction().begin();

        em.merge(student);

        em.getTransaction().commit();
    }
}
