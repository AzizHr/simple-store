package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Page<Product> findAllByCategoryId(UUID categoryId, Pageable pageable);
    Page<Product> findAllByNameLikeOrDescriptionLike(String name, String description, Pageable pageable);
    Page<Product> findAllByCategoryName(String categoryName, Pageable pageable);
    Page<Product> findAllByCategoryNameLike(String categoryName, Pageable pageable);
}
