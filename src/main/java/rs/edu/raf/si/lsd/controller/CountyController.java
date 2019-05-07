package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.si.lsd.domain.dto.county.CountyRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;
import rs.edu.raf.si.lsd.service.CountyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/counties")
public class CountyController {

    @Autowired
    private CountyService countyService;

    @PostMapping(path = "/save")
    public CountyResponseDTO save (@Valid @RequestBody CountyRequestDTO countyRequestDTO) {
        return countyService.save(countyRequestDTO);
    }

    @GetMapping (path = "/delete")
    public void delete(@Valid CountyRequestDTO countyRequestDTO) {
        countyService.delete(countyRequestDTO);
    }

    @GetMapping (path = "/findByName")
    public CountyResponseDTO findByName(CountyRequestDTO countyRequestDTO) {
        return countyService.findByName(countyRequestDTO);
    }

    @GetMapping (path = "/findAll")
    public List<CountyResponseDTO> findAll() {
        return countyService.findAll();
    }
}
