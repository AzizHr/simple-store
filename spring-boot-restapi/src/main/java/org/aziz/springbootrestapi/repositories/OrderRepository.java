package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {}
