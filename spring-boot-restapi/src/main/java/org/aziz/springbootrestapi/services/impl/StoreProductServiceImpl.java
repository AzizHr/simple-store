package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.ShoppingCartProduct;
import org.aziz.springbootrestapi.models.StoreProduct;
import org.aziz.springbootrestapi.repositories.ProductRepository;
import org.aziz.springbootrestapi.repositories.StoreProductRepository;
import org.aziz.springbootrestapi.repositories.StoreRepository;
import org.aziz.springbootrestapi.services.StoreProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreProductServiceImpl implements StoreProductService {

    private final StoreProductRepository storeProductRepository;
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public String addProductToStore(StoreProduct storeProduct) {
        StoreProduct storeProduct1 = modelMapper.map(shoppingCartProductRequest, ShoppingCartProduct.class);

        shoppingCartProduct.setShoppingCart(shoppingCartRepository.findById(
                shoppingCartProductRequest.getShoppingCartId()
        ).orElseThrow(() -> new ItemNotFoundException("ShoppingCart was not found with ID: "+ shoppingCartProductRequest.getShoppingCartId())));

        shoppingCartProduct.setProduct(productRepository.findById(
                shoppingCartProductRequest.getProductId()
        ).orElseThrow(() -> new ItemNotFoundException("Product was not found with ID: "+ shoppingCartProductRequest.getProductId())));

        return modelMapper.map(shoppingCartProductRepository.save(shoppingCartProduct), String.class);
    }

    @Override
    public String removeProductFromStore(StoreProduct storeProduct) {
        return "";
    }
}
