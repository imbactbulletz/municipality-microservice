package rs.edu.raf.si.lsd.domain.dto.city;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.entities.City;
import rs.edu.raf.si.lsd.domain.entities.County;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityResponseDTO {

    private String name;

    private String countyName;

    private String from;

    private String to;

    public CityResponseDTO(City city) {
        this.name = city.getName();

        this.countyName = ((County)city.getOwnershipRelationship().getEnd()).getName();

        this.from = city.getOwnershipRelationship().getFrom();

        this.to = city.getOwnershipRelationship().getTo();
    }
}
