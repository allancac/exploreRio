package com.example.explorerio.repository;

import com.example.explorerio.domain.model.Trail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrailRepository extends JpaRepository<Trail, Long> {
    List<Trail> findByTourPackageCode(
            @Param("tour-code") String tourPackageCode,
            Pageable pageable
            );

}
