package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.dao.BaseDao;
import rs.edu.raf.si.lsd.dao.CityDao;
import rs.edu.raf.si.lsd.dao.MunicipalityDao;
import rs.edu.raf.si.lsd.dao.TownDao;
import rs.edu.raf.si.lsd.domain.dto.town.TownRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.town.TownResponseDTO;
import rs.edu.raf.si.lsd.domain.entities.*;
import rs.edu.raf.si.lsd.service.TownService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImplTownService implements TownService {

    @Autowired
    private TownDao townDao;

    @Autowired
    private CityDao cityDao;


    @Autowired
    private MunicipalityDao municipalityDao;

    @Override
    public TownResponseDTO save(TownRequestDTO requestDTO) {

        if(requestDTO.getCityName() != null) {
            return saveAsCityUnit(requestDTO);
        } else if (requestDTO.getMunicipalityName() != null) {
            return saveAsMunicipalityUnit(requestDTO);
        }


        return null;
    }

    private TownResponseDTO saveAsCityUnit(TownRequestDTO townRequestDTO){
        Town town = Town.builder()
                .name(townRequestDTO.getName())
                .build();

        Optional<City> cityOptional = cityDao.findById(townRequestDTO.getCityName());

        if(cityOptional.isPresent()) {
            townDao.save(town);

            City city = cityOptional.get();

            createRelation(cityDao, town, city, townRequestDTO.getFrom(), townRequestDTO.getTo());

            TownResponseDTO townResponseDTO = TownResponseDTO.builder()
                    .name(town.getName())
                    .cityName(city.getName())
                    .from(townRequestDTO.getFrom())
                    .to(townRequestDTO.getTo())
                    .build();

            return townResponseDTO;
        }

        return null;
    }



    private TownResponseDTO saveAsMunicipalityUnit(TownRequestDTO townRequestDTO) {
        Town town = Town.builder()
                .name(townRequestDTO.getName())
                .build();

        Optional<Municipality> municipalityOptional = municipalityDao.findById(townRequestDTO.getMunicipalityName());

        if(municipalityOptional.isPresent()) {
            townDao.save(town);

            Municipality municipality = municipalityOptional.get();

            createRelation(municipalityDao, town, municipality, townRequestDTO.getFrom(), townRequestDTO.getTo());

            TownResponseDTO townResponseDTO = TownResponseDTO.builder()
                    .name(town.getName())
                    .municipalityName(municipality.getName())
                    .from(townRequestDTO.getFrom())
                    .to(townRequestDTO.getTo())
                    .build();

            return townResponseDTO;
        }

        return null;
    }

    private void createRelation(BaseDao dao, TerritorialUnit childUnit, TerritorialUnit parentUnit, String from, String to) {
        Belongment belongment = new Belongment(childUnit, parentUnit, from, to);

        if(parentUnit instanceof City) {
            ((City)parentUnit).getBelongmentRelationships().add(belongment);
        }

        if(parentUnit instanceof Municipality) {
            ((Municipality)parentUnit).getBelongmentRelationships().add(belongment);
        }

        dao.save(parentUnit);
    }


    @Override
    public void delete(TownRequestDTO requestDTO) {
        Town town = Town.builder()
                .name(requestDTO.getName())
                .build();

        townDao.delete(town);
    }

    @Override
    public TownResponseDTO findByName(TownRequestDTO requestDTO) {
        Town town = townDao.findByName(requestDTO.getName());

        if(town != null) {
            TownResponseDTO townResponseDTO = new TownResponseDTO(town);
            return townResponseDTO;
        }

        return null;
    }

    @Override
    public List<TownResponseDTO> findAll() {
        Iterable<Town> towns = townDao.findAll();

        List<TownResponseDTO> townResponseDTOs = StreamSupport.stream(towns.spliterator(), false)
                .map(TownResponseDTO::new).collect(Collectors.toList());

        return townResponseDTOs;
    }
}
