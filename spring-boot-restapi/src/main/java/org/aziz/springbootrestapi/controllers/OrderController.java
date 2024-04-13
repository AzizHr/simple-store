package org.aziz.springbootrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.OrderRequest;
import org.aziz.springbootrestapi.dtos.response.OrderResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> save(@RequestBody OrderRequest orderRequest) throws ItemNotFoundException {
        return ResponseEntity.ok(orderService.save(orderRequest));
    }

    @PutMapping()
    public ResponseEntity<OrderResponse> update(@RequestBody OrderRequest orderRequest) throws ItemNotFoundException {
        return ResponseEntity.ok(orderService.update(orderRequest));
    }
}
