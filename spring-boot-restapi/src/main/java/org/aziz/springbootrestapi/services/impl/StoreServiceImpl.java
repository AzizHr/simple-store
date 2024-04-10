package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.StoreRequest;
import org.aziz.springbootrestapi.repositories.StoreRepository;
import org.aziz.springbootrestapi.services.StoreService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public String update(StoreRequest storeRequest) {
        return "";
    }
}
