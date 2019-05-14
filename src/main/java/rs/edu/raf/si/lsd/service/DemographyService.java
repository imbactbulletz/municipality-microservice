package rs.edu.raf.si.lsd.service;

import rs.edu.raf.si.lsd.domain.dto.demography.PopulationDensityRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.demography.PopulationDensityResponseDTO;

public interface DemographyService {
    PopulationDensityResponseDTO getPopulationDensity(PopulationDensityRequestDTO requestDTO);
}
