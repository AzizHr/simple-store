package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.models.StoreProduct;

public interface StoreProductService {
    String addProductToStore(StoreProduct storeProduct);
    String removeProductFromStore(StoreProduct storeProduct);
}
