package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {}
