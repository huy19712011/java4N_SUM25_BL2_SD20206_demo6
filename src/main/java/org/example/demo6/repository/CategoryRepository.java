package org.example.demo6.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.demo6.entity.Category;

import java.util.List;

public class CategoryRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public List<Category> getCategories() {

        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    public Category getCategoryById(Long categoryId) {

        return em.find(Category.class, categoryId);
    }
}
