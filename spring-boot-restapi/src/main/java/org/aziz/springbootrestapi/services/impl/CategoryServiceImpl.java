package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.Category;
import org.aziz.springbootrestapi.repositories.CategoryRepository;
import org.aziz.springbootrestapi.services.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) throws ItemNotFoundException {
        if(categoryRepository.findById(category.getId()).isPresent())
            return categoryRepository.save(category);
        throw new ItemNotFoundException("No category was found with ID "+category.getId());
    }

    @Override
    public Category findById(UUID id) throws ItemNotFoundException {
        if(categoryRepository.findById(id).isPresent())
            return categoryRepository.findById(id).get();
        throw new ItemNotFoundException("No category was found with ID of "+id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) throws ItemNotFoundException {
        if(categoryRepository.findById(id).isPresent())
            categoryRepository.deleteById(id);
        throw new ItemNotFoundException("No category was found with ID of "+id);
    }
}
