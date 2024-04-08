package org.aziz.springbootrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.Category;
import org.aziz.springbootrestapi.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> category(@PathVariable UUID id) throws ItemNotFoundException {
        return ResponseEntity.ok(categoryService.findById(id));
    }

}
