package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.Category;
import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category save(Category category);
    Category findById(UUID id) throws ItemNotFoundException;
    List<Category> findAll();
    void deleteById(UUID id) throws ItemNotFoundException;
}
