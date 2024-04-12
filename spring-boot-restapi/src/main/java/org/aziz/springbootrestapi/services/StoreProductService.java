package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.StoreProductRequest;
import org.aziz.springbootrestapi.dtos.response.StoreProductResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;

public interface StoreProductService {
    StoreProductResponse addProductToStore(StoreProductRequest storeProductRequest) throws ItemNotFoundException;
    void removeProductFromStore(StoreProductRequest storeProductRequest) throws ItemNotFoundException;
}
