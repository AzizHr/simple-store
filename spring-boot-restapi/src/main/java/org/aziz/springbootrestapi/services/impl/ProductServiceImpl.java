package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ProductRequest;
import org.aziz.springbootrestapi.dtos.response.ProductResponse;
import org.aziz.springbootrestapi.dtos.response.VariantResponse;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.exceptions.ListIsEmptyException;
import org.aziz.springbootrestapi.models.Product;
import org.aziz.springbootrestapi.models.Variant;
import org.aziz.springbootrestapi.repositories.CategoryRepository;
import org.aziz.springbootrestapi.repositories.ProductRepository;
import org.aziz.springbootrestapi.repositories.VariantRepository;
import org.aziz.springbootrestapi.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final VariantRepository variantRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponse save(ProductRequest productRequest) throws ItemNotFoundException {
        Product product = modelMapper.map(productRequest, Product.class);
        List<Variant> variants = productRequest.getVariants();
        if(categoryRepository.findById(productRequest.getCategoryId()).isPresent()) {
            product.setCategory(categoryRepository.findById(productRequest.getCategoryId()).get());
            Product savedProduct = productRepository.save(product);
            for(Variant variant : variants) {
                variant.setProduct(savedProduct);
            }
            List<Variant> savedVariants = variantRepository.saveAll(variants);
            ProductResponse productResponse = modelMapper.map(savedProduct, ProductResponse.class);
            productResponse.setVariants(savedVariants.stream()
                    .map(variant -> modelMapper.map(variant, VariantResponse.class))
                    .collect(Collectors.toList()));
            return productResponse;
        }
        throw new ItemNotFoundException("No category was found with ID: "+ productRequest.getCategoryId());
    }

    @Override
    public ProductResponse update(ProductRequest productRequest) throws ItemNotFoundException {
        if(productRepository.findById(productRequest.getId()).isPresent()) {
            Product product = modelMapper.map(productRequest, Product.class);
            return modelMapper.map(productRepository.save(product), ProductResponse.class);
        }
        throw new ItemNotFoundException("No product was found with ID "+ productRequest.getId());
    }

    @Override
    public ProductResponse findById(UUID id) throws ItemNotFoundException {
        if(productRepository.findById(id).isPresent())
            return modelMapper.map(productRepository.findById(id).get(), ProductResponse.class);
        throw new ItemNotFoundException("No product was found with ID "+id);
    }

    @Override
    public Page<ProductResponse> findAll(Pageable pageable) throws ListIsEmptyException {
        Page<Product> productPage = productRepository.findAll(pageable);

        if(productPage.getContent().isEmpty())
            throw new ListIsEmptyException("No products found");
        return new PageImpl<>(
                productPage.getContent().stream()
                        .map(product -> modelMapper.map(product, ProductResponse.class))
                        .collect(Collectors.toList()),
                productPage.getPageable(),
                productPage.getTotalElements()
        );
    }

    @Override
    public Page<ProductResponse> findAllByCategoryId(UUID categoryId, Pageable pageable) throws ListIsEmptyException {
        Page<Product> productPage = productRepository.findAllByCategoryId(categoryId, pageable);

        if(productPage.getContent().isEmpty())
            throw new ListIsEmptyException("No products found");
        return new PageImpl<>(
                productPage.getContent().stream()
                        .map(product -> modelMapper.map(product, ProductResponse.class))
                        .collect(Collectors.toList()),
                productPage.getPageable(),
                productPage.getTotalElements()
        );
    }

    @Override
    public void deleteById(UUID id) throws ItemNotFoundException {
        if(productRepository.findById(id).isPresent())
            productRepository.deleteById(id);
        throw new ItemNotFoundException("No product was found with ID "+id);
    }
}
