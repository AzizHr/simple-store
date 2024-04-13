package org.aziz.springbootrestapi.repositories;

import org.aziz.springbootrestapi.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MediaRepository extends JpaRepository<Media, UUID> {}
