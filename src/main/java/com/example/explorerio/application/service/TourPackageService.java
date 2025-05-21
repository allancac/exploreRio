package com.example.explorerio.application.service;

import com.example.explorerio.domain.model.TourPackage;
import com.example.explorerio.repository.TourPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourPackageService {
    private final TourPackageRepository tourPackageRepository;

    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage (String code, String name, Double price){
        return this.tourPackageRepository
                .findById(code)
                .orElse(this.tourPackageRepository.save(new TourPackage(code, name, price)));
    }

    public List<TourPackage> getAllTourPackages(){
        return this.tourPackageRepository.findAll();
    }

    public Optional<TourPackage> getTourPackageByCode(String code){
        return this.tourPackageRepository.findById(code);
    }

    //TODO: Create update method

    public void deleteTourPackage(String code){
        //TODO: Throw exception if the Tour Package does not exist.
        tourPackageRepository.deleteById(code);
    }

}
