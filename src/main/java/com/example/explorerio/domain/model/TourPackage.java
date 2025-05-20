package com.example.explorerio.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TourPackage {

    @Id
    @Column(length = 10)
    private String code;
    @Column()
    private String name;
    @Column()
    private Double price=0.0;

    public TourPackage() {
    }

    public TourPackage(String code, String name,Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
}
