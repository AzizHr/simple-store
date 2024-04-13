package org.aziz.springbootrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.StoreRequest;
import org.aziz.springbootrestapi.dtos.response.StoreResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.services.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PutMapping()
    public ResponseEntity<StoreResponse> update(@RequestBody StoreRequest storeRequest) throws ItemNotFoundException {
        return ResponseEntity.ok(storeService.update(storeRequest));
    }
}
