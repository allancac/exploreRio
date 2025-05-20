package com.example.explorerio.domain.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Trail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 200)
    private String name;
    @Column(length = 2000)
    private String description;
    @Column(length = 2000)
    private String keywords;
    @Column
    private int distance;
    @Column(precision = 1)
    private double time;
    @Column
    @Enumerated
    private Difficulty difficulty;
    @Column
    @Enumerated
    private Region region;
    @ManyToOne
    private TrailPackage trailPackage;

    public Trail() {
    }

    public Trail(String name,
                 String description,
                 String keywords,
                 int distance,
                 double time,
                 Difficulty difficulty,
                 Region region,
                 TrailPackage trailPackage) {
        this.name = name;
        this.description = description;
        this.keywords = keywords;
        this.distance = distance;
        this.time = time;
        this.difficulty = difficulty;
        this.region = region;
        this.trailPackage = trailPackage;
    }

    private void setId(long id) {
        this.id = id;
    }
}
