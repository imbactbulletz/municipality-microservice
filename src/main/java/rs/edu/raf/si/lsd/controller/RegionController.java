package rs.edu.raf.si.lsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.si.lsd.domain.dto.region.RegionRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.region.RegionResponseDTO;
import rs.edu.raf.si.lsd.service.RegionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping (path = "/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping (path = "/save")
    public RegionResponseDTO save( @Valid @RequestBody RegionRequestDTO requestDTO) {
        return regionService.save(requestDTO);
    }

    @GetMapping (path = "/delete")
    public void delete(@Valid RegionRequestDTO requestDTO) {
        regionService.delete(requestDTO);
    }

    @GetMapping (path = "/findByName")
    public RegionResponseDTO findByName(@Valid RegionRequestDTO regionRequestDTO) {
        return regionService.findByName(regionRequestDTO);
    }

    @GetMapping (path = "/findAll")
    public List<RegionResponseDTO> findAll(){
        return regionService.findAll();
    }
}
