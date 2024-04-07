package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.models.Category;
import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category save(Category category);
    Category findById(UUID id);
    List<Category> findAll();
    void deleteById(UUID id);
}
