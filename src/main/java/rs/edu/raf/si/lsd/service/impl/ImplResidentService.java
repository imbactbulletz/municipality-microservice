package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.dao.*;
import rs.edu.raf.si.lsd.domain.dto.resident.ResidentRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.resident.ResidentResponseDTO;
import rs.edu.raf.si.lsd.domain.entities.*;
import rs.edu.raf.si.lsd.service.ResidentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImplResidentService implements ResidentService {

    @Autowired
    private ResidentDao residentDao;

    @Autowired
    private TownDao townDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private MunicipalityDao municipalityDao;

    @Override
    public ResidentResponseDTO save(ResidentRequestDTO requestDTO) {
        Resident resident = Resident.builder()
                .jmbg(requestDTO.getJmbg())
                .build();

        residentDao.save(resident);

        if(requestDTO.getResidenceUnitType().equals("municipality")) {
            return saveAsMunicipalityResident(requestDTO);
        } else if(requestDTO.getResidenceUnitType().equals("city")) {
            return saveAsCityResident(requestDTO);
        } else if (requestDTO.getResidenceUnitType().equals("town")) {
            return saveAsTownResident(requestDTO);
        }

        return null;
    }


    private ResidentResponseDTO saveAsMunicipalityResident(ResidentRequestDTO residentRequestDTO) {
        Optional<Municipality> municipalityOptional = municipalityDao.findById(residentRequestDTO.getResidenceUnitName());

        if(municipalityOptional.isPresent()) {
            Municipality municipality = municipalityOptional.get();
            Resident resident = residentDao.findByJmbg(residentRequestDTO.getJmbg());

            createRelation(municipalityDao, resident, municipality, null, null);

            ResidentResponseDTO residentResponseDTO = new ResidentResponseDTO();
            residentResponseDTO.setJmbg(resident.getJmbg());

            return residentResponseDTO;
        }

        return null;
    }

    private ResidentResponseDTO saveAsCityResident(ResidentRequestDTO residentRequestDTO) {
        Optional<City> cityOptional = cityDao.findById(residentRequestDTO.getResidenceUnitName());

        if(cityOptional.isPresent()) {
            City city = cityOptional.get();
            Resident resident = residentDao.findByJmbg(residentRequestDTO.getJmbg());

            createRelation(cityDao, resident, city, null , null);

            ResidentResponseDTO residentResponseDTO = new ResidentResponseDTO();
            residentResponseDTO.setJmbg(resident.getJmbg());

            return residentResponseDTO;
        }

        return null;
    }

    private ResidentResponseDTO saveAsTownResident(ResidentRequestDTO residentRequestDTO) {
        Optional<Town> townOptional = townDao.findById(residentRequestDTO.getResidenceUnitName());

        if(townOptional.isPresent()) {
            Town town = townOptional.get();
            Resident resident = residentDao.findByJmbg(residentRequestDTO.getJmbg());

            createRelation(townDao, resident, town, null, null);

            ResidentResponseDTO residentResponseDTO = new ResidentResponseDTO();
            residentResponseDTO.setJmbg(resident.getJmbg());

            return residentResponseDTO;
        }

        return null;
    }

    private void createRelation(BaseDao dao, TerritorialUnit childUnit, TerritorialUnit parentUnit, String from, String to) {
        Belongment belongment = new Belongment(childUnit, parentUnit, from, to);

        if(parentUnit instanceof Municipality ) {
            ((Municipality)parentUnit).getBelongmentRelationships().add(belongment);
        }

        if(parentUnit instanceof City) {
            ((City)parentUnit).getBelongmentRelationships().add(belongment);
        }

        if(parentUnit instanceof Town) {
            ((Town) parentUnit).getBelongmentRelationships().add(belongment);
        }

        dao.save(parentUnit);
    }

    @Override
    public void delete(ResidentRequestDTO requestDTO) {
        Resident resident = residentDao.findByJmbg(requestDTO.getJmbg());

        if(resident != null) {
            residentDao.delete(resident);
        }
    }

    @Override
    public ResidentResponseDTO findByName(ResidentRequestDTO requestDTO) {
        Resident resident = residentDao.findByJmbg(requestDTO.getJmbg());

        ResidentResponseDTO residentResponseDTO = new ResidentResponseDTO();
        residentResponseDTO.setJmbg(resident.getJmbg());

        return residentResponseDTO;
    }

    @Override
    public List<ResidentResponseDTO> findAll() {
        Iterable<Resident> residents = residentDao.findAll();

        List<ResidentResponseDTO> residentResponseDTOs = StreamSupport.stream(residents.spliterator(), false)
                .map(ResidentResponseDTO::new)
                .collect(Collectors.toList());

        return residentResponseDTOs;
    }

    @Override
    public List<ResidentResponseDTO> findAllInTown(String townName) {
        Iterable<Resident> residents = residentDao.findAllInTown(townName);

        List<ResidentResponseDTO> residentResponseDTOs = StreamSupport.stream(residents.spliterator(), false)
                .map(ResidentResponseDTO::new)
                .collect(Collectors.toList());

        return residentResponseDTOs;
    }

    @Override
    public List<ResidentResponseDTO> findAllInCity(String cityName) {
        Iterable<Resident> residents = residentDao.findAllInCity(cityName);

        List<ResidentResponseDTO> residentResponseDTOs = StreamSupport.stream(residents.spliterator(), false)
                .map(ResidentResponseDTO::new)
                .collect(Collectors.toList());

        return residentResponseDTOs;
    }

    @Override
    public List<ResidentResponseDTO> findAllInMunicipality(String municipalityName) {
        Iterable<Resident> residents = residentDao.findAllInMunicipality(municipalityName);

        List<ResidentResponseDTO> residentResponseDTOs = StreamSupport.stream(residents.spliterator(), false)
                .map(ResidentResponseDTO::new)
                .collect(Collectors.toList());

        return residentResponseDTOs;
    }

    @Override
    public List<ResidentResponseDTO> findAllInCounty(String countyName) {
        Iterable<Resident> residents = residentDao.findAllInCounty(countyName);

        List<ResidentResponseDTO> residentResponseDTOs = StreamSupport.stream(residents.spliterator(), false)
                .map(ResidentResponseDTO::new)
                .collect(Collectors.toList());

        return residentResponseDTOs;
    }

    @Override
    public List<ResidentResponseDTO> findAllInRegion(String regionName) {
        Iterable<Resident> residents = residentDao.findAllInRegion(regionName);

        List<ResidentResponseDTO> residentResponseDTOs = StreamSupport.stream(residents.spliterator(), false)
                .map(ResidentResponseDTO::new)
                .collect(Collectors.toList());

        return residentResponseDTOs;
    }
}
