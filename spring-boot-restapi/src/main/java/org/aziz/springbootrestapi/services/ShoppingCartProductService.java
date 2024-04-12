package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.ShoppingCartProductRequest;
import org.aziz.springbootrestapi.dtos.response.ShoppingCartProductResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;

public interface ShoppingCartProductService {
    ShoppingCartProductResponse addProductToShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest) throws ItemNotFoundException;
    void removeProductFromShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest) throws ItemNotFoundException;
}
