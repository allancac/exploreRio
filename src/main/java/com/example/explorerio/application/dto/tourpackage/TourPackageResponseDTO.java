package com.example.explorerio.application.dto.tourpackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourPackageResponseDTO extends RepresentationModel<TourPackageResponseDTO> {
    String code;
    String name;
    Double price;
}
