package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {}
