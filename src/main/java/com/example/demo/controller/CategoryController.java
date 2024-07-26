package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Note;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryService.getById(id);
        return category.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Category> createCategory(@RequestBody Category CategoryData) {
        categoryService.save(CategoryData);
        return ResponseEntity.ok(categoryService.save(CategoryData));
    }
    @PostMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category CategoryData) {
        categoryService.save(CategoryData);
        return ResponseEntity.ok(categoryService.save(CategoryData));
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        Iterable<Category> note = categoryService.getAll();
        return ResponseEntity.ok(note);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
