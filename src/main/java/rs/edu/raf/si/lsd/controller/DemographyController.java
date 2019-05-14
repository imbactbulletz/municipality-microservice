package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.edu.raf.si.lsd.domain.dto.demography.PopulationDensityRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.demography.PopulationDensityResponseDTO;
import rs.edu.raf.si.lsd.service.DemographyService;

@RestController
@RequestMapping(path = "/demography")
public class DemographyController {

    @Autowired
    private DemographyService demographyService;

    @GetMapping(path = "/getPopulationDensity")
    public PopulationDensityResponseDTO getPopulationDensity(PopulationDensityRequestDTO requestDTO) {
        return demographyService.getPopulationDensity(requestDTO);
    }
}
