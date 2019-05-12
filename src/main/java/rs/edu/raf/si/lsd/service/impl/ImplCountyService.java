package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.dao.CountyDao;
import rs.edu.raf.si.lsd.dao.RegionDao;
import rs.edu.raf.si.lsd.domain.entities.Belongment;
import rs.edu.raf.si.lsd.domain.entities.County;
import rs.edu.raf.si.lsd.domain.entities.Region;
import rs.edu.raf.si.lsd.domain.dto.county.CountyRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;
import rs.edu.raf.si.lsd.service.CountyService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImplCountyService implements CountyService {

    @Autowired
    private CountyDao countyDao;

    @Autowired
    private RegionDao regionDao;

    @Override
    public CountyResponseDTO save(CountyRequestDTO countyRequestDTO) {
        County county = County.builder()
                .name(countyRequestDTO.getName()).build();

        Optional<Region> regionOptional = regionDao.findById(countyRequestDTO.getRegionName());


        if(regionOptional.isPresent()) {
            countyDao.save(county);

            Region region = regionOptional.get();

            createRelation(county, region, countyRequestDTO.getFrom(), countyRequestDTO.getTo());

            CountyResponseDTO countyResponseDTO = CountyResponseDTO.builder()
                    .name(countyRequestDTO.getName())
                    .regionName(region.getName())
                    .from(countyRequestDTO.getFrom())
                    .to(countyRequestDTO.getTo())
                    .build();

            return countyResponseDTO;
        }

        return null;
    }

    private void createRelation(County county, Region region, String from, String to) {
        Belongment belongment = new Belongment(county, region, from, to);

        region.getBelongmentRelationships().add(belongment);

        regionDao.save(region);
    }

    @Override
    public void delete(CountyRequestDTO countyRequestDTO) {
        County county = County.builder()
                .name(countyRequestDTO.getName())
                .build();

        countyDao.delete(county);
    }

    @Override
    public CountyResponseDTO findByName(CountyRequestDTO countyRequestDTO) {
        County county = countyDao.findByName(countyRequestDTO.getName());

        CountyResponseDTO countyResponseDTO = new CountyResponseDTO(county);

        return countyResponseDTO;
    }

    @Override
    public List<CountyResponseDTO> findAll() {
        Iterable<County> counties = countyDao.findAll();

        List<CountyResponseDTO> countyResponseDTOS = StreamSupport.stream(counties.spliterator(), false)
                .map(CountyResponseDTO::new)
                .collect(Collectors.toList());

        return countyResponseDTOS;
    }


}
