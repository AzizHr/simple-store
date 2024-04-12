package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.StoreRequest;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;

public interface StoreService {
    String update(StoreRequest storeRequest) throws ItemNotFoundException;
}
