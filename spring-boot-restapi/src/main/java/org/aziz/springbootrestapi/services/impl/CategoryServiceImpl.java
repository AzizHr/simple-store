package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.models.Category;
import org.aziz.springbootrestapi.repositories.CategoryRepository;
import org.aziz.springbootrestapi.services.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public Category findById(UUID id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {

    }
}
