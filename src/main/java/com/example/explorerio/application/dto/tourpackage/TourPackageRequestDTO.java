package com.example.explorerio.application.dto.tourpackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourPackageRequestDTO {
    public String code;
    public String name;
    public Double price;

}
