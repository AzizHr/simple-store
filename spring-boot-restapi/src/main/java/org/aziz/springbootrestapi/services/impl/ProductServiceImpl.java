package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ProductReq;
import org.aziz.springbootrestapi.dtos.response.ProductRes;
import org.aziz.springbootrestapi.repositories.ProductRepository;
import org.aziz.springbootrestapi.services.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductRes save(ProductReq product) {
        return null;
    }

    @Override
    public ProductRes update(ProductReq product) {
        return null;
    }

    @Override
    public ProductRes findById(UUID id) {
        return null;
    }

    @Override
    public List<ProductRes> findAll() {
        return List.of();
    }

    @Override
    public List<ProductRes> findByCategoryId(UUID categoryId) {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {

    }
}
