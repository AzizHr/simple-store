package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.ShoppingCartProductRequest;

public interface ShoppingCartProductService {
    String addProductToShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest);
    String removeProductFromShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest);
    String updateQuantity(ShoppingCartProductRequest shoppingCartProductRequest);
}
