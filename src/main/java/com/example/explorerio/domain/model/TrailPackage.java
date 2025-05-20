package com.example.explorerio.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TrailPackage {

    @Id
    @Column(length = 10)
    private String code;
    @Column()
    private String name;

    public TrailPackage() {
    }

    public TrailPackage(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
