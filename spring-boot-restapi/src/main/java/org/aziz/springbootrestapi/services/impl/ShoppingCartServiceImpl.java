package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ShoppingCartRequest;
import org.aziz.springbootrestapi.dtos.response.ShoppingCartResponse;
import org.aziz.springbootrestapi.repositories.ShoppingCartRepository;
import org.aziz.springbootrestapi.services.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCartResponse updateShoppingCart(ShoppingCartRequest shoppingCartRequest) {
        return null;
    }
}
