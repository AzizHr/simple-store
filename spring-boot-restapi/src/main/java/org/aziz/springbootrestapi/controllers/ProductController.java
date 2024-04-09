package org.aziz.springbootrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ProductRequest;
import org.aziz.springbootrestapi.dtos.response.ProductResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.exceptions.ListIsEmptyException;
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
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest productRequest) throws ItemNotFoundException {
        return ResponseEntity.ok(productService.save(productRequest));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> update(@RequestBody ProductRequest productRequest) throws ItemNotFoundException {
        return ResponseEntity.ok(productService.update(productRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable UUID id) throws ItemNotFoundException {
        productService.deleteById(id);
        return ResponseEntity.ok("Product with ID: " + id + " deleted successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> product(@PathVariable UUID id) throws ItemNotFoundException {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> products(Pageable pageable) throws ListIsEmptyException {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Page<ProductResponse>> products(@PathVariable UUID categoryId, Pageable pageable) throws ListIsEmptyException {
        return ResponseEntity.ok(productService.findAllByCategoryId(categoryId, pageable));
    }
}
