package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID> {}
