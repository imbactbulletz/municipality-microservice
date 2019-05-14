package rs.edu.raf.si.lsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.si.lsd.dao.BaseDao;
import rs.edu.raf.si.lsd.dao.LicenseDao;
import rs.edu.raf.si.lsd.dao.ParcelDao;
import rs.edu.raf.si.lsd.domain.dto.license.LicenseRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.license.LicenseResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.parcel.ParcelResponseDTO;
import rs.edu.raf.si.lsd.domain.entities.*;
import rs.edu.raf.si.lsd.service.LicenseService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImplLicenseService implements LicenseService {

    @Autowired
    private LicenseDao licenseDao;


    @Autowired
    private ParcelDao parcelDao;

    @Override
    public LicenseResponseDTO save(LicenseRequestDTO requestDTO) {

        License license = License.builder()
                .licenseType(requestDTO.getLicenseType())
                .ownerId(requestDTO.getLicenseOwnerId())
                .build();

        Optional<Parcel> parcelOptional = parcelDao.findById(requestDTO.getParcelNumber());

        if (parcelOptional.isPresent()) {
            licenseDao.save(license);

            Parcel parcel = parcelOptional.get();

            createRelation(parcelDao, license, parcel, null, null);

            LicenseResponseDTO licenseResponseDTO = LicenseResponseDTO.builder()
                    .id(license.getId())
                    .parcelNumber(parcel.getParcelNumber())
                    .licenseOwner(license.getOwnerId())
                    .licenseType(license.getLicenseType())
                    .build();

            return licenseResponseDTO;
        }

        return null;
    }

    private void createRelation(BaseDao dao, TerritorialUnit childUnit, TerritorialUnit parentUnit, String from, String to) {
        Belongment belongment = new Belongment(childUnit, parentUnit, from, to);

        if (parentUnit instanceof Parcel) {
            ((Parcel) parentUnit).getBelongmentRelationships().add(belongment);
        }

        dao.save(parentUnit);
    }

    @Override
    public void delete(LicenseRequestDTO requestDTO) {
        License license = License.builder()
                .id(requestDTO.getId())
                .build();

        licenseDao.delete(license);
    }

    @Override
    public LicenseResponseDTO findByName(LicenseRequestDTO requestDTO) {
        return null;
    }

    @Override
    public List findAll() {
        Iterable<License> licenses = licenseDao.findAll();

        List<LicenseResponseDTO> licenseResponseDTOs = StreamSupport
                .stream(licenses.spliterator(), false)
                .map(LicenseResponseDTO::new)
                .collect(Collectors.toList());

        return licenseResponseDTOs;
    }

    @Override
    public LicenseResponseDTO findById(Long licenseId) {
        Optional<License> licenseOptional = licenseDao.findById(licenseId);

        if (licenseOptional.isPresent()) {
            return new LicenseResponseDTO(licenseOptional.get());
        }

        return null;
    }

    @Override
    public List<LicenseResponseDTO> findByParcelNumber(String parcelNumber) {
        Iterable<License> licenses = licenseDao.findByParcelNumber(parcelNumber);

        List<LicenseResponseDTO> licenseResponseDTOs = StreamSupport
                .stream(licenses.spliterator(), false)
                .map(LicenseResponseDTO::new)
                .collect(Collectors.toList());

        return licenseResponseDTOs;
    }

    @Override
    public List<LicenseResponseDTO> findByTown(String townName) {
        Iterable<License> licenses = licenseDao.findByTown(townName);

        List<LicenseResponseDTO> licenseResponseDTOs = StreamSupport
                .stream(licenses.spliterator(), false)
                .map(LicenseResponseDTO::new)
                .collect(Collectors.toList());

        return licenseResponseDTOs;
    }

    @Override
    public List<LicenseResponseDTO> findByCity(String cityName) {
        Iterable<License> licenses = licenseDao.findByCity(cityName);

        List<LicenseResponseDTO> licenseResponseDTOs = StreamSupport
                .stream(licenses.spliterator(), false)
                .map(LicenseResponseDTO::new)
                .collect(Collectors.toList());

        return licenseResponseDTOs;
    }

    @Override
    public List<LicenseResponseDTO> findByMunicipality(String municipalityName) {
        Iterable<License> licenses = licenseDao.findByMunicipality(municipalityName);

        List<LicenseResponseDTO> licenseResponseDTOs = StreamSupport
                .stream(licenses.spliterator(), false)
                .map(LicenseResponseDTO::new)
                .collect(Collectors.toList());

        return licenseResponseDTOs;
    }

    @Override
    public List<LicenseResponseDTO> findByCounty(String countyName) {
        Iterable<License> licenses = licenseDao.findByCounty(countyName);

        List<LicenseResponseDTO> licenseResponseDTOs = StreamSupport
                .stream(licenses.spliterator(), false)
                .map(LicenseResponseDTO::new)
                .collect(Collectors.toList());

        return licenseResponseDTOs;
    }

    @Override
    public List<LicenseResponseDTO> findByRegion(String regionName) {
        Iterable<License> licenses = licenseDao.findByRegion(regionName);

        List<LicenseResponseDTO> licenseResponseDTOs = StreamSupport
                .stream(licenses.spliterator(), false)
                .map(LicenseResponseDTO::new)
                .collect(Collectors.toList());

        return licenseResponseDTOs;
    }
}
