package rs.edu.raf.si.lsd.domain.dto.region;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import rs.edu.raf.si.lsd.domain.entities.Belongment;
import rs.edu.raf.si.lsd.domain.entities.County;
import rs.edu.raf.si.lsd.domain.entities.Region;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegionResponseDTO {

    private String name;


    private List<CountyResponseDTO> counties = new ArrayList<>();

    public RegionResponseDTO(Region region) {
        this.name = region.getName();

        setCounties(region.getBelongmentRelationships());
    }

    public void setCounties(List<Belongment> countyRelationships) {

        for(Belongment countyRelationship : countyRelationships) {
            counties.add(
                    CountyResponseDTO.builder()
                            .name(((County)countyRelationship.getOrigin()).getName())
                            .regionName(this.name)
                            .from(countyRelationship.getFrom())
                            .to(countyRelationship.getTo())
                            .build()
            );
        }

    }

}
