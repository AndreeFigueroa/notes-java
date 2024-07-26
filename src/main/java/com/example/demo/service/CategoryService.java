package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
    public Iterable<Category> getAll() {
        return categoryRepository.findAll();
    }
    public void updateById(Long id, Category category) {
        categoryRepository.save(category);
    }
    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }
}
