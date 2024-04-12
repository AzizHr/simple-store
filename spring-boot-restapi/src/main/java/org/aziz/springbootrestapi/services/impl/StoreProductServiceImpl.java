package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.StoreProductRequest;
import org.aziz.springbootrestapi.dtos.response.StoreProductResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
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
    public StoreProductResponse addProductToStore(StoreProductRequest storeProductRequest) throws ItemNotFoundException {
        StoreProduct storeProduct = modelMapper.map(storeProductRequest, StoreProduct.class);

        storeProduct.setStore(storeRepository.findById(
                storeProductRequest.getStoreId()
        ).orElseThrow(() -> new ItemNotFoundException("Store was not found with ID: "+ storeProductRequest.getStoreId())));

        storeProduct.setProduct(productRepository.findById(
                storeProductRequest.getProductId()
        ).orElseThrow(() -> new ItemNotFoundException("Product was not found with ID: "+ storeProductRequest.getProductId())));

        return modelMapper.map(storeProductRepository.save(storeProduct), StoreProductResponse.class);
    }

    @Override
    public void removeProductFromStore(StoreProductRequest storeProductRequest) {
        storeProductRepository.delete(modelMapper.map(storeProductRequest, StoreProduct.class));
        return "";
    }
}
