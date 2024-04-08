package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.ProductReq;
import org.aziz.springbootrestapi.dtos.response.ProductRes;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductRes save(ProductReq productReq);
    ProductRes update(ProductReq productReq) throws ItemNotFoundException;
    ProductRes findById(UUID id) throws ItemNotFoundException;
    Page<ProductRes> findAll(Pageable pageable);
    Page<ProductRes> findByCategoryId(UUID categoryId, Pageable pageable);
    void deleteById(UUID id);
}
