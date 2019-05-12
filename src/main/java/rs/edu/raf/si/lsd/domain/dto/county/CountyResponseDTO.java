package rs.edu.raf.si.lsd.domain.dto.county;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.dto.city.CityResponseDTO;
import rs.edu.raf.si.lsd.domain.dto.municipality.MunicipalityResponseDTO;
import rs.edu.raf.si.lsd.domain.entities.*;

import java.util.ArrayList;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountyResponseDTO {

    private String name;

    private String regionName;

    private String from;

    private String to;

    private List<MunicipalityResponseDTO> municipalities = new ArrayList<>();

    private List<CityResponseDTO> cities = new ArrayList<>();

    public CountyResponseDTO(County county) {
        this.name = county.getName();
        this.regionName = ((Region)county.getOwnershipRelationship().getEnd()).getName();
        this.from = county.getOwnershipRelationship().getFrom();
        this.to = county.getOwnershipRelationship().getTo();

        setCitiesAndMunicipalities(county.getBelongmentRelationships());
    }


    private void setCitiesAndMunicipalities(List<Belongment> municipalityRelationships) {
        for(Belongment relationship : municipalityRelationships) {
            if(relationship.getOrigin() instanceof Municipality) {
                this.municipalities.add(
                        MunicipalityResponseDTO.builder()
                                .name(((Municipality) relationship.getOrigin()).getName())
                                .countyName(this.name)
                                .from(relationship.getFrom())
                                .to(relationship.getTo())
                                .build()
                );
            } else {
                this.cities.add(
                        CityResponseDTO.builder()
                        .name(((City)relationship.getOrigin()).getName())
                        .countyName(this.name)
                        .from(relationship.getFrom())
                        .to(relationship.getTo())
                        .build()
                );
            }
        }
    }

}
