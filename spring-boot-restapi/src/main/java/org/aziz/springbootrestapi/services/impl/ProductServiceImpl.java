package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.ProductReq;
import org.aziz.springbootrestapi.dtos.response.CategoryRes;
import org.aziz.springbootrestapi.dtos.response.ProductRes;
import org.aziz.springbootrestapi.dtos.response.VariantRes;
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
    public ProductRes save(ProductReq productReq) throws ItemNotFoundException {
        Product product = modelMapper.map(productReq, Product.class);
        List<Variant> variants = productReq.getVariants();
        if(categoryRepository.findById(productReq.getCategoryId()).isPresent()) {
            product.setCategory(categoryRepository.findById(productReq.getCategoryId()).get());
            Product savedProduct = productRepository.save(product);
            for(Variant variant : variants) {
                variant.setProduct(savedProduct);
            }
            List<Variant> savedVariants = variantRepository.saveAll(variants);
            ProductRes productRes = modelMapper.map(savedProduct, ProductRes.class);
            productRes.setVariants(savedVariants.stream()
                    .map(variant -> modelMapper.map(variant, VariantRes.class))
                    .collect(Collectors.toList()));
            return productRes;
        }
        throw new ItemNotFoundException("No category was found with ID: "+productReq.getCategoryId());
    }

    @Override
    public ProductRes update(ProductReq productReq) throws ItemNotFoundException {
        if(productRepository.findById(productReq.getId()).isPresent()) {
            Product product = modelMapper.map(productReq, Product.class);
            return modelMapper.map(productRepository.save(product), ProductRes.class);
        }
        throw new ItemNotFoundException("No product was found with ID "+productReq.getId());
    }

    @Override
    public ProductRes findById(UUID id) throws ItemNotFoundException {
        if(productRepository.findById(id).isPresent())
            return modelMapper.map(productRepository.findById(id).get(), ProductRes.class);
        throw new ItemNotFoundException("No product was found with ID "+id);
    }

    @Override
    public Page<ProductRes> findAll(Pageable pageable) throws ListIsEmptyException {
        Page<Product> productPage = productRepository.findAll(pageable);

        if(productPage.getContent().isEmpty())
            throw new ListIsEmptyException("No products found");
        return new PageImpl<>(
                productPage.getContent().stream()
                        .map(product -> modelMapper.map(product, ProductRes.class))
                        .collect(Collectors.toList()),
                productPage.getPageable(),
                productPage.getTotalElements()
        );
    }

    @Override
    public Page<ProductRes> findAllByCategoryId(UUID categoryId, Pageable pageable) throws ListIsEmptyException {
        Page<Product> productPage = productRepository.findAllByCategoryId(categoryId, pageable);

        if(productPage.getContent().isEmpty())
            throw new ListIsEmptyException("No products found");
        return new PageImpl<>(
                productPage.getContent().stream()
                        .map(product -> modelMapper.map(product, ProductRes.class))
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
