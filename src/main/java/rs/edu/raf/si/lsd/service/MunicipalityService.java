package rs.edu.raf.si.lsd.service;

import rs.edu.raf.si.lsd.domain.dto.municipality.MunicipalityRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.municipality.MunicipalityResponseDTO;

import java.util.List;

public interface MunicipalityService {

    MunicipalityResponseDTO save(MunicipalityRequestDTO municipalityRequestDTO);

    void delete(MunicipalityRequestDTO municipalityRequestDTO);

    MunicipalityResponseDTO findByName(MunicipalityRequestDTO municipalityRequestDTO);

    List<MunicipalityResponseDTO> findAll();
}
