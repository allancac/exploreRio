package com.example.explorerio.application.dto.tourpackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourPackageResponseDTO {
    String code;
    String name;
    Double price;
}
