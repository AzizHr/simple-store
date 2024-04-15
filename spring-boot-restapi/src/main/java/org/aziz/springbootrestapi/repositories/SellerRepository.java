package org.aziz.springbootrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {}
