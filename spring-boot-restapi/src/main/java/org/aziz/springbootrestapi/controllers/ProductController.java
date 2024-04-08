package org.aziz.springbootrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ProductReq;
import org.aziz.springbootrestapi.dtos.response.ProductRes;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.Category;
import org.aziz.springbootrestapi.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductRes> save(@RequestBody ProductReq productReq) {
        return ResponseEntity.ok(productService.save(productReq));
    }

    @PutMapping
    public ResponseEntity<ProductRes> update(@RequestBody ProductReq productReq) throws ItemNotFoundException {
        return ResponseEntity.ok(productService.update(productReq));
    }
}
