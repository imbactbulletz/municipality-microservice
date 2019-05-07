package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.dao.RegionDao;
import rs.edu.raf.si.lsd.domain.Region;
import rs.edu.raf.si.lsd.domain.dto.region.RegionRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.region.RegionResponseDTO;
import rs.edu.raf.si.lsd.service.RegionService;

import java.util.Optional;

@Service
public class ImplRegionService implements RegionService {

    @Autowired
    private RegionDao regionDao;

    @Override
    public RegionResponseDTO save(RegionRequestDTO regionRequestDTO) {
        Region region = Region.builder()
                            .name(regionRequestDTO.getName())
                            .build();

        regionDao.save(region);

        Optional<Region> regionOpt = regionDao.findById(regionRequestDTO.getName());

        if(regionOpt.isPresent()) {
            return new RegionResponseDTO(regionOpt.get());
        }

        return null;
    }

    @Override
    public void delete(RegionRequestDTO regionRequestDTO) {
        Region region = Region.builder()
                .name(regionRequestDTO.getName())
                .build();

        regionDao.delete(region);
    }
}
