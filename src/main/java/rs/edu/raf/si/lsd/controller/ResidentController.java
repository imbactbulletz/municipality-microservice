package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.si.lsd.domain.dto.resident.ResidentRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.resident.ResidentResponseDTO;
import rs.edu.raf.si.lsd.service.ResidentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/residents")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @PostMapping(path = "/save")
    public ResidentResponseDTO save (@Valid @RequestBody ResidentRequestDTO residentRequestDTO) {
        return residentService.save(residentRequestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(@Valid ResidentRequestDTO residentRequestDTO) {
        residentService.delete(residentRequestDTO);
    }

    @GetMapping (path = "/findByName")
    public ResidentResponseDTO findByName(ResidentRequestDTO residentRequestDTO) {
        return residentService.findByName(residentRequestDTO);
    }

    @GetMapping (path = "/findAll")
    public List<ResidentResponseDTO> findAll() {
        return residentService.findAll();
    }

    @GetMapping (path = "/findAllInTown")
    public List<ResidentResponseDTO> findAllInTown(String townName) {
        return residentService.findAllInTown(townName);
    }

    @GetMapping (path = "/findAllInCity")
    public List<ResidentResponseDTO> findAllInCity(String cityName) {
        return residentService.findAllInCity(cityName);
    }

    @GetMapping (path = "/findAllInMunicipality")
    public List<ResidentResponseDTO> findAllInMunicipality(String municipalityName) {
        return residentService.findAllInMunicipality(municipalityName);
    }

    @GetMapping (path = "/findAllInCounty")
    public List<ResidentResponseDTO> findAllInCounty(String countyName) {
        return residentService.findAllInCounty(countyName);
    }

    @GetMapping (path = "/findAllInRegion")
    public List<ResidentResponseDTO> findAllInRegion(String regionName) {
        return residentService.findAllInRegion(regionName);
    }
}
