package rs.edu.raf.si.lsd.service;

import rs.edu.raf.si.lsd.domain.dto.resident.ResidentRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.resident.ResidentResponseDTO;

import java.util.List;

public interface ResidentService extends BaseService<ResidentRequestDTO, ResidentResponseDTO> {

    List<ResidentResponseDTO> findAllInTown(String townName);

    List<ResidentResponseDTO> findAllInCity(String cityName);

    List<ResidentResponseDTO> findAllInMunicipality(String municipalityName);

    List<ResidentResponseDTO> findAllInCounty(String countyName);

    List<ResidentResponseDTO> findAllInRegion(String regionName);

}
