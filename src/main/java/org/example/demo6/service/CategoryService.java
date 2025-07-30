package org.example.demo6.service;

import org.example.demo6.entity.Category;
import org.example.demo6.repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    private CategoryRepository categoryRepository = new CategoryRepository();

    public List<Category> getCategories() {

        return categoryRepository.getCategories();
    }

    public Category getCategoryById(Long categoryId) {

        return categoryRepository.getCategoryById(categoryId);
    }
}
