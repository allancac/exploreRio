package com.example.explorerio.repository;

import com.example.explorerio.domain.model.Trail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailRepository extends JpaRepository<Trail, Long> {
}
