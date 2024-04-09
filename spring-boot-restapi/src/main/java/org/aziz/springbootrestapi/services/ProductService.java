package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.ProductRequest;
import org.aziz.springbootrestapi.dtos.response.ProductRes;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.exceptions.ListIsEmptyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {
    ProductRes save(ProductRequest productRequest) throws ItemNotFoundException;
    ProductRes update(ProductRequest productRequest) throws ItemNotFoundException;
    ProductRes findById(UUID id) throws ItemNotFoundException;
    Page<ProductRes> findAll(Pageable pageable) throws ListIsEmptyException;
    Page<ProductRes> findAllByCategoryId(UUID categoryId, Pageable pageable) throws ListIsEmptyException;
    void deleteById(UUID id) throws ItemNotFoundException;
}
