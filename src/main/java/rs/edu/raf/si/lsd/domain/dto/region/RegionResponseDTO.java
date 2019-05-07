package rs.edu.raf.si.lsd.domain.dto.region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.Belongment;
import rs.edu.raf.si.lsd.domain.County;
import rs.edu.raf.si.lsd.domain.Region;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class RegionResponseDTO {

    private String name;

    private List<CountyResponseDTO> counties = new ArrayList<>();

    public RegionResponseDTO(Region region) {
        this.name = region.getName();

        setCounties(region.getCountyRelationships());
    }

    public void setCounties(List<Belongment> countyRelationships) {

        for(Belongment countyRelationship : countyRelationships) {
            counties.add(new CountyResponseDTO(
                    ((County)countyRelationship.getOrigin()).getName(),
                    this.name,
                    countyRelationship.getFrom(),
                    countyRelationship.getTo()
            ));
        }
    }

}
