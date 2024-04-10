package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.OrderRequest;
import org.aziz.springbootrestapi.dtos.response.OrderResponse;
import org.aziz.springbootrestapi.enums.OrderStatus;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.Order;
import org.aziz.springbootrestapi.repositories.OrderRepository;
import org.aziz.springbootrestapi.repositories.ShoppingCartRepository;
import org.aziz.springbootrestapi.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrderResponse save(OrderRequest orderRequest) throws ItemNotFoundException {
        Order order = modelMapper.map(orderRequest, Order.class);
        order.setShoppingCart(shoppingCartRepository.findById(
                orderRequest.getShoppingCartId()
        ).orElseThrow(()
                -> new ItemNotFoundException(
                        "No shoppingCart was found with ID: "+orderRequest.getShoppingCartId()
        )));

        order.setOrderDate(LocalDate.now());
        order.setDeliveryDate(LocalDate.now().plusDays(10));
        order.setStatus(OrderStatus.PENDING);

        return modelMapper.map(orderRepository.save(order), OrderResponse.class);
    }

    @Override
    public OrderResponse update(OrderRequest orderRequest) {
        return null;
    }
}
