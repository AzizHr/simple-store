package org.aziz.springbootrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ProductReq;
import org.aziz.springbootrestapi.dtos.response.ProductRes;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.Category;
import org.aziz.springbootrestapi.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable UUID id) throws ItemNotFoundException {
        productService.deleteById(id);
        return ResponseEntity.ok("Product with ID: " + id + " deleted successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductRes> product(@PathVariable UUID id) throws ItemNotFoundException {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductRes>> products(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Page<ProductRes>> products(@PathVariable UUID categoryId, Pageable pageable) {
        return ResponseEntity.ok(productService.findByCategoryId(categoryId, pageable));
    }
}
