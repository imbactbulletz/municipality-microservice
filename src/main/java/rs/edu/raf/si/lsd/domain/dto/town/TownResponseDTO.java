package rs.edu.raf.si.lsd.domain.dto.town;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.entities.City;
import rs.edu.raf.si.lsd.domain.entities.Municipality;
import rs.edu.raf.si.lsd.domain.entities.Town;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TownResponseDTO {

    private String name;

    private String cityName;

    private String municipalityName;

    private String from;

    private String to;

    public TownResponseDTO(Town town) {
        this.name = town.getName();

        if(town.getOwnershipRelationship() != null) {
            if(town.getOwnershipRelationship().getEnd() instanceof City) {
                this.cityName = ((City)town.getOwnershipRelationship().getEnd()).getName();
            } else {
                this.municipalityName = ((Municipality) town.getOwnershipRelationship().getEnd()).getName();
            }

            this.from = town.getOwnershipRelationship().getFrom();
            this.to = town.getOwnershipRelationship().getTo();
        }
    }
}
