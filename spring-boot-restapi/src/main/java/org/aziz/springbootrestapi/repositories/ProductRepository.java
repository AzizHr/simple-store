package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {}
