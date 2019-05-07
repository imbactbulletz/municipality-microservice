package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.dao.CountyDao;
import rs.edu.raf.si.lsd.dao.RegionDao;
import rs.edu.raf.si.lsd.domain.Belongment;
import rs.edu.raf.si.lsd.domain.County;
import rs.edu.raf.si.lsd.domain.Region;
import rs.edu.raf.si.lsd.domain.dto.county.CountyRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;
import rs.edu.raf.si.lsd.service.CountyService;

import java.util.List;
import java.util.Optional;

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

        Optional<Region> regionOpt = regionDao.findById(countyRequestDTO.getRegionName());


        if(regionOpt.isPresent()) {
            countyDao.save(county);

            Region region = regionOpt.get();

            Belongment belongment = new Belongment(county, region, countyRequestDTO.getFrom(), countyRequestDTO.getTo());

            region.getCounties().add(belongment);
            regionDao.save(region);

        }

        return null;
    }
}
