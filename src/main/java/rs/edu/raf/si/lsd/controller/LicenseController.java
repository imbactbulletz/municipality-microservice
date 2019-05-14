package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.si.lsd.domain.dto.license.LicenseRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.license.LicenseResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.municipality.MunicipalityRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.municipality.MunicipalityResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.town.TownRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.town.TownResponseDTO;
import rs.edu.raf.si.lsd.service.LicenseService;
import rs.edu.raf.si.lsd.service.MunicipalityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/licenses")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;


    @PostMapping(path = "/save")
    public LicenseResponseDTO save(@Valid @RequestBody LicenseRequestDTO licenseRequestDTO) {
        return licenseService.save(licenseRequestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(@Valid LicenseRequestDTO licenseRequestDTO) {
        licenseService.delete(licenseRequestDTO);
    }

    @GetMapping(path = "/findByName")
    public LicenseResponseDTO findByName(LicenseRequestDTO licenseRequestDTO) {
        return licenseService.findByName(licenseRequestDTO);
    }

    @GetMapping(path = "/findByParcelNumber")
    public List<LicenseResponseDTO> findByParcelNumber(String parcelNumber) {
        return licenseService.findByParcelNumber(parcelNumber);
    }

    @GetMapping(path = "/findById")
    public LicenseResponseDTO findById(Long licenseId) {
        return licenseService.findById(licenseId);
    }

    @GetMapping(path = "/findByTown")
    public List<LicenseResponseDTO> findByTown(String townName) {
        return licenseService.findByTown(townName);
    }

    @GetMapping(path = "/findByMunicipality")
    public List<LicenseResponseDTO> findByMunicipality(String municipalityName) {
        return licenseService.findByMunicipality(municipalityName);
    }

    @GetMapping(path = "/findByCity")
    public List<LicenseResponseDTO> findByCity(String cityName) {
        return licenseService.findByCity(cityName);
    }


    @GetMapping(path = "/findByCounty")
    public List<LicenseResponseDTO> findByCounty(String countyName) {
        return licenseService.findByCounty(countyName);
    }


    @GetMapping(path = "/findByRegion")
    public List<LicenseResponseDTO> findByRegion(String regionName) {
        return licenseService.findByRegion(regionName);
    }

    @GetMapping(path = "/findAll")
    public List<LicenseResponseDTO> findAll() {
        return licenseService.findAll();
    }
}
