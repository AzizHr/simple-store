package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.ShoppingCartRequest;
import org.aziz.springbootrestapi.dtos.response.ShoppingCartResponse;

public interface ShoppingCartService {
    ShoppingCartResponse updateShoppingCart(ShoppingCartRequest shoppingCartRequest);
}
