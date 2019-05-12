package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.si.lsd.domain.dto.city.CityRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.city.CityResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;
import rs.edu.raf.si.lsd.service.CityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/cities")
public class CityController {


    @Autowired
    private CityService cityService;

    @PostMapping(path = "/save")
    public CityResponseDTO save (@Valid @RequestBody CityRequestDTO cityRequestDTO) {
        return cityService.save(cityRequestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete (@Valid CityRequestDTO cityRequestDTO) {
        cityService.delete(cityRequestDTO);
    }

    @GetMapping (path = "/findByName")
    public CityResponseDTO findByName (CityRequestDTO cityRequestDTO) {
        return cityService.findByName(cityRequestDTO);
    }

    @GetMapping (path = "/findAll")
    public List<CityResponseDTO> findAll () {
        return cityService.findAll();
    }
}
