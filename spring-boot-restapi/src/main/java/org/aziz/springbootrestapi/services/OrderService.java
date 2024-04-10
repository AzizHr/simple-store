package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.OrderRequest;
import org.aziz.springbootrestapi.dtos.response.OrderResponse;

public interface OrderService {
    OrderResponse save(OrderRequest orderRequest);
    OrderResponse update(OrderRequest orderRequest);
}
