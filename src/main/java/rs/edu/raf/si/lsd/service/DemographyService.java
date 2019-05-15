package rs.edu.raf.si.lsd.service;

import rs.edu.raf.si.lsd.domain.dto.demography.*;

public interface DemographyService {
    PopulationDensityResponseDTO getPopulationDensity(PopulationDensityRequestDTO requestDTO);

    AverageAgeResponseDTO getAverageAge(AverageAgeRequestDTO requestDTO);

    MortalityResponseDTO getMortalityRate();

    NatalityResponseDTO getNatalityRate();
}
