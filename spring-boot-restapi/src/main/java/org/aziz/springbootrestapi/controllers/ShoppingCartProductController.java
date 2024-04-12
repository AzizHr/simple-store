package org.aziz.springbootrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.services.ShoppingCartProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shopping-cart")
public class ShoppingCartProductController {
    private final ShoppingCartProductService shoppingCartProductService;
}
