package com.example.explorerio.devtools.seeder;

import com.example.explorerio.application.dto.TrailRequestDTO;
import com.example.explorerio.application.service.TourPackageService;
import com.example.explorerio.application.service.TrailService;

import com.example.explorerio.domain.model.TourPackage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Profile("dev")
@Component
public class DatabaseSeeder {

    private final TrailService trailService;
    private final TourPackageService tourPackageService;

    @Autowired
    public DatabaseSeeder(TrailService trailService, TourPackageService tourPackageService) {
        this.trailService = trailService;
        this.tourPackageService = tourPackageService;
    }

    public void readTrailsJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<TrailRequestDTO> trails = mapper.readValue(
                new File(filePath),
                new TypeReference<List<TrailRequestDTO>>() {
                }
        );

        for (TrailRequestDTO trail : trails) {
            trailService.createTrail(trail.name,
                    trail.description,
                    trail.keywords,
                    trail.distance,
                    trail.time,
                    trail.difficulty,
                    trail.region,
                    trail.tourPackageCode);
        }
    }

    public void readTourPackagesJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<TourPackage> tours = mapper.readValue(
                new File(filePath),
                new TypeReference<List<TourPackage>>() {
                }
        );
        tours.forEach( tourPck->{
            tourPackageService.createTourPackage(
                    tourPck.getCode(),
                    tourPck.getName(),
                    tourPck.getPrice()

            );
        });

    }
}
