package rs.edu.raf.si.lsd.service;

import rs.edu.raf.si.lsd.domain.dto.county.CountyRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;

import java.util.List;

public interface BaseService <RequestType, ResponseType> {

    ResponseType save(RequestType requestDTO);

    void delete(RequestType requestDTO);

    ResponseType findByName(RequestType requestDTO);

    List<ResponseType> findAll();
}
