package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.dao.BaseDao;
import rs.edu.raf.si.lsd.dao.CityDao;
import rs.edu.raf.si.lsd.dao.CountyDao;
import rs.edu.raf.si.lsd.dao.MunicipalityDao;
import rs.edu.raf.si.lsd.domain.entities.*;
import rs.edu.raf.si.lsd.domain.dto.municipality.MunicipalityRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.municipality.MunicipalityResponseDTO;
import rs.edu.raf.si.lsd.service.MunicipalityService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImplMunicipalityService implements MunicipalityService {

    @Autowired
    private MunicipalityDao municipalityDao;

    @Autowired
    private CountyDao countyDao;

    @Autowired
    private CityDao cityDao;

    @Override
    public MunicipalityResponseDTO save(MunicipalityRequestDTO municipalityRequestDTO) {

        if (municipalityRequestDTO.getCountyName() != null) {
            return saveAsCountyUnit(municipalityRequestDTO);
        } else if (municipalityRequestDTO.getCityName() != null) {
            return saveAsCityUnit(municipalityRequestDTO);
        }

        return null;
    }

    private MunicipalityResponseDTO saveAsCountyUnit(MunicipalityRequestDTO municipalityRequestDTO) {
        Municipality municipality = Municipality.builder()
                .name(municipalityRequestDTO.getName())
                .build();

        Optional<County> countyOptional = countyDao.findById(municipalityRequestDTO.getCountyName());

        if (countyOptional.isPresent()) {
            municipalityDao.save(municipality);

            County county = countyOptional.get();
            createRelation(countyDao, municipality, county, municipalityRequestDTO.getFrom(), municipalityRequestDTO.getTo());

            MunicipalityResponseDTO municipalityResponseDTO = MunicipalityResponseDTO.builder()
                    .name(municipality.getName())
                    .countyName(county.getName())
                    .from(municipalityRequestDTO.getFrom())
                    .to(municipalityRequestDTO.getTo())
                    .build();

            return municipalityResponseDTO;
        }

        return null;
    }


    private MunicipalityResponseDTO saveAsCityUnit(MunicipalityRequestDTO municipalityRequestDTO) {
        Municipality municipality = Municipality.builder()
                .name(municipalityRequestDTO.getName())
                .build();

        Optional<City> cityOptional = cityDao.findById(municipalityRequestDTO.getCityName());

        if (cityOptional.isPresent()) {
            municipalityDao.save(municipality);

            City city = cityOptional.get();

            createRelation(cityDao, municipality, city, municipalityRequestDTO.getFrom(), municipalityRequestDTO.getTo());

            MunicipalityResponseDTO municipalityResponseDTO = MunicipalityResponseDTO.builder()
                    .name(municipality.getName())
                    .cityName(city.getName())
                    .from(municipalityRequestDTO.getFrom())
                    .to(municipalityRequestDTO.getTo())
                    .build();

            return municipalityResponseDTO;
        }

        return null;
    }

    private void createRelation(BaseDao dao, TerritorialUnit childUnit, TerritorialUnit parentUnit, String from, String to) {
        Belongment belongment = new Belongment(childUnit, parentUnit, from, to);

        if(parentUnit instanceof County ) {
            ((County)parentUnit).getBelongmentRelationships().add(belongment);
        }

        if(parentUnit instanceof City) {
            ((City)parentUnit).getBelongmentRelationships().add(belongment);
        }

        dao.save(parentUnit);
    }

    @Override
    public void delete(MunicipalityRequestDTO municipalityRequestDTO) {
        Municipality municipality = Municipality.builder()
                .name(municipalityRequestDTO.getName())
                .build();

        municipalityDao.delete(municipality);
    }

    @Override
    public MunicipalityResponseDTO findByName(MunicipalityRequestDTO municipalityRequestDTO) {
        Municipality municipality = municipalityDao.findByName(municipalityRequestDTO.getName());

        if (municipality != null) {
            MunicipalityResponseDTO municipalityResponseDTO = new MunicipalityResponseDTO(municipality);

            return municipalityResponseDTO;
        }

        return null;
    }

    @Override
    public List<MunicipalityResponseDTO> findAll() {
        Iterable<Municipality> municipalities = municipalityDao.findAll();

        List<MunicipalityResponseDTO> municipalityDTOs = StreamSupport.stream(municipalities.spliterator(), false)
                .map(MunicipalityResponseDTO::new)
                .collect(Collectors.toList());

        return municipalityDTOs;
    }
}
