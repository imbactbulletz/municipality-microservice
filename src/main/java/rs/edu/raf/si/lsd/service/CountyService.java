package rs.edu.raf.si.lsd.service;

import rs.edu.raf.si.lsd.domain.dto.county.CountyRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;

import java.util.List;

public interface CountyService {

    CountyResponseDTO save(CountyRequestDTO countyRequestDTO);

    void delete(CountyRequestDTO countyRequestDTO);

    CountyResponseDTO findByName(CountyRequestDTO countyRequestDTO);

    List<CountyResponseDTO> findAll();
}
