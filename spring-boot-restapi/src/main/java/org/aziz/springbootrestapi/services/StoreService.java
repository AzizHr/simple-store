package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.StoreRequest;

public interface StoreService {
    String update(StoreRequest storeRequest);
}
