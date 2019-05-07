package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.si.lsd.domain.dto.municipality.MunicipalityRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.municipality.MunicipalityResponseDTO;
import rs.edu.raf.si.lsd.service.MunicipalityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/municipalities")
public class MunicipalityController {

    @Autowired
    MunicipalityService municipalityService;


    @PostMapping(path = "/save")
    public MunicipalityResponseDTO save(@Valid @RequestBody MunicipalityRequestDTO municipalityRequestDTO) {
        return municipalityService.save(municipalityRequestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(@Valid MunicipalityRequestDTO municipalityRequestDTO) {
        municipalityService.delete(municipalityRequestDTO);
    }

    @GetMapping(path = "/findByName")
    public MunicipalityResponseDTO findByName(MunicipalityRequestDTO municipalityRequestDTO) {
       return municipalityService.findByName(municipalityRequestDTO);
    }

    @GetMapping(path = "/findAll")
    public List<MunicipalityResponseDTO> findAll() {
        return municipalityService.findAll();
    }
}
