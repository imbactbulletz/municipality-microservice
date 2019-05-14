package rs.edu.raf.si.lsd.service;

import rs.edu.raf.si.lsd.domain.dto.license.LicenseRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.license.LicenseResponseDTO;
import rs.edu.raf.si.lsd.domain.entities.License;

import java.util.List;

public interface LicenseService extends BaseService<LicenseRequestDTO, LicenseResponseDTO> {

    LicenseResponseDTO findById(Long licenseId);

    List<LicenseResponseDTO> findByParcelNumber(String parcelNumber);

    List<LicenseResponseDTO> findByTown(String townName);

    List<LicenseResponseDTO> findByCity(String cityName);

    List<LicenseResponseDTO> findByMunicipality(String municipalityName);

    List<LicenseResponseDTO> findByCounty(String countyName);

    List<LicenseResponseDTO> findByRegion(String regionName);
}
