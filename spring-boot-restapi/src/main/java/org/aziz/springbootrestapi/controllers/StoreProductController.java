package org.aziz.springbootrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.StoreProductRequest;
import org.aziz.springbootrestapi.dtos.response.StoreProductResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.services.StoreProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreProductController {
    private final StoreProductService storeProductService;

    @PostMapping("/add-product")
    public ResponseEntity<StoreProductResponse> addProduct(@RequestBody StoreProductRequest storeProductRequest) throws ItemNotFoundException {
        return ResponseEntity.ok(storeProductService.addProductToStore(storeProductRequest));
    }
}
