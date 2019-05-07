package rs.edu.raf.si.lsd.domain.dto.municipality;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.County;
import rs.edu.raf.si.lsd.domain.Municipality;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MunicipalityResponseDTO {

    @NotNull
    private String name;

    @NotNull
    private String countyName;

    private String from;

    private String to;

    public MunicipalityResponseDTO(Municipality municipality) {
        this.name = municipality.getName();

        this.countyName = ((County)municipality.getCountyRelationship().getEnd()).getName();

        this.from = municipality.getCountyRelationship().getFrom();

        this.to = municipality.getCountyRelationship().getTo();
    }
}