package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.OrderRequest;
import org.aziz.springbootrestapi.dtos.response.OrderResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;

public interface OrderService {
    OrderResponse save(OrderRequest orderRequest) throws ItemNotFoundException;
    OrderResponse update(OrderRequest orderRequest);
}
