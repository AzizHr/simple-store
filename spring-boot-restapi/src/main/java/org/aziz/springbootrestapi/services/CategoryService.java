package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.response.CategoryResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.exceptions.ListIsEmptyException;
import org.aziz.springbootrestapi.models.Category;
import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category save(Category category);
    Category update(Category category) throws ItemNotFoundException;
    Category findById(UUID id) throws ItemNotFoundException;
    List<CategoryResponse> findAll() throws ListIsEmptyException;
    void deleteById(UUID id) throws ItemNotFoundException;
}
