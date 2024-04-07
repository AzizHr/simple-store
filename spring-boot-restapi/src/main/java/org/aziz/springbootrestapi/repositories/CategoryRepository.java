package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {}
