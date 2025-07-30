package org.example.demo6.service;

import org.example.demo6.entity.Product;
import org.example.demo6.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();

    public List<Product> getProducts() {

        return productRepository.getProducts();
    }

    public void addProduct(Product product) {

        productRepository.addProduct(product);
    }
}
