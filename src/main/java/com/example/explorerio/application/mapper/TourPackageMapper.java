package com.example.explorerio.application.mapper;
import com.example.explorerio.application.dto.tourpackage.TourPackageRequestDTO;
import com.example.explorerio.application.dto.tourpackage.TourPackageResponseDTO;
import com.example.explorerio.domain.model.TourPackage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TourPackageMapper {
    TourPackage toEntity(TourPackageRequestDTO dto);
    TourPackageResponseDTO toDTO(TourPackage entity);
}
