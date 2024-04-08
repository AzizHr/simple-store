package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ProductReq;
import org.aziz.springbootrestapi.dtos.response.ProductRes;
import org.aziz.springbootrestapi.models.Product;
import org.aziz.springbootrestapi.repositories.ProductRepository;
import org.aziz.springbootrestapi.services.ProductService;
import org.modelmapper.ModelMapper;
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
}
