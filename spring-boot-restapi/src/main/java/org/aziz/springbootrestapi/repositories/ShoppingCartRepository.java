package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, UUID> {}
