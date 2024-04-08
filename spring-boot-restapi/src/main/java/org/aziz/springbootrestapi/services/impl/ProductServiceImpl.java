package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ProductReq;
import org.aziz.springbootrestapi.dtos.response.ProductRes;
import org.aziz.springbootrestapi.models.Product;
import org.aziz.springbootrestapi.repositories.ProductRepository;
import org.aziz.springbootrestapi.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductRes save(ProductReq productReq) {
        Product product = modelMapper.map(productReq, Product.class);
        return modelMapper.map(productRepository.save(product), ProductRes.class);
    }

    @Override
    public ProductRes update(ProductReq productReq) {
        return null;
    }

    @Override
    public ProductRes findById(UUID id) {
        return null;
    }

    @Override
    public Page<ProductRes> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductRes> findByCategoryId(UUID categoryId, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
