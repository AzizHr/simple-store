package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface VariantRepository extends JpaRepository<Variant, UUID> {}
