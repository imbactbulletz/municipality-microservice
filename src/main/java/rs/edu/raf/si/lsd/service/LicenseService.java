package rs.edu.raf.si.lsd.service;

import rs.edu.raf.si.lsd.domain.dto.license.LicenseRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.license.LicenseResponseDTO;

public interface LicenseService extends BaseService<LicenseRequestDTO, LicenseResponseDTO> {

    LicenseResponseDTO findById(Long licenseId);
}
