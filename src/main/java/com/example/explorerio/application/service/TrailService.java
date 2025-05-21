package com.example.explorerio.application.service;

import com.example.explorerio.domain.model.Difficulty;
import com.example.explorerio.domain.model.Region;
import com.example.explorerio.domain.model.TourPackage;
import com.example.explorerio.domain.model.Trail;
import com.example.explorerio.repository.TourPackageRepository;
import com.example.explorerio.repository.TrailRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrailService {

    private final TrailRepository trailRepository;
    private final TourPackageRepository tourPackageRepository;

    @Autowired
    public TrailService(TrailRepository trailRepository, TourPackageRepository tourPackageRepository) {
        this.trailRepository = trailRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Creates a trail with the given parameters.
     *
     * @param name             The name of the trail.
     * @param description      A description of the trail.
     * @param keywords         Keywords related to the trail.
     * @param distance         An integer value representing the distance of the trail in kilometers.
     * @param time             A double value representing the estimated walking time in hours.
     * @param difficultyString The difficulty level of the trail.
     * @param regionString     The region where the trail is located.
     * @param tourPackageCode  A string code that identifies the tour package this trail is part of.
     * @return The created Trail object.
     */
    public Trail createTrail(String name, String description, String keywords, int distance, double time,
                             String difficultyString, String regionString, String tourPackageCode) {

        Difficulty difficulty = Difficulty.findByLabel(difficultyString.toLowerCase());
        Region region = Region.findByLabel(regionString);
        TourPackage tourPackage = tourPackageRepository.findById(tourPackageCode).orElse(new TourPackage());
        // TODO: Validate if entity already existis.
        return trailRepository.save(new Trail(name, description, keywords, distance, time, difficulty, region, tourPackage));
    }

    /**
     * Fetches all Trails
     *
     * @return A list with all trails in tha repository
     */
    // TODO: Implement pagination
    public List<Trail> getAllTrails() {
        return trailRepository.findAll();
    }

    /**
     * Fetch a Trail by ID
     *
     * @param id A Long value to identify a Trail
     * @return An Optional value for an existing Trail.
     */
    public Optional<Trail> getTrailByID(Long id) {
        // TODO: Throw an exception or return a default response if the trail is not found.
        return trailRepository.findById(id);
    }

    /**
     * Updates an existing Trail
     *
     * @param name             The name of the trail.
     * @param description      A description of the trail.
     * @param keywords         Keywords related to the trail.
     * @param distance         An integer value representing the distance of the trail in kilometers.
     * @param time             A double value representing the estimated walking time in hours.
     * @param difficultyString The difficulty level of the trail.
     * @param regionString     The region where the trail is located.
     * @param tourPackageCode  A string code that identifies the tour package this trail is part of.
     * @return The updated Trail object.
     */
    public Trail updateTrail(long trailId, String name, String description, String keywords, int distance, double time,
                             String difficultyString, String regionString, String tourPackageCode) throws EntityNotFoundException{

        Difficulty difficulty = Difficulty.findByLabel(difficultyString.toLowerCase());
        Region region = Region.findByLabel(regionString);
        TourPackage tourPackage = tourPackageRepository.findById(tourPackageCode).orElse(new TourPackage());


        Trail existingTrail = trailRepository.findById(trailId)
                .orElseThrow(() -> new EntityNotFoundException("Trail not found with ID: " + trailId));
        existingTrail.setName(name);
        existingTrail.setDescription(description);
        existingTrail.setKeywords(keywords);
        existingTrail.setDistance(distance);
        existingTrail.setTime(time);
        existingTrail.setDifficulty(difficulty);
        existingTrail.setRegion(region);
        existingTrail.setTourPackage(tourPackage);

        return trailRepository.save(existingTrail);

    }

    /**
     * Delete an existing Trail
     *
     * @param trailId A Long value to identify a Trail
     * @return A Boolean Value if a Trail was found and deleted.
     */
    public boolean deleteTrail(Long trailId) {
        if (trailRepository.existsById(trailId)) {
            trailRepository.deleteById(trailId);
            return true;
        }
        // TODO: Throw exception or log a warning if the trail does not exist
        return false;
    }

}
