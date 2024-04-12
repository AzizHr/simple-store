package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.StoreRequest;
import org.aziz.springbootrestapi.dtos.response.StoreResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;

public interface StoreService {
    StoreResponse update(StoreRequest storeRequest) throws ItemNotFoundException;
}
