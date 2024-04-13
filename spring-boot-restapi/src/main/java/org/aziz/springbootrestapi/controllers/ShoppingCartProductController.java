package org.aziz.springbootrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ShoppingCartProductRequest;
import org.aziz.springbootrestapi.dtos.response.ShoppingCartProductResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.services.ShoppingCartProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shopping-cart")
public class ShoppingCartProductController {
    private final ShoppingCartProductService shoppingCartProductService;

    @PostMapping("/add-product")
    public ResponseEntity<ShoppingCartProductResponse> addProduct(@RequestBody ShoppingCartProductRequest shoppingCartProductRequest) throws ItemNotFoundException {
        return ResponseEntity.ok(shoppingCartProductService.addProductToShoppingCart(shoppingCartProductRequest));
    }
}
