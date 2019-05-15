package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.domain.dto.demography.*;
import rs.edu.raf.si.lsd.domain.dto.parcel.ParcelResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.registry.InhabitantResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.resident.ResidentResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.registry.RegistryResponseDTO;
import rs.edu.raf.si.lsd.service.DemographyService;
import rs.edu.raf.si.lsd.service.ParcelService;
import rs.edu.raf.si.lsd.service.ResidentService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

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

    @Override
    public AverageAgeResponseDTO getAverageAge(AverageAgeRequestDTO requestDTO) {
        List<InhabitantResponseDTO> inhabitantResponseDTOs = getAllInhabitants();

        int generation = requestDTO.getGeneration();
        int generationHabitants = 0;
        double averageAge = 0;

        for(InhabitantResponseDTO inhabitant : inhabitantResponseDTOs) {
            if(inhabitant.isAlive() && generation == inhabitant.getYearOfBirth()) {
                generationHabitants++;
                averageAge += inhabitant.getAge();
            }
        }

        AverageAgeResponseDTO averageAgeResponseDTO = AverageAgeResponseDTO
                .builder()
                .averageAge(averageAge / generationHabitants)
                .build();

        return averageAgeResponseDTO;
    }

    @Override
    public MortalityResponseDTO getMortalityRate() {
        List<InhabitantResponseDTO> inhabitants = getAllInhabitants();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int died = 0;

        for(InhabitantResponseDTO inhabitant: inhabitants) {
            if(inhabitant.getYearOfDeath() == currentYear) {
                died++;
            }
        }

        double mortalityRate = ((double)died) / inhabitants.size() * 1000;


        MortalityResponseDTO mortalityResponseDTO = MortalityResponseDTO
                .builder()
                .mortalityRate(mortalityRate)
                .build();

        return mortalityResponseDTO;
    }

    @Override
    public NatalityResponseDTO getNatalityRate() {
        List<InhabitantResponseDTO> inhabitants = getAllInhabitants();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int newborns = 0;

        for(InhabitantResponseDTO inhabitant: inhabitants) {
            if(inhabitant.getYearOfBirth() == currentYear) {
                newborns++;
            }
        }

        double natalityRate = ((double) newborns) / inhabitants.size() * 1000;


        NatalityResponseDTO natalityResponseDTO = NatalityResponseDTO.builder()
                .natalityRate(natalityRate)
                .build();

        return natalityResponseDTO;
    }

    public List<InhabitantResponseDTO> getAllInhabitants() {
        List<InhabitantResponseDTO> inhabitants = new ArrayList<>();

        Random random = new Random();

        for(int i = 0; i < 1000; i++){
            String jmbg = String.valueOf(i);
            int age = 119 - (i%120);
            int yearOfBirth = 1900 + (i % 120);
            int rnum = (random.nextInt(120) + 1950);
            int yearOfDeath = rnum > (1900 + (i % 120)) ? rnum : 0;
            boolean isAlive = yearOfBirth > yearOfDeath;

            inhabitants.add(
                    InhabitantResponseDTO.builder()
                    .jmbg(jmbg)
                    .age(age)
                    .yearOfBirth(yearOfBirth)
                    .yearOfDeath(yearOfDeath)
                    .isAlive(isAlive)
                    .build()
            );
        }

        return inhabitants;
    }
}
