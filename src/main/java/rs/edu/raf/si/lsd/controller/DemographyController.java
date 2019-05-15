package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.edu.raf.si.lsd.domain.dto.demography.*;
import rs.edu.raf.si.lsd.service.DemographyService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/demography")
public class DemographyController {

    @Autowired
    private DemographyService demographyService;

    @GetMapping(path = "/getPopulationDensity")
    public PopulationDensityResponseDTO getPopulationDensity(PopulationDensityRequestDTO requestDTO) {
        return demographyService.getPopulationDensity(requestDTO);
    }

    @GetMapping(path = "/getAverageAge")
    public AverageAgeResponseDTO getAverageAge(@Valid AverageAgeRequestDTO requestDTO) {
        return demographyService.getAverageAge(requestDTO);
    }


    @GetMapping(path = "/getNatalityRate")
    public NatalityResponseDTO getNatalityRate(){
        return demographyService.getNatalityRate();
    }

    @GetMapping(path = "/getMortalityRate")
    public MortalityResponseDTO getMortalityRate() {
        return demographyService.getMortalityRate();
    }

}
