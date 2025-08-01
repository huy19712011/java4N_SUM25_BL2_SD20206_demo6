package org.example.demo6.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.demo6.entity.Product;

import java.util.List;

public class ProductRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public List<Product> getProducts() {

        List<Product> products = em.createQuery("SELECT p from Product p", Product.class).getResultList();

        return products;
    }

    public void addProduct(Product product) {

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    public void deleteProduct(Long id) {

        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }

    public Product getProductById(Long id) {

        return em.find(Product.class, id);
    }

    public void updateProduct(Product product) {

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }
}
