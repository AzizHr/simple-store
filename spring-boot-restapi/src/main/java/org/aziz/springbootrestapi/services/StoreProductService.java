package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.StoreProductRequest;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;

public interface StoreProductService {
    String addProductToStore(StoreProductRequest storeProductRequest) throws ItemNotFoundException;
    String removeProductFromStore(StoreProductRequest storeProductRequest);
}
