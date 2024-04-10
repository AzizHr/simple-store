package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.models.StoreProduct;
import org.aziz.springbootrestapi.repositories.StoreProductRepository;
import org.aziz.springbootrestapi.services.StoreProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreProductServiceImpl implements StoreProductService {

    private final StoreProductRepository storeProductRepository;

    @Override
    public String addProductToStore(StoreProduct storeProduct) {
        return "";
    }

    @Override
    public String removeProductFromStore(StoreProduct storeProduct) {
        return "";
    }
}
