package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ShoppingCartProductRequest;
import org.aziz.springbootrestapi.dtos.response.ShoppingCartProductResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.ShoppingCartProduct;
import org.aziz.springbootrestapi.repositories.ProductRepository;
import org.aziz.springbootrestapi.repositories.ShoppingCartProductRepository;
import org.aziz.springbootrestapi.repositories.ShoppingCartRepository;
import org.aziz.springbootrestapi.services.ShoppingCartProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartProductServiceImpl implements ShoppingCartProductService {

    private final ShoppingCartProductRepository shoppingCartProductRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ShoppingCartProductResponse addProductToShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest) throws ItemNotFoundException {
        ShoppingCartProduct shoppingCartProduct = modelMapper.map(shoppingCartProductRequest, ShoppingCartProduct.class);

        shoppingCartProduct.setShoppingCart(shoppingCartRepository.findById(
                shoppingCartProductRequest.getShoppingCartId()
        ).orElseThrow(() -> new ItemNotFoundException("ShoppingCart was not found with ID: "+ shoppingCartProductRequest.getShoppingCartId())));

        shoppingCartProduct.setProduct(productRepository.findById(
                shoppingCartProductRequest.getProductId()
        ).orElseThrow(() -> new ItemNotFoundException("Product was not found with ID: "+ shoppingCartProductRequest.getProductId())));

        return modelMapper.map(shoppingCartProductRepository.save(shoppingCartProduct), ShoppingCartProductResponse.class);
    }

    @Override
    public void removeProductFromShoppingCart(ShoppingCartProductRequest shoppingCartProductRequest) {
        shoppingCartProductRepository.delete(modelMapper.map(shoppingCartProductRequest, ShoppingCartProduct.class));
    }
}
