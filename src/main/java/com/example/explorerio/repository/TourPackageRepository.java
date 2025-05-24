package com.example.explorerio.repository;

import com.example.explorerio.domain.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
    List<TourPackage> findByNameContainsIgnoreCase(@Param("name")String name);
    List<TourPackage> findByPriceLessThanEqual(@Param("price-less-than") Double price);
}
