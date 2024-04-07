package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.ProductReq;
import org.aziz.springbootrestapi.dtos.response.ProductRes;
import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductRes save(ProductReq product);
    ProductRes update(ProductReq product);
    ProductRes findById(UUID id);
    List<ProductRes> findAll();
    List<ProductRes> findByCategoryId(UUID categoryId);
    void deleteById(UUID id);
}
