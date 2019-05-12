package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.dao.CityDao;
import rs.edu.raf.si.lsd.dao.CountyDao;
import rs.edu.raf.si.lsd.domain.dto.city.CityRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.city.CityResponseDTO;
import rs.edu.raf.si.lsd.domain.entities.Belongment;
import rs.edu.raf.si.lsd.domain.entities.City;
import rs.edu.raf.si.lsd.domain.entities.County;
import rs.edu.raf.si.lsd.service.CityService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImplCityService implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CountyDao countyDao;

    @Override
    public CityResponseDTO save(CityRequestDTO requestDTO) {
        City city = City.builder()
                .name(requestDTO.getName())
                .build();

        County county = countyDao.findByName(requestDTO.getCountyName());

        if(county != null) {
            cityDao.save(city);

            createRelation(city, county, requestDTO.getFrom(), requestDTO.getTo());

            CityResponseDTO cityResponseDTO = CityResponseDTO
                    .builder()
                    .name(requestDTO.getName())
                    .countyName(requestDTO.getCountyName())
                    .from(requestDTO.getFrom())
                    .to(requestDTO.getTo())
                    .build();

            return cityResponseDTO;
        }

        return null;
    }

    private void createRelation(City city, County county, String from, String to) {
        Belongment belongment = new Belongment(city, county, from, to);

        county.getBelongmentRelationships().add(belongment);

        countyDao.save(county);
    }

    @Override
    public void delete(CityRequestDTO requestDTO) {
        City city = City.builder()
                .name(requestDTO.getName())
                .build();

        cityDao.delete(city);
    }

    @Override
    public CityResponseDTO findByName(CityRequestDTO requestDTO) {
        City city = cityDao.findByName(requestDTO.getName());

        CityResponseDTO cityResponseDTO = new CityResponseDTO(city);

        return cityResponseDTO;
    }

    @Override
    public List<CityResponseDTO> findAll() {
        Iterable<City> cities = cityDao.findAll();

        List<CityResponseDTO> cityResponseDTOs = StreamSupport.stream(cities.spliterator(), false)
                .map(CityResponseDTO::new)
                .collect(Collectors.toList());

        return cityResponseDTOs;
    }
}
