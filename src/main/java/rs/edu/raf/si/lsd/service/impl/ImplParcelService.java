package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.dao.BaseDao;
import rs.edu.raf.si.lsd.dao.CityDao;
import rs.edu.raf.si.lsd.dao.ParcelDao;
import rs.edu.raf.si.lsd.dao.TownDao;
import rs.edu.raf.si.lsd.domain.dto.parcel.ParcelRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.parcel.ParcelResponseDTO;
import rs.edu.raf.si.lsd.domain.entities.*;
import rs.edu.raf.si.lsd.service.ParcelService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImplParcelService implements ParcelService {

    @Autowired
    private ParcelDao parcelDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private TownDao townDao;

    @Override
    public ParcelResponseDTO save(ParcelRequestDTO requestDTO) {

        if(requestDTO.getTerritorialUnitType().equals("city")) {
            return saveAsCityParcel(requestDTO);
        } else if(requestDTO.getTerritorialUnitType().equals("town")) {
            return saveAsTownParcel(requestDTO);
        }

        return null;
    }


    private ParcelResponseDTO saveAsCityParcel(ParcelRequestDTO parcelRequestDTO) {
        Parcel parcel = Parcel.builder()
                .parcelNumber(parcelRequestDTO.getParcelNumber())
                .surface(parcelRequestDTO.getSurface())
                .estimatedValue(parcelRequestDTO.getEstimatedValue())
                .build();

        Optional<City> cityOptional = cityDao.findById("Šabac");

        if(cityOptional.isPresent()) {
            parcelDao.save(parcel);

            City city = cityOptional.get();

            createRelation(cityDao, parcel, city, null, null);

            ParcelResponseDTO parcelResponseDTO = ParcelResponseDTO
                    .builder()
                    .parcelNumber(parcel.getParcelNumber())
                    .surface(parcel.getSurface())
                    .estimatedValue(parcel.getEstimatedValue())
                    .build();

            return parcelResponseDTO;
        }

        return null;
    }

    private ParcelResponseDTO saveAsTownParcel(ParcelRequestDTO parcelRequestDTO) {
        Parcel parcel = Parcel.builder()
                .parcelNumber(parcelRequestDTO.getParcelNumber())
                .surface(parcelRequestDTO.getSurface())
                .estimatedValue(parcelRequestDTO.getEstimatedValue())
                .build();

        Optional<Town> townOptional = townDao.findById(parcelRequestDTO.getTerritorialUnitName());

        if(townOptional.isPresent()) {
            parcelDao.save(parcel);

            Town town = townOptional.get();

            createRelation(townDao, parcel, town, null, null);

            ParcelResponseDTO parcelResponseDTO = ParcelResponseDTO
                    .builder()
                    .parcelNumber(parcel.getParcelNumber())
                    .surface(parcel.getSurface())
                    .build();

            return parcelResponseDTO;
        }

        return null;
    }

    private void createRelation(BaseDao dao, TerritorialUnit childUnit, TerritorialUnit parentUnit, String from, String to) {
        Belongment belongment = new Belongment(childUnit, parentUnit, from, to);

        if(parentUnit instanceof City) {
            ((City)parentUnit).getBelongmentRelationships().add(belongment);
        }

        if(parentUnit instanceof Town) {
            ((Town)parentUnit).getBelongmentRelationships().add(belongment);
        }

        dao.save(parentUnit);
    }

    @Override
    public void delete(ParcelRequestDTO requestDTO) {
        Parcel parcel = Parcel.builder()
                .parcelNumber(requestDTO.getParcelNumber())
                .build();

        parcelDao.delete(parcel);
    }

    @Override
    public ParcelResponseDTO findByName(ParcelRequestDTO requestDTO) {
        Parcel parcel = parcelDao.findByParcelNumber(requestDTO.getParcelNumber());

        ParcelResponseDTO parcelResponseDTO = new ParcelResponseDTO(parcel);

        return parcelResponseDTO;
    }

    @Override
    public List<ParcelResponseDTO> findAll() {
        Iterable<Parcel> parcels = parcelDao.findAll();

        List<ParcelResponseDTO> parcelResponseDTOs = StreamSupport.stream(parcels.spliterator(), false)
                .map(ParcelResponseDTO::new)
                .collect(Collectors.toList());

        return parcelResponseDTOs;
    }

    @Override
    public List<ParcelResponseDTO> findAllInTown(String townName) {
        Iterable<Parcel> parcels = parcelDao.findAllInTown(townName);

        List<ParcelResponseDTO> parcelResponseDTOs = StreamSupport.stream(parcels.spliterator(), false)
                .map(ParcelResponseDTO::new)
                .collect(Collectors.toList());

        return parcelResponseDTOs;

    }

    @Override
    public List<ParcelResponseDTO> findAllInCity(String cityName) {
        Iterable<Parcel> parcels = parcelDao.findAllInCity(cityName);

        List<ParcelResponseDTO> parcelResponseDTOs = StreamSupport.stream(parcels.spliterator(), false)
                .map(ParcelResponseDTO::new)
                .collect(Collectors.toList());

        return parcelResponseDTOs;

    }

    @Override
    public List<ParcelResponseDTO> findAllInMunicipality(String municipalityName) {
        Iterable<Parcel> parcels = parcelDao.findAllInMunicipality(municipalityName);

        List<ParcelResponseDTO> parcelResponseDTOs = StreamSupport.stream(parcels.spliterator(), false)
                .map(ParcelResponseDTO::new)
                .collect(Collectors.toList());

        return parcelResponseDTOs;

    }

    @Override
    public List<ParcelResponseDTO> findAllInCounty(String countyName) {
        Iterable<Parcel> parcels = parcelDao.findAllInCounty(countyName);

        List<ParcelResponseDTO> parcelResponseDTOs = StreamSupport.stream(parcels.spliterator(), false)
                .map(ParcelResponseDTO::new)
                .collect(Collectors.toList());

        return parcelResponseDTOs;

    }

    @Override
    public List<ParcelResponseDTO> findAllInRegion(String regionName) {
        Iterable<Parcel> parcels = parcelDao.findAllInRegion(regionName);

        List<ParcelResponseDTO> parcelResponseDTOs = StreamSupport.stream(parcels.spliterator(), false)
                .map(ParcelResponseDTO::new)
                .collect(Collectors.toList());

        return parcelResponseDTOs;

    }

    @Override
    public List<ParcelResponseDTO> findAllForOwner(String jmbg) {
        List<Parcel> parcels = parcelDao.findAllForOwner(jmbg);

        List<ParcelResponseDTO> parcelResponseDTOs = parcels.stream()
                .map(ParcelResponseDTO::new)
                .collect(Collectors.toList());

        return parcelResponseDTOs;
    }
}
