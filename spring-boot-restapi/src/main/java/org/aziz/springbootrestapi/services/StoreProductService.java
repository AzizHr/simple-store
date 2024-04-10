package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.StoreProductRequest;

public interface StoreProductService {
    String addProductToStore(StoreProductRequest storeProductRequest);
    String removeProductFromStore(StoreProductRequest storeProductRequest);
}
