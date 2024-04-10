package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ShoppingCartProductRequest;
import org.aziz.springbootrestapi.repositories.ShoppingCartProductRepository;
import org.aziz.springbootrestapi.services.ShoppingCartProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartProductServiceImpl implements ShoppingCartProductService {

    private final ShoppingCartProductRepository shoppingCartProductRepository;

    @Override
    public String addProductToShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest) {
        return "";
    }

    @Override
    public String removeProductFromShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest) {
        return "";
    }
}
