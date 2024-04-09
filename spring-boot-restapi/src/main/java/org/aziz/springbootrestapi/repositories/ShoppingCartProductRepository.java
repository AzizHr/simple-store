package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, UUID> {}
