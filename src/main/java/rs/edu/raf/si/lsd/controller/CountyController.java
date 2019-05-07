package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.edu.raf.si.lsd.domain.dto.county.CountyRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;
import rs.edu.raf.si.lsd.service.CountyService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/counties")
public class CountyController {

    @Autowired
    private CountyService countyService;

    @PostMapping(path = "/save")
    public CountyResponseDTO save (@Valid @RequestBody CountyRequestDTO countyRequestDTO) {
        return countyService.save(countyRequestDTO);
    }
}
