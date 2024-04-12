package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {}
