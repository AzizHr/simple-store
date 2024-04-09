package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StoreProductRepository extends JpaRepository<StoreProduct, UUID> {}
