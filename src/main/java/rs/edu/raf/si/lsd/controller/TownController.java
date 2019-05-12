package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.si.lsd.domain.dto.county.CountyRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.town.TownRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.town.TownResponseDTO;
import rs.edu.raf.si.lsd.service.TownService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/towns")
public class TownController {

    @Autowired
    private TownService townService;

    @PostMapping(path = "/save")
    public TownResponseDTO save (@Valid @RequestBody TownRequestDTO townRequestDTO) {
        return townService.save(townRequestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(@Valid TownRequestDTO townRequestDTO) {
        townService.delete(townRequestDTO);
    }

    @GetMapping (path = "/findByName")
    public TownResponseDTO findByName(TownRequestDTO townRequestDTO) {
        return townService.findByName(townRequestDTO);
    }

    @GetMapping (path = "/findAll")
    public List<TownResponseDTO> findAll() {
        return townService.findAll();
    }
}
