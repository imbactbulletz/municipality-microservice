package rs.edu.raf.si.lsd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.si.lsd.domain.dto.parcel.ParcelRequestDTO;
import rs.edu.raf.si.lsd.domain.dto.parcel.ParcelResponseDTO;
import rs.edu.raf.si.lsd.service.ParcelService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/parcels")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @PostMapping(path = "/save")
    public ParcelResponseDTO save(@Valid @RequestBody ParcelRequestDTO parcelRequestDTO) {
        return parcelService.save(parcelRequestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(@Valid ParcelRequestDTO residentRequestDTO) {
        parcelService.delete(residentRequestDTO);
    }

    @GetMapping(path = "/findByName")
    public ParcelResponseDTO findByName(ParcelRequestDTO residentRequestDTO) {
        return parcelService.findByName(residentRequestDTO);
    }

    @GetMapping(path = "/findAll")
    public List<ParcelResponseDTO> findAll() {
        return parcelService.findAll();
    }


    @GetMapping(path = "/findAllForOwner")
    public List<ParcelResponseDTO> findAllForOwner(String jmbg) {
        return parcelService.findAllForOwner(jmbg);
    }
}
