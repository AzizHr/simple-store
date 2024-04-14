package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.ProductRequest;
import org.aziz.springbootrestapi.dtos.response.ProductResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.exceptions.ListIsEmptyException;
import org.aziz.springbootrestapi.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {
    ProductResponse save(ProductRequest productRequest) throws ItemNotFoundException;
    ProductResponse update(ProductRequest productRequest) throws ItemNotFoundException;
    ProductResponse findById(UUID id) throws ItemNotFoundException;
    Page<ProductResponse> findAll(Pageable pageable) throws ListIsEmptyException;
    Page<Product> findAllByNameLike(String name, String description, Pageable pageable);
    Page<Product> filterByCategoryName(String categoryName, Pageable pageable);
    Page<Product> findAllByCategoryNameLike(String categoryName, Pageable pageable);
    Page<Product> filterByType(String type, Pageable pageable);
    Page<Product> findAllByTypeLike(String type, Pageable pageable);
    Page<ProductResponse> findAllByCategoryId(UUID categoryId, Pageable pageable) throws ListIsEmptyException;
    void deleteById(UUID id) throws ItemNotFoundException;
}
