package com.example.explorerio.repository;

import com.example.explorerio.domain.model.TourPackage;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = true, path = "packages", collectionResourceRel = "packages")
public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
    List<TourPackage> findByNameContainsIgnoreCase(@Param("name")String name);
    List<TourPackage> findByPriceLessThanEqual(@Param("price-less-than") Double price);

    @Override
    @RestResource(exported = false)
    void deleteAllInBatch(Iterable<TourPackage> entities);

    @Override
    @RestResource(exported = false)

    void deleteAllByIdInBatch(Iterable<String> strings);

    @Override
    @RestResource(exported = false)

    void deleteAllInBatch();

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends String> strings);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends TourPackage> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Override
    @RestResource(exported = true)
    void delete(TourPackage entity);

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> List<S> saveAllAndFlush(Iterable<S> entities);


    @Override
    @RestResource(exported = false)
    <S extends TourPackage> S saveAndFlush(S entity);

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> List<S> findAll(Example<S> example, Sort sort);

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> List<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    List<TourPackage> findAllById(Iterable<String> strings);

    @Override
    @RestResource(exported = false)
    long count();

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> Optional<S> findOne(Example<S> example);

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> long count(Example<S> example);
}
