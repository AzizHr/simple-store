package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ShoppingCartRequest;
import org.aziz.springbootrestapi.dtos.response.ShoppingCartResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.ShoppingCart;
import org.aziz.springbootrestapi.repositories.ShoppingCartRepository;
import org.aziz.springbootrestapi.services.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ModelMapper modelMapper;

    @Override
    public ShoppingCartResponse updateShoppingCart(ShoppingCartRequest shoppingCartRequest) throws ItemNotFoundException {
        if(shoppingCartRepository.findById(shoppingCartRequest.getId()).isPresent()) {
            ShoppingCart shoppingCart = modelMapper.map(shoppingCartRequest, ShoppingCart.class);
            return modelMapper.map(shoppingCartRepository.save(shoppingCart), ShoppingCartResponse.class);
        }
        throw new ItemNotFoundException("No shoppingCart was found with ID: "+shoppingCartRequest.getId());
    }
}
