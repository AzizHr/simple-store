package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.ShoppingCartProductRequest;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;

public interface ShoppingCartProductService {
    String addProductToShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest) throws ItemNotFoundException;
    String removeProductFromShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest);
}
