package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.domain.dto.demography.PopulationDensityRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.demography.PopulationDensityResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.parcel.ParcelResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.resident.ResidentResponseDTO;
import rs.edu.raf.si.lsd.service.DemographyService;
import rs.edu.raf.si.lsd.service.ParcelService;
import rs.edu.raf.si.lsd.service.ResidentService;

import java.util.List;

@Service
public class ImplDemographyService implements DemographyService {

    @Autowired
    private ResidentService residentService;

    @Autowired
    private ParcelService parcelService;


    @Override
    public PopulationDensityResponseDTO getPopulationDensity(PopulationDensityRequestDTO requestDTO) {

        List<ResidentResponseDTO> residents = null;
        List<ParcelResponseDTO> parcelResponseDTOs = null;


        if(requestDTO.getTerritorialUnitType().equals("town")) {
            residents = residentService.findAllInTown(requestDTO.getTerritorialUnitName());
            parcelResponseDTOs = parcelService.findAllInTown(requestDTO.getTerritorialUnitName());
        }

        if(requestDTO.getTerritorialUnitType().equals("municipality")) {
            residents = residentService.findAllInTown(requestDTO.getTerritorialUnitName());
            parcelResponseDTOs = parcelService.findAllInMunicipality(requestDTO.getTerritorialUnitName());
        }

        double surfaceSum = 0;

        for(ParcelResponseDTO parcelResponseDTO : parcelResponseDTOs) {
            surfaceSum += parcelResponseDTO.getSurface();
        }

        PopulationDensityResponseDTO populationDensityResponseDTO = PopulationDensityResponseDTO
                .builder()
                .populationDensity(residents.size() / surfaceSum)
                .noOfResidents(residents.size())
                .build();

        return populationDensityResponseDTO;

    }
}
