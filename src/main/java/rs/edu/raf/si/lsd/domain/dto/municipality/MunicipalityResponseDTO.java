package rs.edu.raf.si.lsd.domain.dto.municipality;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.entities.City;
import rs.edu.raf.si.lsd.domain.entities.County;
import rs.edu.raf.si.lsd.domain.entities.Municipality;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MunicipalityResponseDTO {

    @NotNull
    private String name;


    private String countyName;

    private String cityName;

    private String from;

    private String to;

    public MunicipalityResponseDTO(Municipality municipality) {
        this.name = municipality.getName();

        if(municipality.getOwnershipRelationship() != null) {

            if(municipality.getOwnershipRelationship().getEnd() instanceof County) {
                this.countyName = ((County) municipality.getOwnershipRelationship().getEnd()).getName();
            } else {
                this.cityName = ((City) municipality.getOwnershipRelationship().getEnd()).getName();
            }

        }
        this.from = municipality.getOwnershipRelationship().getFrom();

        this.to = municipality.getOwnershipRelationship().getTo();
    }
}