package rs.edu.raf.si.lsd.service;

import org.springframework.data.neo4j.annotation.Query;
import rs.edu.raf.si.lsd.domain.dto.parcel.ParcelRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.parcel.ParcelResponseDTO;
import rs.edu.raf.si.lsd.domain.entities.Parcel;

import java.util.List;

public interface ParcelService extends BaseService<ParcelRequestDTO, ParcelResponseDTO> {

    List<ParcelResponseDTO> findAllInTown(String townName);

    List<ParcelResponseDTO> findAllInCity(String cityName);

    List<ParcelResponseDTO> findAllInMunicipality(String municipalityName);

    List<ParcelResponseDTO> findAllInCounty(String countyName);

    List<ParcelResponseDTO> findAllInRegion(String regionName);

    List<ParcelResponseDTO> findAllForOwner(String jmbg);
}
