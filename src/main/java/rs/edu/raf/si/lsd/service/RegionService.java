package rs.edu.raf.si.lsd.service;

import rs.edu.raf.si.lsd.domain.dto.region.RegionRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.region.RegionResponseDTO;

public interface RegionService {

    RegionResponseDTO save(RegionRequestDTO regionRequestDTO);

    void delete(RegionRequestDTO regionRequestDTO);

}
