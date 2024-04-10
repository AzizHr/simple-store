package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.OrderRequest;
import org.aziz.springbootrestapi.dtos.response.OrderResponse;
import org.aziz.springbootrestapi.repositories.OrderRepository;
import org.aziz.springbootrestapi.services.OrderService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public OrderResponse update(OrderRequest orderRequest) {
        return null;
    }
}
